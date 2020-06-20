package chinaPress.fc.coupon.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.DateUtil;
import chinaPress.common.util.JacksonUtil;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.coupon.dao.FcDiscountCouponCourseMapper;
import chinaPress.fc.coupon.dao.FcDiscountCouponMapper;
import chinaPress.fc.coupon.dao.FcDiscountCouponRecordMapper;
import chinaPress.fc.coupon.model.FcDiscountCoupon;
import chinaPress.fc.coupon.model.FcDiscountCouponCourse;
import chinaPress.fc.coupon.model.FcDiscountCouponRecord;
import chinaPress.fc.coupon.vo.FcDiscountCouponDetailVo;
import chinaPress.fc.coupon.vo.FcDiscountCouponListVo;

@Service
public class FcDiscountCouponService {
	@Autowired
	private FcDiscountCouponMapper fcDiscountCouponMapper;
	@Autowired
	private FcDiscountCouponRecordMapper fcDiscountCouponRecordMapper;
	@Autowired
	private FcDiscountCouponCourseMapper fcDiscountCouponCourseMapper;

	/**
	 * 新建优惠券
	 * 
	 * @author maguoliang
	 * @param fcDiscountCoupon
	 */
	@Transactional
	public Result addFcDiscountCoupon(FcDiscountCoupon fcDiscountCoupon, String course) {
		Result result = new Result();
		String warningMsg = checkData(fcDiscountCoupon, course);
		if (warningMsg != "") {
			result = ResultUtil.custom(-1, warningMsg, -1);
		} else {
			// 新增优惠券
			fcDiscountCouponMapper.insertSelective(fcDiscountCoupon);
			// 新增优惠券记录
			for (int i = 0; i < fcDiscountCoupon.getCount(); i++) {
				FcDiscountCouponRecord fcDiscountCouponRecord = new FcDiscountCouponRecord();
				String codePrefix = fcDiscountCoupon.getCode() + DateUtil.formatDate(new Date(), "yyyyMMdd");
				String newCodeStr = String.valueOf(i + 1);
				String codeSuffix = newCodeStr.length() == 1 ? "00" + newCodeStr
						: (newCodeStr.length() == 2 ? "0" + newCodeStr : newCodeStr);
				fcDiscountCouponRecord.setCode(codePrefix + codeSuffix);
				fcDiscountCouponRecord.setCouponId(fcDiscountCoupon.getId());
				fcDiscountCouponRecordMapper.insertSelective(fcDiscountCouponRecord);
			}
			// 新增优惠券相关课程
			List<FcDiscountCouponCourse> list = JacksonUtil.fromJSONList(course, FcDiscountCouponCourse.class);
			if (list.size() > 0) {
				for (FcDiscountCouponCourse fcDiscountCouponCourse : list) {
					fcDiscountCouponCourse.setCouponId(fcDiscountCoupon.getId());
					fcDiscountCouponCourseMapper.insertSelective(fcDiscountCouponCourse);
				}
			}
			result = ResultUtil.custom(1, "操作成功", 1);
		}
		return result;
	}

	/**
	 * 检查数据
	 * 
	 * @author maguoliang
	 * @param fcDiscountCoupon
	 * @param course
	 * @return
	 */
	public String checkData(FcDiscountCoupon fcDiscountCoupon, String course) {
		// 优惠券类型
		if (fcDiscountCoupon.getType() == null) {
			return "请选择优惠券类型";
		} else if (fcDiscountCoupon.getType().intValue() != 1 && fcDiscountCoupon.getType().intValue() != 2) {
			return "请选择正确的优惠券类型";
		}
		// 优惠券名称
		if (StringUtils.isBlank(fcDiscountCoupon.getName())) {
			return "请填写优惠券名称";
		} else if (fcDiscountCoupon.getName().length() > 10) {
			return "优惠券名称最多支持10个字符";
		}
		// 优惠券数量
		if (fcDiscountCoupon.getCount() == null) {
			return "请填写优惠券数量";
		} else if (fcDiscountCoupon.getCount().intValue() > 100) {
			return "优惠券数量最多100个";
		}
		// 优惠券编码
		if (StringUtils.isBlank(fcDiscountCoupon.getCode())) {
			return "请填写优惠券编码前缀";
		} else if (fcDiscountCoupon.getCode().length() > 5) {
			return "优惠券编码前缀最多支持5个字符，且为英文";
		}
		int count = fcDiscountCouponMapper.selectIsExistsSameCode(fcDiscountCoupon.getCode());
		if (count > 0) {
			return "优惠券编码前缀重复，请更换前缀";
		}
		return "";
	}

	/**
	 * 查询优惠券个数
	 * 
	 * @author maguoliang
	 * @param name      优惠券名称
	 * @param startTime 优惠券有效开始时间
	 * @param endTime   优惠券有效结束时间
	 * @return
	 */
	public int selectFcDiscountCouponCount(String name, String startTime, String endTime) {
		return fcDiscountCouponMapper.selectFcDiscountCouponCount(name, startTime, endTime);
	}

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
	public List<FcDiscountCouponListVo> selectFcDiscountCouponList(String name, String startTime, String endTime,
			Integer pageNumber, Integer pageSize) {
		return fcDiscountCouponMapper.selectFcDiscountCouponList(name, startTime, endTime,
				pageNumber * pageSize - pageSize, pageSize);
	}
	
	/**
	 * 查询优惠券详情+明细
	 * @author maguoliang
	 * @param id
	 * @return
	 */
	public FcDiscountCouponDetailVo selectFcDiscountCouponDetail(Integer id) {
		return fcDiscountCouponMapper.selectFcDiscountCouponDetail(id);
	}
}
