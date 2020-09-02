package chinaPress.exam.exam_option.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.exam.exam_option.model.FcExamOption;
import chinaPress.exam.exam_option.service.FcExamOptionService;

@RestController
@RequestMapping("/examOption")
public class FcExamOptionController {

	/**
	 * 考生考试service
	 */
	@Autowired
	private FcExamOptionService fcExamOptionService;
	
	
	/**
	 * 添加考生考试信息
	 * @param option
	 * @return
	 */
	@RequestMapping("/registerExamOption")
	public Result registerExamOption(FcExamOption option) {
		return fcExamOptionService.addExamOption(option);
	}
	
	
}
