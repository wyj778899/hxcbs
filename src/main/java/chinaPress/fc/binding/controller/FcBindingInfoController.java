package chinaPress.fc.binding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.binding.service.FcBindingInfoService;
import chinaPress.fc.binding.vo.FcBindingInfoVo;
import chinaPress.role.member.vo.MemberCouponInfo;

@RestController
@RequestMapping("binding")
public class FcBindingInfoController {
	@Autowired
	private FcBindingInfoService fcBindingInfoService;

	/**
	 * 查询绑定信息个数
	 * 
	 * @author maguoliang
	 * @param roleType        当前角色类型2.机构3.家长4.从业者
	 * @param institutionId   机构id
	 * @param bindingRoleType 绑定角色类型3.家长4.从业者
	 * @param name            绑定用户名
	 * @return
	 */
	@RequestMapping("index/count")
	public Result selectBindingInfoCount(Integer roleType, Integer institutionId, Integer bindingRoleType,
			String name) {
		int index = fcBindingInfoService.selectBindingInfoCount(roleType, institutionId, bindingRoleType, name);
		return ResultUtil.ok(index);
	}

	/**
	 * 查询绑定信息列表
	 * 
	 * @author maguoliang
	 * @param roleType        当前角色类型2.机构3.家长4.从业者
	 * @param institutionId   机构id
	 * @param bindingRoleType 绑定角色类型3.家长4.从业者
	 * @param name            绑定用户名
	 * @param pageNumber      第几页
	 * @param pageSize        每页查询查询多少条记录
	 * @return
	 */
	@RequestMapping("index/list")
	public Result selectBindingInfoList(Integer roleType, Integer institutionId, Integer bindingRoleType, String name,
			Integer pageNumber, Integer pageSize) {
		List<FcBindingInfoVo> list = fcBindingInfoService.selectBindingInfoList(roleType, institutionId,
				bindingRoleType, name, pageNumber, pageSize);
		return ResultUtil.ok(list);
	}

	/**
	 * 新增绑定关系
	 * 
	 * @author maguoliang
	 * @param data
	 */
	@RequestMapping("index/add")
	public Result addBindingInfo(String data) {
		try {
			fcBindingInfoService.addBindingInfo(data);
			return ResultUtil.custom(1, "操作成功", data);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.custom(0, "操作失败", 0);
		}
	}

	/**
	 * 查询当前机构可绑定人员个数
	 * 
	 * @author maguoliang
	 * @param namePhone     用户名或手机号
	 * @param institutionId 机构id
	 * @return
	 */
	@RequestMapping("member/index/count")
	public Result selectBindingInfoMemberCount(String namePhone, Integer institutionId) {
		int count = fcBindingInfoService.selectBindingInfoMemberCount(namePhone, institutionId);
		return ResultUtil.ok(count);
	}

	/**
	 * 查询当前机构可绑定人员列表
	 * 
	 * @author maguoliang
	 * @param namePhone     用户名或手机号
	 * @param institutionId 机构id
	 * @param pageNumber    第几页
	 * @param pageSize      每页查询多少条数据
	 * @return
	 */
	@RequestMapping("member/index/list")
	public Result selectBindingInfoMemberList(String namePhone, Integer institutionId, Integer pageNumber,
			Integer pageSize) {
		List<MemberCouponInfo> list = fcBindingInfoService.selectBindingInfoMemberList(namePhone, institutionId,
				pageNumber, pageSize);
		return ResultUtil.ok(list);
	}

	/**
	 * 查询当前机构可绑定人员列表
	 * 
	 * @author maguoliang
	 * @param id 数据id
	 * @return
	 */
	@RequestMapping("index/update")
	public Result updateBindingInfo(Integer id, Integer status) {
		int index = fcBindingInfoService.updateBindingInfo(id, status);
		if (index > 0) {
			return ResultUtil.custom(1, "操作成功", index);
		} else {
			return ResultUtil.custom(0, "操作失败", 0);
		}
	}
}
