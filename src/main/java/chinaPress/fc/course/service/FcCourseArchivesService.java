package chinaPress.fc.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.course.dao.FcCourseArchivesMapper;

@Service
public class FcCourseArchivesService {
	@Autowired
	private FcCourseArchivesMapper fcCourseArchivesMapper;

}
