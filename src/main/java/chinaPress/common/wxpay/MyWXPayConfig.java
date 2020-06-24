package chinaPress.common.wxpay;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyWXPayConfig extends WXPayConfig {
	private byte[] certData;

	public MyWXPayConfig() throws IOException {
		String certPath = "";
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		if (os != null && os.toLowerCase().indexOf("linux") > -1) {
			certPath = "/home/ecloud_file/cert/wx_pay/apiclient_cert.p12";
		} else if (os != null && os.toLowerCase().indexOf("windows") > -1) {
			certPath = "c:/ecloud_file/apiclient_cert.p12";
		}
		File file = new File(certPath);
		InputStream certStream = new FileInputStream(file);
		this.certData = new byte[(int) file.length()];
		certStream.read(this.certData);
		certStream.close();
	}

	@Override
	public String getAppID() {
		// TODO Auto-generated method stub
		return "wx59c52a804bbb9a37";
	}

	@Override
	public String getMchID() {
		// TODO Auto-generated method stub
		return "1585598941";
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "639a48d6954fa7242a5413b61718ad98";
	}

	@Override
	InputStream getCertStream() {
		// TODO Auto-generated method stub
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}

	@Override
	IWXPayDomain getWXPayDomain() {
		// TODO Auto-generated method stub
		return WXPayDomainSimpleImpl.instance();
	}

}
