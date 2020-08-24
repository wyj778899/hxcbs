package chinaPress.role.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.role.comment.model.FcCommentInfo;
import chinaPress.role.comment.service.FcCommentService;
import chinaPress.role.comment.vo.FcCommentIndexListVo;
import chinaPress.role.comment.vo.FcCommentListVo;

@RestController
@RequestMapping("comment")
public class FcCommentController {

	@Autowired
	private FcCommentService fcCommentService;

	/**
	 * 添加评论区留言
	 * 
	 * @param fcCommentInfo
	 * @return
	 */
	@RequestMapping("registerComment")
	public Result registerComment(FcCommentInfo fcCommentInfo) {
		return fcCommentService.addCommentInfo(fcCommentInfo);
	}

	/**
	 * 后台管理系统查看评论个数
	 * 
	 * @param userName  用户名
	 * @param tellPhone 手机号
	 * @param status    审核状态1.已审核0.未审核
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectManageFcCommentCount(String userName, String tellPhone, Integer status) {
		int index = fcCommentService.selectManageFcCommentCount(userName, tellPhone, status);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error(index);
		}
	}

	/**
	 * 后台管理系统查看评论列表
	 * 
	 * @param userName   用户名
	 * @param tellPhone  手机号
	 * @param status     审核状态1.已审核0.未审核
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条数据
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectManageFcCommentList(String userName, String tellPhone, Integer status, Integer pageNumber,
			Integer pageSize) {
		List<FcCommentListVo> list = fcCommentService.selectManageFcCommentList(userName, tellPhone, status, pageNumber,
				pageSize);
		if (list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
	}

	/**
	 * 后台管理系统查看评论详情
	 * 
	 * @param id 评论id
	 */
	@RequestMapping("manage/detail")
	public Result selectManageFcCommentDetail(Integer id) {
		FcCommentListVo fcCommentListVo = fcCommentService.selectManageFcCommentDetail(id);
		if (fcCommentListVo != null) {
			return ResultUtil.ok(fcCommentListVo);
		} else {
			return ResultUtil.error(fcCommentListVo);
		}
	}

	/**
	 * 后台管理系统审核评论
	 * 
	 * @param id           评论id
	 * @param status       评论状态1.通过2.驳回
	 * @param rejectReason 驳回原因
	 * @return
	 */
	@RequestMapping("manage/audit")
	public Result auditComment(Integer id, Integer status, String rejectReason) {
		int index = fcCommentService.auditComment(id, status, rejectReason);
		if (index > 0) {
			return ResultUtil.custom(1, "操作成功", index);
		} else if (index == -1) {
			return ResultUtil.custom(-1, "该评论已审核", index);
		} else {
			return ResultUtil.custom(0, "操作失败", 0);
		}
	}

	/**
	 * 前台展示评论
	 * 
	 * @param type   哪个类型下的评论1.评论章节2.评论课程3.评论书籍
	 * @param dataId 哪个类型下哪个具体类型的数据id
	 * @param order  按照什么来排序1.最新2.热门，默认为最新
	 * @return
	 */
	@RequestMapping("index/treeList")
	public Result selectIndexCommentList(Integer type, Integer dataId, Integer order) {
		List<FcCommentIndexListVo> list = fcCommentService.selectIndexCommentList(type, dataId, order);
		if (list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
	}
}
