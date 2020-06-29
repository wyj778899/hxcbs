package chinaPress.fc.binding.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.util.JacksonUtil;
import chinaPress.fc.binding.dao.FcBindingInfoMapper;
import chinaPress.fc.binding.model.FcBindingInfo;
import chinaPress.fc.binding.vo.FcBindingInfoVo;
import chinaPress.role.member.vo.MemberCouponInfo;

@Service
public class FcBindingInfoService {
	@Autowired
	private FcBindingInfoMapper fcBindingInfoMapper;

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
	public int selectBindingInfoCount(Integer roleType, Integer institutionId, Integer bindingRoleType, String name) {
		int index = 0;
		if (roleType.intValue() == 2) {
			index = fcBindingInfoMapper.selectBindingInfoCount(institutionId, bindingRoleType, name);
		}
		if (roleType.intValue() == 3 || roleType.intValue() == 4) {
			index = fcBindingInfoMapper.selectBindingInfoInstitutionCount(institutionId, roleType, name);
		}
		return index;
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
	public List<FcBindingInfoVo> selectBindingInfoList(Integer roleType, Integer institutionId, Integer bindingRoleType,
			String name, Integer pageNumber, Integer pageSize) {
		List<FcBindingInfoVo> list = new ArrayList<FcBindingInfoVo>();
		if (roleType.intValue() == 2) {
			list = fcBindingInfoMapper.selectBindingInfoList(institutionId, bindingRoleType, name,
					pageNumber * pageSize - pageSize, pageSize);
		}
		if (roleType.intValue() == 3 || roleType.intValue() == 4) {
			list = fcBindingInfoMapper.selectBindingInfoInstitutionList(institutionId, roleType, name,
					pageNumber * pageSize - pageSize, pageSize);
		}
		return list;
	}

	/**
	 * 新增绑定关系
	 * 
	 * @author maguoliang
	 * @param data
	 */
	@Transactional
	public void addBindingInfo(String data) {
		List<FcBindingInfo> list = JacksonUtil.fromJSONList(data, FcBindingInfo.class);
		for (FcBindingInfo fcBindingInfo : list) {
			fcBindingInfoMapper.insertSelective(fcBindingInfo);
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
	public int selectBindingInfoMemberCount(String namePhone, Integer institutionId) {
		return fcBindingInfoMapper.selectBindingInfoMemberCount(namePhone, institutionId);
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
	public List<MemberCouponInfo> selectBindingInfoMemberList(String namePhone, Integer institutionId,
			Integer pageNumber, Integer pageSize) {
		return fcBindingInfoMapper.selectBindingInfoMemberList(namePhone, institutionId,
				pageNumber * pageSize - pageSize, pageSize);
	}

	/**
	 * 修改
	 * @author maguoliang
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateBindingInfo(Integer id, Integer status) {
		FcBindingInfo fcBindingInfo = new FcBindingInfo();
		fcBindingInfo.setId(id);
		fcBindingInfo.setReplyStatus(status);
		if (status.intValue() == 2) {
			fcBindingInfo.setBindingTime(new Date());
		}
		if (status.intValue() == 4) {
			fcBindingInfo.setCancelBindingTime(new Date());
		}
		return fcBindingInfoMapper.updateByPrimaryKeySelective(fcBindingInfo);
	}
}
