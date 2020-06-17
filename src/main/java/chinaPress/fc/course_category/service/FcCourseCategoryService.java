package chinaPress.fc.course_category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.course.dao.FcCourseArchivesMapper;

@Service
public class FcCourseCategoryService {
	@Autowired
	private FcCourseArchivesMapper fcCourseArchivesMapper;

}
