package chinaPress.fc.order.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.course_section.model.FcCourseHour;
import chinaPress.fc.order.dao.FcOrderPersonHourMapper;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrderPerson;
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
	@Transactional
	public int setHaveCount(Integer roleId, Integer roleType, Integer courseId, Integer hourId, Integer isPass) {
		Integer personOrderId = fcOrderPersonMapper.findOrderPersonId(roleId, roleType, courseId);
		if (personOrderId != null) {
			// 修改学习进度信息
			FcOrderPerson fcOrderPerson = fcOrderPersonMapper.selectByPrimaryKey(personOrderId);
			if (fcOrderPerson.getHaveCount() < fcOrderPerson.getTotalCount()) {
				fcOrderPersonMapper.updateHaveCount(personOrderId);
			}
			
			// 修改课时学习状态
			FcOrderPersonHour hour = new FcOrderPersonHour();
			hour.setOrderPersonId(personOrderId);
			hour.setHourId(hourId);
			hour.setIsPass(isPass);
			hour.setPassTime(new Date());
			fcOrderPersonHourMapper.updateIsPass(hour);
			
			// 添加下个课时的学习进度和状态，查询下个课时id
			// 先查询当前这个课时的排序
			FcCourseHour currFcCourseHour = fcCourseHourMapper.selectByPrimaryKey(hourId);
			Integer nextHourId = fcCourseHourMapper.selectCourseNextHourIdBysectionId(courseId, currFcCourseHour.getOrder());
			if (nextHourId != null) {
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
			// 针对播放完毕
			// 如果看完了，且当前角色进度没有该章节视频记录则修改（针对视频没有小节题的）
			if (isPass.intValue() == 3) {
				FcOrderPersonHour fcOrderPersonHour = fcOrderPersonHourMapper.selectByOrderPersonAndHour(personOrderId,
						hourId);
				if (fcOrderPersonHour != null) {
					// 0.只有观看权限，
					if (fcOrderPersonHour.getIsPass().intValue() == 0) {
						// 更新进度信息
						FcOrderPersonHour hour = new FcOrderPersonHour();
						hour.setOrderPersonId(personOrderId);
						hour.setHourId(hourId);
						int sectionId = fcCourseHourMapper.selectByPrimaryKey(hourId).getSectionId();
						int stemCount = fcCourseHourMapper.selectIsHaveStemBySectionId(sectionId);
						// 没题
						if (stemCount <= 0) {
							hour.setIsPass(1);
							fcOrderPersonHourMapper.updateIsPass(hour);
							// 更新学习进度
							FcOrderPerson fcOrderPerson = fcOrderPersonMapper.selectByPrimaryKey(personOrderId);
							if (fcOrderPerson.getHaveCount() < fcOrderPerson.getTotalCount()) {
								fcOrderPersonMapper.updateHaveCount(personOrderId);
							}
						} 
						// 有题
						else {
							hour.setIsPass(3);
							fcOrderPersonHourMapper.updateIsPass(hour);
						}
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
					// 查询该课时是否有小节自测题，如果没有，那么添加下一个课时的进度信息
					// 查询这个课时是否有题
					int sectionId = fcCourseHourMapper.selectByPrimaryKey(hourId).getSectionId();
					int stemCount = fcCourseHourMapper.selectIsHaveStemBySectionId(sectionId);
					if (stemCount <= 0) {
						FcCourseHour currFcCourseHour = fcCourseHourMapper.selectByPrimaryKey(hourId);
						Integer nextHourId = fcCourseHourMapper.selectCourseNextHourIdBysectionId(courseId, currFcCourseHour.getOrder());
						// 为空代表是当前是最后一个课时了
						if (nextHourId != null) {
							FcOrderPersonHour nextFcOrderPersonHour = fcOrderPersonHourMapper.selectByOrderPersonAndHour(personOrderId,
									nextHourId);
							if (nextFcOrderPersonHour == null) {
								FcOrderPersonHour record = new FcOrderPersonHour();
								record.setHourId(nextHourId);
								record.setOrderPersonId(personOrderId);
								record.setIsPass(0);
								fcOrderPersonHourMapper.insertSelective(record);
							}
						}
					}
					return 1;
				} 
			} 
			// 针对小节测试未通过，也就是isPass只能为2
			else {
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
