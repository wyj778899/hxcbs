package chinaPress.fc.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.question.model.FcQuestionStem;
import chinaPress.fc.question.service.FcQuestionStemService;
import chinaPress.fc.question.vo.FcQuestionStemListVo;

@RestController
public class FcQuestionStemController {

	@Autowired
	private FcQuestionStemService fcQuestionStemService;

	/**
	 * 查询课程关联试题/课时关联试题
	 * 
	 * @param courseId
	 * @param hourId
	 * @return
	 */
	@RequestMapping("selectQuestionStemList")
	public Result selectQuestionStemList(Integer courseId, Integer hourId, Integer type) {
		List<FcQuestionStemListVo> data = fcQuestionStemService.selectQuestionStemList(courseId, hourId, type);
		if (data.size() > 0) {
			return ResultUtil.custom(1, "查询成功", data);
		}
		return ResultUtil.custom(-1, "查询失败", data);
	}

	/**
	 * 查询该视频有没有小节题
	 * 
	 * @author maguoliang
	 * @param courseId  课程id
	 * @param sectionId 章节id
	 * @return
	 */
	@RequestMapping("selectIsHaveStem")
	public Result selectIsHaveStem(Integer courseId, Integer sectionId) {
		List<FcQuestionStem> list = fcQuestionStemService.selectIsHaveStem(courseId, sectionId);
		if (list.size() > 0) {
			return ResultUtil.custom(1, "有小节题", list);
		}
		return ResultUtil.custom(0, "无小节题", list);
	}
}
