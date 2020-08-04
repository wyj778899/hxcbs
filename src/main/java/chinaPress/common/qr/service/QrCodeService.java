package chinaPress.common.qr.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.common.httpclient.HttpClient;
import chinaPress.common.httpclient.Result;
import chinaPress.common.sms.service.SMSService;
import chinaPress.common.util.JacksonUtil;
import chinaPress.common.util.ResultUtil;
import chinaPress.common.wxpay.MyWXPayConfig;
import chinaPress.common.wxpay.WXPay;
import chinaPress.common.wxpay.WXPayConstants;
import chinaPress.common.wxpay.WXPayConstants.SignType;
import chinaPress.common.wxpay.WXPayUtil;
import chinaPress.common.wxpay.WxUser;
import chinaPress.fc.apply.dao.FcApplyMapper;
import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.coupon.dao.FcDiscountCouponRecordMapper;
import chinaPress.fc.coupon.model.FcDiscountCouponRecord;
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

	@Autowired
	private PractitionerInfoMapper practitionerInfoMapper;

	@Autowired
	private FcDiscountCouponRecordMapper fcDiscountCouponRecordMapper;

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

		BigDecimal orderPayAmountYuan = orderModel.getPayAmount();
		// 转换为分
		BigDecimal orderPayAmountFen = orderPayAmountYuan.multiply(new BigDecimal(100));

		reqData.put("total_fee", orderPayAmountFen.stripTrailingZeros().toPlainString());
		reqData.put("spbill_create_ip", "127.0.0.1");
		reqData.put("notify_url", "http://www.hxclass.cn/chinaPressServer/notify_url");
		reqData.put("trade_type", "NATIVE"); // 交易类型

		// 下单，返回结果
		Map<String, String> resultMap = wxPay.unifiedOrder(reqData);
		WXPayUtil.getLogger().info(resultMap.toString());
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
						updOrder.setPaymentMode("1");
						updOrder.setPayTime(new Date());
						updOrder.setThirdPartyNo(resultMap.get("transaction_id"));
						fcOrderService.updateByPrimaryKeySelective(updOrder);

						if (orderModel.getIsCoupon() != null && orderModel.getIsCoupon().intValue() == 1) {
							FcDiscountCouponRecord couponRecord = new FcDiscountCouponRecord();
							couponRecord.setId(orderModel.getCouponId());
							couponRecord.setStatus(3);
							fcDiscountCouponRecordMapper.updateByPrimaryKeySelective(couponRecord);
						}

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
								// 如果是恩起用户回调给恩起
								Integer roleId = orderModel.getRoleId();
								PractitionerInfo practitionerInfo = practitionerInfoMapper.selectByPrimaryKey(roleId);
								Integer source = practitionerInfo.getSource();
								if (source != null && source == 2) {
									// 回传用户接口
									Map<String, String> params = new HashMap<String, String>();
									params.put("tellPhone", practitionerInfo.getTellPhone());
									params.put("certificateNumber", practitionerInfo.getCertificateNumber());
									try {
										Result result = HttpClient.doPost("http://www.ingclass.org/hx/status/update.do",
												params);
										if (result.getCode() == 200) {
											WXPayUtil.getLogger().info("恩起发送成功");
										}
									} catch (Exception e) {
										e.printStackTrace();
										WXPayUtil.getLogger().info("恩起发送异常");
									}
								}
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

	/**
	 * h5唤起支付
	 * 
	 * @author maguoliang
	 * @param code    网页授权code
	 * @param orderId 订单id
	 * @return
	 * @throws Exception
	 */
	public chinaPress.common.result.model.Result h5CallPay(String openId, Integer orderId) throws Exception {
		chinaPress.common.result.model.Result chinaResult = new chinaPress.common.result.model.Result();
		FcOrder orderModel = fcOrderService.selectById(orderId);
		// 业务逻辑，判断此订单是否存在，已支付等等

		// 统一下单
		MyWXPayConfig config = new MyWXPayConfig();
		WXPay wxPay = new WXPay(config);
		// 统一下单参数
		Map<String, String> reqData = new HashMap<>();
		reqData.put("appid", config.getAppID());
		reqData.put("mch_id", config.getMchID());
		reqData.put("nonce_str", WXPayUtil.generateNonceStr());

		reqData.put("openid", openId); // 用户标识
		reqData.put("body", "11111"); // 商品描述
		reqData.put("out_trade_no", WXPayUtil.generateNonceStr()); // 商户订单号

//		BigDecimal orderPayAmountYuan = orderModel.getPayAmount();
//		// 转换为分
//		BigDecimal orderPayAmountFen = orderPayAmountYuan.multiply(new BigDecimal(100));
		reqData.put("total_fee", "1"); // 标价金额

		reqData.put("spbill_create_ip", "127.0.0.1"); // 终端ip
		reqData.put("notify_url", "http://www.hxclass.cn/"); // 通知地址
		reqData.put("trade_type", "JSAPI"); // 交易类型
		reqData.put("sign", WXPayUtil.generateSignature(reqData, config.getKey(), SignType.HMACSHA256));
		System.out.println(reqData.toString());
		// 下单，返回支付结果
		Map<String, String> resultMap = wxPay.unifiedOrder(reqData);

		WXPayUtil.getLogger().info(resultMap.toString());
		Map<String, String> resParams = new HashMap<String, String>();
		// 统一下单成功
		if (resultMap.get("return_code").equals("SUCCESS")) {
			System.out.println(resultMap.toString());
			resParams.put("appId", resultMap.get("appid"));
			resParams.put("timeStamp", String.valueOf(WXPayUtil.getCurrentTimestamp()));
			resParams.put("nonceStr", resultMap.get("nonce_str"));
			resParams.put("package", "prepay_id=" + resultMap.get("prepay_id"));
			resParams.put("signType", WXPayConstants.HMACSHA256);
			resParams.put("paySign", WXPayUtil.generateSignature(resParams, config.getKey(), SignType.HMACSHA256));
			chinaResult = ResultUtil.custom(1, "成功", resParams);
		} else if (resultMap.get("return_code").equals("FAIL")) {
			chinaResult = ResultUtil.custom(0, "失败", resParams);
		}
		return chinaResult;
	}

	/**
	 * 微信授权
	 * 
	 * @author maguoliang
	 * @return
	 * @throws IOException
	 */
	public String authorization() throws IOException {
		// 授权后重定向的回调链接地址
		String REDIRECT_URI = WXPayUtil.urlEncode("http://www.hxclass.cn/h5/", "UTF-8");
		// 微信授权 URL
		String AUTHORIZATION_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
		MyWXPayConfig myWXPayConfig = new MyWXPayConfig();
		String url = AUTHORIZATION_URL.replace("APPID", myWXPayConfig.getAppID()).replace("REDIRECT_URI", REDIRECT_URI)
				.replace("SCOPE", "snsapi_base");
		return url;
	}

	/**
	 * 通过微信网页授权码获取openId
	 * 
	 * @author maguoliang
	 * @param code
	 * @return
	 * @throws IOException
	 */
	public String getWxOpenId(String code) throws IOException {
		String openId = "";
		MyWXPayConfig myWXPayConfig = new MyWXPayConfig();
		// 回传用户接口
		Map<String, String> params = new HashMap<String, String>();
		params.put("appid", myWXPayConfig.getAppID());
		params.put("secret", myWXPayConfig.getAppSecret());
		params.put("code", code);
		params.put("grant_type", "authorization_code");
		try {
			Result result = HttpClient.doPost("https://api.weixin.qq.com/sns/oauth2/access_token", params);
			if (result.getCode() == 200) {
				WXPayUtil.getLogger().info("请求成功");
				System.out.println(result.getContent());
				WxUser wxUser = JacksonUtil.fromJSON(result.getContent(), WxUser.class);
				openId = wxUser.getOpenid();
			}
		} catch (Exception e) {
			e.printStackTrace();
			WXPayUtil.getLogger().info("请求异常");
		}
		return openId;
	}
}
