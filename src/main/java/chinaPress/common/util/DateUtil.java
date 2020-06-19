package chinaPress.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 格式化日期
	 * @author maguoliang
	 * @param date
	 * @param format
	 * @return
	 */
	public String formatData(Date date, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}
}
