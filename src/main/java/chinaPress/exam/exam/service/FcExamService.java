package chinaPress.exam.exam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import chinaPress.common.util.DateUtil;
import chinaPress.exam.exam.dao.FcExamMapper;
import chinaPress.exam.exam.dao.FcExamUserMapper;
import chinaPress.exam.exam.model.FcExam;
import chinaPress.exam.exam.model.FcExamUser;
import chinaPress.exam.exam_signup.dao.FcExamSignupAreaMapper;
import chinaPress.exam.exam_signup.dao.FcExamSignupMapper;
import chinaPress.exam.exam_signup.dao.FcExamSignupUserMapper;
import chinaPress.exam.exam_signup.model.FcExamSignup;
import chinaPress.exam.exam_signup.model.FcExamSignupArea;
import chinaPress.exam.exam_signup.model.FcExamSignupUser;

@Service
public class FcExamService {
	@Autowired
	private FcExamMapper fcExamMapper;
	@Autowired
	private FcExamUserMapper fcExamUserMapper;
	@Autowired
	private FcExamSignupMapper fcExamSignupMapper;
	@Autowired
	private FcExamSignupUserMapper fcExamSignupUserMapper;
	@Autowired
	private FcExamSignupAreaMapper fcExamSignupAreaMapper;
	

	/**
	 * 添加考试设置
	 * @param fcExam
	 * @param signupUsers
	 */
	public void addFcExam(FcExam fcExam, String signupUsers) {
//		Integer singupId = fcExam.getSignupId();
//		Integer signupAreaId = fcExam.getSignupAreaId();
		// 添加考试设置
		fcExamMapper.insertSelective(fcExam);
		List<FcExamUser> list = new Gson().fromJson(signupUsers, new TypeToken<List<FcExamUser>>() {
		}.getType());
		for (FcExamUser fcExamUser : list) {
			fcExamUserMapper.insertSelective(fcExamUser);
			// 修改报名人员状态
			FcExamSignupUser fcExamSignupUser = new FcExamSignupUser();
			fcExamSignupUser.setId(fcExamUser.getSignupUserId());
			fcExamSignupUser.setExamineType(3);
			fcExamSignupUserMapper.updateByPrimaryKeySelective(fcExamSignupUser);
		}
	}
	
	public int updateExam(FcExam fcExam, String signupUsers) {
		// 检查是否可修改
		FcExam selFcExam = fcExamMapper.selectByPrimaryKey(fcExam.getId());
		if (selFcExam != null) {
			FcExamSignup fcExamSignup = fcExamSignupMapper.selectByPrimaryKey(fcExam.getSignupId());
			if (fcExamSignup != null) {
				FcExamSignupArea fcExamSignupArea = fcExamSignupAreaMapper.selectByPrimaryKey(fcExam.getSignupAreaId());	
				if (fcExamSignupArea != null) {
					// 如果正在考试
					if (DateUtil.compareDate(new Date(), fcExamSignupArea.getStartTime())
							&& DateUtil.compareDate(fcExamSignupArea.getEndTime(), new Date())) {
						// 正在考试中，无法操作
						return -4;
					}
					// 如果考试已经完毕
					if (DateUtil.compareDate(new Date(), fcExamSignupArea.getEndTime())) {
						// 该场考试已结束，无法操作
						return -5;
					}
					// 编辑考试设置
					fcExamMapper.updateByPrimaryKey(fcExam);
					// 恢复原来关联的考试报名用户的审核状态：已报考->已审核
					
					return 1; 
				} else {
					// 考试关联的考试报名区域时间不存在
					return -3;
				}
			} else {
				// 考试关联的报名信息不存在
				return -2;
			}
		} else {
			// 当前考试不存在
			return -1;
		}
	}
}
