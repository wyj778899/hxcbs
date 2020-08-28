package chinaPress.exam.exam.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.exam.model.FcExam;
import chinaPress.exam.exam.vo.FcExamManageDetailVo;

@Mapper
@Repository
public interface FcExamMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcExam record);

	int insertSelective(FcExam record);

	FcExam selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcExam record);

	int updateByPrimaryKey(FcExam record);

	/**
	 * 查询考试详情
	 * 
	 * @param id 考试id
	 */
	FcExamManageDetailVo selectFcExamDetail(Integer id);

	/**
	 * 根据报名信息查询关联考试
	 * 
	 * @param signupId
	 * @param signupAreaId
	 * @param signupUserId
	 * @return
	 */
	FcExam selectFcExamBySignup(@Param("signupId") Integer signupId, @Param("signupAreaId") Integer signupAreaId,
			@Param("signupUserId") Integer signupUserId);
}