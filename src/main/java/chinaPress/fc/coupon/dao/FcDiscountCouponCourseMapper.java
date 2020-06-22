package chinaPress.fc.coupon.dao;

import chinaPress.fc.coupon.model.FcDiscountCouponCourse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcDiscountCouponCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcDiscountCouponCourse record);

    int insertSelective(FcDiscountCouponCourse record);

    FcDiscountCouponCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcDiscountCouponCourse record);

    int updateByPrimaryKey(FcDiscountCouponCourse record);
}