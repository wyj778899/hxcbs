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
	 * @param signupId 考试报名id
	 * @return
	 */
	int selectBySignupIdCount(Integer signupId);

	/**
	 * 根据考试报名id查询该考试报名下的区域时间列表
	 * 
	 * @param signupId 考试报名id
	 * @param offset   从哪一条数据开始查询
	 * @param rows     查询多少条数据
	 * @return
	 */
	List<FcExamSignupAreaListVo> selectBySignupIdList(@Param("signupId") Integer signupId,
			@Param("offset") Integer offset, @Param("rows") Integer rows);
}