package chinaPress.role.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.role.member.service.TrainInstitutionInfoService;

@RestController
@RequestMapping("/institution")
public class TrainInstitutionInfoController {

	
	@Autowired
	private TrainInstitutionInfoService trainInstitutionInfoService;
	
	
	/**
	 * 通过机构名称和地区查询培训机构信息
	 * @param area   地区
	 * @param name   机构名称    模糊查询
	 * @param page   当前页数
	 * @param limit  每页显示的条数
	 * @return
	 */
	@RequestMapping("/queryInsAndEmp")
	public Result queryInsAndEmp(String area,String name,Integer page,Integer limit) {
		return trainInstitutionInfoService.findInsAndEmp(area, name, page, limit);
	}
	
	
	@RequestMapping("/queryInsAndEmpCount")
	public Result queryInsAndEmpCount(String area,String name) {
		return trainInstitutionInfoService.findInsAndEmpCount(area, name);
	}
}
