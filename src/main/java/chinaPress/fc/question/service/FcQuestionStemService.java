package chinaPress.fc.question.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.question.dao.FcQuestionOptionMapper;
import chinaPress.fc.question.dao.FcQuestionStemMapper;
import chinaPress.fc.question.model.FcQuestionOption;
import chinaPress.fc.question.model.FcQuestionStem;
import chinaPress.fc.question.vo.FcQuestionAndOption;
import chinaPress.fc.question.vo.FcQuestionInfo;
import chinaPress.fc.question.vo.FcQuestionOptionVo;
import chinaPress.fc.question.vo.FcQuestionStemListVo;
import chinaPress.fc.question.vo.QuestionStemDetailVo;

@Service
public class FcQuestionStemService {

	@Autowired
	private FcQuestionStemMapper fcQuestionStemMapper;
	@Autowired
	private FcQuestionOptionMapper fcQuestionOptionMapper;

	public List<FcQuestionStemListVo> selectQuestionStemList(Integer courseId, Integer hourId, Integer type) {
		List<FcQuestionStemListVo> data = fcQuestionStemMapper.selectQuestionStemList(courseId, hourId, type);
		if (data.size() > 0) {
			for (FcQuestionStemListVo item : data) {
				List<FcQuestionOptionVo> optionList = fcQuestionOptionMapper.selectByStemId(item.getId());
				if (optionList.size() > 0) {
					item.setOptionList(optionList);
				}
			}
		}
		return data;
	}

	/**
	 * 查询该视频有没有小节题
	 * 
	 * @author maguoliang
	 * @param courseId  课程id
	 * @param sectionId 章节id
	 * @return
	 */
	public List<FcQuestionStem> selectIsHaveStem(Integer courseId, Integer sectionId) {
		return fcQuestionStemMapper.selectIsHaveStem(courseId, sectionId);
	}

	/**
	 * 添加试题信息
	 * 
	 * @param stem
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public Result addQuestionStem(FcQuestionStem stem) {
		// 试题名称
		String name = stem.getQuestionStem();
		if (StringUtils.isBlank(name)) {
			return new Result(0, "试题名称不能为空", "");
		}
		if (fcQuestionStemMapper.selectByQuestionStem(name, null) > 0) {
			return new Result(0, "试题名称不能重复", "");
		}
		// 试题添加
		fcQuestionStemMapper.insertSelective(stem);
		for (FcQuestionOption option : stem.getOptionList()) {
			option.setStemId(stem.getId());
			// 试题答案添加
			fcQuestionOptionMapper.insertSelective(option);
		}
		return new Result(1, "试题添加成功", "");
	}

	/**
	 * 更新试题信息
	 * 
	 * @param stem
	 * @return
	 */
	@Transactional
	public Result setQuestionStem(FcQuestionStem stem) {
		try {
			// 试题编号
			Integer id = stem.getId();
			if (id == null) {
				return new Result(0, "试题信息出错", "");
			}
			// 试题名称
			String name = stem.getQuestionStem();
			if (!StringUtils.isBlank(name)) {
				if (fcQuestionStemMapper.selectByQuestionStem(name, id) > 0) {
					return new Result(0, "试题名称不能重复", "");
				}
			}
			// 试题更新
			fcQuestionStemMapper.updateByPrimaryKeySelective(stem);
			// 删除答案
			fcQuestionOptionMapper.deleteItemId(id);
			// XXX 选项：先删除，后新增   避免答案个数不一致
			for (FcQuestionOption option : stem.getOptionList()) {
				option.setStemId(id);
				// 试题答案更新
				fcQuestionOptionMapper.insertSelective(option);
			}
			return new Result(1, "试题更新成功", "");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统错误", "");
		}
	}

	/**
	 * id查询试题信息
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public Result findQuestionOne(Integer id) {
		try {
			if (id == null) {
				return new Result(0, "查询试题信息出错", "");
			}
			FcQuestionAndOption questionAndOption = fcQuestionStemMapper.selectById(id);
			if (questionAndOption != null) {
				return new Result(1, "查询成功", questionAndOption);
			} else {
				return new Result(0, "用户信息不存在", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统错误", "");
		}
	}

	/**
	 * 删除试题
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public Result deleteQuestionOne(Integer id) {
		try {
			if (id == null) {
				return new Result(0, "查询试题信息出错", "");
			}
			// 删除答案
			fcQuestionOptionMapper.deleteItemId(id);
			// 删除试题
			fcQuestionStemMapper.deleteByPrimaryKey(id);
			return new Result(1, "删除成功", "");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统错误", "");
		}
	}

	/**
	 * 通过试题名称,试题难度,试题分类 查询试题信息
	 * 
	 * @param questionStem
	 * @param taskDifficulty
	 * @param catalogId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Result findByCatalogIdAll(String questionStem, Integer taskDifficulty, Integer catalogId, Integer type,
			Integer page, Integer limit) {
		try {
			List<FcQuestionInfo> list = fcQuestionStemMapper.selectByCatalogIdAll(questionStem, taskDifficulty,
					catalogId, type, page, limit);
			return new Result(1, "查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "查询失败", "");
		}
	}

	/**
	 * 通过试题名称,试题难度,试题分类 查询试题个数
	 * 
	 * @param questionStem
	 * @param taskDifficulty
	 * @param catalogId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Result findByCatalogIdCount(String questionStem, Integer taskDifficulty, Integer catalogId, Integer type) {
		try {
			int count = fcQuestionStemMapper.selectByCatalogIdCount(questionStem, taskDifficulty, catalogId, type);
			return new Result(1, "查询成功", count);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "查询失败", "");
		}
	}

	/**
	 * 题库档案 - 详情
	 * 
	 * @param id
	 * @return
	 */
	public Result detail(Integer id) {
		try {
			if (id == null) {
				return ResultUtil.custom(0, "参数错误");
			}
			QuestionStemDetailVo detail = fcQuestionStemMapper.detail(id);
			if (detail == null) {
				return ResultUtil.custom(0, "数据异常");
			}
			return ResultUtil.custom(1, "查询成功", detail);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.custom(0, "系统错误");
		}
	}
}
