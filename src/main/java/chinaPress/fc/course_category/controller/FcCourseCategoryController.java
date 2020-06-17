package chinaPress.fc.course_category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.fc.course.service.FcCourseArchivesService;

@RestController
public class FcCourseCategoryController {

	@Autowired
	private FcCourseArchivesService fcCourseArchivesService;
}
