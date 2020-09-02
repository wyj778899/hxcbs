package chinaPress.exam.exam_signup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.exam_signup.model.FcExamSignupUser;
import chinaPress.exam.exam_signup.vo.ExamUserVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupDetailAreaListVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserDetailVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserListIndexVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserListVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserPrepareVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserVo;
import chinaPress.exam.exam_signup.vo.FcExamToUserVo;

@Mapper
@Repository
public interface FcExamSignupUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcExamSignupUser record);

	int insertSelective(FcExamSignupUser record);

	FcExamSignupUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcExamSignupUser record);

	int updateByPrimaryKey(FcExamSignupUser record);

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
	 * @param startTime         开始时间
	 * @param endTime           结束时间
	 * @return
	 */
	int selectExamSignupUserCount(@Param("signupId") Integer signupId, @Param("signupAreaId") List<String> signupAreaId,
			@Param("userName") String userName, @Param("tellPhone") String tellPhone,
			@Param("certificateNumber") String certificateNumber, @Param("examineType") Integer examineType,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

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
	 * @param startTime         开始时间
	 * @param endTime           结束时间
	 * @param offset            从第几条数据开始查询
	 * @param rows              查询多少条
	 * @return
	 */
	List<FcExamSignupUserListVo> selectExamSignupUserList(@Param("signupId") Integer signupId,
			@Param("signupAreaId") List<String> signupAreaId, @Param("userName") String userName,
			@Param("tellPhone") String tellPhone, @Param("certificateNumber") String certificateNumber,
			@Param("examineType") Integer examineType, @Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("offset") Integer offset, @Param("rows") Integer rows);

	/**
	 * 根据考试报名id和区域id查询有多少人
	 * 
	 * @author maguoliang
	 * @param signupId
	 * @param areaId
	 * @return
	 */
	int selectCountBySignupIdAndAreaId(@Param("signupId") Integer signupId, @Param("areaId") Integer areaId);

	/**
	 * 查询前台管理端用户的已报名审核个数
	 * 
	 * @param roleId   角色id
	 * @param roleType 角色类型1.家长2.从业者
	 * @return
	 */
	int selectUserFcExamSignupCount(@Param("roleId") Integer roleId, @Param("roleType") Integer roleType);

	/**
	 * 查询前台管理端用户的已报名审核列表
	 * 
	 * @param roleId   角色id
	 * @param roleType 角色类型1.家长2.从业者
	 * @param offset   从第几条数据开始查询
	 * @param rows     查询多少条
	 * @return
	 */
	List<FcExamSignupUserListIndexVo> selectUserFcExamSignupList(@Param("roleId") Integer roleId,
			@Param("roleType") Integer roleType, @Param("offset") Integer offset, @Param("rows") Integer rows);

	/**
	 * 查询考试报名用户信息
	 * 
	 * @param signupUserId 考试报名用户id
	 * @return
	 */
	FcExamSignupUserDetailVo selectFcExamSignupUserDetail(Integer signupUserId);

	/**
	 * 查询是否已经报名了
	 * 
	 * @param signupId     考试报名id
	 * @param signupAreaId 考试报名区域id
	 * @param roleId       角色id
	 * @param roleType     角色类型1.家长2.从业者
	 * @return
	 */
	List<FcExamSignupUser> selectIsSignup(@Param("signupId") Integer signupId,
			@Param("signupAreaId") Integer signupAreaId, @Param("roleId") Integer roleId,
			@Param("roleType") Integer roleType);

	/**
	 * 根据多个考试报名区域id和考试报名id查询
	 * 
	 * @param signupId         考试报名id
	 * @param signupAreaIdList 考试报名区域id集合
	 * @return
	 */
	int selectBySignupIdAndSignupIdCount(@Param("signupId") Integer signupId,
			@Param("signupAreaIdList") List<String> signupAreaIdList);

	/**
	 * 根据多个考试报名区域id和考试报名id查询
	 * 
	 * @param signupId         考试报名id
	 * @param signupAreaIdList 考试报名区域id集合
	 * @param offset           从第几条数据开始查询
	 * @param rows             查询多少条
	 * @return
	 */
	List<FcExamSignupDetailAreaListVo> selectBySignupIdAndSignupIdList(@Param("signupId") Integer signupId,
			@Param("signupAreaIdList") List<String> signupAreaIdList, @Param("offset") Integer offset,
			@Param("rows") Integer rows);

	/**
	 * 通过手机号和身份证号查询用户的考试信息 用于登录考试
	 * 
	 * @param certificateNumber
	 * @param tellPhone
	 * @return
	 */
	FcExamSignupUserVo selectCertificateNumberAndTellPhone(@Param("certificateNumber") String certificateNumber,
			@Param("tellPhone") String tellPhone);

	/**
	 * 查询用户的考试信息
	 * 
	 * @param certificateNumber
	 * @param tellPhone
	 * @return
	 */
	List<FcExamToUserVo> selectUserExams(@Param("certificateNumber") String certificateNumber,
			@Param("tellPhone") String tellPhone);

	/**
	 * 用于展示用户信息
	 * 
	 * @param certificateNumber
	 * @param tellPhone
	 * @return
	 */
	ExamUserVo selectUserInfo(@Param("certificateNumber") String certificateNumber,
			@Param("tellPhone") String tellPhone, @Param("signupId") Integer signupId,
			@Param("signupAreaId") Integer signupAreaId);

	/**
	 * 根据家长/从业者id查询信息
	 * 
	 * @param id 家长/从业者id
	 * @return
	 */
	FcExamSignupUserPrepareVo selectSignupUserInfoById(Integer id);
}