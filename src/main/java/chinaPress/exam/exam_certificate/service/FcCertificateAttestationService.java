package chinaPress.exam.exam_certificate.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.common.result.model.Result;
import chinaPress.exam.exam_certificate.dao.FcCertificateAttestationMapper;
import chinaPress.exam.exam_certificate.model.FcCertificateAttestation;
import chinaPress.exam.exam_certificate.vo.ExamCertificate;

@Service
public class FcCertificateAttestationService {

	@Autowired
	private FcCertificateAttestationMapper fcCertificateAttestationMapper;
	
	/**
	 * 添加证书信息
	 * @param fcCertificateAttestation
	 * @return
	 */
	public Result addAttestation(FcCertificateAttestation fcCertificateAttestation) {
		String name = fcCertificateAttestation.getName();
		if(StringUtils.isBlank(name)) {
			return new Result(0,"证书名称不能为空","");
		}
		try {
			if(fcCertificateAttestationMapper.selectCertName(name, null)>0) {
				return new Result(0,"证书名称不能重复","");
			}
			fcCertificateAttestationMapper.insertSelective(fcCertificateAttestation);
			return new Result(1,"添加成功","");
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	/**
	 * 更新证书信息
	 * @param fcCertificateAttestation
	 * @return
	 */
	public Result setAttestation(FcCertificateAttestation fcCertificateAttestation) {
		String name = fcCertificateAttestation.getName();
		if(StringUtils.isBlank(name)) {
			return new Result(0,"证书名称不能为空","");
		}
		Integer id = fcCertificateAttestation.getId();
		if(id ==null) {
			return new Result(0,"证书信息出错","");
		}
		try {
			if(fcCertificateAttestationMapper.selectCertName(name, id)>0) {
				return new Result(0,"证书名称不能重复","");
			}
			fcCertificateAttestationMapper.updateByPrimaryKeySelective(fcCertificateAttestation);
			return new Result(1,"更新成功","");
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	/**
	 * id查询证书信息
	 * @param id
	 * @return
	 */
	public Result findPageAttestation(Integer id) {
		if(id ==null) {
			return new Result(0,"证书信息出错","");
		}
		try {
			FcCertificateAttestation attestation = fcCertificateAttestationMapper.selectByPrimaryKey(id);
			return new Result(1,"查询成功",attestation);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	/**
	 * 删除证书信息
	 * @param id
	 * @return
	 */
	public Result deleteAttestation(Integer id) {
		if(id ==null) {
			return new Result(0,"证书信息出错","");
		}
		try {
			fcCertificateAttestationMapper.deleteByPrimaryKey(id);
			return new Result(1,"删除成功","");
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	/**
	 * 查询所有证书信息
	 * @param page
	 * @param limit
	 * @return
	 */
	public Result findAttestationAll(Integer page,Integer limit) {
		try {
			List<ExamCertificate> examCertificates = fcCertificateAttestationMapper.selectCertAll(page, limit);
			return new Result(1,"查询成功",examCertificates);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	
	/**
	 * 查询所有证书信息个数
	 * @return
	 */
	public Result findAttestationAllCount() {
		try {
			int count = fcCertificateAttestationMapper.selectCertAllCount();
			return new Result(1,"查询成功",count);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
}
