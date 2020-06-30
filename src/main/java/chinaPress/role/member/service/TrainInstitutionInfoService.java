package chinaPress.role.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.role.member.dao.TrainInstitutionInfoMapper;
import chinaPress.role.member.vo.InstitutionAndEmpInfo;

/**
 * 机构信息
 * @author Administrator
 *
 */
@Transactional
@Service
public class TrainInstitutionInfoService {

	//培训机构信息
	@Autowired
	private TrainInstitutionInfoMapper trainInstitutionInfoMapper;
	
	
	/**
	 * 通过地区和机构名称查询机构信息
	 * @param area  地区
	 * @param name  机构名称
	 * @param page  当前页数
	 * @param limit 每页显示的条数
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findInsAndEmp(String area,String name,Integer page,Integer limit) {
		List<InstitutionAndEmpInfo> list = trainInstitutionInfoMapper.selectInstAndEmpInfo(area, name, (page-1)*limit, limit);
		if(list.size()>0) {
			return new Result(0, "查询成功", list);
		}else {
			return new Result(-1, "系统错误", "");
		}
	}
	
	
	/**
	 * 通过地区和机构名称查询机构信息个数
	 * @param area
	 * @param name
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findInsAndEmpCount(String area,String name) {
		int count = trainInstitutionInfoMapper.selectInstAndEmpInfoCount(area, name);
		if(count>0) {
			return new Result(0, "查询成功", count);
		}else {
			return new Result(-1, "系统错误", "");
		}
	}
	
	
}
