package chinaPress.role.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.role.member.model.CertificateInfo;
import chinaPress.role.teacher.dao.RoleTeacherArchivesMapper;
import chinaPress.role.teacher.vo.TeacherArchivesParam;
import chinaPress.role.teacher.vo.TeacherCertificateVo;

@Service
public class RoleTeacherArchivesService {
	
	@Autowired
	private RoleTeacherArchivesMapper roleTeacherArchivesMapper;
	
	/**
	 * 根据id查询教师详情
	 * @param id
	 * @return
	 */
	public TeacherArchivesParam selectTeacherById(Integer id) {
		TeacherArchivesParam model = roleTeacherArchivesMapper.selectTeacherById(id);
		if(model!=null) {
			List<CertificateInfo> list = roleTeacherArchivesMapper.selectcertificateList(id, 4);
			if(list.size()>0) {
				model.setCertificateList(list);
			}
		}
		return model;
	}
	
	public List<TeacherCertificateVo> selectTeacherCertificate(String name,String idCard,Integer type,Integer certificateType){
		return  roleTeacherArchivesMapper.selectTeacherCertificate(name, idCard, type,certificateType);
	}

}
