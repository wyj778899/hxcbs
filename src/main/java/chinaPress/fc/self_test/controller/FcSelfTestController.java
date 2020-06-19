package chinaPress.fc.self_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.self_test.model.FcSelfTest;
import chinaPress.fc.self_test.service.FcSelfTestService;
import chinaPress.fc.self_test.vo.FcSelfTestDetailVo;
import chinaPress.fc.self_test.vo.FcSelfTestListParam;
import chinaPress.fc.self_test.vo.FcSelfTestListVo;

@RequestMapping("fc_self_test")
@RestController
public class FcSelfTestController {

	@Autowired
	private FcSelfTestService fcSelfTestService;

	/**
	 * 新增
	 * 
	 * @param record
	 * @param stemJson
	 * @return
	 */
	@PostMapping("insert")
	public Result insert(FcSelfTest record, String stemJson) {
		int index = fcSelfTestService.insert(record, stemJson);
		if (index > 0) {
			return ResultUtil.ok();
		} else {
			return ResultUtil.error();
		}
	}

	/**
	 * 详情
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("detail")
	public Result detail(Integer id) {
		FcSelfTestDetailVo detail = fcSelfTestService.detail(id);
		if (detail != null) {
			return ResultUtil.ok(detail);
		} else {
			return ResultUtil.error();
		}
	}

	/**
	 * 数据数量
	 * 
	 * @param param
	 * @return
	 */
	@GetMapping("count")
	public Result count(FcSelfTestListParam param) {
		int count = fcSelfTestService.count(param);
		return ResultUtil.ok(count);
	}

	/**
	 * 数据集合
	 * 
	 * @param param
	 * @return
	 */
	@GetMapping("list")
	public Result list(FcSelfTestListParam param) {
		List<FcSelfTestListVo> list = fcSelfTestService.list(param);
		return ResultUtil.ok(list);
	}
}
