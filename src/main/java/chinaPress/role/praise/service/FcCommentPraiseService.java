package chinaPress.role.praise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.role.comment.dao.FcCommentInfoMapper;
import chinaPress.role.comment.model.FcCommentInfo;
import chinaPress.role.praise.dao.FcCommentPraiseMapper;
import chinaPress.role.praise.model.FcCommentPraise;

@Service
public class FcCommentPraiseService {
	@Autowired
	private FcCommentPraiseMapper fcCommentPraiseMapper;
	@Autowired
	private FcCommentInfoMapper fcCommentInfoMapper;
	
	/**
	 * 点赞和取消赞
	 * @param fcCommentPraise
	 */
	@Transactional
	public void addPraise(FcCommentPraise fcCommentPraise) {
		// 查询当前的点赞数量
		FcCommentInfo currFcCommentInfo = fcCommentInfoMapper.selectByPrimaryKey(fcCommentPraise.getCommentId());
		// 更新评论的点赞数量
		if (currFcCommentInfo != null) {
			int newPraiseCount = currFcCommentInfo.getPraiseCount();
			if (fcCommentPraise.getStatus().intValue() == 1) {
				newPraiseCount = newPraiseCount + 1;
				fcCommentPraiseMapper.insertSelective(fcCommentPraise);
			}
			if (fcCommentPraise.getStatus().intValue() == 0) {
				newPraiseCount = newPraiseCount - 1;
				fcCommentPraiseMapper.updateByPrimaryKeySelective(fcCommentPraise);
			}
			FcCommentInfo newFcCommentInfo = new FcCommentInfo();
			newFcCommentInfo.setId(fcCommentPraise.getCommentId());
			newFcCommentInfo.setPraiseCount(newPraiseCount);
			fcCommentInfoMapper.updateByPrimaryKeySelective(newFcCommentInfo);
		}
	}
}
