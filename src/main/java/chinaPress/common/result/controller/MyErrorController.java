package chinaPress.common.result.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;

@RestController
public class MyErrorController implements ErrorController {
	@Autowired
	private ErrorAttributes errorAttributes;

	private final static String ERROR_PATH = "/error";

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	/**
	 * 处理xml，json等
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = ERROR_PATH)
	@ExceptionHandler(value = { Exception.class })
	public Result handleApiError(HttpServletRequest request, HttpServletResponse response) {
		ServletWebRequest requestAttributes = new ServletWebRequest(request);
		Map<String, Object> map = errorAttributes.getErrorAttributes(requestAttributes, false);
		System.out.println(map.toString());
		Result result = ResultUtil.custom((int) map.get("status"), (String) map.get("message"));
		return result;
	}
}
