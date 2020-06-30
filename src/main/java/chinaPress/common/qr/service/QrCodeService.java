package chinaPress.common.qr.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.common.sms.service.SMSService;
import chinaPress.common.wxpay.MyWXPayConfig;
import chinaPress.common.wxpay.WXPay;
import chinaPress.common.wxpay.WXPayConstants;
import chinaPress.common.wxpay.WXPayConstants.SignType;
import chinaPress.common.wxpay.WXPayUtil;
import chinaPress.fc.apply.dao.FcApplyMapper;
import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.course.dao.FcCourseArchivesMapper;
import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.service.FcOrderService;
import chinaPress.role.member.dao.MemberInfoMapper;
import chinaPress.role.member.model.MemberInfo;

@Service
public class QrCodeService {

	@Autowired
	private FcOrderService fcOrderService;

	@Autowired
	private FcCourseArchivesMapper fcCourseArchivesMapper;

	@Autowired
	private FcOrderPersonMapper fcOrderPersonMapper;

	@Autowired
	private FcApplyMapper fcApplyMapper;

	@Autowired
	private MemberInfoMapper memberInfoMapper;

	@Autowired
	private SMSService smsService;

	/**
	 * 微信支付模式一支付回调
	 * 
	 * @author maguoliang
	 * @param wxPayCallbackMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> wxPayCallback(Map<String, String> wxPayCallbackMap) throws Exception {
		// 购买的信息
		String orderId = wxPayCallbackMap.get("product_id");
		String openId = wxPayCallbackMap.get("openid");

		FcOrder orderModel = fcOrderService.selectById(Integer.parseInt(orderId));

		// 统一下单
		MyWXPayConfig config = new MyWXPayConfig();
		WXPay wxPay = new WXPay(config);
		Map<String, String> reqData = new HashMap<>();
		String body = "购买课程";

		reqData.put("body", body);
		reqData.put("out_trade_no", orderModel.getCode());
		reqData.put("total_fee", String.valueOf(orderModel.getPayAmount().multiply(new BigDecimal(100))));
		reqData.put("spbill_create_ip", "127.0.0.1");
		reqData.put("notify_url", "http://www.zryuxiang.com:8080/software/notify_url");
		reqData.put("trade_type", "NATIVE"); // 交易类型

		// 下单，返回结果
		Map<String, String> resultMap = wxPay.unifiedOrder(reqData);
		Map<String, String> resParams = new HashMap<String, String>();
		// 统一下单成功
		if (resultMap.get("return_code").equals("SUCCESS")) {
			// 暂时只做统一下单成功，就立马需要支付，中间暂不做业务
			resParams.put("return_code", "SUCCESS"); // 必须
			resParams.put("appid", config.getAppID()); // 必须
			resParams.put("mch_id", config.getMchID()); // 必须
			resParams.put("nonce_str", WXPayUtil.generateNonceStr()); // 必须
			resParams.put("prepay_id", resultMap.get("prepay_id")); // 必须
			resParams.put("result_code", "SUCCESS"); // 必须
			resParams.put("sign", WXPayUtil.generateSignature(resParams, config.getKey(), SignType.MD5)); // 签名
		} else if (resultMap.get("return_code").equals("FAIL")) {
			resParams.put("return_code", "FAIL"); // 必须
			resParams.put("return_msg", "统一下单返回失败"); // 必须
			resParams.put("appid", config.getAppID()); // 必须
			resParams.put("mch_id", config.getMchID()); // 必须
			resParams.put("nonce_str", WXPayUtil.generateNonceStr()); // 必须
			resParams.put("prepay_id", ""); // 必须
			resParams.put("result_code", "FAIL"); // 必须
			resParams.put("sign", WXPayUtil.generateSignature(resParams, config.getKey(), SignType.MD5)); // 签名
		}
		return resParams;
	}

	/**
	 * 支付结果回调
	 * 
	 * @author maguoliang
	 * @param resultMap
	 * @return
	 * @throws Exception
	 */
	public String notifyUrl(Map<String, String> resultMap) throws Exception {
		String resXml = "";
		// 此处只判断是否支付成功，不管实际业务（统一下单时的业务，暂不做）是否成功
		WXPayUtil.getLogger().info(resultMap.toString());
		if (WXPayConstants.SUCCESS.equals(resultMap.get("return_code"))) {
			MyWXPayConfig config = new MyWXPayConfig();
			// 验证签名
			if (WXPayUtil.isSignatureValid(resultMap, config.getKey(), SignType.HMACSHA256)) {
				// 订单编码
				String buyInfo = resultMap.get("out_trade_no");
				// 订单详情
				FcOrder orderModel = fcOrderService.selectByCode(buyInfo);
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
								// 家长/从业者
								message = "【华夏云课堂】您好：您已成功报名" + courseName + "，请及时关注课程信息，祝您学习愉快！";
								smsService.sendFinishSMS(memberInfo.getTellPhone(), message);
							}
						}
					}
					resXml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
				} else {
					resXml = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[支付成功，购买会员失败]]></return_msg></xml>";
				}
			} else {
				resXml = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[验签失败]]></return_msg></xml>";
			}
		} else {
			resXml = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[支付失败]]></return_msg></xml>";
		}
		return resXml;
	}
}
