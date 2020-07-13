package chinaPress.role.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.role.member.dao.PractitionerInfoMapper;
import chinaPress.role.member.model.PractitionerInfo;
import chinaPress.role.member.vo.CertVo;
import chinaPress.role.member.vo.TeacherAndCertVo;
import chinaPress.role.member.vo.TeacherCertVo;
import chinaPress.role.member.vo.TeacherScoreVo;

/**
 * 20200709   add
 * @author wyj
 * 教师信息展示
 */
@Service
@Transactional
public class TeacherInfoService {

	
	/**
	 * 家长/从业者（教师）
	 */
	@Autowired 
	private PractitionerInfoMapper practitionerInfoMapper;

	/**
	 * 查询教师证书信息
	 * @param teacherCertVo
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findTeacherAndCert(PractitionerInfo practitionerInfo){
		List<TeacherCertVo> list = practitionerInfoMapper.selectTeacherAndCert(practitionerInfo);
		if(list.size()>0) {
			return new Result(0,"查询成功",list);
		}else {
			return new Result(-1,"数据库错误","");
		}
	}
	
	/**
	 * 查询教师证书信息个数
	 * @param teacherCertVo
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findTeacherAndCertCount(PractitionerInfo practitionerInfo){
		int count = practitionerInfoMapper.selectTeacherAndCertCount(practitionerInfo);
		if(count>0) {
			return new Result(0,"查询成功",count);
		}else {
			return new Result(-1,"数据库错误","");
		}
	}
	
	
	/**
	 * 查询教师成绩信息
	 * @param teacherScoreVo
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findTeacherAndScore(PractitionerInfo practitionerInfo){
		List<TeacherScoreVo> list = practitionerInfoMapper.selectTeacherAndScore(practitionerInfo);
		if(list.size()>0) {
			return new Result(0,"查询成功",list);
		}else {
			return new Result(-1,"数据库错误","");
		}
	}
	
	/**
	 * 查询教师成绩信息个数
	 * @param teacherScoreVo
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findTeacherAndScoreCount(PractitionerInfo practitionerInfo){
		int count = practitionerInfoMapper.selectTeacherAndScoreCount(practitionerInfo);
		if(count>0) {
			return new Result(0,"查询成功",count);
		}else {
			return new Result(-1,"数据库错误","");
		}
	}
	
	/**
	 * 查询教师认证信息
	 * @param practitionerInfo
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findTeacherAndCertInfos(PractitionerInfo practitionerInfo){
		List<TeacherAndCertVo> list = practitionerInfoMapper.selectTeacherAndCertInfos(practitionerInfo);
		if(list.size()>0) {
			return new Result(0,"查询成功",list);
		}else {
			return new Result(-1,"数据库错误","");
		}
	}
	
	/**
	 * 查询教师认证信息个数
	 * @param teacherScoreVo
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findTeacherAndCertInfosCount(PractitionerInfo practitionerInfo){
		int count = practitionerInfoMapper.selectTeacherAndCertInfosCount(practitionerInfo);
		if(count>0) {
			return new Result(0,"查询成功",count);
		}else {
			return new Result(-1,"数据库错误","");
		}
	}
	
	/**
	 * 教师id和证书id查询教师信息
	 * @param teaId
	 * @param cerId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findTeacherByIdAndCerId(Integer cerId) {
		CertVo certVo= practitionerInfoMapper.selectTeacherByIdAndCerId(cerId);
		if(certVo!=null) {
			return new Result(0,"查询成功",certVo);
		}else {
			return new Result(-1,"查询失败","");
		}
	}
}
