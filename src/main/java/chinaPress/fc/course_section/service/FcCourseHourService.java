package chinaPress.fc.course_section.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.course_section.dao.FcCourseSectionMapper;
import chinaPress.fc.course_section.model.FcCourseHour;
import chinaPress.fc.course_section.vo.FcCourseHourVo;
import chinaPress.fc.course_section.vo.FcSectionHourInfo;
import chinaPress.fc.order.dao.FcOrderPersonHourMapper;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrderPersonHour;
import chinaPress.fc.order.service.FcOrderPersonService;
import chinaPress.fc.order.service.FcOrderService;

@Service
public class FcCourseHourService {

	@Autowired
	private FcCourseHourMapper fcCourseHourMapper;
	@Autowired
	private FcOrderPersonService fcOrderPersonService;
	@Autowired
	private FcOrderService fcOrderService;
	@Autowired
	private FcOrderPersonMapper fcOrderPersonMapper;
	@Autowired
	private FcOrderPersonHourMapper fcOrderPersonHourMapper;
	@Autowired
	private FcCourseSectionMapper fcCourseSectionMapper;

	/**
	 * 根据章节id查询关联课时
	 * 
	 * @param personId  角色id
	 * @param courseId  课程id
	 * @param sectionId 章节id
	 * @param roleType  角色类型：1.家长2.从业者
	 * @param type      视频下标，只有第一个视频会有值
	 * @return
	 */
	@Transactional
	public Result selectCourseHourListBySectionId(Integer personId, Integer courseId, Integer sectionId,
			Integer roleType, Integer type) {
		Result result = new Result();
		// 先去判断上个课时是否通过测试了，如果通过测试了，允许观看（不能快进，即isPass为0），如果没通过测试，删除本条记录，修改上个课时为已观看（未考试，即isPass为3）
		
		// 当前点击的课时章节
		List<FcCourseHourVo> data = fcCourseHourMapper.selectCourseHourListBySectionId(sectionId);
		if (data.size() > 0) {
			FcCourseHour currFcCourseHour = fcCourseHourMapper.selectByPrimaryKey(data.get(0).getId());
			// 当前点击的课时章节的上一节
			Integer lastHourId = fcCourseHourMapper.selectCourseLastHourIdBysectionId(courseId,
					currFcCourseHour.getOrder());

			FcOrderPersonHour lastFcOrderPersonHour = fcOrderPersonMapper.findPersonHour(personId, roleType, courseId,
					lastHourId);
			// 如果上个课时进度不为空
			if (lastFcOrderPersonHour != null) {
				// 只要不是没通过测试的，删除本条纪录
				// 查询 当前角色 针对于当前课程的选择的课时是否看过/考过
				int index = fcOrderPersonService.findPersonHourIsPass(personId, roleType, courseId,
						data.get(0).getId());
				
				if (lastFcOrderPersonHour.getIsPass().intValue() != 1 && index != -1) {
					// 更新上条为已看完且未考过试
					FcOrderPersonHour hour = new FcOrderPersonHour();
					hour.setOrderPersonId(lastFcOrderPersonHour.getOrderPersonId());
					hour.setHourId(lastHourId);
					hour.setIsPass(3);
					fcOrderPersonHourMapper.updateIsPass(hour);

					FcCourseHour fcCourseHour = fcCourseHourMapper.selectByPrimaryKey(lastHourId);
					// 查询这个课时是否有题
					int stemCount = fcCourseHourMapper.selectIsHaveStemBySectionId(sectionId);
					data = new ArrayList<FcCourseHourVo>();
					data.add(new FcCourseHourVo(fcCourseHour.getId(), fcCourseHour.getSectionId(), fcCourseHour.getName(),
							fcCourseHour.getAddress(), fcCourseHour.getUrl(), fcCourseHour.getFormat(),
							fcCourseHour.getIsLook(), stemCount > 0 ? 1 : 0));
					// 删除本条纪录
					fcOrderPersonHourMapper.deleteByOrderPersonIdAndHourId(lastFcOrderPersonHour.getOrderPersonId(),
							currFcCourseHour.getId());
					result = ResultUtil.custom(6, "检测到上个课程未通过小节测试，请先学习上一节课程并通过小节测试", data);
				} else {
					// 根据章节id查询是否有视频
					for (FcCourseHourVo fcCourseHourVo : data) {
						// 查询这个课时是否有题
						int stemCount = fcCourseHourMapper.selectIsHaveStemBySectionId(sectionId);
						fcCourseHourVo.setIsHaveStem(stemCount > 0 ? 1 : 0);
					}
					// 查询该课程是否买过
					Map<String, Object> map = fcOrderService.findMyCourseIsExist(personId, roleType, courseId);
					if (map.get("code").toString().equals("0")) {
						// 看完视频且通过小节测试了
						if (index == 1) {
							result = ResultUtil.custom(1, "可以观看", data);
						}
						// 看完视频但未通过小节测试
						else if (index == 2) {
							result = ResultUtil.custom(2, "看过未考过", data);
						}
						// 视频还未看完，正在学习
						else if (index == 0) {
							result = ResultUtil.custom(4, "从未考过小节测试", data);
						}
						// 看完视频从未考过小节测试
						else if (index == 3) {
							result = ResultUtil.custom(5, "从未考过小节测试", data);
						} else {
							result = ResultUtil.custom(0, "暂未学习到该视频", data);
						}
					} else {
						// 免费试看
						if (type == 0) {
							result = ResultUtil.custom(3, "免费试看", data);
						}
						// 没有购买课程
						else {
							result = ResultUtil.custom(-2, "暂无购买课程");
						}
					}
				}
			}
			// 为空代表第一个视频
			else {
				// 根据章节id查询是否有视频
				for (FcCourseHourVo fcCourseHourVo : data) {
					// 查询这个课时是否有题
					int stemCount = fcCourseHourMapper.selectIsHaveStemBySectionId(sectionId);
					fcCourseHourVo.setIsHaveStem(stemCount > 0 ? 1 : 0);
				}
				// 查询该课程是否买过
				Map<String, Object> map = fcOrderService.findMyCourseIsExist(personId, roleType, courseId);
				if (map.get("code").toString().equals("0")) {
					// 查询 当前角色 针对于当前课程的选择的课时是否看过/考过
					int index = fcOrderPersonService.findPersonHourIsPass(personId, roleType, courseId,
							data.get(0).getId());
					// 看完视频且通过小节测试了
					if (index == 1) {
						result = ResultUtil.custom(1, "可以观看", data);
					}
					// 看完视频但未通过小节测试
					else if (index == 2) {
						result = ResultUtil.custom(2, "看过未考过", data);
					}
					// 视频还未看完，正在学习
					else if (index == 0) {
						result = ResultUtil.custom(4, "从未考过小节测试", data);
					}
					// 看完视频从未考过小节测试
					else if (index == 3) {
						result = ResultUtil.custom(5, "从未考过小节测试", data);
					} else {
						result = ResultUtil.custom(0, "暂未学习到该视频", data);
					}
				} else {
					// 免费试看
					if (type == 0) {
						result = ResultUtil.custom(3, "免费试看", data);
					}
					// 没有购买课程
					else {
						result = ResultUtil.custom(-2, "暂无购买课程");
					}
				}
			}
		} else {
			return ResultUtil.custom(-1, "暂无视频");
		}
		return result;
	}

//	/**
//	 * 判断上个课时的状态
//	 * 
//	 * @author maguoliang
//	 * @param hourId    当前课时id
//	 * @param courseId  课程id
//	 * @param personId  人员id
//	 * @param roleType  角色类型
//	 * @param sectionId 章节id
//	 */
//	public Result judgeLastHour(Integer personId, Integer courseId, Integer sectionId,
//			Integer roleType, Integer type) {
//		Result result = new Result();
//		// 先去判断上个课时是否通过测试了，如果通过测试了，允许观看（不能快进，即isPass为0），如果没通过测试，删除本条记录，修改上个课时为已观看（未考试，即isPass为3）
//		FcCourseHour currFcCourseHour = fcCourseHourMapper.selectByPrimaryKey(hourId);
//		Integer lastHourId = fcCourseHourMapper.selectCourseLastHourIdBysectionId(courseId,
//				currFcCourseHour.getOrder());
//
//		FcOrderPersonHour lastFcOrderPersonHour = fcOrderPersonMapper.findPersonHour(personId, roleType, courseId,
//				lastHourId);
//		// 如果上个课时进度不为空
//		if (lastFcOrderPersonHour != null) {
//			// 只要不是没通过测试的，删除本条纪录
//			if (lastFcOrderPersonHour.getIsPass().intValue() != 1) {
//				// 更新上条为已看完且未考过试
//				FcOrderPersonHour hour = new FcOrderPersonHour();
//				hour.setOrderPersonId(lastFcOrderPersonHour.getOrderPersonId());
//				hour.setHourId(lastHourId);
//				hour.setIsPass(3);
//				fcOrderPersonHourMapper.updateIsPass(hour);
//
//				FcCourseHour fcCourseHour = fcCourseHourMapper.selectByPrimaryKey(lastHourId);
//				// 查询这个课时是否有题
//				int stemCount = fcCourseHourMapper.selectIsHaveStemBySectionId(sectionId);
//				data = new ArrayList<FcCourseHourVo>();
//				data.add(new FcCourseHourVo(fcCourseHour.getId(), fcCourseHour.getSectionId(), fcCourseHour.getName(),
//						fcCourseHour.getAddress(), fcCourseHour.getUrl(), fcCourseHour.getFormat(),
//						fcCourseHour.getIsLook(), stemCount > 0 ? 1 : 0));
//				// 删除本条纪录
//				fcOrderPersonHourMapper.deleteByOrderPersonIdAndHourId(lastFcOrderPersonHour.getOrderPersonId(),
//						hourId);
//				result = ResultUtil.custom(6, "检测到上个课程未通过小节测试，请先学习上一节课程并通过小节测试", data);
//			} else {
//				// 根据章节id查询是否有视频
//				List<FcCourseHourVo> data = fcCourseHourMapper.selectCourseHourListBySectionId(sectionId);
//				if (data.size() > 0) {
//					for (FcCourseHourVo fcCourseHourVo : data) {
//						// 查询这个课时是否有题
//						int stemCount = fcCourseHourMapper.selectIsHaveStemBySectionId(sectionId);
//						fcCourseHourVo.setIsHaveStem(stemCount > 0 ? 1 : 0);
//					}
//					// 查询该课程是否买过
//					Map<String, Object> map = fcOrderService.findMyCourseIsExist(personId, roleType, courseId);
//					if (map.get("code").toString().equals("0")) {
//						// 查询 当前角色 针对于当前课程的选择的课时是否看过/考过
//						int index = fcOrderPersonService.findPersonHourIsPass(personId, roleType, courseId,
//								data.get(0).getId());
//						// 看完视频且通过小节测试了
//						if (index == 1) {
//							return ResultUtil.custom(1, "可以观看", data);
//						}
//						// 看完视频但未通过小节测试
//						else if (index == 2) {
//							return ResultUtil.custom(2, "看过未考过", data);
//						}
//						// 视频还未看完，正在学习
//						else if (index == 0) {
////							return judgeLastHour(data.get(0).getId(), courseId, personId, roleType, sectionId, data, index);
//							return ResultUtil.custom(4, "从未考过小节测试", data);
//						}
//						// 看完视频从未考过小节测试
//						else if (index == 3) {
////							return judgeLastHour(data.get(0).getId(), courseId, personId, roleType, sectionId, data, index);
//							return ResultUtil.custom(5, "从未考过小节测试", data);
//						} else {
//							return ResultUtil.custom(0, "暂未学习到该视频", data);
//						}
//					} else {
//						// 免费试看
//						if (type == 0) {
//							return ResultUtil.custom(3, "免费试看", data);
//						}
//						// 没有购买课程
//						else {
//							return ResultUtil.custom(-2, "暂无购买课程");
//						}
//					}
//
//				} else {
//					return ResultUtil.custom(-1, "暂无视频");
//				}
//			}
//		}
//		// 为空代表第一个视频
//		else {
//
//		}
//		return result;
//	}

//	/**
//	 * 是否可以学习该章节
//	 * 
//	 * @param roleId   角色id
//	 * @param roleType 角色类型：1.家长2.从业者
//	 * @param courseId 课程id
//	 * @param hourId   课时id
//	 * @return
//	 */
//	public Result findIsLearnSection(Integer roleId, Integer roleType, Integer courseId, Integer hourId) {
//		Map<String, Object> map = fcOrderService.findMyCourseIsExist(roleId, roleType, courseId);
//		if (map.get("code").toString().equals("0")) {
//			int index = fcOrderPersonService.findPersonHourIsPass(roleId, roleType, courseId, roleId);
//			if (index == 1) {// 通过
//				return ResultUtil.custom(1, "可以观看");
//			} else {
//				return ResultUtil.custom(0, "暂未学习到该视频");
//			}
//		} else {
//			return ResultUtil.custom(-1, "暂无购买课程");
//		}
//	}

	/**
	 * 根据课程id查询视频数量
	 * 
	 * @param courseId
	 * @return
	 */
	public int selectCourseHourCountByCOurseId(Integer courseId) {
		return fcCourseHourMapper.selectCourseHourCountByCOurseId(courseId);
	}

	
	/**
	 * 查询所有课时id和章节名称用于试题关联展示
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findSectionAndHourAll() {
		try {
			List<FcSectionHourInfo> selectSectionAndHours = fcCourseSectionMapper.selectSectionAndHourAll();
			if(selectSectionAndHours.size()>0) {
				return new Result(1,"查询成功",selectSectionAndHours);
			}else {
				return new Result(0,"无数据","");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
}
