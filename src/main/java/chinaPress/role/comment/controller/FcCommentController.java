package chinaPress.role.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.role.comment.model.FcCommentInfo;
import chinaPress.role.comment.service.FcCommentService;

@RestController
@RequestMapping("/comment")
public class FcCommentController {

	@Autowired
	private FcCommentService fcCommentService;
	
	/**
	 * 添加评论区留言
	 * @param fcCommentInfo
	 * @return
	 */
	@RequestMapping("/registerComment")
	public Result registerComment(FcCommentInfo fcCommentInfo) {
		return fcCommentService.addCommentInfo(fcCommentInfo);
	}
}
