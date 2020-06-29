package chinaPress.fc.order.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.order.dao.FcOrderMapper;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.model.FcOrderPerson;
import chinaPress.fc.order.vo.TerminalInstitutionOrderDetailVo;
import chinaPress.fc.order.vo.TerminalOrderListParam;
import chinaPress.fc.order.vo.TerminalOrderListVo;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListParam;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListVo;

@Service
public class FcOrderService {

	@Autowired
	private FcOrderMapper fcOrderMapper;

	@Autowired
	private FcOrderPersonMapper fcOrderPersonMapper;

	@Autowired
	private FcCourseHourMapper fcCourseHourMapper;

	/**
	 * 终端 我的订单数据数量
	 * 
	 * @param param
	 * @return
	 */
	public int findTerminalOrderCount(TerminalOrderListParam param) {
		return fcOrderMapper.findTerminalOrderCount(param);
	}

	/**
	 * 终端 我的订单数据集合
	 * 
	 * @param param
	 * @return
	 */
	public List<TerminalOrderListVo> findTerminalOrderList(TerminalOrderListParam param) {
		return fcOrderMapper.findTerminalOrderList(param);
	}

	/**
	 * 终端 机构我的订单详情
	 * 
	 * @param id
	 * @return
	 */
	public TerminalInstitutionOrderDetailVo findTerminalInstitutionOrderDetail(Integer id) {
		TerminalInstitutionOrderDetailVo detail = fcOrderMapper.findTerminalInstitutionOrderDetail(id);
		if (detail != null) {
			detail.setVideoNumber(fcCourseHourMapper.selectCourseHourCountByCOurseId(detail.getCourseId()));
		}
		return detail;
	}

	/**
	 * 终端家长 课程数据数量
	 * 
	 * @param param
	 * @return
	 */
	public int findTerminalPractitionerCourseCount(TerminalPractitionerOrderCourseListParam param) {
		return fcOrderMapper.findTerminalPractitionerCourseCount(param);
	}

	/**
	 * 终端家长 课程数据集合
	 * 
	 * @param param
	 * @return
	 */
	public List<TerminalPractitionerOrderCourseListVo> findTerminalPractitionerCourseList(
			TerminalPractitionerOrderCourseListParam param) {
		return fcOrderMapper.findTerminalPractitionerCourseList(param);
	}

	/**
	 * 新增家长/从业者订单
	 * 
	 * @param record
	 * @return
	 */
	public int insertPractitioner(FcOrder record) {
		Date current_date = new Date();
		record.setCode(String.valueOf(current_date.getTime()));
		record.setDate(current_date);
		int index = fcOrderMapper.insertSelective(record);
		if (index > 0) {
			FcOrderPerson person = new FcOrderPerson();
			person.setOrderId(record.getId());
			person.setRoleId(record.getRoleId());
			// 家长
			if (record.getRoleType().intValue() == 2) {
				person.setRoleType(1);
			}
			// 从业者
			else if (record.getRoleType().intValue() == 3) {
				person.setRoleType(2);
			}
			person.setTotalCount(fcCourseHourMapper.selectCourseHourCountByCOurseId(record.getCourseId()));
			fcOrderPersonMapper.insertSelective(person);
			return record.getId();
		}
		return 0;
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public FcOrder selectById(Integer id) {
		return fcOrderMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据code 查询
	 * 
	 * @param code
	 * @return
	 */
	public FcOrder selectByCode(String code) {
		return fcOrderMapper.selectByCode(code);
	}

	/**
	 * 修改
	 * 
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(FcOrder record) {
		return fcOrderMapper.updateByPrimaryKeySelective(record);
	}
}
