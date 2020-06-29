package chinaPress.common.qr.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import chinaPress.common.wxpay.MyWXPayConfig;
import chinaPress.common.wxpay.WXPay;
import chinaPress.common.wxpay.WXPayConstants;
import chinaPress.common.wxpay.WXPayConstants.SignType;
import chinaPress.common.wxpay.WXPayUtil;

@Service
public class QrCodeService {

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
		String buyInfo = wxPayCallbackMap.get("product_id");
		WXPayUtil.getLogger().info(buyInfo);
		String openId = wxPayCallbackMap.get("openid");
		String roleId = buyInfo.split("-")[0];
		String roleType = buyInfo.split("-")[1];
		String buyProductType = buyInfo.split("-")[2];
		String buyProductId = buyInfo.split("-")[3];
		String buyProductKind = buyInfo.split("-")[4];
		String buyProductPrice = buyInfo.split("-")[6];
		// 统一下单
		MyWXPayConfig config = new MyWXPayConfig();
		WXPay wxPay = new WXPay(config);
		Map<String, String> reqData = new HashMap<>();
		String body = "";
		if (buyProductKind.equals("1")) {
			body = "软件网-会员充值";
		}
		if (buyProductKind.equals("2")) {
			body = "软件网-下订单";
		}
		reqData.put("body", body);
		reqData.put("out_trade_no", buyInfo);
		reqData.put("total_fee", String.valueOf(new BigDecimal(buyProductPrice).multiply(new BigDecimal(100))));
//		reqData.put("total_fee", buyProductPrice);
		reqData.put("spbill_create_ip", "127.0.0.1");
		reqData.put("notify_url", "http://www.zryuxiang.com:8080/software/notify_url");
		reqData.put("trade_type", "NATIVE"); // 交易类型

		// 下单，返回结果
		Map<String, String> resultMap = wxPay.unifiedOrder(reqData);
		Map<String, String> resParams = new HashMap<String, String>();
		// 统一下单成功
		if (resultMap.get("return_code").equals("SUCCESS")) {
//					// 业务成功
//					if (resultMap.get("result_code").equals("SUCCESS")) {
//						
//					}
//					// 业务失败
//					else if (resultMap.get("result_code").equals("FAIL")) {
//						
//					}
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
				// 暂不做：实际支付金额和系统的商品金额的对比
				// String total_fee = resultMap.get("total_fee");
				// WXPayUtil.getLogger().info("商城支付通知，订单id（" + orderId + "）金额与支付金额不一致");

				String buyInfo = resultMap.get("out_trade_no");
				WXPayUtil.getLogger().info(buyInfo);
				String roleId = buyInfo.split("-")[0];
				String roleType = buyInfo.split("-")[1];
				String buyProductType = buyInfo.split("-")[2];
				String buyProductId = buyInfo.split("-")[3];
				String buyProductKind = buyInfo.split("-")[4];
				String buyProductPrice = buyInfo.split("-")[6];
//				// 购买的会员
//				if (buyProductKind.equals("1")) {
//					RoleCost record = new RoleCost();
//					record.setPayTs(new Date());
//					record.setPayWay(2);
//					record.setRelationId(Integer.parseInt(buyProductId));
//					record.setRelationType(Integer.parseInt(roleType));
//					record.setRoleId(Integer.parseInt(roleId));
//					Date expireDate = CalculateTimeUtil
//							.parse(CalculateTimeUtil.getFewDaysLater(30, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss");
//					record.setExpireTime(expireDate);
//					int index = roleCostMapper.insertSelective(record);
//					// 1.厂商.2.代理商.3.客户.4.顾问.5.后台
//					if (roleType.equals("1")) {
//
//					} else if (roleType.equals("2")) {
//
//					} else if (roleType.equals("3")) {
//
//					} else if (roleType.equals("4")) {
//
//					}
//					if (index > 0) {
//						// 支付成功、新增一条消费记录
//						FcExpenseRecord expenseRecord = new FcExpenseRecord();
//						expenseRecord.setOrderCode(sysOrderCodeService.insertOrderCode(5));
//						expenseRecord.setPaymentMode(2);
//						expenseRecord.setPaymentOrderCode(resultMap.get("transaction_id").toString());
//						expenseRecord.setPaymentTime(new Date());
//						expenseRecord.setRoleId(Integer.parseInt(roleId));
//						expenseRecord.setOrderId(record.getId());
//						expenseRecord.setRoleType(Integer.parseInt(roleType));
//						expenseRecord.setType(1);
//						fcExpenseRecordService.insert(expenseRecord);
//						resXml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
//					} else {
//						resXml = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[支付成功，购买会员失败]]></return_msg></xml>";
//					}
//				}
//				// 购买的订单
//				else if (buyProductKind.equals("2")) {
//					// 修改订单状态
//					// 需求订单
//					if (buyProductType.equals("1")) {
//						FcOrderDemand fcOrderDemand = new FcOrderDemand();
//						fcOrderDemand.setId(Integer.parseInt(buyProductId));
//						fcOrderDemand.setOrderState(3);
//						fcOrderDemandService.updateFcOrderDemandSelective(fcOrderDemand,null);
//					}
//					// 产品订单
//					else if (buyProductType.equals("2")) {
//						FcOrderProduct fcOrderProduct = new FcOrderProduct();
//						fcOrderProduct.setId(Integer.parseInt(buyProductId));
//						fcOrderProduct.setOrderState(2);
//						fcOrderProductService.updateFcOrderProductSelective(fcOrderProduct);
//					}
//				}
			} else {
				resXml = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[验签失败]]></return_msg></xml>";
			}
		} else {
			resXml = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[支付失败]]></return_msg></xml>";
		}
		return resXml;
	}
}
