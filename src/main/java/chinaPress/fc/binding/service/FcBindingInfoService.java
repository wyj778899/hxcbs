package chinaPress.fc.binding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.binding.dao.FcBindingInfoMapper;
import chinaPress.fc.binding.vo.FcBindingInfoVo;

@Service
public class FcBindingInfoService {
	@Autowired
	private FcBindingInfoMapper fcBindingInfoMapper;

	/**
	 * 查询绑定信息个数
	 * 
	 * @author maguoliang
	 * @param institutionId   机构id
	 * @param bindingRoleType 绑定角色类型3.家长4.从业者
	 * @param name            绑定用户名
	 * @return
	 */
	public int selectBindingInfoCount(Integer institutionId, Integer bindingRoleType, String name) {
		return fcBindingInfoMapper.selectBindingInfoCount(institutionId, bindingRoleType, name);
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
	public List<FcBindingInfoVo> selectBindingInfoList(Integer institutionId, Integer bindingRoleType, String name,
			Integer pageNumber, Integer pageSize) {
		return fcBindingInfoMapper.selectBindingInfoList(institutionId, bindingRoleType, name,
				pageNumber * pageSize - pageSize, pageSize);
	}
}
