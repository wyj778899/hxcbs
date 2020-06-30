package chinaPress.fc.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.order.model.FcOrderPerson;
import chinaPress.fc.order.model.FcOrderPersonHour;
import chinaPress.fc.order.vo.TerminalInstitutionOrderPersonParam;
import chinaPress.fc.order.vo.TerminalInstitutionOrderPersonVo;

@Mapper
@Repository
public interface FcOrderPersonMapper {
	int deleteByPrimaryKey(Integer id);

	int insertSelective(FcOrderPerson record);

	FcOrderPerson selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcOrderPerson record);

	/**
	 * 终端 查询订单人员数据数量
	 * 
	 * @param param
	 * @return
	 */
	int findTerminalCount(TerminalInstitutionOrderPersonParam param);

	/**
	 * 终端 查询订单人员数据集合
	 * 
	 * @param param
	 * @return
	 */
	List<TerminalInstitutionOrderPersonVo> findTerminalList(TerminalInstitutionOrderPersonParam param);

	/**
	 * 修改数据为个人
	 * 
	 * @return
	 */
	int updateIndividualByOrderId(Integer orderId);

	/**
	 * 查询id
	 * 
	 * @param roleId   角色id
	 * @param roleType 角色类型（1.家长2.从业者）
	 * @param courseId 课程id
	 * @return
	 */
	Integer findOrderPersonId(Integer roleId, Integer roleType, Integer courseId);

	/**
	 * 修改已看数量
	 * 
	 * @param id
	 * @return
	 */
	int updateHaveCount(Integer id);

	/**
	 * 查询课时
	 * @param roleId
	 * @param roleType
	 * @param courseId
	 * @param hourId
	 * @return
	 */
	FcOrderPersonHour findPersonHour(Integer roleId, Integer roleType, Integer courseId, Integer hourId);
}