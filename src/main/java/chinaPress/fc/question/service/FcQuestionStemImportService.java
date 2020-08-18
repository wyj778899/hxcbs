package chinaPress.fc.question.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ExcelUtil;
import chinaPress.fc.course.dao.FcCourseArchivesMapper;
import chinaPress.fc.course.vo.CourseArchivesInfo;
import chinaPress.fc.course_section.dao.FcCourseSectionMapper;
import chinaPress.fc.course_section.vo.FcSectionHourInfo;
import chinaPress.fc.question.dao.FcQuestionCatalogMapper;
import chinaPress.fc.question.dao.FcQuestionOptionMapper;
import chinaPress.fc.question.dao.FcQuestionStemMapper;
import chinaPress.fc.question.model.FcQuestionOption;
import chinaPress.fc.question.model.FcQuestionStem;
import chinaPress.fc.question.vo.FcQuestionCatalogVo;

/**
 * 试题导入
 * @author wyj
 *
 */
@Service
public class FcQuestionStemImportService {

	
	/**
	 * 课程dao
	 */
	@Autowired
	private FcCourseArchivesMapper fcCourseArchivesMapper;
	
	/**
	 * 章节dao
	 */
	@Autowired
	private FcCourseSectionMapper fcCourseSectionMapper;
	
	/**
	 * 试题分类dao
	 */
	@Autowired
	private FcQuestionCatalogMapper fcQuestionCatalogMapper;
	
	/**
	 * 试题dao
	 */
	@Autowired
	private FcQuestionStemMapper fcQuestionStemMapper;
	
	/**
	 * 试题答案dao
	 */
	@Autowired
	private FcQuestionOptionMapper fcQuestionOptionMapper;
	
	/**
	 * 试题批量导入信息
	 * @param workbook
	 * @return
	 */
	@Transactional
	public Result questionStemDataImport(XSSFWorkbook workbook){
		//所有有效课程信息
		List<CourseArchivesInfo> courseArchives = fcCourseArchivesMapper.selectCourseArchivesAll();
		
		//所有课时和章节信息
		List<FcSectionHourInfo> sectionAndHours = fcCourseSectionMapper.selectSectionAndHourAll();
		
		//所有试题分类信息
		List<FcQuestionCatalogVo> questionCatalogs = fcQuestionCatalogMapper.selectAll();
		
		//所有试题名称信息
		List<String> questionStemNames = fcQuestionStemMapper.selectQuestionStemNameAll();
		
		// 成功信息
		StringBuffer sbOk = new StringBuffer();
		// 错误信息
		StringBuffer sb = new StringBuffer();
		// 工作表
		XSSFSheet sheet = null;
		// 行信息
		XSSFRow row = null;
		// 返回信息
		String result = "";
		//获取第一个工作表
		sheet = workbook.getSheetAt(0);
		//第一行
		int firstRowNum = sheet.getFirstRowNum();
		//最后一行
		int lastRowNum = sheet.getLastRowNum();
		// 获取表格每行的信息 第一行是标题，从第二行开始循环
		for (int j = firstRowNum + 1; j <= lastRowNum; j++) {
			row = sheet.getRow(j);
			//试题对象
			FcQuestionStem stem = new FcQuestionStem();
			//试题名称
			String name = ExcelUtil.formatCell4(row.getCell(0)).trim();
			if(name !=null && name!="") {
				//判断试题名称是否存在集合中
				if(questionStemNames.stream().filter(s->s.toString().equals(name)).count()>0) {
					sb.append("第" + (j + 1) + "行信息出错：试题名称已存在,");
					//一条不符合则跳出本次循环
					continue;
				}else {
					//赋值试题名称
					stem.setQuestionStem(name);
				}
			}else {
				sb.append("第" + (j + 1) + "行信息出错：请填写试题名称信息,");
				continue;
			}
			//试题难度
			String taskDifficulty = ExcelUtil.formatCell4(row.getCell(1)).trim();
			if(taskDifficulty !=null && taskDifficulty!="") {
				if("简单".equals(taskDifficulty)) {
					stem.setTaskDifficulty(1);
				}else if("一般".equals(taskDifficulty)) {
					stem.setTaskDifficulty(2);
				}else if("困难".equals(taskDifficulty)) {
					stem.setTaskDifficulty(3);
				}else {
					sb.append("第" + (j + 1) + "行信息出错：试题难度信息填写有误,");
					continue;
				}
			}else {
				sb.append("第" + (j + 1) + "行信息出错：请填写试题难度信息,");
				continue;
			}
			//分数
			String grade = ExcelUtil.formatCell4(row.getCell(2)).trim();
			if(grade !=null && grade!="") {
				stem.setGrade(grade);
			}else {
				sb.append("第" + (j + 1) + "行信息出错：请填写试题分数信息,");
				continue;
			}
			//试题类型
			String questionType = ExcelUtil.formatCell4(row.getCell(3)).trim();
			if(questionType!=null && questionType!="") {
				if("单选".equals(questionType)) {
					stem.setQuestionType(1);
				}else if("多选".equals(questionType)) {
					stem.setQuestionType(2);
				}else if("判断".equals(questionType)) {
					stem.setQuestionType(3);
				}else {
					sb.append("第" + (j + 1) + "行信息出错：试题类型信息填写有误,");
					continue;
				}
			}else {
				sb.append("第" + (j + 1) + "行信息出错：请填写试题类型信息,");
				continue;
			}
			//试题类别
			String type = ExcelUtil.formatCell4(row.getCell(4)).trim();
			if(type!=null && type!="") {
				if("小结".equals(type)) {
					stem.setType(1);
				}else if("自测".equals(type)) {
					stem.setType(2);
				}else if("考试".equals(type)) {
					stem.setType(3);
				}else {
					sb.append("第" + (j + 1) + "行信息出错：试题类别信息填写有误,");
					continue;
				}
			}else {
				sb.append("第" + (j + 1) + "行信息出错：请填写试题类别信息,");
				continue;
			}
			//关联课程
			String course = ExcelUtil.formatCell4(row.getCell(5)).trim();
			if(course!=null && course!="") {
				//获取集合中名称相同的数据
				List<CourseArchivesInfo> list = courseArchives.stream().filter(c->c.getName().equals(course)).collect(Collectors.toList());
				if(list.size()>0) {
					//转成list对象取第一个对象的id值
					stem.setCourseId(list.get(0).getId());
				}else {
					sb.append("第" + (j + 1) + "行信息出错：关联课程信息填写有误,");
					continue;
				}
			}else {
				sb.append("第" + (j + 1) + "行信息出错：请填写关联课程信息,");
				continue;
			}
			//关联课时     课时和章节是1对1的   这里取章节信息
			String hour = ExcelUtil.formatCell4(row.getCell(6)).trim();
			if(hour!=null && hour!="") {
				//获取集合中名称相同的数据
				List<FcSectionHourInfo> list = sectionAndHours.stream().filter(h->h.getName().equals(hour)).collect(Collectors.toList());
				if(list.size()>0) {
					//转成list对象取第一个对象的id值
					stem.setCourseId(list.get(0).getId());
				}else {
					sb.append("第" + (j + 1) + "行信息出错：关联课时信息填写有误,");
					continue;
				}
			}else {
				sb.append("第" + (j + 1) + "行信息出错：请填写关联课时信息,");
				continue;
			}
			//试题分类
			String catalog = ExcelUtil.formatCell4(row.getCell(7)).trim();
			if(catalog!=null && catalog!="") {
				//获取集合中名称相同的数据
				List<FcQuestionCatalogVo> list = questionCatalogs.stream().filter(l->l.getName().equals(catalog)).collect(Collectors.toList());
				if(list.size()>0) {
					//转成list对象取第一个对象的id值
					stem.setCourseId(list.get(0).getId());
				}else {
					sb.append("第" + (j + 1) + "行信息出错：试题分类信息填写有误,");
					continue;
				}
			}else {
				sb.append("第" + (j + 1) + "行信息出错：请填写试题分类信息,");
				continue;
			}
			//试题解析
			String analysis = ExcelUtil.formatCell4(row.getCell(8)).trim();
			if(analysis!=null && analysis!="") {
				stem.setAnalysis(analysis);
			}
			//选项A
			String optionA = ExcelUtil.formatCell4(row.getCell(9)).trim();
			//选项B
			String optionB = ExcelUtil.formatCell4(row.getCell(10)).trim();
			//选项C
			String optionC = ExcelUtil.formatCell4(row.getCell(11)).trim();
			//选项D
			String optionD = ExcelUtil.formatCell4(row.getCell(12)).trim();
			//正确答案
			String answer = ExcelUtil.formatCell4(row.getCell(13)).trim();
			if(StringUtils.isBlank(answer)) {
				sb.append("第" + (j + 1) + "行信息出错：请填写正确答案信息,");
				continue;
			}
			//校验答案信息和正确答案
			Map<String,Object> map= checkaAnswer(questionType,answer,optionA,optionB,optionC,optionD);
			if(map.get("error")!=null){
				sb.append("第" + (j + 1) + "行信息出错："+map.get("error"));
				continue;
			}
			List<FcQuestionOption> options= (List<FcQuestionOption>) map.get("ok");
			
			//执行试题添加操作
			fcQuestionStemMapper.insertSelective(stem);
			for(FcQuestionOption f:options) {
				f.setStemId(stem.getId());
				fcQuestionOptionMapper.insertSelective(f);
			}
			sbOk.append((j+1)+",");
		}
		if (sbOk.length() > 0) {
			result += "成功行号信息：" + sbOk.substring(0, sbOk.length() - 1) + ";";
		}
		if (sb.length() > 0) {
			result += "失败行号信息：" + sb.substring(0, sb.length() - 1);
		}
		if (sbOk.length() == 0 && sb.length() == 0) {
			return new Result(-1, "文件格式不正确", "");
		} else {
			return new Result(0, result, "");
		}
	}
	
	/**
	 * 
	 * @param questionType     试题类型，单选，多选，判断
	 * @param answer           正确答案
	 * @param optionA          答案1
	 * @param optionB          答案2
	 * @param optionC          答案3
	 * @param optionD          答案4
	 * @return
	 */
	public Map<String,Object> checkaAnswer(String questionType,String answer,String optionA,String optionB,String optionC,String optionD) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		//通过试题类型校验试题答案信息，如果是单选题有多个答案代表此行信息出错
		if("单选".equals(questionType) && answer.length()>1) {
			map.put("error","单选题正确答案信息填写有误:单选题只能有一个正确答案,");
			return map;
		}else if("多选".equals(questionType) && answer.length()<2) {
			map.put("error","多选题正确答案信息填写有误:多选题至少有两个正确答案,");
			return map;
		}else if("判断".equals(questionType) && answer.length()>1) {
			map.put("error","判断题正确答案信息填写有误:判断题只能有一个正确答案,");
			return map;
		}
		
		//校验正确答案信息是否符合填写规则
		char []c = answer.toCharArray();
		for(int i=0;i<c.length;i++) {
			if(c[i]!='A' && c[i]!='B' && c[i]!='C' && c[i]!='D') {
				map.put("error","正确答案信息填写有误:请填写ABCD选项,");
				return map;
			}
		}
		if(answer.length()>4) {
			map.put("error","正确答案信息填写有误:正确答案不能超过4个,");
			return map;
		}
		if(answer.length()<1) {
			map.put("error","正确答案信息填写有误:至少有一个正确答案,");
			return map;
		}
		//答案信息个数
		List<FcQuestionOption> options = new ArrayList<FcQuestionOption>();
		//答案标识符
		boolean flagA = false;
		boolean flagB = false;
		boolean flagC = false;
		boolean flagD = false;
		if(!StringUtils.isBlank(optionA)) {
			FcQuestionOption option1 = new FcQuestionOption();
			option1.setOptionType(1);
			option1.setOptionName(optionA);//内容
			if(answer.contains("A")) {
				option1.setIsCorrect(1);
			}else {
				option1.setIsCorrect(0);
			}
			options.add(option1);
			flagA = true;
		}
		if(!StringUtils.isBlank(optionB)) {
			FcQuestionOption option2 = new FcQuestionOption();
			option2.setOptionType(2);
			option2.setOptionName(optionA);//内容
			if(answer.contains("B")) {
				option2.setIsCorrect(1);
			}else {
				option2.setIsCorrect(0);
			}
			options.add(option2);
			flagB = true;
		}
		if(!StringUtils.isBlank(optionC)) {
			FcQuestionOption option3 = new FcQuestionOption();
			option3.setOptionType(3);
			option3.setOptionName(optionA);//内容
			if(answer.contains("C")) {
				option3.setIsCorrect(1);
			}else {
				option3.setIsCorrect(0);
			}
			options.add(option3);
			flagC = true;
		}
		if(!StringUtils.isBlank(optionD)) {
			FcQuestionOption option4 = new FcQuestionOption();
			option4.setOptionType(4);
			option4.setOptionName(optionA);//内容
			if(answer.contains("D")) {
				option4.setIsCorrect(1);
			}else {
				option4.setIsCorrect(0);
			}
			options.add(option4);
			flagD = true;
		}
		//答案信息个数校验
		if(options.size()<2) {
			map.put("error","答案信息填写有误:至少有两个答案信息,");
			return map;
		}
		//正确答案不能大于答案信息的个数
		if(answer.length()>options.size()) {
			map.put("error","答案信息填写有误:答案信息和正确答案信息不匹配,");
			return map;
		}
		//校验正确答案的编号必须有正确答案编号对应的信息
		if(answer.contains("A") && !flagA) {
			map.put("error","答案信息填写有误:答案信息和正确答案信息不匹配,");
			return map;
		}
		if(answer.contains("B") && !flagB) {
			map.put("error","答案信息填写有误:答案信息和正确答案信息不匹配,");
			return map;
		}
		if(answer.contains("C") && !flagC) {
			map.put("error","答案信息填写有误:答案信息和正确答案信息不匹配,");
			return map;
		}
		if(answer.contains("D") && !flagD) {
			map.put("error","答案信息填写有误:答案信息和正确答案信息不匹配,");
			return map;
		}
		map.put("ok", options);
		return map;
	}
}
