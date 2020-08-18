package chinaPress.fc.apply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.apply.service.FcApplyPersonService;
import chinaPress.fc.apply.vo.FcApplyPersonVo;
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

	/**
	 * 查询所有报名申请已审核的家长和从业者个数
	 * 
	 * @author maguoliang
	 * @param tellPhoneUserName 用户名或手机号
	 * @return
	 */
	@RequestMapping("exam_group/count")
	public Result selectFcApplyPersonInfoCount(String tellPhoneUserName) {
		int index = fcApplyPersonService.selectFcApplyPersonInfoCount(tellPhoneUserName);
		if (index > 0) {
			return ResultUtil.custom(1, "有数据", index);
		} else {
			return ResultUtil.custom(0, "无数据", index);
		}
	}

	/**
	 * 查询所有报名申请已审核的家长和从业者列表
	 * 
	 * @author maguoliang
	 * @param tellPhoneUserName 用户名或手机号
	 * @param offset            从第几条数据开始查询
	 * @param rows              查询多少条数据
	 * @return
	 */
	@RequestMapping("exam_group/list")
	public Result selectFcApplyPersonInfoList(String tellPhoneUserName, Integer pageNumber, Integer pageSize) {
		List<FcApplyPersonVo> list = fcApplyPersonService.selectFcApplyPersonInfoList(tellPhoneUserName, pageNumber,
				pageSize);
		if (list.size() > 0) {
			return ResultUtil.custom(1, "有数据", list);
		} else {
			return ResultUtil.custom(0, "无数据", list);
		}
	}
}
