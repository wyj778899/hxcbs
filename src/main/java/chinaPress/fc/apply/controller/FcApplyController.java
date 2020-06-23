package chinaPress.fc.apply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.apply.service.FcApplyService;
import chinaPress.fc.apply.vo.TerminalApplyListParam;
import chinaPress.fc.apply.vo.TerminalApplyListVo;
import chinaPress.fc.apply.vo.TerminalInstitutionApplyDetailVo;
import chinaPress.fc.apply.vo.TerminalPractitionerApplyDetailVo;

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
	@PostMapping("insert")
	public Result insert(FcApply record, String personJson) {
		int index = fcApplyService.insert(record, personJson);
		if (index > 0) {
			return ResultUtil.custom(1, "操作成功");
		} else {
			return ResultUtil.custom(0, "操作失败");
		}
	}

	/**
	 * 终端 报名申请数据数量
	 * 
	 * @return
	 */
	@GetMapping("findTerminalApplyCount")
	public Result findTerminalApplyCount(TerminalApplyListParam param) {
		int count = fcApplyService.findTerminalApplyCount(param);
		return ResultUtil.ok(count);
	}

	/**
	 * 终端 报名申请数据集合
	 * 
	 * @return
	 */
	@GetMapping("findTerminalApplyList")
	public Result findTerminalApplyList(TerminalApplyListParam param) {
		List<TerminalApplyListVo> data = fcApplyService.findTerminalApplyList(param);
		return ResultUtil.ok(data);
	}

	/**
	 * 终端机构 详情
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("findTerminalInstitutionDetail")
	public Result findTerminalInstitutionDetail(Integer id) {
		TerminalInstitutionApplyDetailVo detail = fcApplyService.findTerminalInstitutionDetail(id);
		if (detail != null) {
			return ResultUtil.ok(detail);
		} else {
			return ResultUtil.error();
		}
	}

	/**
	 * 终端家长 详情
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("findTerminalPractitionerDetail")
	public Result findTerminalPractitionerDetail(Integer id) {
		TerminalPractitionerApplyDetailVo detail = fcApplyService.findTerminalPractitionerDetail(id);
		if (detail != null) {
			return ResultUtil.ok(detail);
		} else {
			return ResultUtil.error();
		}
	}
}
