package chinaPress.role.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.role.comment.model.FcCommentInfo;
import chinaPress.role.comment.vo.FcCommentListVo;

@Mapper
@Repository
public interface FcCommentInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insertSelective(FcCommentInfo record);

	FcCommentInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcCommentInfo record);

	/**
	 * 后台管理系统查看评论个数
	 * 
	 * @param userName  用户名
	 * @param tellPhone 手机号
	 * @param status    审核状态1.已审核0.未审核
	 * @return
	 */
	int selectManageFcCommentCount(@Param("userName") String userName, @Param("tellPhone") String tellPhone,
			@Param("status") Integer status);

	/**
	 * 后台管理系统查看评论列表
	 * 
	 * @param userName  用户名
	 * @param tellPhone 手机号
	 * @param status    审核状态1.已审核0.未审核
	 * @param offset    从哪一条数据开始查询
	 * @param rows      查询多少条数据
	 * @return
	 */
	List<FcCommentListVo> selectManageFcCommentList(@Param("userName") String userName,
			@Param("tellPhone") String tellPhone, @Param("status") Integer status, @Param("offset") Integer offset,
			@Param("rows") Integer rows);

	/**
	 * 后台管理系统查看评论详情
	 * 
	 * @param id 评论id
	 */
	FcCommentListVo selectManageFcCommentDetail(Integer id);
}