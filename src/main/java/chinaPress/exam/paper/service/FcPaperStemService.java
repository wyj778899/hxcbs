package chinaPress.exam.paper.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.exam.paper.dao.FcPaperMapper;
import chinaPress.exam.paper.dao.FcPaperStemMapper;
import chinaPress.exam.paper.model.FcPaper;
import chinaPress.fc.question.dao.FcQuestionStemMapper;
import chinaPress.fc.question.model.FcQuestionStem;


@Service
public class FcPaperStemService {

	/**
	 * 试卷试题关联dao
	 */
	@Autowired
	private FcPaperStemMapper fcPaperStemMapper;
	
	
	/**
	 * 试卷dao
	 */
	@Autowired
	private FcPaperMapper fcPaperMapper;
	
	
	@Autowired
	private FcQuestionStemMapper fcQuestionStemMapper;
	
	
	/**
	 * 添加试卷
	 * @param fcPaper
	 * @return
	 */
	@Transactional
	public Result addPaper(FcPaper fcPaper) {
		//试卷名称
		String paperName = fcPaper.getPaperName();
		if(StringUtils.isAllBlank(paperName)) {
			return new Result(0,"试卷名称不能为空","");
		}
		try {
			//查询所有试题信息
			//List<FcQuestionStem> fcQuestionStems = fcQuestionStemMapper.selectQuestionAll();
			
			if(fcPaperMapper.selectByPaperName(null, paperName)>0) {
				return new Result(0,"试卷名称不可重复","");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
		return null;
	}
	
	/**
	 * 随机抽取试题
	 * @param list            所有试题
	 * @param catalogId       试题分类 
	 * @param taskDifficulty  试题难度 1.简单2.一般3.困难
	 * @param questionType    试题类型 1.单选2.多选3.判断
	 * @param count           个数
	 * @return
	 */
	 private List<FcQuestionStem> getRandomQuestion(List<FcQuestionStem> list,Integer catalogId,Integer taskDifficulty,Integer questionType,Integer count){
	        return null;
	    }
}
