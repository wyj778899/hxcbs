package chinaPress.fc.apply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.apply.service.FcApplyService;

@RequestMapping("fc_apply")
@RestController
public class FcApplyController {

	@Autowired
	private FcApplyService fcApplyService;

	/**
	 * 新增
	 * 
	 * @param record
	 * @param personJson
	 * @return
	 */
	@GetMapping("insert")
	public Result insert(FcApply record, String personJson) {
		int index = fcApplyService.insert(record, personJson);
		if (index > 0) {
			return ResultUtil.ok();
		} else {
			return ResultUtil.error();
		}
	}
	
}
