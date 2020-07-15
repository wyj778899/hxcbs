package chinaPress.role.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.role.comment.dao.FcCommentInfoMapper;
import chinaPress.role.comment.model.FcCommentInfo;

@Service
@Transactional
public class FcCommentService {

	
	@Autowired
	private FcCommentInfoMapper fcCommentInfoMapper;
	
	
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result addCommentInfo(FcCommentInfo fcCommentInfo) {
		int count = fcCommentInfoMapper.insertSelective(fcCommentInfo);
		if(count>0) {
			return new Result(1,"发表成功","");
		}else {
			return new Result(0,"发表失败","");
		}
	}
	
	
}
