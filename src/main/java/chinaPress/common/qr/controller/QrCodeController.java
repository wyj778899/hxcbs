package chinaPress.common.qr.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import chinaPress.common.httpclient.Result;
import chinaPress.common.qr.service.QrCodeService;
import chinaPress.common.util.ResultUtil;
import chinaPress.common.wxpay.MyWXPayConfig;
import chinaPress.common.wxpay.WXPay;
import chinaPress.common.wxpay.WXPayUtil;
import chinaPress.fc.order.service.FcOrderService;

@RestController
public class QrCodeController {

	@Autowired
	private QrCodeService qrCodeService;

	/**
	 * 生成微信支付二维码图片
	 * 
	 * @author maguoliang
	 * @param content
	 * @return
	 */
	public static BufferedImage QREncode(String content) {
		int width = 250; // 图像宽度
		int height = 250; // 图像高度
		Map<EncodeHintType, Object> hints = new HashMap<>();
		// 内容编码格式
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		// 指定纠错等级
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 设置二维码边的空度，非负数
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = null;
		BufferedImage bufferedImage = null;
		try {
			bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

			MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF);
			bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix, matrixToImageConfig);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		return bufferedImage;
	}

	/**
	 * 获取二维码图片
	 * 
	 * @author maguoliang
	 * @param response
	 * @throws Exception
	 */
	@GetMapping("qrcode")
	public void getBarCodeImage(HttpServletResponse response, String orderId) throws Exception {
		// 设置页面不缓存
		assert response != null;
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 设置输出的内容的类型为JPEG图像
		response.setContentType("image/jpeg");
		// 设置二维码内容
		MyWXPayConfig config = new MyWXPayConfig();
		Map<String, String> data = new HashMap<String, String>();
		data.put("appid", config.getAppID());
		data.put("mch_id", config.getMchID());
		data.put("time_stamp", String.valueOf(WXPayUtil.getCurrentTimestamp()));
		data.put("nonce_str", WXPayUtil.generateNonceStr());
		data.put("product_id", orderId);
		// 生成签名
		String sign = WXPayUtil.generateSignature(data, config.getKey());
		String text = "weixin://wxpay/bizpayurl?sign=" + sign + "&appid=" + config.getAppID() + "&mch_id="
				+ config.getMchID() + "&product_id=" + orderId + "&time_stamp=" + data.get("time_stamp") + "&nonce_str="
				+ data.get("nonce_str");

		BufferedImage bufferedImage = QREncode(text);
		// 写给浏览器
		ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
	}

	/**
	 * 微信支付模式一回调url
	 * 
	 * @author maguoliang
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("return_url")
	public void wxPayCallback(HttpServletRequest request, HttpServletResponse response) throws Exception {
		WXPayUtil.getLogger().info("模式一支付回调URL");
		Map<String, String> wxPayCallbackMap = getWxPayRequestData(request);
		WXPayUtil.getLogger().info(wxPayCallbackMap.toString());
		Map<String, String> resParams = qrCodeService.wxPayCallback(wxPayCallbackMap);
		WXPayUtil.getLogger().info(resParams.toString());
		// 通知微信 预下单成功
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		out.write(WXPayUtil.mapToXml(resParams).getBytes());
		out.flush();
		out.close();
	}

	/**
	 * 统一下单 - 通知
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("notify_url")
	public void notifyUrl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		WXPayUtil.getLogger().info("支付结果通知");
		String resXml = "";
		Map<String, String> resultMap = getWxPayRequestData(request);
		resXml = qrCodeService.notifyUrl(resultMap);
		WXPayUtil.getLogger().info(resXml);
		// 处理业务完毕
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		out.write(resXml.getBytes());
		out.flush();
		out.close();
	}

	/**
	 * 获取微信向商户系统请求的数据
	 * 
	 * @author maguoliang
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private Map<String, String> getWxPayRequestData(HttpServletRequest request) throws Exception {
		// 获取微信调用我们notify_url的返回信息
		InputStream inStream = request.getInputStream();
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		String result = new String(outSteam.toByteArray(), "utf-8");
		// 关闭流
		outSteam.close();
		inStream.close();
		// xml转换为map
		Map<String, String> resultMap = WXPayUtil.xmlToMap(result);
		return resultMap;
	}

	/**
	 * 查询微信支付结果
	 * 
	 * @author maguoliang
	 * @param buyData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryWxPayResult")
	public Map<String, Object> queryWxPayResult(String buyData) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// 统一下单
		MyWXPayConfig config = new MyWXPayConfig();
		WXPay wxPay = new WXPay(config);
		Map<String, String> reqData = new HashMap<>();
		reqData.put("out_trade_no", buyData.split("_")[0]);
		reqData.put("nonce_str", WXPayUtil.generateNonceStr());
		reqData.put("sign", WXPayUtil.generateSignature(reqData, config.getKey()));
		Map<String, String> queryResult = wxPay.orderQuery(reqData, 100000, 100000);
		WXPayUtil.getLogger().info(queryResult.toString());
		if (queryResult.get("return_code").equals("SUCCESS")) {
			if (queryResult.get("result_code").equals("SUCCESS")) {
				map.put("code", 1);
				map.put("data", queryResult.get("trade_state"));
				map.put("msg", queryResult.get("trade_state_desc"));
			}
		} else if (queryResult.get("return_code").equals("FAIL")) {
			map.put("code", -1);
			map.put("data", "FAIL");
			map.put("msg", "支付失败，请联系管理员");
		}
		return map;
	}

	/**
	 * 微信授权
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "wxH5Authorization")
	public String authorization() throws IOException {
		return qrCodeService.authorization();
	}

	/**
	 * 通过微信网页授权码获取openId
	 * 
	 * @author maguoliang
	 * @param code
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "getWxOpenId")
	public chinaPress.common.result.model.Result getWxOpenId(String code) throws IOException {
		String openId = qrCodeService.getWxOpenId(code);
		if (openId != "") {
			return ResultUtil.custom(1, "获取成功", openId);
		} else {
			return ResultUtil.custom(0, "获取失败", openId);
		}
	}

	/**
	 * h5唤起支付
	 * 
	 * @author maguoliang
	 * @param openId
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "h5CallPay")
	public chinaPress.common.result.model.Result h5CallPay(String openId, Integer orderId) throws Exception {
		return qrCodeService.h5CallPay(openId, orderId);
	}
	
	/**
	 * h5支付
	 * 
	 * @author maguoliang
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("wxH5Pay")
	public chinaPress.common.result.model.Result wxH5Pay(HttpServletRequest request, HttpServletResponse response, Integer orderId) throws Exception {
		Map<String, String> resParams = qrCodeService.wxH5Pay(orderId);
		WXPayUtil.getLogger().info(resParams.toString());
		return ResultUtil.ok(resParams);
	}
}
