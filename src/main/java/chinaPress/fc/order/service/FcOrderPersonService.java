package chinaPress.fc.order.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.course_section.dao.FcCourseHourMapper;
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

	@Autowired
	private FcCourseHourMapper fcCourseHourMapper;

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
				
				// 查询下个课时id
				int nextHourId = fcCourseHourMapper.selectCourseNextHourIdBysectionId(courseId, hourId);
				FcOrderPersonHour fcOrderPersonHour = fcOrderPersonHourMapper.selectByOrderPersonAndHour(personOrderId,
						nextHourId);
				if (fcOrderPersonHour == null) {
					FcOrderPersonHour personHour = new FcOrderPersonHour();
					personHour.setOrderPersonId(personOrderId);
					personHour.setHourId(nextHourId);
					fcOrderPersonHourMapper.insertSelective(personHour);
					return 1;
				}
			}
		}
		return 0;
	}

	/**
	 * 修改课时的通过状态
	 * 
	 * @param roleId   角色id
	 * @param roleType 角色类型（1.家长2.从业者）
	 * @param courseId 课程id
	 * @param hourId   课时id
	 * @param isPass   是否通过
	 * @return
	 */
	public int setHourIsPass(Integer roleId, Integer roleType, Integer courseId, Integer hourId, Integer isPass) {
		Integer personOrderId = fcOrderPersonMapper.findOrderPersonId(roleId, roleType, courseId);
		if (personOrderId != null) {
			// 如果看完了，且当前角色进度没有该章节视频记录则修改（针对视频没有小节题的）
			if (isPass.intValue() == 3) {
				FcOrderPersonHour fcOrderPersonHour = fcOrderPersonHourMapper.selectByOrderPersonAndHour(personOrderId,
						hourId);
				if (fcOrderPersonHour != null) {
					// 0.只有观看权限，
					if (fcOrderPersonHour.getIsPass().intValue() == 0) {
						FcOrderPersonHour hour = new FcOrderPersonHour();
						hour.setOrderPersonId(personOrderId);
						hour.setHourId(hourId);
						hour.setIsPass(isPass);
						return fcOrderPersonHourMapper.updateIsPass(hour);
					} 
					// 1.已观看完且通过测试，
					else if (fcOrderPersonHour.getIsPass().intValue() == 1) {
						
					} 
					// 2.已观看完未通过测试，
					else if (fcOrderPersonHour.getIsPass().intValue() == 2) {
						
					} 
					// 3.已观看完还未考试
					else if (fcOrderPersonHour.getIsPass().intValue() == 3) {
						
					}
				} else {
					FcOrderPersonHour record = new FcOrderPersonHour();
					record.setHourId(hourId);
					record.setOrderPersonId(personOrderId);
					record.setIsPass(isPass);
					fcOrderPersonHourMapper.insertSelective(record);
				}
			} else {
				FcOrderPersonHour fcOrderPersonHour = fcOrderPersonHourMapper.selectByOrderPersonAndHour(personOrderId,
						hourId);
				if (fcOrderPersonHour != null) {
					FcOrderPersonHour hour = new FcOrderPersonHour();
					hour.setOrderPersonId(personOrderId);
					hour.setHourId(hourId);
					hour.setIsPass(isPass);
					return fcOrderPersonHourMapper.updateIsPass(hour);
				}
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

	/**
	 * 查询某个人正在学习某课程的最新进度
	 * 
	 * @author maguoliang
	 * @param courseId 课程id
	 * @param roleId   角色id
	 * @param roleType 角色类型1.家长2.从业者
	 * @return
	 */
	public Integer selectTheNewestHour(Integer courseId, Integer roleId, Integer roleType) {
		return fcOrderPersonHourMapper.selectTheNewestHour(courseId, roleId, roleType);
	}
}
