package chinaPress.fc.apply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.apply.vo.OrderVo;
import chinaPress.fc.apply.vo.TerminalApplyListParam;
import chinaPress.fc.apply.vo.TerminalApplyListVo;
import chinaPress.fc.apply.vo.TerminalInstitutionApplyDetailVo;
import chinaPress.fc.apply.vo.TerminalPractitionerApplyDetailVo;

@Mapper
@Repository
public interface FcApplyMapper {

	int insertSelective(FcApply record);

	FcApply selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcApply record);

	/**
	 * 终端 报名申请数据数量
	 * 
	 * @return
	 */
	int findTerminalApplyCount(TerminalApplyListParam param);

	/**
	 * 终端 报名申请数据集合
	 * 
	 * @return
	 */
	List<TerminalApplyListVo> findTerminalApplyList(TerminalApplyListParam param);

	/**
	 * 终端机构 详情
	 * 
	 * @param id
	 * @return
	 */
	TerminalInstitutionApplyDetailVo findTerminalInstitutionDetail(Integer id);

	/**
	 * 终端家长 详情
	 * 
	 * @param id
	 * @return
	 */
	TerminalPractitionerApplyDetailVo findTerminalPractitionerDetail(Integer id);

	/**
	 * 查询是否为第二次报名
	 * 
	 * @author maguoliang
	 * @param courseId 课程id
	 * @param roleType 角色类型1.家长2.从业者
	 * @param roleId   角色id
	 * @return
	 */
	FcApply selectIsSecondApply(@Param("courseId") Integer courseId, @Param("roleType") Integer roleType,
			@Param("roleId") Integer roleId);
	
	
	/**
	 * 通过课程id,角色id，角色类型查询用户的订单状态和订单创建时间                   判断机构是不是给这个用户二次报名
	 * @param courseId
	 * @param roleType   1.家长2.从业者
	 * @param roleId
	 * @return
	 */
	OrderVo selectApplyOrder(@Param("courseId") Integer courseId, @Param("roleType") Integer roleType,@Param("roleId") Integer roleId);
}