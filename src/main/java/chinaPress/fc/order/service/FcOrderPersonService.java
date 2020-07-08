package chinaPress.fc.order.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.order.dao.FcOrderPersonHourMapper;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrderPersonHour;
import chinaPress.fc.order.vo.TerminalInstitutionOrderPersonParam;
import chinaPress.fc.order.vo.TerminalInstitutionOrderPersonVo;

@Service
public class FcOrderPersonService {

	@Autowired
	private FcOrderPersonMapper fcOrderPersonMapper;

	@Autowired
	private FcOrderPersonHourMapper fcOrderPersonHourMapper;

	/**
	 * 终端 查询订单人员数据数量
	 * 
	 * @param param
	 * @return
	 */
	public int findTerminalCount(TerminalInstitutionOrderPersonParam param) {
		return fcOrderPersonMapper.findTerminalCount(param);
	}

	/**
	 * 终端 查询订单人员数据集合
	 * 
	 * @param param
	 * @return
	 */
	public List<TerminalInstitutionOrderPersonVo> findTerminalList(TerminalInstitutionOrderPersonParam param) {
		return fcOrderPersonMapper.findTerminalList(param);
	}

	/**
	 * 修改已看数量
	 * 
	 * @param roleId   角色id
	 * @param roleType 角色类型（1.家长2.从业者）
	 * @param courseId 课程id
	 * @param hourId   课时id
	 * @param isPass   是否通过
	 * @return
	 */
	public int setHaveCount(Integer roleId, Integer roleType, Integer courseId, Integer hourId, Integer isPass) {
		Integer personOrderId = fcOrderPersonMapper.findOrderPersonId(roleId, roleType, courseId);
		if (personOrderId != null) {
			int index = fcOrderPersonMapper.updateHaveCount(personOrderId);
			if (index > 0) {
				FcOrderPersonHour hour = new FcOrderPersonHour();
				hour.setOrderPersonId(personOrderId);
				hour.setHourId(hourId);
				hour.setIsPass(isPass);
				hour.setPassTime(new Date());
				fcOrderPersonHourMapper.updateIsPass(hour);
				return 1;
			}
		}
		return 0;
	}

	/**
	 * 查询课时是否通过
	 * 
	 * @param roleId
	 * @param roleType 角色类型（1.家长2.从业者）
	 * @param courseId
	 * @param hourId
	 * @return
	 */
	public int findPersonHourIsPass(Integer roleId, Integer roleType, Integer courseId, Integer hourId) {
		FcOrderPersonHour model = fcOrderPersonMapper.findPersonHour(roleId, roleType, courseId, hourId);
		if (model != null) {
			return model.getIsPass();
		} else {
			return -1;
		}
	}
}
