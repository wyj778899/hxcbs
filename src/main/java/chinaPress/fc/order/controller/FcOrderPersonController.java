package chinaPress.fc.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.order.service.FcOrderPersonService;
import chinaPress.fc.order.vo.TerminalInstitutionOrderPersonParam;
import chinaPress.fc.order.vo.TerminalInstitutionOrderPersonVo;

@RequestMapping("fc_order_person")
@RestController
public class FcOrderPersonController {

	@Autowired
	private FcOrderPersonService fcOrderPersonService;

	/**
	 * 终端 查询订单人员数据数量
	 * 
	 * @param param
	 * @return
	 */
	@GetMapping("findTerminalCount")
	public Result findTerminalCount(TerminalInstitutionOrderPersonParam param) {
		int count = fcOrderPersonService.findTerminalCount(param);
		return ResultUtil.ok(count);
	}

	/**
	 * 终端 查询订单人员数据集合
	 * 
	 * @param param
	 * @return
	 */
	@GetMapping("findTerminalList")
	public Result findTerminalList(TerminalInstitutionOrderPersonParam param) {
		List<TerminalInstitutionOrderPersonVo> data = fcOrderPersonService.findTerminalList(param);
		return ResultUtil.ok(data);
	}
}
