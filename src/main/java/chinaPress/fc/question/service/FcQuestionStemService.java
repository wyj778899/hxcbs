package chinaPress.fc.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.question.dao.FcQuestionOptionMapper;
import chinaPress.fc.question.dao.FcQuestionStemMapper;
import chinaPress.fc.question.vo.FcQuestionOptionVo;
import chinaPress.fc.question.vo.FcQuestionStemListVo;

@Service
public class FcQuestionStemService {
	
	@Autowired
	private FcQuestionStemMapper fcQuestionStemMapper;
	@Autowired
	private FcQuestionOptionMapper fcQuestionOptionMapper;
	
	public List<FcQuestionStemListVo> selectQuestionStemList(Integer courseId,Integer hourId,Integer type){
		List<FcQuestionStemListVo> data = fcQuestionStemMapper.selectQuestionStemList(courseId, hourId,type);
		if(data.size()>0) {
			for (FcQuestionStemListVo item : data) {
				List<FcQuestionOptionVo> optionList = fcQuestionOptionMapper.selectByStemId(item.getId());
				if(optionList.size()>0) {
					item.setOptionList(optionList);
				}
			}
		}
		return data;
	}

}
