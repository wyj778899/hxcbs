package chinaPress.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class ValidateUtil {
	// 用户名
	public static boolean isUser(String string) {
		Pattern pattern = Pattern.compile("^([0-9A-Za-z]{4,18})\\@([0-9A-Za-z]{4,6})$");
		return pattern.matcher(string).matches();
	}

	// 字母、数字组合
	public static boolean isLetterOrDigits(String string) {
		boolean flag = false;
		for (int i = 0; i < string.length(); i++) {
			if (Character.isLowerCase(string.charAt(i)) || Character.isUpperCase(string.charAt(i))
					|| Character.isDigit(string.charAt(i))) {
				flag = true;
			} else {
				flag = false;
				return flag;
			}
		}
		return flag;

	}

	// 手机号码
	public static boolean isMobileNO(String mobileNums) {
		String telRegex = "^((1[0-9]))\\d{9}$";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
		if (StringUtils.isBlank(mobileNums))
			return false;
		else
			return mobileNums.matches(telRegex);
	}

	public static final int IDENTITYCODE_OLD = 15; // 老身份证15位
	public static final int IDENTITYCODE_NEW = 18; // 新身份证18位
	public static int[] Wi = new int[17];

	/**
	 * 判断身份证号码是否正确。
	 *
	 * @param code 身份证号码。
	 * @return 如果身份证号码正确，则返回true，否则返回false。
	 */
	public static boolean isIdentityCode(String code) {

		if (StringUtils.isEmpty(code)) {
			return false;
		}

		code = code.trim().toUpperCase();

		// 长度只有15和18两种情况
		if ((code.length() != IDENTITYCODE_OLD) && (code.length() != IDENTITYCODE_NEW)) {
			return false;
		}

		// 身份证号码必须为数字(18位的新身份证最后一位可以是x)
		Pattern pt = Pattern.compile("(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)");
		Matcher mt = pt.matcher(code);
		if (!mt.find()) {
			return false;
		}
		return true;
	}

	// 邮箱
	public static boolean isEmail(String string) {
		if (string == null)
			return false;
		String regEx1 = "^[a-z0-9._%-]+@([a-z0-9-]+\\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\\d{9}$";
		Pattern p;
		Matcher m;
		p = Pattern.compile(regEx1);
		m = p.matcher(string);
		if (m.matches())
			return true;
		else
			return false;
	}

	// 正整数
	public static boolean isNumeric(String string) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(string).matches();
	}

	/**
	 * 请输入2-8位之间的字符(非纯数字)
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isAbbreviation(String string) {
		Pattern pattern = Pattern.compile("^(?![0-9]+$)(.{2,8})$");
		return pattern.matcher(string).matches();
	}
}
