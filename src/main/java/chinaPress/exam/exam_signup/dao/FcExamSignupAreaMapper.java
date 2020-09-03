package chinaPress.exam.exam_signup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.exam_signup.model.FcExamSignupArea;
import chinaPress.exam.exam_signup.vo.FcExamSignupAreaListVo;

@Mapper
@Repository
public interface FcExamSignupAreaMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcExamSignupArea record);

	int insertSelective(FcExamSignupArea record);

	FcExamSignupArea selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcExamSignupArea record);

	int updateByPrimaryKey(FcExamSignupArea record);

	/**
	 * 根据考试报名id删除
	 * 
	 * @author maguoliang
	 * @param signupId 考试报名id
	 * @return
	 */
	int deleteExamSignupAreaBySignupId(Integer signupId);

	/**
	 * 根据考试报名id查询该考试报名下的区域时间个数
	 * 
	 * @param signupId  考试报名id
	 * @param province  区域-省
	 * @param city      区域-市
	 * @param district  区域-区
	 * @param startTime 考试开始时间
	 * @param endTime   考试结束时间
	 * @param isPutaway 是否上架1.上架0.下架
	 * @return
	 */
	int selectBySignupIdCount(Integer signupId, @Param("province") String province, @Param("city") String city,
			@Param("district") String district, @Param("startTime") String startTime, @Param("endTime") String endTime,
			@Param("isPutaway") Integer isPutaway);

	/**
	 * 根据考试报名id查询该考试报名下的区域时间列表
	 * 
	 * @param signupId  考试报名id
	 * @param province  区域-省
	 * @param city      区域-市
	 * @param district  区域-区
	 * @param startTime 考试开始时间
	 * @param endTime   考试结束时间
	 * @param isPutaway 是否上架1.上架0.下架
	 * @param offset    从哪一条数据开始查询
	 * @param rows      查询多少条数据
	 * @return
	 */
	List<FcExamSignupAreaListVo> selectBySignupIdList(@Param("signupId") Integer signupId,
			@Param("province") String province, @Param("city") String city, @Param("district") String district,
			@Param("startTime") String startTime, @Param("endTime") String endTime,
			@Param("isPutaway") Integer isPutaway, @Param("offset") Integer offset, @Param("rows") Integer rows);

	/**
	 * 根据考试报名id查询
	 * 
	 * @param signupId
	 * @return
	 */
	List<FcExamSignupArea> selectBySignupId(Integer signupId);

	/**
	 * 查询是否有别的区域的报名了
	 * 
	 * @param signupId     考试报名id
	 * @param signupAreaId 考试报名区域id
	 * @param roleId       角色id
	 * @param roleType     角色类型1.家长2.从业者
	 * @return
	 */
	List<FcExamSignupArea> selectIsOtherSignup(@Param("signupId") Integer signupId,
			@Param("signupAreaId") Integer signupAreaId, @Param("roleId") Integer roleId,
			@Param("roleType") Integer roleType);
}