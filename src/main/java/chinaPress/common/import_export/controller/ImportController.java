package chinaPress.common.import_export.controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ExcelUtil;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.apply.vo.FcApplyPersonParam;

@RequestMapping("import")
@RestController
public class ImportController {

	/**
	 * 导入机构学员读取信息
	 * 
	 * @param request
	 * @param excelFile
	 * @return
	 */
	@RequestMapping("institutionsStudents")
	public Result institutionsStudents(HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile multipartFile) {
		String fileName = multipartFile.getOriginalFilename();
		File file = new File(fileName);
		String fname = file.getName();
		String prefix = fname.substring(fname.lastIndexOf(".") + 1);
		// 数据集
		List<FcApplyPersonParam> data = new ArrayList<>();
		if (prefix.equals("xlsx")) {
			try {
				InputStream is = multipartFile.getInputStream();
				@SuppressWarnings("resource")
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

				for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
					xssfSheet = xssfWorkbook.getSheetAt(numSheet);
					if (xssfSheet == null) {
						continue;
					}

					for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
						XSSFRow xssfRow = xssfSheet.getRow(rowNum);
						if (xssfRow != null) {
							FcApplyPersonParam model = new FcApplyPersonParam();
							// 姓名
							model.setName(ExcelUtil.formatCell4(xssfRow.getCell(0)));
							// 性别
							String sex = ExcelUtil.formatCell6(xssfRow.getCell(1));
							if (sex != null && !sex.trim().equals("")) {
								model.setSex(Integer.parseInt(sex));
							} else {
								model.setSex(1);
							}
							model.setCertificateNumber(ExcelUtil.formatCell4(xssfRow.getCell(2)));
							model.setTellPhone(ExcelUtil.formatCell4(xssfRow.getCell(3)));
							model.setAddress(ExcelUtil.formatCell4(xssfRow.getCell(4)));
							data.add(model);
						}
					}

				}
			} catch (Exception e) {
				return ResultUtil.custom(-1, "模板导入异常，请检查档案模板");
			}
			return ResultUtil.ok(data);
		} else {
			return ResultUtil.custom(-1, "模版格式不正确");
		}
	}
}
