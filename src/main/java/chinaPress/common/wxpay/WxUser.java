package chinaPress.common.wxpay;

public class WxUser {
	private String access_token;
	private Integer expires_in;
	private String refresh_token;
	private String openid;
	private String scope;

	/**
	 * 获取：access_token
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * 设置：access_token
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * 获取：expires_in
	 */
	public Integer getExpires_in() {
		return expires_in;
	}

	/**
	 * 设置：expires_in
	 */
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * 获取：refresh_token
	 */
	public String getRefresh_token() {
		return refresh_token;
	}

	/**
	 * 设置：refresh_token
	 */
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	/**
	 * 获取：openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 设置：openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * 获取：scope
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * 设置：scope
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
}
