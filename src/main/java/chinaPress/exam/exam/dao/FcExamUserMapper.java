package chinaPress.exam.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.exam.exam.model.FcExamUser;

@Mapper
@Repository
public interface FcExamUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcExamUser record);

	int insertSelective(FcExamUser record);

	FcExamUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcExamUser record);

	int updateByPrimaryKey(FcExamUser record);

	/**
	 * 根据考试id查询考试下的考试用户
	 * 
	 * @param examId
	 * @return
	 */
	List<FcExamUser> selectByFcExamId(Integer examId);
	
	/**
	 * 根据考试id删除考试下的考试用户
	 * @param examId
	 * @return
	 */
	int deleteByFcExamId(Integer examId);
}