package chinaPress.fc.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.book.model.FcBookArchives;
import chinaPress.fc.book.service.FcBookArchivesService;
import chinaPress.fc.book.vo.FcBookArchivesManageListVo;


@RestController
@RequestMapping("/book")
public class FcBookArchivesController {

	// 书籍
	@Autowired
	FcBookArchivesService fcBookArchivesService;

	/**
	 * 添加书籍功能
	 * 
	 * @param fcBookArchives
	 * @return
	 */
	@RequestMapping("/registerBookArchives")
	public Result registerBookArchives(FcBookArchives fcBookArchives) {
		return fcBookArchivesService.addFcBookArchives(fcBookArchives);
	}

	/**
	 * 更新书籍功能
	 * 
	 * @param fcBookArchives
	 * @return
	 */
	@RequestMapping("/modifyBookArchives")
	public Result modifyBookArchives(FcBookArchives fcBookArchives) {
		return fcBookArchivesService.setFcBookArchives(fcBookArchives);
	}

	/**
	 * 查询书籍功能
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryBookArchives")
	public Result queryBookArchives(Integer id) {
		return fcBookArchivesService.findBookInfos(id);
	}

	/**
	 * 查询书籍档案个数
	 * 
	 * @author maguoliang
	 * @param name 书籍名称
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectBookArchivesCount(String name) {
		int count = fcBookArchivesService.selectBookArchivesCount(name);
		return ResultUtil.ok(count);
	}

	/**
	 * 查询书籍档案列表
	 * 
	 * @author maguoliang
	 * @param name       书籍名称
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条数据
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectBookArchivesList(String name, Integer pageNumber, Integer pageSize) {
		List<FcBookArchivesManageListVo> list = fcBookArchivesService.selectBookArchivesList(name, pageNumber,
				pageSize);
		return ResultUtil.ok(list);
	}
}
