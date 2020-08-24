package chinaPress.role.praise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.role.praise.model.FcCommentPraise;
import chinaPress.role.praise.service.FcCommentPraiseService;

@RestController
@RequestMapping("comment_praise")
public class FcCommentPraiseController {
	@Autowired
	private FcCommentPraiseService fcCommentPraiseService;

	/**
	 * 点赞和取消赞
	 * 
	 * @param fcCommentPraise
	 */
	@RequestMapping("index/add")
	public Result addPraise(FcCommentPraise fcCommentPraise) {
		try {
			fcCommentPraiseService.addPraise(fcCommentPraise);
			return ResultUtil.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error();
		}
	}
}
