package chinaPress.fc.apply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.apply.service.FcApplyPersonService;
import chinaPress.fc.apply.vo.TerminalApplyPersonListParam;
import chinaPress.fc.apply.vo.TerminalApplyPersonListVo;

@RequestMapping("fc_apply_person")
@RestController
public class FcApplyPersonController {

	@Autowired
	private FcApplyPersonService fcApplyPersonService;

	/**
	 * 终端 数据数量
	 * 
	 * @param param
	 * @return
	 */
	@GetMapping("findTerminalCount")
	public Result findTerminalCount(TerminalApplyPersonListParam param) {
		int count = fcApplyPersonService.findTerminalCount(param);
		return ResultUtil.ok(count);
	}

	/**
	 * 终端 数据集合
	 * 
	 * @param param
	 * @return
	 */
	@GetMapping("findTerminalList")
	public Result findTerminalList(TerminalApplyPersonListParam param) {
		List<TerminalApplyPersonListVo> data = fcApplyPersonService.findTerminalList(param);
		return ResultUtil.ok(data);
	}
}
