package chinaPress.exam.exam_signup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.exam.exam_signup.dao.FcExamSignupAreaMapper;
import chinaPress.exam.exam_signup.dao.FcExamSignupMapper;
import chinaPress.exam.exam_signup.dao.FcExamSignupUserMapper;
import chinaPress.exam.exam_signup.model.FcExamSignup;
import chinaPress.exam.exam_signup.model.FcExamSignupArea;
import chinaPress.exam.exam_signup.model.FcExamSignupUser;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserListVo;
import chinaPress.fc.order.dao.FcOrderMapper;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.model.FcOrderPerson;

@Service
public class FcExamSignupUserService {
	@Autowired
	private FcExamSignupUserMapper fcExamSignupUserMapper;
	@Autowired
	private FcOrderMapper fcOrderMapper;
	@Autowired
	private FcOrderPersonMapper fcOrderPersonMapper;
	@Autowired
	private FcExamSignupMapper fcExamSignupMapper;
	@Autowired
	private FcExamSignupAreaMapper fcExamSignupAreaMapper;

	/**
	 * 查询考试报名的人员信息
	 * 
	 * @author maguoliang
	 * @param signupAreaId      考试报名区域时间id
	 * @param userName          姓名
	 * @param tellPhone         手机号
	 * @param certificateNumber 身份证号
	 * @param examineType       是否允许补考(1允许,0不允许)
	 * @return
	 */
	public int selectExamSignupUserCount(Integer signupAreaId, String userName, String tellPhone,
			String certificateNumber, Integer examineType) {
		return fcExamSignupUserMapper.selectExamSignupUserCount(signupAreaId, userName, tellPhone, certificateNumber,
				examineType);
	}

	/**
	 * 查询考试报名的人员信息
	 * 
	 * @author maguoliang
	 * @param signupAreaId      考试报名区域时间id
	 * @param userName          姓名
	 * @param tellPhone         手机号
	 * @param certificateNumber 身份证号
	 * @param examineType       是否允许补考(1允许,0不允许)
	 * @param pageNumber        第几页
	 * @param pageSize          每页查询多少条
	 * @return
	 */
	public List<FcExamSignupUserListVo> selectExamSignupUserList(Integer signupAreaId, String userName,
			String tellPhone, String certificateNumber, Integer examineType, Integer pageNumber, Integer pageSize) {
		List<FcExamSignupUserListVo> list = fcExamSignupUserMapper.selectExamSignupUserList(signupAreaId, userName,
				tellPhone, certificateNumber, examineType, pageNumber * pageSize - pageSize, pageSize);
		for (FcExamSignupUserListVo fcExamSignupUserListVo : list) {
			// 1.查询这个人针对当前考试报名关联的课程的学习进度
			FcOrder exceptionFcOrder = fcOrderMapper.selectIsExceptionOrder(fcExamSignupUserListVo.getRoleId(),
					fcExamSignupUserListVo.getRoleType(), fcExamSignupUserListVo.getCourseId());
			if (exceptionFcOrder == null) {
				fcExamSignupUserListVo.setStudyProcess("未学习");
			} else {
				// 查看是否学习完
				FcOrderPerson fcOrderPerson = fcOrderPersonMapper.selectByOrderId(exceptionFcOrder.getId());
				if (fcOrderPerson.getHaveCount() < fcOrderPerson.getTotalCount()) {
					fcExamSignupUserListVo.setStudyProcess("学习中");
				} else {
					fcExamSignupUserListVo.setStudyProcess("已学完");
				}
			}
			// 2.补考信息
		}
		return list;
	}

	/**
	 * 用户考试报名
	 * 
	 * @author maguoliang
	 * @param fcExamSignupUser
	 * @return -1 用户所报名的考试不存在，-2用户所报名的考试区域不存在，-3用户所报名的考试区域和考试不一致，-4该考试报名已下架
	 * 	-5该报名下的该区域报名人数已满
	 */
	@Transactional
	public int userSignup(FcExamSignupUser fcExamSignupUser) {
		// 检查考试报名id
		if (fcExamSignupUser.getSignupId() == null) {
			return -1;
		} else {
			// 检查考试报名是否存在
			FcExamSignup fcExamSignup = fcExamSignupMapper.selectByPrimaryKey(fcExamSignupUser.getSignupId());
			if (fcExamSignup == null) {
				return -1;
			} else {
				// 检查考试报名区域时间id
				if (fcExamSignupUser.getAreaId() == null) {
					return -2;
				} else {
					// 检查考试报名区域时间是否存在
					FcExamSignupArea fcExamSignupArea = fcExamSignupAreaMapper.selectByPrimaryKey(fcExamSignupUser.getAreaId());
					if (fcExamSignupArea == null) {
						return -2;
					} else {
						// 检查考试报名区域时间和考试报名是否一致
						if (fcExamSignupArea.getSignupId().intValue() != fcExamSignupUser.getSignupId().intValue()) {
							return -3;
						} else {
							// 检查考试报名是否下架了
							if (fcExamSignup.getIsPutaway().intValue() == 0) {
								return -4;
							}
							// 检查报名人员是否已经满了
							// 1.最大报名人数
							int maxCount = fcExamSignupArea.getMaxCount();
							int currFcExamSignupUser = fcExamSignupUserMapper.selectCountBySignupIdAndAreaId(
									fcExamSignupUser.getSignupId(), fcExamSignupUser.getAreaId());
							if (currFcExamSignupUser == maxCount) {
								return -5;
							}
						}
					}
				}
			}
		}
		// 报名成功后判断是否满足最大人数限制，满足则自动下架
		fcExamSignupUserMapper.insertSelective(fcExamSignupUser);
		int currFcExamSignupUser = fcExamSignupUserMapper.selectCountBySignupIdAndAreaId(fcExamSignupUser.getSignupId(),
				fcExamSignupUser.getAreaId());
		FcExamSignupArea fcExamSignupArea = fcExamSignupAreaMapper.selectByPrimaryKey(fcExamSignupUser.getAreaId());
		if (currFcExamSignupUser == fcExamSignupArea.getMaxCount().intValue()) {
			FcExamSignupArea record = new FcExamSignupArea();
			record.setId(fcExamSignupArea.getId());
			record.setIsPutaway(0);
			fcExamSignupAreaMapper.updateByPrimaryKeySelective(record);
		}
		return 1;
	}

	/**
	 * 审核用户考试报名
	 * 
	 * @author maguoliang
	 * @param signupUserId 考试报名用户id
	 * @param status       审核状态1.通过2.拒绝
	 * @return
	 */
	public int auditFcExamSignupUser(Integer signupUserId, Integer status) {
		FcExamSignupUser record = new FcExamSignupUser();
		record.setExamineType(status);
		return fcExamSignupUserMapper.updateByPrimaryKeySelective(record);
	}
}
