package chinaPress.common.import_export.controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ExcelUtil;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.apply.vo.FcApplyPersonParam;
import chinaPress.role.member.service.MemberInfoService;

@RequestMapping("import")
@RestController
public class ImportController {
	
	@Autowired
	private MemberInfoService memberInfoService;

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
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String fileName = multipartFile.getOriginalFilename();
		File file = new File(fileName);
		String fname = file.getName();
		String prefix = fname.substring(fname.lastIndexOf(".") + 1);
		// 数据集
		List<FcApplyPersonParam> data = new ArrayList<>();
		if (prefix.equals("xlsx")) {
			// 老师数量
			Integer teacherNumber = 0;
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
					if (xssfSheet.getLastRowNum() == 0) {
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
								if (sex.trim().equals("女")) {
									model.setSex(2);
								} else {
									model.setSex(1);
								}
							} else {
								model.setSex(1);
							}
							// 民族
							model.setEthnic(ExcelUtil.formatCell6(xssfRow.getCell(2)));

							// 学历
							model.setEducation(ExcelUtil.formatCell4(xssfRow.getCell(3)));

							// 身份账号
							model.setCertificateNumber(ExcelUtil.formatCell6(xssfRow.getCell(4)));

							// 手机号
							String tellPhone = ExcelUtil.formatCell6(xssfRow.getCell(5));
							if (tellPhone != null && !tellPhone.equals("")) {
								teacherNumber += memberInfoService.findPractitionerByTellPhone(tellPhone.trim());
							}
							model.setTellPhone(tellPhone);
							// 岗位
							model.setPost(ExcelUtil.formatCell4(xssfRow.getCell(6)));

							// 工作年限
							String workYear = ExcelUtil.formatCell6(xssfRow.getCell(7));
							if (workYear != null && !workYear.trim().equals("")) {
								model.setWorkYear(Integer.parseInt(workYear));
							} else {
								model.setWorkYear(0);
							}
							// 籍贯
							model.setNativePlace(ExcelUtil.formatCell4(xssfRow.getCell(8)));
							// 户籍所在省市
							model.setCensusAddress(ExcelUtil.formatCell4(xssfRow.getCell(9)));
							// 工作所在详细地址
							model.setInstitutionAddress(ExcelUtil.formatCell4(xssfRow.getCell(10)));
							// 邮寄地址
							model.setMailingAddress(ExcelUtil.formatCell4(xssfRow.getCell(11)));
							data.add(model);
						}
					}

				}
			} catch (Exception e) {
				return ResultUtil.custom(-1, "模板导入异常，请检查档案模板");
			}

			// 机构名称
			resultMap.put("institutionName", "机构名称");
			// 老师数量
			resultMap.put("teacherNumber", teacherNumber);
			// 申请数量
			resultMap.put("applyNumber", data.size());
			resultMap.put("data", data);
			return ResultUtil.ok(resultMap);
		} else {
			return ResultUtil.custom(-1, "模版格式不正确");
		}
	}
}
