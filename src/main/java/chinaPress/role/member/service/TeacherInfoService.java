package chinaPress.role.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.role.member.dao.PractitionerInfoMapper;
import chinaPress.role.member.model.PractitionerInfo;
import chinaPress.role.member.vo.CertInfo;
import chinaPress.role.member.vo.TeacherAndCertVo;
import chinaPress.role.member.vo.TeacherCerInfos;
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
	 * 教师id和证书id查询教师信息
	 * @param teaId
	 * @param type
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findTeacherByCers(Integer teaId,Integer type) {
		TeacherCerInfos teacherCerInfos= practitionerInfoMapper.selectTeacherByCers(teaId,type);
		if(teacherCerInfos!=null) {
			/*   type等于null做数据优化
			 *   将教师资格证和其他证书类型放在两个list里面返回
			 */
			if(type==null) {
				//返回map数据类型
				Map<String,Object> map = new HashMap<String,Object>();
				//教师资格证书的信息
				List<CertInfo> certs = new ArrayList<CertInfo>();
				//所有的教师资格证书    遍历完只剩下出来教师资格证书的其他信息
				Iterator <CertInfo>it =teacherCerInfos.getCerts().iterator();
				while(it.hasNext()) {
					//教师资格证书的状态等于1
					CertInfo c= it.next();
					if(c.getCertType()!=null && c.getCertType()==1) {
						certs.add(c);
						it.remove();
					}
				}
				map.put("data",teacherCerInfos);
				map.put("certs",certs);
				return new Result(0,"查询成功",map);
			}else {
				return new Result(0,"查询成功",teacherCerInfos);
			}
		}else {
			return new Result(-1,"查询失败","");
		}
	}
}
