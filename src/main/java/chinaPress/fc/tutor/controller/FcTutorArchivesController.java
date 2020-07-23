package chinaPress.fc.tutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.tutor.model.FcTutorArchives;
import chinaPress.fc.tutor.service.FcTutorArchivesService;
import chinaPress.fc.tutor.vo.FcTurorArchivesManageDetailVo;
import chinaPress.fc.tutor.vo.FcTurorArchivesManageListVo;

@RestController
@RequestMapping("tutor")
public class FcTutorArchivesController {
	@Autowired
	private FcTutorArchivesService fcTutorArchivesService;

	/**
	 * 查询导师档案个数
	 * 
	 * @author maguoliang
	 * @param name 导师姓名
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectFcTutorArchivesCount(String name) {
		int count = fcTutorArchivesService.selectFcTutorArchivesCount(name);
		return ResultUtil.ok(count);
	}

	/**
	 * 查询导师档案列表
	 * 
	 * @author maguoliang
	 * @param name       导师姓名
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectFcTutorArchivesList(String name, Integer pageNumber, Integer pageSize) {
		List<FcTurorArchivesManageListVo> list = fcTutorArchivesService.selectFcTutorArchivesList(name, pageNumber,
				pageSize);
		return ResultUtil.ok(list);
	}

	/**
	 * 添加教师档案
	 * 
	 * @author maguoliang
	 * @param fcTutorArchives
	 * @return
	 */
	@RequestMapping("manage/add")
	public Result addFcTutorArchives(FcTutorArchives fcTutorArchives) {
		int index = fcTutorArchivesService.addFcTutorArchives(fcTutorArchives);
		if (index > 0) {
			return ResultUtil.custom(1, "操作成功", 1);
		} else {
			return ResultUtil.custom(0, "操作失败", 0);
		}
	}

	/**
	 * 修改教师档案
	 * 
	 * @author maguoliang
	 * @param fcTutorArchives
	 * @return
	 */
	@RequestMapping("manage/update")
	public Result updateFcTutorArchives(FcTutorArchives fcTutorArchives) {
		int index = fcTutorArchivesService.updateFcTutorArchives(fcTutorArchives);
		if (index > 0) {
			return ResultUtil.custom(1, "操作成功", 1);
		} else {
			return ResultUtil.custom(0, "操作失败", 0);
		}
	}

	/**
	 * 查询详情
	 * 
	 * @author maguoliang
	 * @param id
	 * @return
	 */
	@RequestMapping("manage/detail")
	public Result selectFcTutorArchivesDetail(Integer id) {
		FcTurorArchivesManageDetailVo fcTurorArchivesManageDetailVo = fcTutorArchivesService
				.selectFcTutorArchivesDetail(id);
		if (fcTurorArchivesManageDetailVo != null) {
			return ResultUtil.custom(1, "有数据", fcTurorArchivesManageDetailVo);
		} else {
			return ResultUtil.custom(0, "无数据", fcTurorArchivesManageDetailVo);
		}
	}
}
