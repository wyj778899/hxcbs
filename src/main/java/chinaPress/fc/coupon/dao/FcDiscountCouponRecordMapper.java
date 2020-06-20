package chinaPress.fc.coupon.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.coupon.model.FcDiscountCouponRecord;
import chinaPress.fc.coupon.vo.FcDiscountValidCouponVo;
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
}