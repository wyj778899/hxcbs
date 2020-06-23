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
	 * 根据章节id查询关联课时
	 * @param sectionId
	 * @return
	 */
	public List<FcCourseHourVo> selectCourseHourListBySectionId(Integer sectionId){
		return fcCourseHourMapper.selectCourseHourListBySectionId(sectionId);
	}

}
