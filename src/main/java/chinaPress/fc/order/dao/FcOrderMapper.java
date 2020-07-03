package chinaPress.fc.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.vo.TerminalInstitutionOrderDetailVo;
import chinaPress.fc.order.vo.TerminalOrderListParam;
import chinaPress.fc.order.vo.TerminalOrderListVo;
import chinaPress.fc.order.vo.TerminalPayOrderDetailVo;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListParam;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListVo;
import chinaPress.fc.order.vo.TerminalSubmitOrderDetailVo;

@Mapper
@Repository
public interface FcOrderMapper {

	int insertSelective(FcOrder record);

	FcOrder selectByPrimaryKey(Integer id);

	FcOrder selectByCode(String code);

	int updateByPrimaryKeySelective(FcOrder record);

	/**
	 * 终端 我的订单数据数量
	 * 
	 * @param param
	 * @return
	 */
	int findTerminalOrderCount(TerminalOrderListParam param);

	/**
	 * 终端 我的订单数据集合
	 * 
	 * @param param
	 * @return
	 */
	List<TerminalOrderListVo> findTerminalOrderList(TerminalOrderListParam param);

	/**
	 * 终端 机构我的订单详情
	 * 
	 * @param id
	 * @return
	 */
	TerminalInstitutionOrderDetailVo findTerminalInstitutionOrderDetail(Integer id);

	/**
	 * 终端家长 课程数据数量
	 * 
	 * @param param
	 * @return
	 */
	int findTerminalPractitionerCourseCount(TerminalPractitionerOrderCourseListParam param);

	/**
	 * 终端家长 课程数据集合
	 * 
	 * @param param
	 * @return
	 */
	List<TerminalPractitionerOrderCourseListVo> findTerminalPractitionerCourseList(
			TerminalPractitionerOrderCourseListParam param);

	/**
	 * 查询课程是否拥有
	 * 
	 * @param roleId   角色id
	 * @param roleType 角色类型：1.家长2.从业者
	 * @param courseId 课程id
	 * @return
	 */
	FcOrder findMyCourseIsExist(Integer roleId, Integer roleType, Integer courseId);

	/**
	 * 终端支付订单详情
	 * 
	 * @param id
	 * @return
	 */
	TerminalPayOrderDetailVo findTerminalPayOrderDetail(Integer id);

	/**
	 * 终端提交订单详情
	 * 
	 * @param id
	 * @return
	 */
	TerminalSubmitOrderDetailVo findTerminalSubmitOrderDetail(Integer id);
}