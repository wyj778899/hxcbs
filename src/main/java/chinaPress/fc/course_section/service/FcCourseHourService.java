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
	 * @param sectionId
	 * @return
	 */
	public Result selectCourseHourListBySectionId(Integer personId,Integer courseId, Integer sectionId,Integer roleType,Integer type){
		List<FcCourseHourVo> data = fcCourseHourMapper.selectCourseHourListBySectionId(sectionId);
		if(data.size()>0) {
			Map<String, Object> map = fcOrderService.findMyCourseIsExist(personId, roleType, courseId);
			if(map.get("code").toString().equals("0")) {
				int index = fcOrderPersonService.findPersonHourIsPass(personId, roleType, courseId, data.get(0).getId());
				if(index == 1) {//通过
					return ResultUtil.custom(1, "查询成功", data);
				}else if(index == 0){
					return ResultUtil.custom(0, "看过未考过", data);
				}else {
					return ResultUtil.custom(-1, "暂无视频");
				}
			}else {
				if(type == 0) {
					return ResultUtil.custom(1, "免费试看", data);
				}else {
					return ResultUtil.custom(-1, "暂无视频");
				}
			}
			
		}else {
			return ResultUtil.custom(-1, "暂无视频");
		}
		
	}
	
	/**
	 * 根据课程id查询视频数量
	 * @param courseId
	 * @return
	 */
	public int selectCourseHourCountByCOurseId(Integer courseId) {
		return fcCourseHourMapper.selectCourseHourCountByCOurseId(courseId);
	}

}
