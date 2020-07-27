package chinaPress.fc.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.fc.question.model.FcQuestionCatalog;
import chinaPress.fc.question.service.FcQuestionCatalogService;

/**
 * 书籍分类
 * @author wyj
 *
 */
@RestController
@RequestMapping("/catalog")
public class FcQuestionCatalogController {

	
	@Autowired
	private FcQuestionCatalogService fcQuestionCatalogService;
	
	
	/**
	 * 添加书籍分类
	 * @param fcQuestionCatalog
	 * @return
	 */
	@RequestMapping("/registerCatalog")
	public Result registerCatalog(FcQuestionCatalog fcQuestionCatalog) {
		return fcQuestionCatalogService.addQuestionCatalog(fcQuestionCatalog);
	}
	
	
	/**
	 * 更新书籍分类
	 * @param fcQuestionCatalog
	 * @return
	 */
	@RequestMapping("/mofidyCatalog")
	public Result mofidyCatalog(FcQuestionCatalog fcQuestionCatalog) {
		return fcQuestionCatalogService.setQuestionCatalog(fcQuestionCatalog);
	}
	
	/**
	 * 显示所有书籍分类
	 * @return
	 */
	@RequestMapping("/queryAll")
	public Result queryAll() {
		return fcQuestionCatalogService.findAll();
	}
	
	/**
	 * 删除书籍分类
	 * @return
	 */
	@RequestMapping("/removeCatalog")
	public Result removeCatalog(Integer id) {
		return fcQuestionCatalogService.truncateById(id);
	}
	
}
