package chinaPress.exam.exam_option.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.common.result.model.Result;
import chinaPress.exam.exam_option.dao.FcExamOptionMapper;
import chinaPress.exam.exam_option.model.FcExamOption;
import chinaPress.fc.question.dao.FcQuestionStemMapper;
import chinaPress.fc.question.vo.FcQuestionAndOption;
import chinaPress.fc.question.vo.QuestionOption;

/**
 * 考试考试答案信息
 * @author wyj
 *
 */
@Service
public class FcExamOptionService {

	
	
	/**
	 * 考生考试dao
	 */
	@Autowired
	private FcExamOptionMapper fcExamOptionMapper;
	
	/**
	 * 试题dao
	 */
	@Autowired
	private FcQuestionStemMapper fcQuestionStemMapper;
	
	/**
	 * 添加考试考生答案信息
	 * @param option
	 * @return
	 */
	public Result addExamOption(FcExamOption option) {
		//试题id
		Integer stemId = option.getStemId();
		//试题答案id
		String optionId = option.getOptionId();
		List<String> asList = Arrays.asList(optionId.split(",")); 
		List<String> answers = new ArrayList<String>();
		try {
			//试题信息
			FcQuestionAndOption question = fcQuestionStemMapper.selectById(stemId);
			if(question!=null) {
				//试题正确答案信息
				for(QuestionOption stem:question.getOptions()) {
					if(stem.getIsCorrect().intValue()==1) {
						answers.add(stem.getoId()+"");
					}
				}
				//校验答案信息
				if(!answers.retainAll(asList)) {
					option.setIsCorrect(1);
				}else {
					option.setIsCorrect(0);
				}
				Integer id = fcExamOptionMapper.selectExamUserInfo(option.getExamId(), option.getPaperId(), stemId, option.getUserId());
				if(id!=null) {
					option.setId(id);
					fcExamOptionMapper.updateByPrimaryKeySelective(option);
				}else {
					fcExamOptionMapper.insertSelective(option);
				}
				return new Result(1,"保存成功","");
			}else {
				return new Result(0,"试题信息出错","");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	
}
