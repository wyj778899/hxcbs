package chinaPress.common.util;

import chinaPress.common.result.model.Result;

public class ResultUtil {
	/**
	 * 成功无返回数据
	 * 
	 * @return
	 */
	public static Result ok() {
		Result result = new Result();
		result.setCode(1);
		result.setMsg("ok");
		return result;
	}

	/**
	 * 成功带返回数据
	 * 
	 * @param data
	 * @return
	 */
	public static Result ok(Object data) {
		Result result = new Result();
		result.setCode(1);
		result.setMsg("ok");
		result.setData(data);
		return result;
	}

	/**
	 * 失败无返回数据
	 * 
	 * @return
	 */
	public static Result error() {
		Result result = new Result();
		result.setCode(0);
		result.setMsg("error");
		return result;
	}

	/**
	 * 失败带返回数据
	 * 
	 * @param data
	 * @return
	 */
	public static Result error(Object data) {
		Result result = new Result();
		result.setCode(0);
		result.setMsg("error");
		result.setData(data);
		return result;
	}

	/**
	 * 自定义返回结果
	 * 
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	public static Result custom(Integer code, String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}

	/**
	 * 自定义返回结果
	 * 
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	public static Result custom(Integer code, String msg, Object data) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
}
