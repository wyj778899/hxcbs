package chinaPress.exam.exam_signup.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.util.DateUtil;
import chinaPress.exam.exam.dao.FcExamMapper;
import chinaPress.exam.exam_signup.dao.FcExamSignupAreaMapper;
import chinaPress.exam.exam_signup.dao.FcExamSignupMapper;
import chinaPress.exam.exam_signup.dao.FcExamSignupUserMapper;
import chinaPress.exam.exam_signup.model.FcExamSignup;
import chinaPress.exam.exam_signup.model.FcExamSignupArea;
import chinaPress.exam.exam_signup.model.FcExamSignupUser;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserDetailVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserListIndexVo;
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
	@Autowired
	private FcExamMapper fcExamMapper;

	/**
	 * 查询考试报名的人员信息
	 * 
	 * @author maguoliang
	 * @param signupId          考试报名id
	 * @param signupAreaId      考试报名区域时间id
	 * @param userName          姓名
	 * @param tellPhone         手机号
	 * @param certificateNumber 身份证号
	 * @param examineType       审核状态(0未审核,1已审核,2已驳回3.已关联考试)
	 * @return
	 */
	public int selectExamSignupUserCount(Integer signupId, Integer signupAreaId, String userName, String tellPhone,
			String certificateNumber, Integer examineType) {
		return fcExamSignupUserMapper.selectExamSignupUserCount(signupId, signupAreaId, userName, tellPhone,
				certificateNumber, examineType);
	}

	/**
	 * 查询考试报名的人员信息
	 * 
	 * @author maguoliang
	 * @param signupId          考试报名id
	 * @param signupAreaId      考试报名区域时间id
	 * @param userName          姓名
	 * @param tellPhone         手机号
	 * @param certificateNumber 身份证号
	 * @param examineType       审核状态(0未审核,1已审核,2已驳回3.已关联考试)
	 * @param pageNumber        第几页
	 * @param pageSize          每页查询多少条
	 * @return
	 */
	public List<FcExamSignupUserListVo> selectExamSignupUserList(Integer signupId, Integer signupAreaId,
			String userName, String tellPhone, String certificateNumber, Integer examineType, Integer pageNumber,
			Integer pageSize) {
		List<FcExamSignupUserListVo> list = fcExamSignupUserMapper.selectExamSignupUserList(signupId, signupAreaId,
				userName, tellPhone, certificateNumber, examineType, pageNumber * pageSize - pageSize, pageSize);
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
	 *         -5该报名下的该区域报名人数已满
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
					FcExamSignupArea fcExamSignupArea = fcExamSignupAreaMapper
							.selectByPrimaryKey(fcExamSignupUser.getAreaId());
					if (fcExamSignupArea == null) {
						return -2;
					} else {
						// 检查考试报名区域时间和考试报名是否一致
						if (fcExamSignupArea.getSignupId().intValue() != fcExamSignupUser.getSignupId().intValue()) {
							return -3;
						} else {
							// 检查是否在报名时间范围
							if (DateUtil.compareDate(fcExamSignupArea.getSignupStartTime(), new Date())
									|| DateUtil.compareDate(new Date(), fcExamSignupArea.getSignupEndTime())) {
								return -6;
							}
							// 检查考试报名是否下架了
							if (fcExamSignup.getIsPutaway().intValue() == 0) {
								return -4;
							}
							// 检查考试报名区域是否下架了
							if (fcExamSignupArea.getIsPutaway().intValue() == 0) {
								return -7;
							}
							// 检查报名人员是否已经满了
							// 1.最大报名人数
							int maxCount = fcExamSignupArea.getMaxCount();
							int currFcExamSignupUser = fcExamSignupUserMapper.selectCountBySignupIdAndAreaId(
									fcExamSignupUser.getSignupId(), fcExamSignupUser.getAreaId());
							if (currFcExamSignupUser == maxCount) {
								return -5;
							}
							// 检查是否已经报名了
							List<FcExamSignupUser> list = fcExamSignupUserMapper
									.selectIsSignup(fcExamSignupUser.getSignupId(), fcExamSignupUser.getAreaId());
							if (list.size() > 0) {
								return -8;
							}
						}
					}
				}
			}
		}
		// 再检查上次报名是否已经考试完成
//		fcExamMapper.selectByPrimaryKey(id);

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
	 * @param remarks      驳回原因
	 * @return
	 */
	public int auditFcExamSignupUser(Integer signupUserId, Integer status, String remarks) {
		FcExamSignupUser record = new FcExamSignupUser();
		record.setExamineType(status);
		if (status.intValue() == 2) {
			record.setRemarks(remarks);
		}
		return fcExamSignupUserMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 查询前台管理端用户的已报名审核个数
	 * 
	 * @param roleId   角色id
	 * @param roleType 角色类型1.家长2.从业者
	 * @return
	 */
	public int selectUserFcExamSignupCount(Integer roleId, Integer roleType) {
		return fcExamSignupUserMapper.selectUserFcExamSignupCount(roleId, roleType);
	}

	/**
	 * 查询前台管理端用户的已报名审核列表
	 * 
	 * @param roleId     角色id
	 * @param roleType   角色类型1.家长2.从业者
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条
	 * @return
	 */
	public List<FcExamSignupUserListIndexVo> selectUserFcExamSignupList(Integer roleId, Integer roleType,
			Integer pageNumber, Integer pageSize) {
		List<FcExamSignupUserListIndexVo> list = fcExamSignupUserMapper.selectUserFcExamSignupList(roleId, roleType,
				pageNumber * pageSize - pageSize, pageSize);
		return list;
	}

	/**
	 * 查询考试报名用户信息
	 * 
	 * @param signupUserId 考试报名用户id
	 * @return
	 */
	public FcExamSignupUserDetailVo selectFcExamSignupUserDetail(Integer signupUserId) {
		return fcExamSignupUserMapper.selectFcExamSignupUserDetail(signupUserId);
	}
}
