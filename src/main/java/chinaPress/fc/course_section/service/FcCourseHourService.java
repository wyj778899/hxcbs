package chinaPress.fc.course_section.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.course_section.vo.FcCourseHourVo;
import chinaPress.fc.order.service.FcOrderPersonService;

@Service
public class FcCourseHourService {
	
	@Autowired
	private FcCourseHourMapper fcCourseHourMapper;
	@Autowired
	private FcOrderPersonService fcOrderPersonService;
	
	/**
	 * 根据章节id查询关联课时
	 * @param sectionId
	 * @return
	 */
	public Result selectCourseHourListBySectionId(Integer personId,Integer courseId, Integer sectionId,Integer roleType){
		List<FcCourseHourVo> data = fcCourseHourMapper.selectCourseHourListBySectionId(sectionId);
		if(data.size()>0) {
			int index = fcOrderPersonService.findPersonHourIsPass(personId, roleType, courseId, data.get(0).getId());
			if(index == 1) {//通过
				return ResultUtil.custom(1, "操作成功", data);
			}else if(index == 0){
				return ResultUtil.custom(0, "操作成功", data);
			}else {
				return ResultUtil.custom(-1, "暂无视频");
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
