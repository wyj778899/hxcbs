package chinaPress.fc.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	/**
	 * 修改已看数量（即小节测试全部通过）
	 * 
	 * @param roleId   角色id
	 * @param roleType 角色类型（1.家长2.从业者）
	 * @param courseId 课程id
	 * @param hourId   课时id
	 * @param isPass   是否通过：1.是，2.否
	 * @return
	 */
	@PostMapping("setHaveCount")
	public Result setHaveCount(Integer roleId, Integer roleType, Integer courseId, Integer hourId, Integer isPass) {
		int index = fcOrderPersonService.setHaveCount(roleId, roleType, courseId, hourId, isPass);
		if (index > 0) {
			return ResultUtil.ok();
		} else {
			return ResultUtil.error();
		}
	}

	/**
	 * 修改课时的通过状态
	 * 
	 * @param roleId   角色id
	 * @param roleType 角色类型（1.家长2.从业者）
	 * @param courseId 课程id
	 * @param hourId   课时id
	 * @param isPass   是否通过
	 * @return
	 */
	@RequestMapping("setHourIsPass")
	public Result setHourIsPass(Integer roleId, Integer roleType, Integer courseId, Integer hourId, Integer isPass) {
		int index = fcOrderPersonService.setHourIsPass(roleId, roleType, courseId, hourId, isPass);
		if (index > 0) {
			return ResultUtil.ok();
		} else {
			return ResultUtil.error();
		}
	}

	/**
	 * 查询课时是否通过
	 * 
	 * @param roleId   角色id
	 * @param roleType 角色类型（1.家长2.从业者）
	 * @param courseId 课程id
	 * @param hourId   课时id
	 * @return
	 */
	@PostMapping("findPersonHourIsPass")
	public int findPersonHourIsPass(Integer roleId, Integer roleType, Integer courseId, Integer hourId) {
		return fcOrderPersonService.findPersonHourIsPass(roleId, roleType, courseId, hourId);
	}
	
	/**
	 * 查询某个人正在学习某课程的最新进度
	 * 
	 * @author maguoliang
	 * @param courseId 课程id
	 * @param roleId   角色id
	 * @param roleType 角色类型1.家长2.从业者
	 * @return
	 */
	@RequestMapping("selectTheNewestHour")
	public Result selectTheNewestHour(Integer courseId, Integer roleId, Integer roleType) {
		Integer fcOrderPersonHour = fcOrderPersonService.selectTheNewestHour(courseId, roleId, roleType);
		if (fcOrderPersonHour != null) {
			return ResultUtil.ok(fcOrderPersonHour);
		} else {
			return ResultUtil.error(fcOrderPersonHour);
		}
	}
}
