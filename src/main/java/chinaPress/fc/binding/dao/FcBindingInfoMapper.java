package chinaPress.fc.binding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.binding.model.FcBindingInfo;
import chinaPress.fc.binding.vo.FcBindingInfoVo;
import chinaPress.role.member.vo.MemberCouponInfo;
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

	/**
	 * 查询当前机构可绑定人员个数
	 * 
	 * @author maguoliang
	 * @param namePhone     用户名或手机号
	 * @param institutionId 机构id
	 * @return
	 */
	int selectBindingInfoMemberCount(@Param("namePhone") String namePhone,
			@Param("institutionId") Integer institutionId);

	/**
	 * 查询当前机构可绑定人员列表
	 * 
	 * @author maguoliang
	 * @param namePhone     用户名或手机号
	 * @param institutionId 机构id
	 * @param offset        从哪一条数据开始查询
	 * @param rows          查询多少条数据
	 * @return
	 */
	List<MemberCouponInfo> selectBindingInfoMemberList(@Param("namePhone") String namePhone,
			@Param("institutionId") Integer institutionId, @Param("offset") Integer offset,
			@Param("rows") Integer rows);

	/**
	 * 查询当前家长和从业者绑定的机构个数
	 * 
	 * @author maguoliang
	 * @param bindingRoleId   绑定角色id
	 * @param bindingRoleType 绑定角色类型3.家长4.从业者
	 * @param name            用户名
	 * @return
	 */
	int selectBindingInfoInstitutionCount(@Param("bindingRoleId") Integer bindingRoleId,
			@Param("bindingRoleType") Integer bindingRoleType, @Param("name") String name);

	/**
	 * 查询当前家长和从业者绑定的机构个数
	 * 
	 * @author maguoliang
	 * @param bindingRoleId   绑定角色id
	 * @param bindingRoleType 绑定角色类型3.家长4.从业者
	 * @param name            用户名
	 * @param offset          从哪一条数据开始查询
	 * @param rows            查询多少条数据
	 * @return
	 */
	List<FcBindingInfoVo> selectBindingInfoInstitutionList(@Param("bindingRoleId") Integer bindingRoleId,
			@Param("bindingRoleType") Integer bindingRoleType, @Param("name") String name,
			@Param("offset") Integer offset, @Param("rows") Integer rows);
}