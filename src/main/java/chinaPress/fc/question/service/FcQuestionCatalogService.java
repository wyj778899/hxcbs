package chinaPress.fc.question.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.question.dao.FcQuestionCatalogMapper;
import chinaPress.fc.question.model.FcQuestionCatalog;
import chinaPress.fc.question.vo.FcQuestionCatalogVo;

/**
 * 20200724 试题分类
 * 
 * @author wyj
 *
 */
@Service
@Transactional
public class FcQuestionCatalogService {

	/**
	 * 试题分类dao
	 */
	@Autowired
	private FcQuestionCatalogMapper fcQuestionCatalogMapper;

	/**
	 * 添加试题分类
	 * 
	 * @return
	 */
	public Result addQuestionCatalog(FcQuestionCatalog fcQuestionCatalog) {
		// 判断排序号是否重复
		try {
			Integer sort = fcQuestionCatalog.getCatalogSort();
			if (sort != null) {
				int count = fcQuestionCatalogMapper.selectBySortAndName(sort, null, null);
				if (count > 0) {
					return new Result(0, "分类编号已存在", "");
				}
			}
			String name = fcQuestionCatalog.getCatalogName();
			if (name != null && name != "") {
				int num = fcQuestionCatalogMapper.selectBySortAndName(null, name, null);
				if (num > 0) {
					return new Result(0, "分类名称已存在", "");
				}
			}
			fcQuestionCatalogMapper.insertSelective(fcQuestionCatalog);
			return new Result(1, "添加成功", "");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "添加失败", "");
		}
	}

	/**
	 * 更新目录操作
	 * 
	 * @param fcQuestionCatalog
	 * @return
	 */
	public Result setQuestionCatalog(FcQuestionCatalog fcQuestionCatalog) {
		try {
			// 校验名称和排序号
			Integer id = fcQuestionCatalog.getId();
			if (id == null) {
				return new Result(0, "目录不存在", "");
			}
			String name = fcQuestionCatalog.getCatalogName();
			Integer sort = fcQuestionCatalog.getCatalogSort();
			if (name != null && name != "") {
				int count = fcQuestionCatalogMapper.selectBySortAndName(null, name, id);
				if (count > 0) {
					return new Result(0, "分类名称已存在", "");
				}
			}
			if (sort != null) {
				int num = fcQuestionCatalogMapper.selectBySortAndName(sort, null, id);
				if (num > 0) {
					return new Result(0, "分类编号已存在", "");
				}
			}
			fcQuestionCatalogMapper.updateByPrimaryKeySelective(fcQuestionCatalog);
			return new Result(1, "更新成功", "");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统错误", "");
		}
	}

	/**
	 * 查询所有分类
	 * 
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Result findAll(String name, Integer page, Integer limit) {
		try {
			if (page != null && limit != null) {
				page = (page - 1) * limit;
			}
			List<FcQuestionCatalogVo> list = fcQuestionCatalogMapper.selectAll(name, page, limit);
			return new Result(1, "查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统错误", "");
		}
	}

	/**
	 * 查询所有分类个数
	 * 
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Result findAllCount(String name) {
		try {
			int count = fcQuestionCatalogMapper.selectAllCount(name);
			return new Result(1, "查询成功", count);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统错误", "");
		}
	}

	/**
	 * 删除书籍目录
	 * 
	 * @param id
	 * @return
	 */
	public Result truncateById(Integer id) {
		try {
			if (id != null) {
				int count = fcQuestionCatalogMapper.selectByCatalogId(id);
				if (count > 0) {
					return new Result(0, "删除目录必须删除目录下所有试题", "");
				}
				fcQuestionCatalogMapper.deleteByPrimaryKey(id);
				return new Result(1, "删除成功", "");
			}
			return new Result(0, "目录不存在", "");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "删除失败", "");
		}
	}

	/**
	 * 查询分类集合
	 * 
	 * @return
	 */
	public Result selectCatalogList() {
		try {
			List<Map<String, Object>> data = fcQuestionCatalogMapper.selectCatalogList();
			return ResultUtil.custom(1, "查询成功", data);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.custom(0, "系统错误");
		}
	}
}
