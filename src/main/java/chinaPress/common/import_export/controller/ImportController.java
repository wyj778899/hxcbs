package chinaPress.common.import_export.controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import chinaPress.common.import_export.service.ImportService;
import chinaPress.common.result.model.Result;
import chinaPress.common.util.ExcelUtil;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.apply.vo.FcApplyPersonParam;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.service.FcOrderService;
import chinaPress.role.member.model.MemberInfo;
import chinaPress.role.member.service.MemberInfoService;

@RequestMapping("import")
@RestController
public class ImportController {

	@Autowired
	private ImportService importService;

	@Autowired
	private MemberInfoService memberInfoService;

	@Autowired
	private FcOrderService fcOrderService;

	/**
	 * 导入机构学员读取信息
	 * 
	 * @param request
	 * @param excelFile
	 * @return
	 */
	@RequestMapping("institutionsStudents")
	public Result institutionsStudents(HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile multipartFile, Integer courseId) {
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
			// 机构名称
			String name = "";
			// 申请数量
			Integer applyNumber = 0;
			// 错误信息
			String errorMsg = "";
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
//						if (!isAllRowEmpty(xssfRow, xssfSheet.getRow(0))) {
						if (xssfRow != null) {
							// 报名机构信息
							if (rowNum < 4) {
								// 机构名称
								if (rowNum == 1) {
									if (StringUtils.isBlank(ExcelUtil.formatCell4(xssfRow.getCell(4)))) {
										errorMsg += "机构名称不能为空；";
									} else {
										name = ExcelUtil.formatCell4(xssfRow.getCell(4));
									}
								}
								// 机构教师总人数，申请报名总人数
								if (rowNum == 2) {
									if (StringUtils.isBlank(ExcelUtil.formatCell6(xssfRow.getCell(4)))) {
										errorMsg += "机构教师总人数不能为空；";
									} else {
										teacherNumber = Integer.parseInt(ExcelUtil.formatCell6(xssfRow.getCell(4)));
									}
									if (StringUtils.isBlank(ExcelUtil.formatCell6(xssfRow.getCell(8)))) {
										errorMsg += "申请报名总人数不能为空；";
									} else {
										applyNumber = Integer.parseInt(ExcelUtil.formatCell6(xssfRow.getCell(8)));
									}
								}
							}
							if (rowNum >= 4) {
								FcApplyPersonParam model = new FcApplyPersonParam();
								model.setErrorType(0);
								// 姓名
								if (StringUtils.isBlank(ExcelUtil.formatCell4(xssfRow.getCell(0)))) {
									errorMsg += "第"+(rowNum+1)+"行姓名不能为空；";
								} else {
									model.setName(ExcelUtil.formatCell4(xssfRow.getCell(0)));
								}
								
								// 性别
								if (StringUtils.isBlank(ExcelUtil.formatCell6(xssfRow.getCell(1)))) {
									errorMsg += "第"+(rowNum+1)+"行性别不能为空；";
								} else {
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
								}
								// 年龄
								if (StringUtils.isBlank(ExcelUtil.formatCell6(xssfRow.getCell(2)))) {
									errorMsg += "第"+(rowNum+1)+"行年龄不能为空；";
								} else {
									model.setAge(Integer.parseInt(ExcelUtil.formatCell6(xssfRow.getCell(2))));
								}

								// 学历
								if (StringUtils.isBlank(ExcelUtil.formatCell4(xssfRow.getCell(3)))) {
									errorMsg += "第"+(rowNum+1)+"行学历不能为空；";
								} else {
									model.setEducation(ExcelUtil.formatCell4(xssfRow.getCell(3)));
								}

								// 身份账号
								if (StringUtils.isBlank(ExcelUtil.formatCell6(xssfRow.getCell(4)))) {
									errorMsg += "第"+(rowNum+1)+"行身份证号不能为空；";
								} else {
									model.setCertificateNumber(ExcelUtil.formatCell6(xssfRow.getCell(4)));
								}

								// 手机号
								if (StringUtils.isBlank(ExcelUtil.formatCell6(xssfRow.getCell(5)))) {
									errorMsg += "第"+(rowNum+1)+"行手机号不能为空；";
								} else {
									String tellPhone = ExcelUtil.formatCell6(xssfRow.getCell(5));
									MemberInfo memberParam = new MemberInfo();
									memberParam.setTellPhone(tellPhone);
									MemberInfo memberInfo = memberInfoService.selectByPrimaryKey(memberParam);
									// 当前报名的手机号存在了
									if (memberInfo != null) {
										if (memberInfo.getRoleType().intValue() == 2) {
											model.setErrorType(2);
										}
										if (memberInfo.getRoleType().intValue() == 5) {
											model.setErrorType(3);
										}
										if (memberInfo.getRoleType().intValue() == 3
												|| memberInfo.getRoleType().intValue() == 4) {
											// 判断该手机号用户是否正在学习该课程中
											FcOrder fcOrder = fcOrderService.selectCourseIsLearning(memberInfo.getRoleId(),
													memberInfo.getRoleType(), courseId);
											if (fcOrder != null) {
												model.setErrorType(1);
											}
										}
									}
									if (tellPhone != null && !tellPhone.equals("")) {
										teacherNumber += memberInfoService.findPractitionerByTellPhone(tellPhone.trim());
									}
									model.setTellPhone(tellPhone);
								}
								// 岗位
								if (StringUtils.isBlank(ExcelUtil.formatCell4(xssfRow.getCell(6)))) {
									errorMsg += "第"+(rowNum+1)+"行岗位不能为空；";
								} else {
									model.setPost(ExcelUtil.formatCell4(xssfRow.getCell(6)));
								}

								// 工作年限
								if (StringUtils.isBlank(ExcelUtil.formatCell6(xssfRow.getCell(7)))) {
									errorMsg += "第"+(rowNum+1)+"行工作年限不能为空；";
								} else {
									String workYear = ExcelUtil.formatCell6(xssfRow.getCell(7));
									if (workYear != null && !workYear.trim().equals("")) {
										model.setWorkYear(Integer.parseInt(workYear));
									} else {
										model.setWorkYear(0);
									}
								}
								// 户籍所在省市
								if (StringUtils.isBlank(ExcelUtil.formatCell4(xssfRow.getCell(8)))) {
									errorMsg += "第"+(rowNum+1)+"行户籍所在省市不能为空；";
								} else {
									model.setCensusAddress(ExcelUtil.formatCell4(xssfRow.getCell(8)));
								}
								// 工作所在详细地址
								if (StringUtils.isBlank(ExcelUtil.formatCell4(xssfRow.getCell(9)))) {
									errorMsg += "第"+(rowNum+1)+"行工作所在详细地址不能为空；";
								} else {
									model.setInstitutionAddress(ExcelUtil.formatCell4(xssfRow.getCell(9)));
								}
								data.add(model);
							}
						}
					}
				}
			} catch (Exception e) {
				return ResultUtil.custom(-1, "模板导入异常，请检查档案模板");
			}
			if (errorMsg != "") {
				return ResultUtil.custom(-2, errorMsg);
			} else {
				// 机构名称
				resultMap.put("institutionName", name);
				// 老师数量
				resultMap.put("teacherNumber", teacherNumber);
				// 申请数量
				resultMap.put("applyNumber", applyNumber);
				resultMap.put("data", data);
				return ResultUtil.ok(resultMap);
			}
		} else {
			return ResultUtil.custom(0, "模版格式不正确，请下载导入模板");
		}
	}

	/**
	 * 判断行为空
	 * 
	 * @author maguoliang
	 * @param row
	 * @param firstRow
	 * @return
	 */
	private boolean isAllRowEmpty(XSSFRow row, XSSFRow firstRow) {
		int count = 0;
		// 单元格数量
		int rowCount = firstRow.getLastCellNum() - firstRow.getFirstCellNum();
		// 判断多少个单元格为空
		for (int c = 0; c < rowCount; c++) {
			Cell cell = row.getCell(c);
			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				count += 1;
			}
		}

		if (count == rowCount) {
			return true;
		}

		return false;
	}

	@GetMapping("importExcel")
	public Result importExcel(String path) {
		return importService.importExcel(path);
	}
}
