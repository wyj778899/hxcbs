package chinaPress.exam.exam_signup.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.face.CompareFace;
import chinaPress.common.result.model.Result;
import chinaPress.common.util.DateUtil;
import chinaPress.common.util.ResultUtil;
import chinaPress.exam.exam_signup.dao.FcExamSignupAreaMapper;
import chinaPress.exam.exam_signup.dao.FcExamSignupMapper;
import chinaPress.exam.exam_signup.dao.FcExamSignupUserMapper;
import chinaPress.exam.exam_signup.model.FcExamSignup;
import chinaPress.exam.exam_signup.model.FcExamSignupArea;
import chinaPress.exam.exam_signup.model.FcExamSignupUser;
import chinaPress.exam.exam_signup.vo.ExamUserVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupDetailAreaListVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserDetailVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserListIndexVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserListVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserPrepareVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserVo;
import chinaPress.exam.exam_signup.vo.FcExamToUserVo;
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
	 * @param signupId          考试报名id
	 * @param signupAreaIds     考试报名区域时间id
	 * @param userName          姓名
	 * @param tellPhone         手机号
	 * @param certificateNumber 身份证号
	 * @param examineType       审核状态(0未审核,1已审核,2已驳回3.已关联考试)
	 * @param startTime         开始时间
	 * @param endTime           结束时间
	 * @return
	 */
	public int selectExamSignupUserCount(Integer signupId, String signupAreaIds, String userName, String tellPhone,
			String certificateNumber, Integer examineType, String startTime, String endTime) {
		List<String> areaList = new ArrayList<String>();
		if (StringUtils.isNotBlank(signupAreaIds)) {
			areaList = Arrays.asList(signupAreaIds.split(","));
		}
		return fcExamSignupUserMapper.selectExamSignupUserCount(signupId, areaList, userName, tellPhone,
				certificateNumber, examineType, startTime, endTime);
	}

	/**
	 * 查询考试报名的人员信息
	 * 
	 * @author maguoliang
	 * @param signupId          考试报名id
	 * @param signupAreaIds     考试报名区域时间id
	 * @param userName          姓名
	 * @param tellPhone         手机号
	 * @param certificateNumber 身份证号
	 * @param examineType       审核状态(0未审核,1已审核,2已驳回3.已关联考试)
	 * @param startTime         开始时间
	 * @param endTime           结束时间
	 * @param pageNumber        第几页
	 * @param pageSize          每页查询多少条
	 * @return
	 */
	public List<FcExamSignupUserListVo> selectExamSignupUserList(Integer signupId, String signupAreaIds,
			String userName, String tellPhone, String certificateNumber, Integer examineType, String startTime,
			String endTime, Integer pageNumber, Integer pageSize) {
		List<String> areaList = new ArrayList<String>();
		if (StringUtils.isNotBlank(signupAreaIds)) {
			areaList = Arrays.asList(signupAreaIds.split(","));
		}
		List<FcExamSignupUserListVo> list = fcExamSignupUserMapper.selectExamSignupUserList(signupId, areaList,
				userName, tellPhone, certificateNumber, examineType, startTime, endTime,
				pageNumber * pageSize - pageSize, pageSize);
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
	 * 检查是否满足报名条件
	 * 
	 * @param signupId     考试报名id
	 * @param signupAreaId 考试报名区域id
	 * @param roleId       角色id
	 * @param roleType     角色类型1.家长2.从业者
	 * @return
	 */
	public int checkIsSignup(Integer signupId, Integer signupAreaId, Integer roleId, Integer roleType) {
		// 检查考试报名id
		if (signupId == null) {
			return -1;
		} else {
			// 检查考试报名是否存在
			FcExamSignup fcExamSignup = fcExamSignupMapper.selectByPrimaryKey(signupId);
			if (fcExamSignup == null) {
				return -1;
			} else {
				// 检查考试报名区域时间id
				if (signupAreaId == null) {
					return -2;
				} else {
					// 检查考试报名区域时间是否存在
					FcExamSignupArea fcExamSignupArea = fcExamSignupAreaMapper.selectByPrimaryKey(signupAreaId);
					if (fcExamSignupArea == null) {
						return -2;
					} else {
						// 检查考试报名区域时间和考试报名是否一致
						if (fcExamSignupArea.getSignupId().intValue() != signupId.intValue()) {
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
							int currFcExamSignupUser = fcExamSignupUserMapper.selectCountBySignupIdAndAreaId(signupId,
									signupAreaId);
							if (currFcExamSignupUser == maxCount) {
								return -5;
							}
							// 检查是否已经报名了
							List<FcExamSignupUser> signupList = fcExamSignupUserMapper.selectIsSignup(signupId,
									signupAreaId, roleId, roleType);
							if (signupList.size() > 0) {
								return -8;
							}
							// 检查是否存在相同的考试报名区域时间（不能报考相同的考试时间）
							List<FcExamSignupUser> sameTimeList = fcExamSignupUserMapper.selectExistsSameAreaTime(
									fcExamSignupArea.getStartTime(), fcExamSignupArea.getEndTime(), roleId, roleType,
									signupId);
							if (sameTimeList.size() > 0) {
								return -9;
							}
							// 检查同一个报名下有没有报名，且考试时间过了没（当前已有报考考试，无法进行报名）
							List<FcExamSignupArea> sameAreaList = fcExamSignupAreaMapper.selectIsOtherSignup(signupId,
									signupAreaId, roleId, roleType);
							if (sameAreaList.size() > 0) {
								List<FcExamSignupArea> newSameAreaList = sameAreaList.stream()
										.filter(model -> DateUtil.compareDate(new Date(), model.getEndTime()))
										.collect(Collectors.toList());
								if (sameAreaList.size() != newSameAreaList.size()) {
									return -10;
								}
							}
						}
					}
				}
			}
		}
		return 1;
	}

	/**
	 * 用户考试报名
	 * 
	 * @author maguoliang
	 * @param fcExamSignupUser
	 * @return
	 */
	@Transactional
	public int userSignup(FcExamSignupUser fcExamSignupUser) {
		int index = checkIsSignup(fcExamSignupUser.getSignupId(), fcExamSignupUser.getAreaId(),
				fcExamSignupUser.getRoleId(), fcExamSignupUser.getRoleType());
		if (index == 1) {
			// 再检查上次报名是否已经考试完成
//			fcExamMapper.selectByPrimaryKey(id);

			// 报名成功后判断是否满足最大人数限制，满足则自动下架
			fcExamSignupUserMapper.insertSelective(fcExamSignupUser);
			int currFcExamSignupUser = fcExamSignupUserMapper
					.selectCountBySignupIdAndAreaId(fcExamSignupUser.getSignupId(), fcExamSignupUser.getAreaId());
			FcExamSignupArea fcExamSignupArea = fcExamSignupAreaMapper.selectByPrimaryKey(fcExamSignupUser.getAreaId());
			if (currFcExamSignupUser == fcExamSignupArea.getMaxCount().intValue()) {
				FcExamSignupArea record = new FcExamSignupArea();
				record.setId(fcExamSignupArea.getId());
				record.setIsPutaway(0);
				fcExamSignupAreaMapper.updateByPrimaryKeySelective(record);
			}
			// 下架完成之后，查询该考试报名下是否所有都 已下架，如果已下架，那么考试报名下架
			List<FcExamSignupArea> areaList = fcExamSignupAreaMapper.selectBySignupId(fcExamSignupUser.getSignupId());
			List<FcExamSignupArea> filterAreaList = areaList.stream().filter(area -> area.getIsPutaway() == 0)
					.collect(Collectors.toList());
			if (areaList.size() == filterAreaList.size()) {
				FcExamSignup record = new FcExamSignup();
				record.setId(fcExamSignupUser.getSignupId());
				record.setIsPutaway(0);
				fcExamSignupMapper.updateByPrimaryKey(record);
			}
			return 1;
		} else {
			return index;
		}
	}

	/**
	 * 审核用户考试报名
	 * 
	 * @author maguoliang
	 * @param signupUserIds 考试报名用户id
	 * @param status        审核状态1.通过2.拒绝
	 * @param remarks       驳回原因
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public void auditFcExamSignupUser(String signupUserIds, Integer status, String remarks) {
		List<String> signupUserIdList = Arrays.asList(signupUserIds.split(","));
		for (String signupUserId : signupUserIdList) {
			FcExamSignupUser record = new FcExamSignupUser();
			record.setId(Integer.parseInt(signupUserId));
			record.setExamineType(status);
			if (status.intValue() == 2) {
				record.setRemarks(remarks);
			}
			fcExamSignupUserMapper.updateByPrimaryKeySelective(record);
		}
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

	/**
	 * 根据多个考试报名区域id和考试报名id查询
	 * 
	 * @param signupId         考试报名id
	 * @param signupAreaIdList 考试报名区域id集合
	 * @return
	 */
	public int selectBySignupIdAndSignupIdCount(Integer signupId, String signupAreaIds) {
		List<String> signupAreaIdList = new ArrayList<String>();
		if (StringUtils.isNotBlank(signupAreaIds)) {
			signupAreaIdList = Arrays.asList(signupAreaIds.split(","));
		}
		return fcExamSignupUserMapper.selectBySignupIdAndSignupIdCount(signupId, signupAreaIdList);
	}

	/**
	 * 根据多个考试报名区域id和考试报名id查询
	 * 
	 * @param signupId         考试报名id
	 * @param signupAreaIdList 考试报名区域id集合
	 * @param pageNumber       第几页
	 * @param pageSize         每页查询多少条
	 * @return
	 */
	public List<FcExamSignupDetailAreaListVo> selectBySignupIdAndSignupIdList(Integer signupId, String signupAreaIds,
			Integer pageNumber, Integer pageSize) {
		List<String> signupAreaIdList = new ArrayList<String>();
		if (StringUtils.isNotBlank(signupAreaIds)) {
			signupAreaIdList = Arrays.asList(signupAreaIds.split(","));
		}
		if (pageNumber != null && pageSize != null) {
			return fcExamSignupUserMapper.selectBySignupIdAndSignupIdList(signupId, signupAreaIdList,
					pageNumber * pageSize - pageSize, pageSize);
		} else {
			return fcExamSignupUserMapper.selectBySignupIdAndSignupIdList(signupId, signupAreaIdList, null, null);
		}
	}

	/**
	 * 身份证号和手机号查询用户的信息用于考试登录
	 * 
	 * @param certificateNumber
	 * @param tellPhone
	 * @return
	 */
	public FcExamSignupUserVo findCertificateNumberAndTellPhone(String certificateNumber, String tellPhone) {
		return fcExamSignupUserMapper.selectCertificateNumberAndTellPhone(certificateNumber, tellPhone);
	}

	/**
	 * 查询用户的考试信息关联多个
	 * 
	 * @param certificateNumber
	 * @param tellPhone
	 * @return
	 */
	public List<FcExamToUserVo> findUserExams(String certificateNumber, String tellPhone) {
		return fcExamSignupUserMapper.selectUserExams(certificateNumber, tellPhone);
	}

	/**
	 * 
	 * @param certificateNumber
	 * @param tellPhone
	 * @return
	 */
	public ExamUserVo findUserInfo(String certificateNumber, String tellPhone, Integer signupId, Integer signupAreaId) {
		return fcExamSignupUserMapper.selectUserInfo(certificateNumber, tellPhone, signupId, signupAreaId);
	}

	/**
	 * 根据家长/从业者id查询信息
	 * 
	 * @param id 家长/从业者id
	 * @return
	 */
	public FcExamSignupUserPrepareVo selectSignupUserInfoById(Integer id) {
		return fcExamSignupUserMapper.selectSignupUserInfoById(id);
	}

	/**
	 * 人脸对比
	 * 
	 * @param request
	 * @param id
	 * @param imageUrl
	 */
	public Result compareFace(HttpServletRequest request, Integer id, String imageUrl) {
//		if (id == null) {
//			return ResultUtil.custom(-2, "参数错误，请检查参数");
//		}
//
//		if (imageUrl == null || imageUrl.equals("")) {
//			return ResultUtil.custom(-2, "参数错误，请检查参数");
//		}
//
//		String url = request.getScheme() + request.getServerName() + request.getServerPort();
//		FcExamSignupUser signupUser = fcExamSignupUserMapper.selectByPrimaryKey(id);
//
//		String imageURLA = signupUser.getCertificateFront();
//		if (imageURLA == null || imageURLA.equals("")) {
//			return ResultUtil.custom(-1, "报名信息错误");
//		}
//		imageURLA = url + imageURLA;
		String imageURLA = "http://explorer-image.oss-cn-shanghai.aliyuncs.com/1455274160764180/id_card.jpg?OSSAccessKeyId=LTAI4Fk9FstqSEYnqKJ5Dpeo&Expires=1599114269&Signature=Ook94YgZiyX2xS%2FxoSrAFRNF7Ng%3D";
		Result compareFace = CompareFace.compareFace(imageURLA, imageUrl);
		return compareFace;

	}
}
