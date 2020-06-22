package chinaPress.common.sms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.sms.service.SMSService;



@RestController
public class SMSController {
	@Autowired
	private SMSService smsService;

	/**
	 * 发送短信
	 * @param phone
	 * @return
	 */
	@RequestMapping("sendSMS")
	public Map<String,Object> sendSMS(String phone,Integer type){
		Map<String,Object> map = new HashMap<String,Object>();
		map = smsService.sendSMS(phone,type);
		return map;
	}

	/**
	 * 忘记密码发送验证码
	 * @param phone
	 * @return
	 */
	@RequestMapping("forgetPassword")
	public Map<String,Object> forgetPassword(String phone){
		Map<String,Object> map = new HashMap<String,Object>();
		map = smsService.forgetPassword(phone);
		return map;
	}

}
