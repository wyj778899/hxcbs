package chinaPress.fc.question.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import chinaPress.common.result.model.Result;
import chinaPress.fc.question.service.FcQuestionStemImportService;

@Controller
public class FcQuestionStemImportController {
	@Autowired
	private FcQuestionStemImportService fcQuestionStemImportService;
	
	/**
	 * 试题批量导入
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping("/stemDataImport")
	@ResponseBody
	public Result stemDataImport(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		Result result = null;
		if (file == null) {
			return new Result(-1, "文件不存在", "");
		}
		String name = file.getOriginalFilename();
		if (name.indexOf(".xlsx") == -1) {
			return new Result(-1, "请上传.xlsx结尾的文件", "");
		}
		try {
			InputStream in = file.getInputStream();
			XSSFWorkbook wb = new XSSFWorkbook(in);
			result = fcQuestionStemImportService.questionStemDataImport(wb);
			wb.close();
			in.close();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return new Result(-1, "上传失败", "");
		}
	}
}
