package chinaPress.common.httpclient;

import java.io.Serializable;

/**
 * 封装httpClient响应结果
 * 
 * @author Chaoqun
 *
 */
public class Result implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 响应状态码
	 */
	private int code;

	/**
	 * 响应数据
	 */
	private String content;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Result() {
		super();
	}

	public Result(int code) {
		super();
		this.code = code;
	}

	public Result(int code, String content) {
		super();
		this.code = code;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", content=" + content + "]";
	}

}
