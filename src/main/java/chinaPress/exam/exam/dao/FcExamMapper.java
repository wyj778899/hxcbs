package chinaPress.exam.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.exam.model.FcExam;
import chinaPress.exam.exam.vo.FcExamManageDetailVo;
import chinaPress.exam.exam.vo.FcExamManageListVo;

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

	/**
	 * 查询考试设置列表个数
	 * 
	 * @param name 考试名称
	 * @param type 考试类型
	 * @return
	 */
	int selectFcExamCount(@Param("name") String name, @Param("type") Integer type);

	/**
	 * 查询考试设置列表个数
	 * 
	 * @param name   考试名称
	 * @param type   考试类型
	 * @param offset 从哪一条开始查询
	 * @param rows   查询多少条
	 * @return
	 */
	List<FcExamManageListVo> selectFcExamList(@Param("name") String name, @Param("type") Integer type,
			@Param("offset") Integer offset, @Param("rows") Integer rows);
}