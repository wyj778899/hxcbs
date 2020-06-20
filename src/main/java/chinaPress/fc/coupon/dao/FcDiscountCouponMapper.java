package chinaPress.fc.coupon.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.coupon.model.FcDiscountCoupon;
import chinaPress.fc.coupon.vo.FcDiscountCouponDetailVo;
import chinaPress.fc.coupon.vo.FcDiscountCouponListVo;
import io.lettuce.core.dynamic.annotation.Param;

@Mapper
@Repository
public interface FcDiscountCouponMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcDiscountCoupon record);

	int insertSelective(FcDiscountCoupon record);

	FcDiscountCoupon selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcDiscountCoupon record);

	int updateByPrimaryKey(FcDiscountCoupon record);

	/**
	 * 查询优惠券个数
	 * 
	 * @author maguoliang
	 * @param name      优惠券名称
	 * @param startTime 优惠券有效开始时间
	 * @param endTime   优惠券有效结束时间
	 * @return
	 */
	int selectFcDiscountCouponCount(@Param("name") String name, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	/**
	 * 查询优惠券列表
	 * 
	 * @author maguoliang
	 * @param name      优惠券名称
	 * @param startTime 优惠券有效开始时间
	 * @param endTime   优惠券有效结束时间
	 * @param offset    从哪一条开始查询
	 * @param rows      查询多少条
	 * @return
	 */
	List<FcDiscountCouponListVo> selectFcDiscountCouponList(@Param("name") String name,
			@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("offset") Integer offset,
			@Param("rows") Integer rows);

	/**
	 * 查询优惠券详情+明细
	 * 
	 * @author maguoliang
	 * @param id
	 * @return
	 */
	FcDiscountCouponDetailVo selectFcDiscountCouponDetail(Integer id);

	/**
	 * 查询是否存在相同的编码
	 * 
	 * @author maguoliang
	 * @param code
	 * @return
	 */
	int selectIsExistsSameCode(String code);
}