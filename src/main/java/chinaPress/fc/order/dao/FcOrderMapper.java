package chinaPress.fc.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.vo.TerminalInstitutionOrderDetailVo;
import chinaPress.fc.order.vo.TerminalInstitutionOrderDetailVo;
import chinaPress.fc.order.vo.TerminalInstitutionOrderDetailVo;
import chinaPress.fc.order.vo.TerminalOrderListParam;
import chinaPress.fc.order.vo.TerminalOrderListVo;

@Mapper
@Repository
public interface FcOrderMapper {

	int insertSelective(FcOrder record);

	FcOrder selectByPrimaryKey(Integer id);

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
	 * @param id
	 * @return
	 */
	TerminalInstitutionOrderDetailVo findTerminalInstitutionOrderDetail(Integer id);

}