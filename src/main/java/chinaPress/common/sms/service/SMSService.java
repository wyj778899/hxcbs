package chinaPress.common.sms.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.common.sms.conf.SMSConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@Service
public class SMSService {
	@Autowired
    private JedisPool jedisPool;//注入JedisPool
//	@Autowired
//	private RoleStaffMapper roleStaffMapper;
	
	/**
	 * 发送短信
	 * @param phone 手机号
	 * @return
	 */
	public Map<String,Object> sendSMS(String phone,Integer type){
		Map<String,Object> map = new HashMap<String,Object>();
//		if(!ValidateUtil.isMobileNO(phone)){
//			map.put("code", 0);
//			map.put("messag", "请输入正确的手机号");
//			return map;
//		}
//		// 判断是否注册过
//		RoleStaff staff = roleStaffMapper.selectUserNameExists(phone);
//		if(staff != null) {
//			if(staff.getIsEnabled() == 1 || staff.getIsEnabled() == 2) {
//				map.put("code", -1);
//				map.put("message", "该注册手机号已存在");
//				return map;
//			}else if(staff.getIsEnabled() == 3) {
//				map.put("code", -2);
//				map.put("message", "该注册手机号正在审核中，请耐心等待。");
//				return map;
//			}
//		}
		map = ihuyiSendSMS(phone,1);
		return map;
	}

	/**
	 * 更改密码发送验证码
	 * @param phone
	 * @return
	 */
	public Map<String,Object> forgetPassword(String phone){
		Map<String,Object> map = new HashMap<String,Object>();
//		if(!ValidateUtil.isMobileNO(phone)){
//			map.put("code", 0);
//			map.put("messag", "请输入正确的手机号");
//		}else{
//			RoleStaff staffs = roleStaffMapper.selectUserNameExists(phone);
//			if(staffs==null){
//				map.put("code", -2);
//				map.put("messahe", "该手机号尚未注册");
//			}else{
//				map = ihuyiSendSMS(phone,2);
//			}
//		}
		return map;
	}


	/**
	 * 互亿无线ihuyi
	 * @param phone 手机号
	 * @param type 1.企业注册2.企业忘记密码 3.账号审核通过
	 * @return
	 */
	public Map<String,Object> ihuyiSendSMS(String phone,int type) {
		Map<String,Object> map = new HashMap<String,Object>();
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(SMSConfig.url);
		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
		int mobile_code = (int)((Math.random()*9+1)*100000);
		String content = "";
		if(type == 1){
			content = "您注册企业的验证码为："+mobile_code+"，请不要把验证码泄露给其他人！5分钟内有效。";
		}else if(type == 2){
			content = "您正在找回密码，验证码为："+mobile_code+"，请不要把验证码泄露给其他人。如非本人操作，可不用理会！5分钟内有效。";
		}else if(type == 3) {
			content = "您的账号已经审核通过，请登录查看。 ";
		}
		NameValuePair[] data = {
				//提交短信
				new NameValuePair("account", SMSConfig.APIID),
				new NameValuePair("password", SMSConfig.APIKEY), // 查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
				//new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
				new NameValuePair("mobile", phone),
				new NameValuePair("content", content),
		};
		method.setRequestBody(data);
		String code="";
		String msg="";
		String smsid="";
		try {
			client.executeMethod(method);
			String SubmitResult = method.getResponseBodyAsString();
			//System.out.println(SubmitResult);
			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();
			code = root.elementText("code");
			msg = root.elementText("msg");
			smsid = root.elementText("smsid");
			if(code.equals("2")){
				System.out.println(code);
				System.out.println(msg);
				System.out.println(smsid);
				Jedis jedis = jedisPool.getResource();
				// 企业注册
				if(type==1){
					jedis.setex("register_".concat(phone), 1*60*5, String.valueOf(mobile_code));
				}
				// 企业忘记密码
				else if(type==2){
					jedis.setex("forget_password_".concat(phone), 1*60*5, String.valueOf(mobile_code));
				}else if(type == 3){
					jedis.setex("register_".concat(phone), 1*60*5, String.valueOf(mobile_code));
					map.put("verif", mobile_code);
				}
				jedis.close();
				map.put("code", 1);
				map.put("message", "发送成功");
			}else{
				System.err.println(code);
				System.err.println(msg);
				System.err.println(smsid);
				map.put("code", -1);
				map.put("message", "发送失败");
			}
		} catch (HttpException e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("message", "异常");
		} catch (IOException e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("message", "异常");
		} catch (DocumentException e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("message", "异常");
		}
		return map;
	}

	/**
	 * 审核成功/失败发送信息
	 * @param phone
	 * @return
	 */
	public Map<String,Object> sendFinishSMS(String phone,String message) {
		Map<String,Object> map = new HashMap<String,Object>();
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(SMSConfig.url);
		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
		String content = new String(message);
		NameValuePair[] data = {
				//提交短信
				new NameValuePair("account", SMSConfig.APIID),
				new NameValuePair("password", SMSConfig.APIKEY), // 查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
				//new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
				new NameValuePair("mobile", phone),
				new NameValuePair("content", content),
		};
		method.setRequestBody(data);
		String code="";
		String msg="";
		String smsid="";
		try {
			client.executeMethod(method);
			String SubmitResult = method.getResponseBodyAsString();
			//System.out.println(SubmitResult);
			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();
			code = root.elementText("code");
			msg = root.elementText("msg");
			smsid = root.elementText("smsid");
			if(code.equals("2")){
				System.out.println(code);
				System.out.println(msg);
				System.out.println(smsid);
				map.put("code", 1);
				map.put("message", msg);
			}else{
				System.err.println(code);
				System.err.println(msg);
				System.err.println(smsid);
				map.put("code", -1);
				map.put("message", "发送失败");
			}
		} catch (HttpException e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("message", "异常");
		} catch (IOException e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("message", "异常");
		} catch (DocumentException e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("message", "异常");
		}
		return map;
	}

}
