package chinaPress.exam.group.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.exam.group.dao.FcGroupMapper;
import chinaPress.exam.group.dao.FcGroupUserMapper;
import chinaPress.exam.group.model.FcGroup;
import chinaPress.exam.group.model.FcGroupUser;
import chinaPress.exam.group.vo.GroupAndUser;
import chinaPress.exam.group.vo.GroupVo;
import chinaPress.role.member.dao.PractitionerInfoMapper;
import chinaPress.role.member.vo.GroupUser;

@Service
public class FcGroupService {
	
	/**
	 * 分组dao
	 */
	@Autowired
	private FcGroupMapper fcGroupMapper;
	
	/**
	 *分组人员关联dao 
	 */
	@Autowired
	private FcGroupUserMapper fcGroupUserMapper;
	
	/**
	 * 家长从业者的dao
	 */
	@Autowired
	private PractitionerInfoMapper practitionerInfoMapper;
	
	
	/**
	 * 名称查询家长从业者信息
	 * @param name
	 * @param page
	 * @param limit
	 * @return
	 */
	public Result findUserAll(String name,Integer page,Integer limit) {
		try {
			List<GroupUser> users = practitionerInfoMapper.selectUserAll(name, page, limit);
			return new Result(1,"ok",users);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统异常","");
		}
	}
	
	/**
	 * 名称查询家长个数信息
	 * @param name
	 * @return
	 */
	public Result findUserAllCount(String name) {
		try {
			int count = practitionerInfoMapper.selectUserAllCount(name);
			return new Result(1,"ok",count);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统异常","");
		}
	}
	
	/**
	 * 添加分组信息
	 * @param fcGroup
	 * @param userIds
	 * @return
	 */
	@Transactional
	public Result addGroup(FcGroup fcGroup,String userIds) {
		if(StringUtils.isAllBlank(userIds)) {
			return new Result(0,"分组必须关联人员","");
		}
		String name = fcGroup.getGroupName();
		if(StringUtils.isAllBlank(name)) {
			return new Result(0,"分组名称不可以为空","");
		}
		try {
			if(fcGroupMapper.selectByGroupName(name, null)>0) {
				return new Result(0,"分组名称不可以重复","");	
			}
			//分组添加
			fcGroupMapper.insertSelective(fcGroup);
			String [] users = userIds.split(",");
			for(String s:users) {
				if(!StringUtils.isAllBlank(s)) {
					FcGroupUser fcGroupUser = new FcGroupUser();
					fcGroupUser.setGroupId(fcGroup.getId());
					fcGroupUser.setRoleId(Integer.parseInt(s));
					//分组关联人员配置添加
					fcGroupUserMapper.insertSelective(fcGroupUser);
				}
			}
			return new Result(1,"添加成功","");
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统异常","");

		}
	}
	
	
	/**
	 * 更新分组信息
	 * @param fcGroup
	 * @param userIds
	 * @return
	 */
	@Transactional
	public Result setGroup(FcGroup fcGroup,String userIds) {
		String name = fcGroup.getGroupName();
		Integer id = fcGroup.getId();
		String [] users = null;
		if(id==null) {
			return new Result(0,"分组信息出错","");
		}
		try {
			if(fcGroupMapper.selectByGroupName(name, id)>0) {
				return new Result(0,"分组名称不可以重复","");
			}
			fcGroupMapper.updateByPrimaryKeySelective(fcGroup);
			users = userIds.split(",");
			//分组关联信息不为null进行修改
			if(users.length>0) {
				fcGroupUserMapper.deleteByGroupId(id);
				for(String s:users) {
					if(!StringUtils.isAllBlank(s)) {
						FcGroupUser fcGroupUser = new FcGroupUser();
						fcGroupUser.setGroupId(fcGroup.getId());
						fcGroupUser.setRoleId(Integer.parseInt(s));
						//分组关联人员配置添加
						fcGroupUserMapper.insertSelective(fcGroupUser);
					}
				}
			}
			return new Result(1,"修改成功","");
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统异常","");
		}
	}
	
	/**
	 * 删除分组信息
	 * @param groupId
	 * @return
	 */
	@Transactional
	public Result deleteGroup(Integer groupId) {
		if(groupId==null) {
			return new Result(0,"分组信息出错","");
		}
		try {
			fcGroupUserMapper.deleteByGroupId(groupId);
			fcGroupMapper.deleteByPrimaryKey(groupId);
			return new Result(1,"删除成功","");
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统异常","");
		}
	}
	
	/**
	 * id查询分组
	 * @param groupId
	 * @return
	 */
	public Result findByGroupId(Integer groupId) {
		if(groupId==null) {
			return new Result(0,"分组信息出错","");
		}
		try {
			GroupVo vo = fcGroupMapper.selectByGroupId(groupId);
			return new Result(1,"查询成功",vo);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统异常","");
		}
	}
	
	/**
	 * 名称查询分组信息
	 * @param groupName
	 * @param page
	 * @param limit
	 * @return
	 */
	public Result findByNameLikeAll(String groupName,Integer page,Integer limit) {
		try {
			List<GroupAndUser> list = fcGroupMapper.selectByNameLikeAll(groupName, page, limit);
			return new Result(1,"查询成功",list);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统异常","");
		}
	}
	
	
	/**
	 * 名称查询分组信息个数
	 * @param groupName
	 * @return
	 */
	public Result findByNameLikeAllCount(String groupName) {
		try {
			int count= fcGroupMapper.selectByNameLikeAllCount(groupName);
			return new Result(1,"查询成功",count);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统异常","");
		}
	}
	
}
