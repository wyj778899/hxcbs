package chinaPress.fc.coupon.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.coupon.model.FcDiscountCouponRecord;
import chinaPress.fc.coupon.vo.FcDiscountCouponRecordVo;
import chinaPress.fc.coupon.vo.FcDiscountMyCouponRecordListVo;
import chinaPress.fc.coupon.vo.FcDiscountValidCouponVo;
import chinaPress.fc.coupon.vo.FcOrderDiscountCoupon;
import io.lettuce.core.dynamic.annotation.Param;

@Mapper
@Repository
public interface FcDiscountCouponRecordMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcDiscountCouponRecord record);

	int insertSelective(FcDiscountCouponRecord record);

	FcDiscountCouponRecord selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcDiscountCouponRecord record);

	int updateByPrimaryKey(FcDiscountCouponRecord record);

	/**
	 * 查询可发放优惠券个数
	 * 
	 * @author maguoliang
	 * @return
	 */
	int selectValidCouponCount();

	/**
	 * 查询可发放优惠券列表
	 * 
	 * @author maguoliang
	 * @param offset 从哪一条开始查询
	 * @param rows   查询多少条记录
	 * @return
	 */
	List<FcDiscountValidCouponVo> selectValidCouponList(@Param("offset") Integer offset, @Param("rows") Integer rows);

	/**
	 * 查询各个状态的优惠券数量
	 * 
	 * @author maguoliang
	 * @param couponId 优惠券id
	 * @param status   状态1.未发放2.已领取3.已核销
	 * @return
	 */
	int selectCouponCountByStatus(@Param("couponId") Integer couponId, @Param("status") Integer status);

	/**
	 * 查询优惠券明细
	 * 
	 * @author maguoliang
	 * @param couponId      优惠券id
	 * @param code          优惠券编码
	 * @param grantRoleName 领取人名称
	 * @param status        使用状态
	 * @param startTime     开始时间
	 * @param endTime       结束时间
	 * @return
	 */
	int selectCouponRecordDetailCount(@Param("couponId") Integer couponId, @Param("code") String code,
			@Param("grantRoleName") String grantRoleName, @Param("status") Integer status,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	/**
	 * 查询优惠券明细
	 * 
	 * @author maguoliang
	 * @param couponId      优惠券id
	 * @param code          优惠券编码
	 * @param grantRoleName 领取人名称
	 * @param status        使用状态
	 * @param startTime     开始时间
	 * @param endTime       结束时间
	 * @param offset        从哪一条数据开始查询
	 * @param rows          查询多少条数据
	 * @return
	 */
	List<FcDiscountCouponRecordVo> selectCouponRecordDetailList(@Param("couponId") Integer couponId,
			@Param("code") String code, @Param("grantRoleName") String grantRoleName, @Param("status") Integer status,
			@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("offset") Integer offset,
			@Param("rows") Integer rows);

	/**
	 * 查询我的优惠券个数
	 * 
	 * @author maguoliang
	 * @param grantRoleId   领取人角色id
	 * @param grantRoleType 领取人角色类型
	 * @param type          优惠券类型1.满减券2.观看券
	 * @param name          优惠券名称
	 * @param code          优惠券编码
	 * @param courseName    优惠券课程名称
	 * @param status        优惠券使用状态1.未使用2.已过期
	 * @param searchTxt     搜索条件（优惠券名称/编码或课程名称）
	 * @return
	 */
	int selectMyCouponRecordCount(@Param("grantRoleId") Integer grantRoleId,
			@Param("grantRoleType") Integer grantRoleType, @Param("type") Integer type, @Param("name") String name,
			@Param("code") String code, @Param("courseName") String courseName, @Param("status") Integer status,
			@Param("searchTxt") String searchTxt);

	/**
	 * 查询我的优惠券列表
	 * 
	 * @author maguoliang
	 * @param grantRoleId   领取人角色id
	 * @param grantRoleType 领取人角色类型
	 * @param type          优惠券类型1.满减券2.观看券
	 * @param name          优惠券名称
	 * @param code          优惠券编码
	 * @param courseName    优惠券课程名称
	 * @param status        优惠券使用状态1.未使用2.已过期
	 * @param searchTxt     搜索条件（优惠券名称/编码或课程名称）
	 * @param offset        从第几条数据开始查询
	 * @param rows          查询多少条数据
	 * @return
	 */
	List<FcDiscountMyCouponRecordListVo> selectMyCouponRecordList(@Param("grantRoleId") Integer grantRoleId,
			@Param("grantRoleType") Integer grantRoleType, @Param("type") Integer type, @Param("name") String name,
			@Param("code") String code, @Param("courseName") String courseName, @Param("status") Integer status,
			@Param("searchTxt") String searchTxt, @Param("offset") Integer offset, @Param("rows") Integer rows);

	/**
	 * 发放优惠券
	 * 
	 * @author maguoliang
	 * @param grantRoleId
	 * @param grantRoleType
	 * @param couponRecordIdList
	 * @return
	 */
	int grantCoupon(@Param("grantRoleId") Integer grantRoleId, @Param("grantRoleType") Integer grantRoleType,
			@Param("couponRecordIdList") List<String> couponRecordIdList);

	/**
	 * 根据优惠券编码，角色id，角色类型查询
	 * 
	 * @author maguoliang
	 * @param grantRoleId   角色id
	 * @param grantRoleType 角色类型
	 * @param couponCode    优惠券编码
	 * @param courseId      课程id
	 */
	FcOrderDiscountCoupon selectOrderCoupon(@Param("grantRoleId") Integer grantRoleId,
			@Param("grantRoleType") Integer grantRoleType, @Param("couponCode") String couponCode,
			@Param("courseId") Integer courseId);
}