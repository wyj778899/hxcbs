package chinaPress.exam.paper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.JacksonUtil;
import chinaPress.exam.paper.model.FcPaper;
import chinaPress.exam.paper.service.FcPaperService;
import chinaPress.exam.paper.vo.PaperVo;
import chinaPress.fc.question.vo.QuestionVo;

/**
 * 试卷信息
 * @author wyj
 *
 */
@RestController
@RequestMapping("/paper")
public class FcPaperContrller {

	@Autowired
	private FcPaperService fcPaperService;
	
	/**
	 * 预览试卷
	 * @param fcPaper
	 * @Param jsonData    试卷关联试题信息
	 * @return
	 */
	@RequestMapping("/previewPaper")
	public Result previewPaper(FcPaper fcPaper,String jsonData) {
		try {
			List<PaperVo> papers = JacksonUtil.fromJSONList(jsonData, PaperVo.class);
			fcPaper.setPapers(papers);
			return fcPaperService.previewPaper(fcPaper);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"试卷关联试题出错","");
		}
	}
	
	/**
	 * 新建试卷
	 * @param fcPaper
	 * @Param jsonData    试卷关联试题信息/已经关联好的试题信息
	 * @param type        直接保存和预览后保存         1有试卷试题关联信息/2有试题信息
	 * @return
	 */
	@RequestMapping("/registerPaper")
	public Result registerPaper(FcPaper fcPaper,String jsonData,Integer type) {
		try {
			//试卷试题关联信息
			if(type!=null && type.intValue() == 1) {
				List<PaperVo> papers = JacksonUtil.fromJSONList(jsonData, PaperVo.class);
				fcPaper.setPapers(papers);
			}else if(type!=null && type.intValue() == 2){//试题信息
				List<QuestionVo> questions = JacksonUtil.fromJSONList(jsonData, QuestionVo.class);
				fcPaper.setQuestions(questions);
			}else {
				return new Result(0,"试卷生成错误","");
			}
			return fcPaperService.addPaper(fcPaper);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"试卷关联试题信息出错","");
		}
	}
	
	/**
	 * 查询试卷信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryByPaperId")
	public Result queryByPaperId(Integer id) {
		return fcPaperService.findById(id);
	}
	
	/**
	 * 
	 * @param fcPaper
	 * @Param jsonData    试卷试题抽取规则信息/已经关联好的试题信息
	 * @param type        直接保存和预览后保存         1(直接保存)有试卷试题抽取关联信息/2(预览后保存)有试题信息
	 * @return
	 */
	@RequestMapping("/modifyPaper")
	public Result modifyPaper(FcPaper fcPaper,String jsonData,Integer type) {
		try {
			//试卷试题关联信息
			if(type!=null && type.intValue() == 1) {
				List<PaperVo> papers = JacksonUtil.fromJSONList(jsonData, PaperVo.class);
				fcPaper.setQuestions(null);//试题置空
				fcPaper.setPapers(papers);
			}else if(type!=null && type.intValue() == 2){//试题信息
				List<QuestionVo> questions = JacksonUtil.fromJSONList(jsonData, QuestionVo.class);
				fcPaper.setQuestions(questions);
			}else {
				return new Result(0,"试卷修改错误","");
			}
			return fcPaperService.setPaper(fcPaper);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"试卷关联试题信息出错","");
		}
	}
	
	
	/**
	 * 删除试卷和试卷试题关联信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/removePaper")
	public Result removePaper(Integer id) {
		return fcPaperService.deletePaper(id);
	}
	
	/**
	 * 试卷信息
	 * @param paperName
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/queryPaperLikeName")
	public Result queryPaperLikeName(String paperName,Integer paperCatalog,Integer page,Integer limit) {
		return fcPaperService.findPaperLikeName(paperName,paperCatalog,(page-1)*limit, limit);
	}
	
	
	/**
	 * 试卷信息个数
	 * @param paperName
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/queryPaperLikeNameCount")
	public Result queryPaperLikeNameCount(String paperName,Integer paperCatalog) {
		return fcPaperService.findPaperLikeNameCount(paperName,paperCatalog);
	}
	
	
	@RequestMapping("/queryByExamId")
	public Result queryByExamId(Integer examId,Integer flag) {
		return fcPaperService.findByExamId(examId, flag);
	}
	
}
