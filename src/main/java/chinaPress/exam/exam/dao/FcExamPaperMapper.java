package chinaPress.exam.exam.dao;

import chinaPress.exam.exam.model.FcExamPaper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcExamPaperMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcExamPaper record);

	int insertSelective(FcExamPaper record);

	FcExamPaper selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcExamPaper record);

	int updateByPrimaryKey(FcExamPaper record);

	/**
	 * 根据考试设置id删除
	 * 
	 * @param examId 考试设置id
	 * @return
	 */
	int deleteByExamId(Integer examId);
}