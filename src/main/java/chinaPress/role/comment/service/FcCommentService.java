package chinaPress.role.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.role.comment.dao.FcCommentInfoMapper;
import chinaPress.role.comment.model.FcCommentInfo;
import chinaPress.role.comment.vo.FcCommentListVo;

@Service
public class FcCommentService {

	@Autowired
	private FcCommentInfoMapper fcCommentInfoMapper;

	/**
	 * 发布评论
	 * 
	 * @param fcCommentInfo
	 * @return
	 */
	@Transactional
	public Result addCommentInfo(FcCommentInfo fcCommentInfo) {
		int count = fcCommentInfoMapper.insertSelective(fcCommentInfo);
		if (count > 0) {
			return new Result(1, "发表成功", "");
		} else {
			return new Result(0, "发表失败", "");
		}
	}

	/**
	 * 后台管理系统查看评论个数
	 * 
	 * @param userName  用户名
	 * @param tellPhone 手机号
	 * @param status    审核状态1.已审核0.未审核
	 * @return
	 */
	public int selectManageFcCommentCount(String userName, String tellPhone, Integer status) {
		return fcCommentInfoMapper.selectManageFcCommentCount(userName, tellPhone, status);
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
	public List<FcCommentListVo> selectManageFcCommentList(String userName, String tellPhone, Integer status,
			Integer pageNumber, Integer pageSize) {
		return fcCommentInfoMapper.selectManageFcCommentList(userName, tellPhone, status,
				pageNumber * pageSize - pageSize, pageSize);
	}

	/**
	 * 后台管理系统查看评论详情
	 * 
	 * @param id 评论id
	 */
	public FcCommentListVo selectManageFcCommentDetail(Integer id) {
		return fcCommentInfoMapper.selectManageFcCommentDetail(id);
	}

	/**
	 * 审核评论
	 * 
	 * @param id     评论id
	 * @param status 评论状态1.通过2.驳回
	 * @return
	 */
	@Transactional
	public int auditComment(Integer id, Integer status) {
		FcCommentInfo fcCommentInfo = fcCommentInfoMapper.selectByPrimaryKey(id);
		if (fcCommentInfo.getStatus().intValue() != 0) {
			return -1;
		}
		FcCommentInfo record = new FcCommentInfo();
		record.setId(id);
		record.setStatus(status);
		return fcCommentInfoMapper.updateByPrimaryKeySelective(record);
	}
}
