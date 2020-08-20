package chinaPress.exam.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.exam.group.service.FcGroupService;

@RestController
@RequestMapping("fc_group")
public class FcGroupController {
	@Autowired
	private FcGroupService fcGroupService;
	
}
