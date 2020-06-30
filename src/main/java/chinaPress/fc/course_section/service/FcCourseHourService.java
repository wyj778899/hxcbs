package chinaPress.fc.course_section.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.course_section.vo.FcCourseHourVo;

@Service
public class FcCourseHourService {
	
	@Autowired
	private FcCourseHourMapper fcCourseHourMapper;
	
	/**
	 * 根据课程id查询课程关联的视频第一个id
	 * @param courseId
	 * @return
	 */
	public int selectCourseHourIdBysectionId(Integer courseId) {
		List<Integer> list = fcCourseHourMapper.selectCourseHourIdBysectionId(courseId);
		if(list.size()>0) {
			return list.get(0);
		}else {
			return 0;
		}
	}
	
	/**
	 * 根据章节id查询关联课时
	 * @param sectionId
	 * @return
	 */
	public List<FcCourseHourVo> selectCourseHourListBySectionId(Integer sectionId){
		return  fcCourseHourMapper.selectCourseHourListBySectionId(sectionId);
		
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
