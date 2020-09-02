package chinaPress.exam.exam_signup.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import chinaPress.exam.exam_signup.dao.FcExamSignupAreaMapper;
import chinaPress.exam.exam_signup.dao.FcExamSignupMapper;
import chinaPress.exam.exam_signup.model.FcExamSignup;
import chinaPress.exam.exam_signup.model.FcExamSignupArea;
import chinaPress.exam.exam_signup.vo.FcExamSignupIndexDetailVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupIndexVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupListVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupManageDetailVo;

@Service
public class FcExamSignupService {
	@Autowired
	private FcExamSignupMapper fcExamSignupMapper;
	@Autowired
	private FcExamSignupAreaMapper examSignupAreaMapper;

	/**
	 * 查询考试报名列表个数
	 * 
	 * @author maguoliang
	 * @param signupName 考试报名名称
	 * @param examForm   考试形式(1现场0非现场)
	 * @param isPutaway  是否上架1.上架0.下架
	 * @return
	 */
	public int selectExamSignupCount(String signupName, Integer examForm, Integer isPutaway) {
		return fcExamSignupMapper.selectExamSignupCount(signupName, examForm, isPutaway);
	}

	/**
	 * 查询考试报名列表个数
	 * 
	 * @author maguoliang
	 * @param signupName 考试报名名称
	 * @param examForm   考试形式(1现场0非现场)
	 * @param isPutaway  是否上架1.上架0.下架
	 * @param pageNumber 第几页
	 * @param pageSize   查询多少条数据
	 * @return
	 */
	public List<FcExamSignupListVo> selectExamSignupList(String signupName, Integer examForm, Integer isPutaway,
			Integer pageNumber, Integer pageSize) {
		return fcExamSignupMapper.selectExamSignupList(signupName, examForm, isPutaway,
				pageNumber * pageSize - pageSize, pageSize);
	}

	/**
	 * 添加考试报名
	 * 
	 * @author maguoliang
	 * @param fcExamSignup 考试报名信息
	 * @param areas        考试报名关联的区域json字符串
	 */
	@Transactional
	public void insertExamSignup(FcExamSignup fcExamSignup, String areas) {
		// 添加考试报名
		fcExamSignupMapper.insertSelective(fcExamSignup);
		// 添加考试报名区域
		if (StringUtils.isNotBlank(areas)) {
			List<FcExamSignupArea> areaList = new Gson().fromJson(areas, new TypeToken<List<FcExamSignupArea>>() {
			}.getType());
			for (FcExamSignupArea fcExamSignupArea : areaList) {
				fcExamSignupArea.setSignupId(fcExamSignup.getId());
				examSignupAreaMapper.insertSelective(fcExamSignupArea);
			}
		}
	}

	/**
	 * 修改考试报名
	 * 
	 * @author maguoliang
	 * @param fcExamSignup 考试报名信息
	 * @param areas        考试报名关联的区域json字符串
	 */
	@Transactional
	public void updateExamSignup(FcExamSignup fcExamSignup, String areas) {
		// 添加考试报名
		fcExamSignupMapper.updateByPrimaryKeySelective(fcExamSignup);
		// 添加考试报名区域
		if (StringUtils.isNotBlank(areas)) {
			// 删除考试报名区域
			examSignupAreaMapper.deleteExamSignupAreaBySignupId(fcExamSignup.getId());
			// 重新添加考试报名区域
			List<FcExamSignupArea> areaList = new Gson().fromJson(areas, new TypeToken<List<FcExamSignupArea>>() {
			}.getType());
			for (FcExamSignupArea fcExamSignupArea : areaList) {
				fcExamSignupArea.setSignupId(fcExamSignup.getId());
				examSignupAreaMapper.insertSelective(fcExamSignupArea);
			}
		}
	}

	/**
	 * 查询考试报名详情
	 * 
	 * @param signupId 考试报名id
	 * @return
	 */
	public FcExamSignupManageDetailVo selectExamSignupDetail(Integer signupId) {
		return fcExamSignupMapper.selectExamSignupDetail(signupId);
	}

	/**
	 * 下架考试报名
	 * 
	 * @author maguoliang
	 * @param id        考试报名id
	 * @param isPutaway 上下架状态1.上架0.下架
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public void onShelf(Integer id, Integer isPutaway) {
		FcExamSignup fcExamSignup = new FcExamSignup();
		fcExamSignup.setId(id);
		fcExamSignup.setIsPutaway(isPutaway);
		fcExamSignupMapper.updateByPrimaryKeySelective(fcExamSignup);
		// 如果下架了，同时下架报名下的区域
		if (isPutaway.intValue() == 0) {
			List<FcExamSignupArea> signupAreaList = examSignupAreaMapper.selectBySignupId(id);
			for (FcExamSignupArea fcExamSignupArea : signupAreaList) {
				FcExamSignupArea record = new FcExamSignupArea();
				record.setId(fcExamSignupArea.getId());
				record.setIsPutaway(0);
				examSignupAreaMapper.updateByPrimaryKeySelective(record);
			}
		}
	}

	/**
	 * 查询已上架的考试报个数
	 * 
	 * @return
	 */
	public int selectPutawayExamSignupCount() {
		return fcExamSignupMapper.selectPutawayExamSignupCount();
	}

	/**
	 * 查询已上架的考试报名
	 * 
	 * @author maguoliang
	 * @param pageNumber 第几页
	 * @param pageSize   查询多少条数据
	 * @return
	 */
	public List<FcExamSignupIndexVo> selectPutawayExamSignupList(Integer pageNumber, Integer pageSize) {
		return fcExamSignupMapper.selectPutawayExamSignupList(pageNumber * pageSize - pageSize, pageSize);
	}

	/**
	 * 查询已上架的考试报名详情
	 * 
	 * @author maguoliang
	 * @param signupId
	 * @return
	 */
	public FcExamSignupIndexDetailVo selectPutawayExamSignupDetail(Integer signupId) {
		return fcExamSignupMapper.selectPutawayExamSignupDetail(signupId);
	}
}
