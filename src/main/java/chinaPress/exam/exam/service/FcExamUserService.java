package chinaPress.exam.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.exam.exam.dao.FcExamUserMapper;
import chinaPress.exam.exam.vo.FcExamManageAreaUserListVo;

@Service
public class FcExamUserService {
	@Autowired
	private FcExamUserMapper fcExamUserMapper;

	/**
	 * 查询考试区域用户
	 * 
	 * @param signupAreaId      考试报名区域id
	 * @param name              名称
	 * @param phone             手机
	 * @param certificateNumber 身份证
	 * @param status            状态1.通过2.没通过
	 * @return
	 */
	public int selectFcExamAreaUserCount(Integer signupAreaId, String name, String phone, String certificateNumber,
			Integer status) {
		return fcExamUserMapper.selectFcExamAreaUserCount(signupAreaId, name, phone, certificateNumber, status);
	}

	/**
	 * 查询考试区域用户
	 * 
	 * @param signupAreaId      考试报名区域id
	 * @param name              名称
	 * @param phone             手机
	 * @param certificateNumber 身份证
	 * @param status            状态1.通过2.没通过
	 * @param pageNumber        第几页
	 * @param pageSize          每页查询多少条
	 * @return
	 */
	public List<FcExamManageAreaUserListVo> selectFcExamAreaUserList(Integer signupAreaId, String name, String phone,
			String certificateNumber, Integer status, Integer pageNumber, Integer pageSize) {
		return fcExamUserMapper.selectFcExamAreaUserList(signupAreaId, name, phone, certificateNumber, status,
				pageNumber * pageSize - pageSize, pageSize);
	}
}
