package chinaPress.common.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ExcelUtil {
	// 设置表头列
	public static HSSFCell createCell(List<String> data, HSSFRow row, HSSFCellStyle style) {
		HSSFCell cell = null;
		for (int i = 0; i < data.size(); i++) {
			cell = row.createCell((short) i);
			cell.setCellValue(data.get(i));
			cell.setCellStyle(style);
		}
		return cell;
	}

	public static XSSFCell createXSSFCell(List<String> data, XSSFRow row, XSSFCellStyle style) {
		XSSFCell cell = null;
		for (int i = 0; i < data.size(); i++) {
			cell = row.createCell((short) i);
			cell.setCellValue(data.get(i));
			cell.setCellStyle(style);
		}
		return cell;
	}

	/**
	 * 处理单元格格式的简单方式
	 * 
	 * @param hssfCell
	 * @return
	 */
	public static String formatCell(HSSFCell hssfCell) {
		if (hssfCell == null) {
			return "";
		} else {
			if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(hssfCell.getBooleanCellValue());
			} else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				return String.valueOf(hssfCell.getNumericCellValue());
			} else {
				return String.valueOf(hssfCell.getStringCellValue());
			}
		}
	}

	/**
	 * 处理单元格格式的第二种方式: 包括如何对单元格内容是日期的处理
	 * 
	 * @param cell
	 * @return
	 */
	public static String formatCell2(HSSFCell cell) {
		if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			// 针对单元格式为日期格式
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
			}
			return String.valueOf(cell.getNumericCellValue());
		} else {
			return cell.getStringCellValue();
		}
	}

	/**
	 * 处理单元格格式的第三种方法:比较全面
	 * 
	 * @param xssfCell
	 * @return
	 */
	public static String formatCell3(HSSFCell xssfCell) {
		if (xssfCell == null) {
			return "";
		}
		switch (xssfCell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:

			// 日期格式的处理
			if (HSSFDateUtil.isCellDateFormatted(xssfCell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				return sdf.format(HSSFDateUtil.getJavaDate(xssfCell.getNumericCellValue())).toString();
			}

			return String.valueOf(xssfCell.getNumericCellValue());

		// 字符串
		case HSSFCell.CELL_TYPE_STRING:
			return xssfCell.getStringCellValue();

		// 公式
		case HSSFCell.CELL_TYPE_FORMULA:
			return xssfCell.getCellFormula();

		// 空白
		case HSSFCell.CELL_TYPE_BLANK:
			return "";

		// 布尔取值
		case HSSFCell.CELL_TYPE_BOOLEAN:
			return xssfCell.getBooleanCellValue() + "";

		// 错误类型
		case HSSFCell.CELL_TYPE_ERROR:
			return xssfCell.getErrorCellValue() + "";
		}

		return "";
	}

	/**
	 * 处理单元格格式的第三种方法:比较全面
	 * 
	 * @param xssfCell
	 * @return
	 */
	public static String formatCell4(XSSFCell cell) {
		if (cell == null) {
			return "";
		}
		DecimalFormat df = new DecimalFormat("0");// 格式化 number String
		// 字符
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
		DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字
		switch (cell.getCellType()) {
		case XSSFCell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case XSSFCell.CELL_TYPE_NUMERIC:
			if ("@".equals(cell.getCellStyle().getDataFormatString())) {
				return df.format(cell.getNumericCellValue());
			} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
				return nf.format(cell.getNumericCellValue());
			} else {
				return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
			}
		case XSSFCell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue() + "";

		case XSSFCell.CELL_TYPE_BLANK:
			return "";
		default:
			return cell.toString();
		}
	}

	public static String formatCell5(XSSFCell cell) {
		if (cell == null) {
			return "";
		}
		DecimalFormat df = new DecimalFormat("0");// 格式化 number String
		// 字符
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
		DecimalFormat nf = new DecimalFormat("0");// 格式化数字
		switch (cell.getCellType()) {
		case XSSFCell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case XSSFCell.CELL_TYPE_NUMERIC:
			if ("@".equals(cell.getCellStyle().getDataFormatString())) {
				return df.format(cell.getNumericCellValue());
			} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
				return nf.format(cell.getNumericCellValue());
			} else {
				return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
			}
		case XSSFCell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue() + "";

		case XSSFCell.CELL_TYPE_BLANK:
			return "";
		default:
			return cell.toString();
		}
	}
}
