package chinaPress.fc.coupon.dao;

import chinaPress.fc.coupon.model.FcDiscountCouponRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcDiscountCouponRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcDiscountCouponRecord record);

    int insertSelective(FcDiscountCouponRecord record);

    FcDiscountCouponRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcDiscountCouponRecord record);

    int updateByPrimaryKey(FcDiscountCouponRecord record);
}