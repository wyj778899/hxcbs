package chinaPress.fc.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.fc.question.model.FcQuestionCatalog;
import chinaPress.fc.question.service.FcQuestionCatalogService;

/**
 * 试题分类
 * @author wyj
 *
 */
@RestController
@RequestMapping("/catalog")
public class FcQuestionCatalogController {

	
	@Autowired
	private FcQuestionCatalogService fcQuestionCatalogService;
	
	
	/**
	 * 添加试题分类
	 * @param fcQuestionCatalog
	 * @return
	 */
	@RequestMapping("/registerCatalog")
	public Result registerCatalog(FcQuestionCatalog fcQuestionCatalog) {
		return fcQuestionCatalogService.addQuestionCatalog(fcQuestionCatalog);
	}
	
	
	/**
	 * 更新试题分类
	 * @param fcQuestionCatalog
	 * @return
	 */
	@RequestMapping("/modifyCatalog")
	public Result modifyCatalog(FcQuestionCatalog fcQuestionCatalog) {
		return fcQuestionCatalogService.setQuestionCatalog(fcQuestionCatalog);
	}
	
	/**
	 * 显示所有试题分类
	 * @return
	 */
	@RequestMapping("/queryAll")
	public Result queryAll() {
		return fcQuestionCatalogService.findAll();
	}
	
	/**
	 * 删除试题分类
	 * @return
	 */
	@RequestMapping("/removeCatalog")
	public Result removeCatalog(Integer id) {
		return fcQuestionCatalogService.truncateById(id);
	}
	
}
