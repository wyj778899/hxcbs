package chinaPress.common.code;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.util.RandomValidateCodeUtil;

@RestController
public class CodeController {

	
	/**
	 * 输出验证码
	 * @param request
	 * @param response
	 */
	@RequestMapping("/verificationCode")
	public void verificationCode(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			  response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
			  response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
			  response.setHeader("Cache-Control", "no-cache");
			  response.setDateHeader("Expire", 0);
			  //验证码工具类
			  RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
			  randomValidateCode.getRandcode(request, response);//输出验证码图片方法
			 } catch (Exception e) {
			 	e.printStackTrace();
			 }
	}
}
