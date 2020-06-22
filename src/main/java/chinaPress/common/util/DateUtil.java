package chinaPress.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 格式化日期
	 * 
	 * @author maguoliang
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	/**
	 * 日期转换
	 * 
	 * @author maguoliang
	 * @param date
	 * @param foramt
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String date, String foramt) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(foramt);
		return simpleDateFormat.parse(date);
	}
}
