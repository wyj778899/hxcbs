package chinaPress.exam.group.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.exam.group.model.FcGroup;
import chinaPress.exam.group.service.FcGroupService;

@RestController
@RequestMapping("fc_group")
public class FcGroupController {
	/**
	 * 分组管理的dao
	 */
	@Autowired
	private FcGroupService fcGroupService;
	
	
	/**
	 * 家长从业者信息展示
	 * @param name
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/queryUserAll")
	public Result queryUserAll(String name,Integer page,Integer limit) {
		return fcGroupService.findUserAll(name, (page-1)*limit, limit);
	}
	
	/**
	 * 家长从业者信息展示个数
	 * @param name
	 * @return
	 */
	@RequestMapping("/queryUserAllCount")
	public Result queryUserAllCount(String name) {
		return fcGroupService.findUserAllCount(name);
	}
	
	/**
	 * 添加分组信息
	 * @param fcGroup
	 * @param userIds
	 * @return
	 */
	@RequestMapping("/registerGroup")
	public Result registerGroup(FcGroup fcGroup,String userIds) {
		return fcGroupService.addGroup(fcGroup, userIds);
	}
	
	/**
	 * 更新分组信息
	 * @param fcGroup
	 * @param userIds
	 * @return
	 */
	@RequestMapping("/modifyGroup")
	public Result modifyGroup(FcGroup fcGroup,String userIds) {
		return fcGroupService.setGroup(fcGroup, userIds);
	}
	
	/**
	 * id查询单个分组信息
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/queryPageGroup")
	public Result queryPageGroup(Integer groupId) {
		return fcGroupService.findByGroupId(groupId);
	}
	
	/**
	 * 删除分组信息
	 * @param groupId
	 * @return
	 */
	@RequestMapping("/removeGroup")
	public Result removeGroup(Integer groupId) {
		return fcGroupService.deleteGroup(groupId);
	}
	
	/**
	 * 模糊查询姓名分组信息
	 * @param groupName
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/queryByNameLikeAll")
	public Result queryByNameLikeAll(String groupName,Integer page,Integer limit) {
		return fcGroupService.findByNameLikeAll(groupName, (page-1)*limit, limit);
	}
	
	/**
	 * 模糊查询姓名分组信息个数
	 * @param groupName
	 * @return
	 */
	@RequestMapping("/queryByNameLikeAllCount")
	public Result queryByNameLikeAllCount(String groupName) {
		return fcGroupService.findByNameLikeAllCount(groupName);
	}
}
