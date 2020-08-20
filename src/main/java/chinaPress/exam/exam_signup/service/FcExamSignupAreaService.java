package chinaPress.exam.exam_signup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.exam.exam_signup.dao.FcExamSignupAreaMapper;
import chinaPress.exam.exam_signup.model.FcExamSignupArea;
import chinaPress.exam.exam_signup.vo.FcExamSignupAreaListVo;

@Service
public class FcExamSignupAreaService {
	@Autowired
	private FcExamSignupAreaMapper fcExamSignupAreaMapper;

	/**
	 * 下架考试报名区域
	 * 
	 * @author maguoliang
	 * @param areaId 考试报名区域id
	 * @return
	 */
	public int onShelf(Integer areaId) {
		FcExamSignupArea record = new FcExamSignupArea();
		record.setId(areaId);
		record.setIsPutaway(0);
		return fcExamSignupAreaMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 根据考试报名id查询该考试报名下的区域时间个数
	 * 
	 * @param signupId 考试报名id
	 * @return
	 */
	public int selectBySignupIdCount(Integer signupId) {
		return fcExamSignupAreaMapper.selectBySignupIdCount(signupId);
	}

	/**
	 * 根据考试报名id查询该考试报名下的区域时间
	 * 
	 * @param signupId   考试报名id
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条
	 * @return
	 */
	public List<FcExamSignupAreaListVo> selectBySignupIdList(Integer signupId, Integer pageNumber, Integer pageSize) {
		return fcExamSignupAreaMapper.selectBySignupIdList(signupId, pageNumber * pageSize - pageSize, pageSize);
	}
}
