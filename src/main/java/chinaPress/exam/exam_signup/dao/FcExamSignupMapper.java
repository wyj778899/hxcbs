package chinaPress.exam.exam_signup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.exam_signup.model.FcExamSignup;
import chinaPress.exam.exam_signup.vo.FcExamSignupIndexDetailVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupIndexVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupListVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupManageDetailVo;

@Mapper
@Repository
public interface FcExamSignupMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcExamSignup record);

	int insertSelective(FcExamSignup record);

	FcExamSignup selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcExamSignup record);

	int updateByPrimaryKey(FcExamSignup record);

	/**
	 * 查询考试报名列表个数
	 * 
	 * @author maguoliang
	 * @param signupName 考试报名名称
	 * @param examForm   考试形式(1现场0非现场)
	 * @param isPutaway  是否上架1.上架0.下架
	 * @return
	 */
	int selectExamSignupCount(@Param("signupName") String signupName, @Param("examForm") Integer examForm,
			@Param("isPutaway") Integer isPutaway);

	/**
	 * 查询考试报名列表个数
	 * 
	 * @author maguoliang
	 * @param signupName 考试报名名称
	 * @param examForm   考试形式(1现场0非现场)
	 * @param isPutaway  是否上架1.上架0.下架
	 * @param offset     从哪一条数据开始查询
	 * @param rows       查询多少条数据
	 * @return
	 */
	List<FcExamSignupListVo> selectExamSignupList(@Param("signupName") String signupName,
			@Param("examForm") Integer examForm, @Param("isPutaway") Integer isPutaway, @Param("offset") Integer offset,
			@Param("rows") Integer rows);

	/**
	 * 查询已上架的考试报个数
	 * 
	 * @return
	 */
	int selectPutawayExamSignupCount();

	/**
	 * 查询已上架的考试报名列表
	 * 
	 * @param offset 从哪一条数据开始查询
	 * @param rows   查询多少条数据
	 * @return
	 */
	List<FcExamSignupIndexVo> selectPutawayExamSignupList(@Param("offset") Integer offset, @Param("rows") Integer rows);

	/**
	 * 查询已上架的考试报名详情
	 * 
	 * @author maguoliang
	 * @param signupId 考试报名id
	 * @return
	 */
	FcExamSignupIndexDetailVo selectPutawayExamSignupDetail(Integer signupId);

	/**
	 * 查询考试报名详情
	 * 
	 * @param signupId 考试报名id
	 * @return
	 */
	FcExamSignupManageDetailVo selectExamSignupDetail(Integer signupId);
}