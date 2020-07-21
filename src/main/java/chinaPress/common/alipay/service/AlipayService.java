package chinaPress.common.alipay.service;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

import chinaPress.common.alipay.AlipayConfig;
import chinaPress.common.sms.service.SMSService;
import chinaPress.common.wxpay.WXPayUtil;
import chinaPress.fc.apply.dao.FcApplyMapper;
import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.course.dao.FcCourseArchivesMapper;
import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.service.FcOrderService;
import chinaPress.role.member.dao.MemberInfoMapper;
import chinaPress.role.member.dao.PractitionerInfoMapper;
import chinaPress.role.member.model.MemberInfo;
import chinaPress.role.member.model.PractitionerInfo;

@Service
public class AlipayService {
	@Autowired
	private FcOrderService fcOrderService;
	@Autowired
	private MemberInfoMapper memberInfoMapper;
	@Autowired
	private FcCourseArchivesMapper fcCourseArchivesMapper;
	@Autowired
	private FcOrderPersonMapper fcOrderPersonMapper;
	@Autowired
	private FcApplyMapper fcApplyMapper;
	@Autowired
	private SMSService smsService;
	@Autowired
	private PractitionerInfoMapper practitionerInfoMapper;
	/**
	 * 支付宝支付回调
	 * 
	 * @author maguoliang
	 * @param notify_time
	 * @param notify_type
	 * @param notify_id
	 * @param app_id
	 * @param charset
	 * @param version
	 * @param sign_type
	 * @param sign
	 * @param trade_no
	 * @param out_trade_no
	 * @param trade_status
	 * @throws UnsupportedEncodingException
	 */
	public String alipayNotifyUrl(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {

		// 乱码解决，这段代码在出现乱码时使用
//		request.setCharacterEncoding("utf-8");
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (String str : requestParams.keySet()) {
			String name = str;
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}

		try {
			// 调用SDK验证签名
			boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key,
					AlipayConfig.charset, AlipayConfig.sign_type);
			if (!signVerified) {
				WXPayUtil.getLogger().info("验签失败");
				return "fail";
			} else {
				// 商户订单号,之前生成的带用户ID的订单号
				String out_trade_no = params.get("out_trade_no");
				// 支付宝交易号
//				String trade_no = params.get("trade_no");
				// 付款金额
				String total_amount = params.get("total_amount");
				// 交易状态
				String trade_status = params.get("trade_status");
				// app_id
				String app_id = params.get("app_id");

				// 1.商户需要验证该通知数据中的 out_trade_no 是否为商户系统中创建的订单号；

				// 2.判断 total_amount 是否确实为该订单的实际金额（即商户订单创建时的金额）；
				if (!total_amount.equals(total_amount)) {
					return "fail";
				}
				// 3.校验通知中的 seller_id（或者 seller_email) 是否为 out_trade_no
				// 这笔单据的对应的操作方（有的时候，一个商户可能有多个 seller_id/seller_email）；

				// 4.验证app_id 是否为该商户本身。
				if (!app_id.equals(AlipayConfig.app_id)) {
					return "fail";
				}

				if (trade_status.equals("TRADE_FINISHED")) {
					/* 此处可自由发挥 */
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序
					// 注意：
					// 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
				} else if (trade_status.equals("TRADE_SUCCESS")) {
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（out_trade_no在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 如果有做过处理，不执行商户的业务程序
					// 增加用户在数据库余额

					// 订单详情
					FcOrder orderModel = fcOrderService.selectByCode(out_trade_no);
					if (orderModel != null) {
						if (orderModel.getPayStatus() == 1) {
							// 课程档案
							FcCourseArchives courseModel = fcCourseArchivesMapper
									.selectByPrimaryKey(orderModel.getCourseId());

							FcOrder updOrder = new FcOrder();
							updOrder.setId(orderModel.getId());
							// 当前时间
							Calendar current_calendar = Calendar.getInstance();
							// 开始时间
							updOrder.setStartTime(current_calendar.getTime());
							// 结束时间
							current_calendar.add(Calendar.DAY_OF_YEAR, courseModel.getCourseNumber());
							updOrder.setEndTime(current_calendar.getTime());
							updOrder.setPayStatus(2);
							fcOrderService.updateByPrimaryKeySelective(updOrder);

							// 修改订单子数据为个人
							fcOrderPersonMapper.updateIndividualByOrderId(orderModel.getId());

							// 修改申请记录为已缴费
							if (orderModel.getApplyId() != null) {
								FcApply updApply = new FcApply();
								updApply.setId(orderModel.getApplyId());
								updApply.setApplySchedule(2);
								fcApplyMapper.updateByPrimaryKeySelective(updApply);
							}

							MemberInfo memberParam = new MemberInfo();
							memberParam.setRoleId(orderModel.getRoleId());
							if (orderModel.getRoleType() == 1) {
								memberParam.setRoleType(2);
							} else if (orderModel.getRoleType() == 2) {
								memberParam.setRoleType(3);
							} else if (orderModel.getRoleType() == 3) {
								memberParam.setRoleType(4);
							}
							MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(memberParam);
							if (memberInfo != null) {
								String courseName = fcCourseArchivesMapper.selectByPrimaryKey(orderModel.getCourseId())
										.getName();
								String message = "";
								if (orderModel.getRoleType().intValue() == 1) {
									// 机构
								} else {
									//如果是恩起用户回调给恩起
									Integer roleId = orderModel.getRoleId();
									PractitionerInfo practitionerInfo  = practitionerInfoMapper.selectByPrimaryKey(roleId);
									Integer source = practitionerInfo.getSource();
									if(source!=null && source==2) {
										//回传用户接口
									}
									// 家长/从业者
									message = "【华夏云课堂】您好：您已成功报名" + courseName + "，请及时关注课程信息，祝您学习愉快！";
									smsService.sendFinishSMS(memberInfo.getTellPhone(), message);
								}
							}
						}
						return "success";
					} else {
						WXPayUtil.getLogger().info("订单不存在");
						return "fail";
					}
				}
				return "success";
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
			WXPayUtil.getLogger().info("验签异常");
			return "fail";
		}
	}
}
