package chinaPress.fc.binding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.binding.model.FcBindingInfo;
import chinaPress.fc.binding.vo.FcBindingInfoVo;
import io.lettuce.core.dynamic.annotation.Param;

@Mapper
@Repository
public interface FcBindingInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcBindingInfo record);

	int insertSelective(FcBindingInfo record);

	FcBindingInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcBindingInfo record);

	int updateByPrimaryKey(FcBindingInfo record);

	/**
	 * 查询绑定信息个数
	 * 
	 * @author maguoliang
	 * @param institutionId   机构id
	 * @param bindingRoleType 绑定角色类型3.家长4.从业者
	 * @param name            绑定用户名
	 * @return
	 */
	int selectBindingInfoCount(@Param("institutionId") Integer institutionId,
			@Param("bindingRoleType") Integer bindingRoleType, @Param("name") String name);

	/**
	 * 查询绑定信息列表
	 * 
	 * @author maguoliang
	 * @param institutionId   机构id
	 * @param bindingRoleType 绑定角色类型3.家长4.从业者
	 * @param name            绑定用户名
	 * @param offset          从第几条记录开始查询
	 * @param rows            查询多少条记录
	 * @return
	 */
	List<FcBindingInfoVo> selectBindingInfoList(@Param("institutionId") Integer institutionId,
			@Param("bindingRoleType") Integer bindingRoleType, @Param("name") String name,
			@Param("offset") Integer offset, @Param("rows") Integer rows);
}