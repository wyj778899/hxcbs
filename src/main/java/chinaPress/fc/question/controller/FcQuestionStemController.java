package chinaPress.fc.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.JacksonUtil;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.question.model.FcQuestionOption;
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

	/**
	 * 添加试题
	 * 
	 * @param fcQuestionStem
	 * @return
	 */
	@RequestMapping("registerQuestionStem")
	public Result registerQuestionStem(FcQuestionStem fcQuestionStem, String jsonData) {
		try {
			List<FcQuestionOption> optionList = JacksonUtil.fromJSONList(jsonData, FcQuestionOption.class);
			fcQuestionStem.setOptionList(optionList);
			return fcQuestionStemService.addQuestionStem(fcQuestionStem);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统异常", "");
		}
	}

	/**
	 * 修改试题
	 * 
	 * @param fcQuestionStem
	 * @return
	 */
	@RequestMapping("modifyQuestionStem")
	public Result modifyQuestionStem(FcQuestionStem fcQuestionStem, String jsonData) {
		try {
			List<FcQuestionOption> optionList = JacksonUtil.fromJSONList(jsonData, FcQuestionOption.class);
			fcQuestionStem.setOptionList(optionList);
			return fcQuestionStemService.setQuestionStem(fcQuestionStem);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统异常", "");
		}
	}

	/**
	 * 查询试题和答案信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("queryPageQuestionStem")
	public Result queryPageQuestionStem(Integer id) {
		return fcQuestionStemService.findQuestionOne(id);
	}

	/**
	 * 删除试题信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("removeByQuestionStem")
	public Result removeByQuestionStem(Integer id) {
		return fcQuestionStemService.deleteQuestionOne(id);
	}

	/**
	 * 通过试题名称,试题难度,试题分类 查询试题信息
	 * 
	 * @param questionStem
	 * @param taskDifficulty
	 * @param catalogId
	 * @return
	 */
	@RequestMapping("queryByCatalogIdAll")
	public Result queryByCatalogIdAll(String questionStem, Integer taskDifficulty, Integer catalogId, Integer type,
			Integer page, Integer limit) {
		return fcQuestionStemService.findByCatalogIdAll(questionStem, taskDifficulty, type, catalogId,
				(page - 1) * limit, limit);
	}

	/**
	 * 通过试题名称,试题难度,试题分类 查询试题个数
	 * 
	 * @param questionStem
	 * @param taskDifficulty
	 * @param catalogId
	 * @return
	 */
	@RequestMapping("queryByCatalogIdCount")
	public Result queryByCatalogIdCount(String questionStem, Integer taskDifficulty, Integer catalogId, Integer type) {
		return fcQuestionStemService.findByCatalogIdCount(questionStem, taskDifficulty, catalogId, type);
	}

	/**
	 * 题库档案 - 详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("questionStemDetail")
	public Result detail(Integer id) {
		return fcQuestionStemService.detail(id);
	}
}
