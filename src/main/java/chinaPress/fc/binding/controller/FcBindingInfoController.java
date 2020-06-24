package chinaPress.fc.binding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.binding.service.FcBindingInfoService;
import chinaPress.fc.binding.vo.FcBindingInfoVo;

@RestController
@RequestMapping("binding")
public class FcBindingInfoController {
	@Autowired
	private FcBindingInfoService fcBindingInfoService;

	/**
	 * 查询绑定信息个数
	 * 
	 * @author maguoliang
	 * @param institutionId   机构id
	 * @param bindingRoleType 绑定角色类型3.家长4.从业者
	 * @param name            绑定用户名
	 * @return
	 */
	@RequestMapping("index/count")
	public Result selectBindingInfoCount(Integer institutionId, Integer bindingRoleType, String name) {
		int index = fcBindingInfoService.selectBindingInfoCount(institutionId, bindingRoleType, name);
		return ResultUtil.ok(index);
	}

	/**
	 * 查询绑定信息列表
	 * 
	 * @author maguoliang
	 * @param institutionId   机构id
	 * @param bindingRoleType 绑定角色类型3.家长4.从业者
	 * @param name            绑定用户名
	 * @param pageNumber      第几页
	 * @param pageSize        每页查询查询多少条记录
	 * @return
	 */
	@RequestMapping("index/list")
	public Result selectBindingInfoList(Integer institutionId, Integer bindingRoleType, String name, Integer pageNumber,
			Integer pageSize) {
		List<FcBindingInfoVo> list = fcBindingInfoService.selectBindingInfoList(institutionId, bindingRoleType, name,
				pageNumber, pageSize);
		return ResultUtil.ok(list);
	}
}
