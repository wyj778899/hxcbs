package chinaPress.fc.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.vo.OrderInvoiceInfo;
import chinaPress.fc.order.vo.TerminalInstitutionOrderDetailVo;
import chinaPress.fc.order.vo.TerminalOrderListParam;
import chinaPress.fc.order.vo.TerminalOrderListVo;
import chinaPress.fc.order.vo.TerminalPayOrderDetailVo;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListParam;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListVo;
import chinaPress.fc.order.vo.TerminalSubmitOrderDetailVo;
import chinaPress.fc.order.vo.UserInvoiceInfo;

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

	/**
	 * 判断当前这个课程当前报名人是否正在学习中
	 * 
	 * @author maguoliang
	 * @param roleId   角色id
	 * @param roleType 角色类型
	 * @param courseId 课程id
	 * @return
	 */
	FcOrder selectCourseIsLearning(@Param("roleId") Integer roleId, @Param("roleType") Integer roleType,
			@Param("courseId") Integer courseId);

	/**
	 * 查询订单发票信息 record 订单对象
	 * 
	 * @return
	 */
	List<OrderInvoiceInfo> selectInvoiceInfo(FcOrder record);

	/**
	 * 查询订单发票信息个数 record 订单对象
	 * 
	 * @return
	 */
	int selectInvoiceInfoCount(FcOrder record);

	/**
	 * 根据发票类型查询用户的发票信息 家长/从业者，培训机构
	 * 
	 * @param type
	 * @return
	 */
	List<UserInvoiceInfo> selectUserInvoices(@Param("type") Integer type, @Param("page") Integer page,
			@Param("limit") Integer limit);

	/**
	 * 根据发票类型查询用户的发票信息个数 家长/从业者，培训机构
	 * 
	 * @param type
	 * @return
	 */
	int selectUserInvoicesCount(@Param("type") Integer type);

	/**
	 * 发票详情信息 终端和管理端公用
	 * 
	 * @param id
	 * @return
	 */
	OrderInvoiceInfo selectInvoicePage(@Param("id") Integer id);

	/**
	 * 查询某个角色针对某个课程已支付的订单
	 * 
	 * @author maguoliang
	 * @param roleId   角色id
	 * @param roleType 角色类型1.机构2.家长3.从业者
	 * @param courseId 课程id
	 * @return
	 */
	FcOrder selectIsExceptionOrder(@Param("roleId") Integer roleId, @Param("roleType") Integer roleType,
			@Param("courseId") Integer courseId);
}