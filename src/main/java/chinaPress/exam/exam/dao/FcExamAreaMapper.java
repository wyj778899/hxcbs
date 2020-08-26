package chinaPress.exam.exam.dao;

import chinaPress.exam.exam.model.FcExamArea;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcExamAreaMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcExamArea record);

	int insertSelective(FcExamArea record);

	FcExamArea selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcExamArea record);

	int updateByPrimaryKey(FcExamArea record);

	/**
	 * 根据考试id删除
	 * 
	 * @param examId
	 * @return
	 */
	int deleteByFcExamId(Integer examId);
}