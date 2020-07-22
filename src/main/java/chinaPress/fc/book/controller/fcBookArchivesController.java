package chinaPress.fc.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.fc.book.model.FcBookArchives;
import chinaPress.fc.book.service.FcBookArchivesService;


/**
 * 20200717   终端书籍查询添加功能
 * @author wyj
 *
 */
@RestController
@RequestMapping("/book")
public class fcBookArchivesController {

	
	//书籍
	@Autowired
	FcBookArchivesService fcBookArchivesService;
	
	
	/**
	 * 添加书籍功能
	 * @param fcBookArchives
	 * @return
	 */
	@RequestMapping("/registerBookArchives")
	public Result registerBookArchives(FcBookArchives fcBookArchives) {
		return fcBookArchivesService.addFcBookArchives(fcBookArchives);
	}
	
	
	/**
	 * 更新书籍功能
	 * @param fcBookArchives
	 * @return
	 */
	@RequestMapping("/modifyBookArchives")
	public Result modifyBookArchives(FcBookArchives fcBookArchives) {
		return fcBookArchivesService.setFcBookArchives(fcBookArchives);
	}
	
	
	/**
	 * 查询书籍功能
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryBookArchives")
	public Result queryBookArchives(Integer id) {
		return fcBookArchivesService.findBooKInfos(id);
	}
}
