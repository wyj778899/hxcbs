package chinaPress.fc.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.fc.course.service.FcCourseArchivesService;

@RestController
public class FcCourseArchivesController {
	@Autowired
	private FcCourseArchivesService fcCourseArchivesService;

}
