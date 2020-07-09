package chinaPress.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

	/**
	 * 查询今天是周几
	 * 
	 * @return 1.周一 2.周二 以此类推
	 */
	public static int getTodayWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		if (weekday == 1) {
			weekday = 7;
		} else {
			weekday--;
		}
		return weekday;
	}

	/**
	 * 计算两个日期差
	 * 
	 * @param endDate
	 * @param nowDate
	 * @return
	 */
	public static String getDatePoor(Date endDate, Date nowDate) {
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		long nm = 1000 * 60;
		// long ns = 1000;
		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - nowDate.getTime();
		// 计算差多少天
		long day = diff / nd;
		// 计算差多少小时
		long hour = diff % nd / nh;
		// 计算差多少分钟
		long min = diff % nd % nh / nm;
		// 计算差多少秒//输出结果
		// long sec = diff % nd % nh % nm / ns;
		return day + "天" + hour + "小时" + min + "分钟";
	}

	/**
	 * 分钟转换为时分
	 * 
	 * @param minute
	 * @return
	 */
	public static String minuteToHoursMinute(String minute) {
		String ss = "";
		Integer minutes = Integer.parseInt(minute);
		if (minutes < 60) {
			ss = minute.concat("分");
		} else {
			if (minutes % 60 == 0) {
				Integer hours = minutes / 60;
				ss = hours.toString().concat("时");
			} else {
				Integer hours = minutes / 60;
				Integer hoursMinute = minutes % 60;
				ss = hours.toString().concat("时").concat(hoursMinute.toString()).concat("分");
			}
		}
		return ss;
	}

	/**
	 * 计算日期之间的分钟数差
	 * 
	 * @param endDate
	 * @param nowDate
	 * @return
	 */
	public static long getDatePoorMinute(Date sDate, Date eDate, int diffType) {
		java.util.Calendar calst = java.util.Calendar.getInstance();
		java.util.Calendar caled = java.util.Calendar.getInstance();

		calst.setTime(sDate);
		caled.setTime(eDate);

		long diffMill = caled.getTime().getTime() - calst.getTime().getTime();
		long rtn = 0;
		switch (diffType) {
		case Calendar.MILLISECOND:
			rtn = diffMill;
			break;
		case Calendar.SECOND:
			rtn = diffMill / 1000;
			break;
		case Calendar.MINUTE:
			rtn = diffMill / 1000 / 60;
			break;
		case Calendar.HOUR:
			rtn = diffMill / 1000 / 3600;
			break;
		case Calendar.DATE:
			rtn = diffMill / 1000 / 60 / 60 / 24;
			break;
		case Calendar.MONTH:
			rtn = diffMill / 1000 / 60 / 60 / 24 / 12;
			break;
		case Calendar.YEAR:
			rtn = diffMill / 1000 / 60 / 60 / 24 / 365;
			break;
		}
		return rtn;
	}

	/**
	 * 获取前一天
	 * 
	 * @return
	 */
	public static String getYesterday(Date date, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		Date time = calendar.getTime();
		return formatDate(time, format);
	}

	/**
	 * 获取后一天
	 * 
	 * @return
	 */
	public static String getTomorrow(Date date, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		Date time = calendar.getTime();
		return formatDate(time, format);
	}

	/**
	 * 获取指定日期的月的第一天
	 * 
	 * @param date   指定日期
	 * @param format 格式
	 * @return
	 */
	public static String getFirstDate(Date date, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, 0);
		return formatDate(calendar.getTime(), format);
	}

	/**
	 * 获取指定日期的月的最后一天
	 * 
	 * @param date   指定日期
	 * @param format 格式
	 * @return
	 */
	public static String getLastDate(Date date, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, getDateMonthDay(date));
		calendar.add(Calendar.MONTH, 0);
		return formatDate(calendar.getTime(), format);
	}

	/**
	 * 判断指定两个日期是否年月相同
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameYearMonth(Date date1, Date date2) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		boolean isSameYear = calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR);
		boolean isSameMonth = calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
		if (isSameYear && isSameMonth) {
			return true;
		}
		return false;
	}

	/**
	 * 判断指定两个日期是否年月日相同
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameYearMonthDate(Date date1, Date date2) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		boolean isSameYear = calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR);
		boolean isSameMonth = calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
		boolean isSameDay = calendar1.get(Calendar.DATE) == calendar2.get(Calendar.DATE);
		if (isSameYear && isSameMonth && isSameDay) {
			return true;
		}
		return false;
	}

	/**
	 * 获取指定日期月的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDateMonthDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);
		int maxDate = calendar.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 计算指定两个日期的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getLongOfTwoDate(Date date1, Date date2) {
		int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
		return days;
	}

	/**
	 * 比较两个日期之间的大小 d1 > d2 返回true，否则返回false
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean compareDate(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);

		int result = c1.compareTo(c2);
		if (result >= 0)
			return true;
		else
			return false;
	}

	/**
	 * 获取指定日期的年月日周
	 * 
	 * @param date
	 * @param type 1.年 2.月 3.日
	 * @return
	 */
	public static int getYearMonthDayWeek(Date date, int type) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		if (type == 1) {
			int year = ca.get(Calendar.YEAR);// 年份数值
			return year;
		}
		if (type == 2) {
			int month = ca.get(Calendar.MONTH) + 1;// 第几个月
			return month;
		}
		if (type == 3) {
			int day = ca.get(Calendar.DATE);// 日
			return day;
		}
		return -1;
	}

	/**
	 * 获取某年某月每一周所对应的是哪几天
	 * 
	 * @return
	 */
	public static List<String> getYearMonthWeek(String text) {
		// Java8 LocalDate
		LocalDate date = LocalDate.parse(text);

		// 该月第一天
		LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());
		// 该月最后一天
		LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
		// 该月的第一个周一
		LocalDate start = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

		List<String> list = new ArrayList<>();

		// 处理每个月的1号不是周一的情况
		if (!firstDay.equals(start)) {
			StringBuilder strbur = new StringBuilder();
			strbur.append(firstDay.toString()).append("至").append(start.plusDays(-1).toString());
			list.add(strbur.toString());
		}

//	    Date1.after(Date2),当Date1大于Date2时，返回TRUE，当小于等于时，返回false； 
//	    Date1.before(Date2)，当Date1小于Date2时，返回TRUE，当大于等于时，返回false； 
//		如果业务数据存在相等的时候，而且相等时也需要做相应的业务判断或处理时，请注意。 
//	            如果有这样的需求，在某个日期内的业务check，那么你需要使用：！Date1.after(Date2)

		while (!lastDay.isBefore(start)) {
			StringBuilder strbur = new StringBuilder();
			strbur.append(start.toString());

			LocalDate temp = start.plusDays(6);
			if (temp.isBefore(lastDay)) {
				strbur.append("至").append(temp.toString());
			} else {
				strbur.append("至").append(lastDay.toString());
			}

			list.add(strbur.toString());
			start = start.plusWeeks(1);
		}
		return list;
	}
}
