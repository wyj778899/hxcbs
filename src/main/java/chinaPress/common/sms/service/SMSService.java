package chinaPress.common.sms.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import chinaPress.common.util.ValidateUtil;
import chinaPress.role.member.dao.MemberInfoMapper;
import chinaPress.role.member.model.MemberInfo;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class SMSService {
	@Autowired
	private JedisPool jedisPool;// 注入JedisPool
//	@Autowired
//	private RoleStaffMapper roleStaffMapper;

	@Autowired
	private MemberInfoMapper memberInfoMapper;

	/**
	 * 发送短信
	 * 
	 * @param phone 手机号
	 * @return
	 */
	public Map<String, Object> sendSMS(String phone, Integer type) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!ValidateUtil.isMobileNO(phone)) {
			map.put("code", 0);
			map.put("message", "请输入正确的手机号");
			return map;
		}
		MemberInfo param = new MemberInfo();
		param.setTellPhone(phone);
		MemberInfo m = memberInfoMapper.selectByPrimaryKey(param);
		if (m != null) {
			if (m.getIsStart() == 1) {
				map.put("code", -1);
				map.put("message", "该注册手机号已存在");
				return map;
			} else if (m.getState() == 1) {
				map.put("code", -2);
				map.put("message", "该注册手机号正在审核中，请耐心等待。");
				return map;
			}
		}
		int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);
		String content = "验证码：" + mobile_code + "，您正在注册成为新用户，验证码10分钟内有效，请勿泄露给他人。";
		Jedis jedis = jedisPool.getResource();
		jedis.setex("register_".concat(phone), 1 * 60 * 10, String.valueOf(mobile_code));
		map = sendFinishSMS(phone, content);
		return map;
	}

	/**
	 * 更改密码发送验证码
	 * 
	 * @param phone
	 * @return
	 */
	public Map<String, Object> forgetPassword(String phone) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!ValidateUtil.isMobileNO(phone)) {
			map.put("code", 0);
			map.put("message", "请输入正确的手机号");
		} else {
			MemberInfo param = new MemberInfo();
			param.setTellPhone(phone);
			MemberInfo m = memberInfoMapper.selectByPrimaryKey(param);
			if (m == null) {
				map.put("code", -2);
				map.put("message", "该手机号尚未注册");
			} else {
				int mobile_code = (int) ((Math.random() * 9 + 1) * 100000);
				String content = "验证码：" + mobile_code + "，您正在使用手机账号找回密码，验证码10分钟内有效，请勿泄露给他人。";
				Jedis jedis = jedisPool.getResource();
				jedis.setex("forget_password_".concat(phone), 1 * 60 * 10, String.valueOf(mobile_code));
				map = sendFinishSMS(phone, content);
			}
		}
		return map;
	}

	/**
	 * 审核成功/失败发送信息
	 * 
	 * @param phone
	 * @return
	 */
	public Map<String, Object> sendFinishSMS(String phone, String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		String content = null;
		try {
			content = java.net.URLEncoder.encode(message.concat("[华夏云课堂]"), "utf-8");
			SMSConfig SMSConfig = new SMSConfig("SDK-WSS-010-12472", "BCbQzg2H");
			String result_mt = SMSConfig.mdsmssend(phone, content, "", "", "", "");
			System.out.print(result_mt);
			map.put("code", 1);
			map.put("message", "发送成功");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("message", "发送异常");
		} catch (IOException e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("message", "发送异常");
		}
		return map;
	}

}
