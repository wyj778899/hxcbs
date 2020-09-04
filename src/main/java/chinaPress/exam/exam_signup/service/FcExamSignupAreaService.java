package chinaPress.exam.exam_signup.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.exam.exam_signup.dao.FcExamSignupAreaMapper;
import chinaPress.exam.exam_signup.dao.FcExamSignupMapper;
import chinaPress.exam.exam_signup.model.FcExamSignup;
import chinaPress.exam.exam_signup.model.FcExamSignupArea;
import chinaPress.exam.exam_signup.vo.FcExamSignupAreaListVo;

@Service
public class FcExamSignupAreaService {
	@Autowired
	private FcExamSignupAreaMapper fcExamSignupAreaMapper;
	@Autowired
	private FcExamSignupMapper fcExamSignupMapper;

	/**
	 * 下架考试报名区域
	 * 
	 * @author maguoliang
	 * @param areaId    考试报名区域id
	 * @param isPutaway 上下架状态1.上架；0.手动下架
	 * @return
	 */
	public int onOffShelf(Integer areaId, Integer isPutaway) {
		FcExamSignupArea fcExamSignupArea = new FcExamSignupArea();
		fcExamSignupArea.setId(areaId);
		fcExamSignupArea.setIsPutaway(isPutaway);
		fcExamSignupAreaMapper.updateByPrimaryKeySelective(fcExamSignupArea);
		// 下架完成之后，查询该考试报名下是否所有都 已下架，如果已下架，那么考试报名下架
		if (isPutaway.intValue() == 0) {
			FcExamSignupArea oldFcExamSignupArea = fcExamSignupAreaMapper.selectByPrimaryKey(areaId);
			List<FcExamSignupArea> areaList = fcExamSignupAreaMapper
					.selectBySignupId(oldFcExamSignupArea.getSignupId());
			List<FcExamSignupArea> filterAreaList = areaList.stream().filter(area -> area.getIsPutaway() == 0)
					.collect(Collectors.toList());
			if (areaList.size() == filterAreaList.size()) {
				FcExamSignup record = new FcExamSignup();
				record.setId(oldFcExamSignupArea.getSignupId());
				record.setIsPutaway(0);
				fcExamSignupMapper.updateByPrimaryKeySelective(record);
			}
		}
		if (isPutaway.intValue() == 1) {
			FcExamSignupArea oldFcExamSignupArea = fcExamSignupAreaMapper.selectByPrimaryKey(areaId);	
			// 1.上架；0.手动下架；-1.人满下架；-2.被考试设置进去下架；-3.报名下架导致被动下架
			if (oldFcExamSignupArea.getIsPutaway().intValue() == -1) {
				// 请重新设置人数
				return -1;
			}
			if (oldFcExamSignupArea.getIsPutaway().intValue() == -2) {
				// 该区域时间已用进考试，无法上架
				return -2;
			}
		}
		return 1;
	}

	/**
	 * 根据考试报名id查询该考试报名下的区域时间个数
	 * 
	 * @param signupId  考试报名id
	 * @param province  区域-省
	 * @param city      区域-市
	 * @param district  区域-区
	 * @param startTime 考试开始时间
	 * @param endTime   考试结束时间
	 * @param isPutaway 是否上架1.上架0.下架
	 * @return
	 */
	public int selectBySignupIdCount(Integer signupId, String province, String city, String district, String startTime,
			String endTime, Integer isPutaway) {
		return fcExamSignupAreaMapper.selectBySignupIdCount(signupId, province, city, district, startTime, endTime,
				isPutaway);
	}

	/**
	 * 根据考试报名id查询该考试报名下的区域时间
	 * 
	 * @param signupId   考试报名id
	 * @param province   区域-省
	 * @param city       区域-市
	 * @param district   区域-区
	 * @param startTime  考试开始时间
	 * @param endTime    考试结束时间
	 * @param isPutaway  是否上架1.上架0.下架
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条
	 * @return
	 */
	public List<FcExamSignupAreaListVo> selectBySignupIdList(Integer signupId, String province, String city,
			String district, String startTime, String endTime, Integer isPutaway, Integer pageNumber,
			Integer pageSize) {
		return fcExamSignupAreaMapper.selectBySignupIdList(signupId, province, city, district, startTime, endTime,
				isPutaway, pageNumber * pageSize - pageSize, pageSize);
	}
}
