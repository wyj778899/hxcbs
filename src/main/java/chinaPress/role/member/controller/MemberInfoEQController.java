package chinaPress.role.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.role.member.model.PractitionerInfo;
import chinaPress.role.member.service.MemberInfoEQService;

/**
 * 恩起的用户注册接口
 * @author wyj
 *
 */
@RestController
@RequestMapping("/enqi")
public class MemberInfoEQController {

	
	@Autowired
	private MemberInfoEQService memberInfoEQService;
	
	
	
	/**
	 * 从业者添加
	 * 
	 * @param practitioner
	 * @return
	 */
	@PostMapping("/registerPract")
	public Result registerPract(PractitionerInfo practitioner) {
		practitioner.setType(2);
		return memberInfoEQService.addPract(practitioner);
	}
	
	
	/**
	 * 家长添加
	 * 
	 * @param practitioner
	 * @return
	 */
	@PostMapping("/registerParent")
	public Result registerParent(PractitionerInfo practitioner) {
		practitioner.setType(1);
		return memberInfoEQService.addPract(practitioner);
	}
	
}
