package chinaPress.fc.apply.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@PostMapping("insert")
	public Result insert(FcApply record, String personJson) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return fcApplyService.insert(record, personJson);
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

	/**
	 * 审核
	 * 
	 * @param id
	 * @param auditStatus
	 * @param auditPeople
	 * @return
	 */
	public Result audit(Integer id, Integer auditStatus, Integer auditPeople) {
		int index = fcApplyService.audit(id, auditStatus, auditPeople);
		if (index > 0) {
			return ResultUtil.ok();
		} else {
			return ResultUtil.error();
		}
	}
}
