package chinaPress.exam.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.exam.model.FcExamUser;
import chinaPress.exam.exam.vo.FcExamManageAreaUserListVo;

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
	 * 
	 * @param examId
	 * @return
	 */
	int deleteByFcExamId(Integer examId);

	/**
	 * 查询考试区域用户
	 * 
	 * @param signupAreaId      考试报名区域id
	 * @param name              名称
	 * @param phone             手机
	 * @param certificateNumber 身份证
	 * @param status            状态1.通过2.没通过
	 * @return
	 */
	int selectFcExamAreaUserCount(@Param("signupAreaId") Integer signupAreaId, @Param("name") String name,
			@Param("phone") String phone, @Param("certificateNumber") String certificateNumber,
			@Param("status") Integer status);

	/**
	 * 查询考试区域用户
	 * 
	 * @param signupAreaId      考试报名区域id
	 * @param name              名称
	 * @param phone             手机
	 * @param certificateNumber 身份证
	 * @param status            状态1.通过2.没通过
	 * @param offset            从第几条数据开始查询
	 * @param rows              查询多少条
	 * @return
	 */
	List<FcExamManageAreaUserListVo> selectFcExamAreaUserList(@Param("signupAreaId") Integer signupAreaId,
			@Param("name") String name, @Param("phone") String phone,
			@Param("certificateNumber") String certificateNumber, @Param("status") Integer status,
			@Param("offset") Integer offset, @Param("rows") Integer rows);
}