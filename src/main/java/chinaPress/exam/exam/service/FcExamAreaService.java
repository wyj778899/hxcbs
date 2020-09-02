package chinaPress.exam.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.exam.exam.dao.FcExamAreaMapper;
import chinaPress.exam.exam.vo.FcExamManageAreaListVo;

@Service
public class FcExamAreaService {
	@Autowired
	private FcExamAreaMapper fcExamAreaMapper;

	/**
	 * 查询考试设置下的考试区域
	 * 
	 * @param examId    考试id
	 * @param province  省
	 * @param city      市
	 * @param district  区
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @param status    考试状态1.未开始2.进行中3.已结束
	 * @return
	 */
	public int selectFcExamAreaCount(Integer examId, String province, String city, String district, String startTime,
			String endTime, Integer status) {
		return fcExamAreaMapper.selectFcExamAreaCount(examId, province, city, district, startTime, endTime, status);
	}

	/**
	 * 查询考试设置下的考试区域
	 * 
	 * @param examId     考试id
	 * @param province   省
	 * @param city       市
	 * @param district   区
	 * @param startTime  开始时间
	 * @param endTime    结束时间
	 * @param status     考试状态1.未开始2.进行中3.已结束
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条
	 * @return
	 */
	public List<FcExamManageAreaListVo> selectFcExamAreaList(Integer examId, String province, String city,
			String district, String startTime, String endTime, Integer status, Integer pageNumber, Integer pageSize) {
		return fcExamAreaMapper.selectFcExamAreaList(examId, province, city, district, startTime, endTime, status,
				pageNumber * pageSize - pageSize, pageSize);
	}
}
