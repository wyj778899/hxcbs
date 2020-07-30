package chinaPress.common.alipay.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import chinaPress.common.alipay.AlipayConfig;
import chinaPress.common.alipay.service.AlipayService;
import chinaPress.common.wxpay.WXPayUtil;

@RestController
@RequestMapping("alipay")
public class AliPayController {
	@Autowired
	private AlipayService alipayService;

	/**
	 * 统一收单下单并支付页面
	 * 
	 * @author maguoliang
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws AlipayApiException
	 */
	@RequestMapping("alipayPage")
	public String alipayPage(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);

		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

		// 商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"), "UTF-8");
		// 付款金额，必填
		String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"), "UTF-8");
		// 订单名称，必填
		String subject = request.getParameter("WIDsubject");
		// 商品描述，可空
		String body = request.getParameter("WIDbody");

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
				+ "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		// 若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
		// alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
		// + "\"total_amount\":\""+ total_amount +"\","
		// + "\"subject\":\""+ subject +"\","
		// + "\"body\":\""+ body +"\","
		// + "\"timeout_express\":\"10m\","
		// + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		// 请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

		// 请求
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		WXPayUtil.getLogger().info(result);
		// 输出
//		out.println(result);
		return result;
	}

	/**
	 * 支付宝异步回调url
	 * 
	 * @author maguoliang
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("notify_url")
	public String alipayNotifyUrl(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		WXPayUtil.getLogger().info("alipay-支付结果通知");
		return alipayService.alipayNotifyUrl(request, response);
	}
}
