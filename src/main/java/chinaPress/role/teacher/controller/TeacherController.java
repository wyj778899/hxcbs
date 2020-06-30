package chinaPress.role.teacher.controller;

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
import chinaPress.role.teacher.service.RoleTeacherArchivesService;
import chinaPress.role.teacher.vo.TeacherCertificateVo;

@RestController
public class TeacherController {
	
	@Autowired
	private RoleTeacherArchivesService roleTeacherArchivesService;
	
	/**
	 * 证书分数查询
	 * @param request
	 * @param multipartFile
	 * @return
	 */
	@RequestMapping("selectTeacherCertificate")
	public Result selectTeacherCertificate(String name,String idCard,Integer type,Integer certificateType) {
		List<TeacherCertificateVo> data = roleTeacherArchivesService.selectTeacherCertificate(name, idCard, type,certificateType);
		if(data.size()>0) {
			return ResultUtil.custom(1, "查询成功", data);
		}
		return ResultUtil.custom(-1, "查询失败", data);
	}
	
	@RequestMapping("importTeacher")
	public Result importTeacher(HttpServletRequest request,
			@RequestParam(value = "file", required = false ) MultipartFile multipartFile) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
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
					if (xssfSheet.getLastRowNum() == 0) {
						continue;
					}
					for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
						XSSFRow xssfRow = xssfSheet.getRow(rowNum);
						if (xssfRow != null) {
							FcApplyPersonParam model = new FcApplyPersonParam();
							String typeName = ExcelUtil.formatCell4(xssfRow.getCell(1));
							if(typeName == "单选") {
								
							}else if(typeName == "多选") {
								
							}else if(typeName == "判断") {
								
							}
							data.add(model);
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				return ResultUtil.custom(-1, "模板导入异常，请检查档案模板");
			}
			
			return ResultUtil.custom(1, "导入成功");
		}else {
			return ResultUtil.custom(-1, "模版格式不正确");
		}
	}

}
