package chinaPress.fc.course_section.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.course_section.vo.FcCourseHourVo;
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
	public Result selectCourseHourListBySectionId(Integer personId, Integer courseId, Integer sectionId,
			Integer roleType, Integer type) {
		// 根据章节id查询是否有视频
		List<FcCourseHourVo> data = fcCourseHourMapper.selectCourseHourListBySectionId(sectionId);
		if (data.size() > 0) {
			// 查询该课程是否买过
			Map<String, Object> map = fcOrderService.findMyCourseIsExist(personId, roleType, courseId);
			if (map.get("code").toString().equals("0")) {
				// 查询 当前角色  针对于当前课程的选择的课时是否看过/考过
				int index = fcOrderPersonService.findPersonHourIsPass(personId, roleType, courseId,
						data.get(0).getId());
				// 看完视频且通过小节测试了
				if (index == 1) {
					return ResultUtil.custom(1, "可以观看", data);
				}
				// 看完视频但未通过小节测试
				else if (index == 2) {
					return ResultUtil.custom(2, "看过未考过", data);
				}
				// 视频还未看完，正在学习
				else if (index == 0) {
					return ResultUtil.custom(4, "从未考过小节测试", data);
				}
				// 看完视频从未考过小节测试
				else if (index == 3) {
					return ResultUtil.custom(5, "从未考过小节测试", data);
				}
				else {
					return ResultUtil.custom(0, "暂未学习到该视频");
				}
			} else {
				// 免费试看
				if (type == 0) {
					return ResultUtil.custom(3, "免费试看", data);
				} 
				// 没有购买课程
				else {
					return ResultUtil.custom(-1, "暂无购买课程");
				}
			}

		} else {
			return ResultUtil.custom(-1, "暂无视频");
		}

	}

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

}
