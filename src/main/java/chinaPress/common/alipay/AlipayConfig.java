package chinaPress.common.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2017082808420785";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCwvFB4AT3H4e3T3UbmBzl3ikR5LKdGArVfpTsLvWeGeWaki2sskQFzPpaxMvGZH0wwFCwTUn1cnph6UMatC/zHhn3TTtVKHk8vOwnw2YGJBV9aTSgSzVQc+9+WTL8kghDEksIuoGx1vulTP/TwAxhqD+zW4stkG6qzKas8MzxGq71f5DQoVKm6PKnS0FhQuXeCz9EwLPNftVItEWlbjEeDLTVChY6IKZiDclc4h+llQ7YxY4Qz/+vmIeSuQUDrb/i6grK+IhA1E+LzzncjBwX2nqZ9rDztrFaRfingDRWvdWE9i/3dj2Obj7TQyiP2hZ5VufWWSWBzoXzMucH9cSaPAgMBAAECggEAcpIRhEoht9Mxrveyf2pNib37t6YH5i3ZUGC3z1uAoj9PF/o9hw2VqBT58XN6BW6xoDVjgT8nf4RcimaU9RdhTiNUrEhdoofVg2O9hQIrpBz0fICqKs4q6gMqJbAo9UzP++67rShYR1h0v4Alk/YdvJwISCGMAqCg3zZzCDqap6CWHhZTuXQvP1oeq8K4LuwdwDptBYiFbwYr8OMQc+2iB6yyZuHHRqQ0qtWk81f/lsE9aE/O3TWKhX0pP72+s20an9zri2hP5Y5ckv1dsVHyZ34Mvlwv3Zzefl/ivs6VLy9MaasDqufYDWxg0dtfetxDfeTqlWqcg7a2C/bK78xyyQKBgQDvHIXBkhI+q23bipKV3C/eMpSQ1dIcZvxR80Ww84r23acL+4pb4L6pRwflxUaDquZeyphhO/5uq2mFPn79A64PkSNt1X5sTN2iZE9R/Rtw2yULdCSrC+Y+l5Me2dKOOuqz+IfJIGUAZQVtsoUZfjIlPAVXxDqmHrNFaasrttqs8wKBgQC9N/KYdBgyvq62h59uBqCyewGrMCXbOO82w3zuzlH8nGWXlFZoQv9L3kBAuIbWYpiPglXh3hMxtatrUdqChFE2b1CO3yfcAbkWI0a3fTXHK/6gZ1NKNseCUMgeHY7Yn0pzqJNlzmuDWi9yEt+/YgbTF7bwg782th3yb/PuG7BW9QKBgC4uwh7bCa8VCUjoANv1BUHTXyKCSey2b3GcnQ9KWsLHmOYVlWmdhPXJBFt6uN3helFArCHLpp7VeLIFmh1gQpQ7Ii6ql5pvVjdxTGi3jD9F9Ge77QEkcToRqJbC14olEwPjssZD/X4QBPZlDpQX7bOHXjjPa8x+DX4QpMDytlXFAoGATWilA3+DIsdlfGDxdTaa6UlvPlRdOFkLa/D/nEalvd1RpnhV/SNjg+sxiAi1iOEfHp6oedW7Lnvu2+HJrdlpzAYwA7MBgHzn9kmKNaiwpoG2EnMS3OqaJhLcO43GEZLhB33whxayXzM288kK5iW5OwSZn72WLVDF4ZexSDjlpD0CgYEA45tl2kh6un46DdR/abasQq+iBLoqzr0Yl0e+qeHGkTwke5IYv6LrAyDVXpqv2Wfte6XRkcn0faEEwKHRgC/gKbz5jkocjCJFLAJKABw4hSUevks5XdEFHmNrGZrkZTiwiNVd4EQHiJQf0qvHfU/2b3Vv5JvpiodrfiNu0nZ+lZU=";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsD8Wa2lFiK7J8nfc51Ghalwi1JaSVQe0tv/i4uaFyJ3sDCXC7goR7NnROYV0jEs0u9md8hlO6tBgvt5W+kln9IKpDqHZo+wRa+9YOnBVurvz5wcj937syoyAp34aSQZbEkv0Vv9GmMouTeldm5AeFyUlHXQfXtuEyGXhgQ6Z6+rUr2tjUOo2kHcvjfwCcZNkLeZMtNlVPG58+ntS0JhXxaFlBPxoPd+jUXgDH2MsxC4Hhx1VaXqrLJj5i4bhgMtvP8A1cC/Z9HnHUWuEaHZr3Cd0vz0brKt7srfdOm4G96ZHq8IQJlakRvbAWPCW3afTQ7LXRkFNXq04zDwirsQigQIDAQAB";

	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://www.hxclass.cn/chinaPressServer/alipay/notify_url";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://www.hxclass.cn/home/curriculumCenter";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * 
	 * @param sWord 要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
