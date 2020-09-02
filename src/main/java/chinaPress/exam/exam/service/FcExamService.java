package chinaPress.exam.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import chinaPress.exam.exam.dao.FcExamAreaMapper;
import chinaPress.exam.exam.dao.FcExamMapper;
import chinaPress.exam.exam.dao.FcExamPaperMapper;
import chinaPress.exam.exam.dao.FcExamUserMapper;
import chinaPress.exam.exam.model.FcExam;
import chinaPress.exam.exam.model.FcExamArea;
import chinaPress.exam.exam.model.FcExamPaper;
import chinaPress.exam.exam.model.FcExamUser;
import chinaPress.exam.exam.vo.FcExamManageDetailVo;
import chinaPress.exam.exam.vo.FcExamManageListVo;
import chinaPress.exam.exam_signup.dao.FcExamSignupMapper;
import chinaPress.exam.exam_signup.dao.FcExamSignupUserMapper;
import chinaPress.exam.exam_signup.model.FcExamSignup;
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
	private FcExamAreaMapper fcExamAreaMapper;
	@Autowired
	private FcExamPaperMapper fcExamPaperMapper;

	/**
	 * 添加考试设置
	 * 
	 * @param fcExam
	 * @param signupUsers
	 * @param signupAreas
	 */
	@Transactional(rollbackFor = Exception.class)
	public void addFcExam(FcExam fcExam, String signupUsers, String signupAreas) {
		// 添加考试设置
		fcExamMapper.insertSelective(fcExam);
		// 添加考试关联用户
		List<FcExamUser> userList = new Gson().fromJson(signupUsers, new TypeToken<List<FcExamUser>>() {
		}.getType());
		for (FcExamUser fcExamUser : userList) {
			fcExamUser.setExamId(fcExam.getId());
			fcExamUserMapper.insertSelective(fcExamUser);
			// 修改报名人员状态
//			FcExamSignupUser fcExamSignupUser = new FcExamSignupUser();
//			fcExamSignupUser.setId(fcExamUser.getSignupUserId());
//			fcExamSignupUser.setExamineType(3);
//			fcExamSignupUserMapper.updateByPrimaryKeySelective(fcExamSignupUser);
		}
		// 添加考试关联区域
		List<FcExamArea> areaList = new Gson().fromJson(signupAreas, new TypeToken<List<FcExamArea>>() {
		}.getType());
		for (FcExamArea fcExamArea : areaList) {
			fcExamArea.setExamId(fcExam.getId());
			fcExamAreaMapper.insertSelective(fcExamArea);
		}
		// 添加考试关联试卷
		FcExamPaper fcExamPaper = new FcExamPaper();
		fcExamPaper.setExamId(fcExam.getId());
		fcExamPaper.setPaperId(fcExam.getPaperId());
		fcExamPaperMapper.insertSelective(fcExamPaper);
	}

	/**
	 * 修改考试设置
	 * 
	 * @param fcExam
	 * @param signupUsers
	 * @param signupAreas
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public int updateExam(FcExam fcExam, String signupUsers, String signupAreas) {
		// 检查是否可修改
		FcExam selFcExam = fcExamMapper.selectByPrimaryKey(fcExam.getId());
		if (selFcExam != null) {
			FcExamSignup fcExamSignup = fcExamSignupMapper.selectByPrimaryKey(fcExam.getSignupId());
			if (fcExamSignup != null) {
//					// 如果正在考试
//					if (DateUtil.compareDate(new Date(), fcExamSignupArea.getStartTime())
//							&& DateUtil.compareDate(fcExamSignupArea.getEndTime(), new Date())) {
//						// 正在考试中，无法操作
//						return -4;
//					}
//					// 如果考试已经完毕
//					if (DateUtil.compareDate(new Date(), fcExamSignupArea.getEndTime())) {
//						// 该场考试已结束，无法操作
//						return -5;
//					}
				// 编辑考试设置
				fcExamMapper.updateByPrimaryKey(fcExam);
				// 恢复原来关联的考试报名用户的审核状态：已报考->已审核，且修改新的关联的考试报名用户的审核状态为：已报考
				List<FcExamUser> list = new Gson().fromJson(signupUsers, new TypeToken<List<FcExamUser>>() {
				}.getType());
				List<FcExamUser> oldExamUserList = fcExamUserMapper.selectByFcExamId(fcExam.getId());
				for (FcExamUser fcExamUser : oldExamUserList) {
					FcExamSignupUser fcExamSignupUser = new FcExamSignupUser();
					fcExamSignupUser.setId(fcExamUser.getSignupUserId());
					fcExamSignupUser.setExamineType(1);
					fcExamSignupUserMapper.updateByPrimaryKeySelective(fcExamSignupUser);
				}
//				for (FcExamUser fcExamUser : list) {
//					FcExamSignupUser fcExamSignupUser = new FcExamSignupUser();
//					fcExamSignupUser.setId(fcExamUser.getSignupUserId());
//					fcExamSignupUser.setExamineType(3);
//					fcExamSignupUserMapper.updateByPrimaryKeySelective(fcExamSignupUser);
//				}
				// 删除原来关联的考试用户
				fcExamUserMapper.deleteByFcExamId(fcExam.getId());
				// 添加新写的考试用户
				for (FcExamUser fcExamUser : list) {
					fcExamUser.setExamId(fcExam.getId());
					fcExamUserMapper.insertSelective(fcExamUser);
				}
				// 删除原来关联的考试区域
				fcExamAreaMapper.deleteByFcExamId(fcExam.getId());
				// 添加新的考试区域
				List<FcExamArea> areaList = new Gson().fromJson(signupAreas, new TypeToken<List<FcExamArea>>() {
				}.getType());
				for (FcExamArea fcExamArea : areaList) {
					fcExamArea.setExamId(fcExam.getId());
					fcExamAreaMapper.insertSelective(fcExamArea);
				}
				// 删除原来的考试关联试卷
				fcExamPaperMapper.deleteByExamId(fcExam.getId());
				// 添加考试关联试卷
				FcExamPaper fcExamPaper = new FcExamPaper();
				fcExamPaper.setExamId(fcExam.getId());
				fcExamPaper.setPaperId(fcExam.getPaperId());
				fcExamPaperMapper.insertSelective(fcExamPaper);
				return 1;
			} else {
				// 考试关联的报名信息不存在
				return -2;
			}
		} else {
			// 当前考试不存在
			return -1;
		}
	}

	/**
	 * 查询考试详情
	 * 
	 * @param id 考试id
	 */
	public FcExamManageDetailVo selectFcExamDetail(Integer id) {
		return fcExamMapper.selectFcExamDetail(id);
	}

	/**
	 * 查询考试设置列表个数
	 * 
	 * @param name 考试名称
	 * @param type 考试类型
	 * @return
	 */
	public int selectFcExamCount(String name, Integer type) {
		return fcExamMapper.selectFcExamCount(name, type);
	}

	/**
	 * 查询考试设置列表个数
	 * 
	 * @param name       考试名称
	 * @param type       考试类型
	 * @param pageNumber 查询第几页
	 * @param pageSize   查询多少条
	 * @return
	 */
	public List<FcExamManageListVo> selectFcExamList(String name, Integer type, Integer pageNumber, Integer pageSize) {
		return fcExamMapper.selectFcExamList(name, type, pageNumber * pageSize - pageSize, pageSize);
	}
}
