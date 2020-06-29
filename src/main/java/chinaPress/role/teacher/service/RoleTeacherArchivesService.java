package chinaPress.role.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.role.teacher.dao.RoleTeacherArchivesMapper;
import chinaPress.role.teacher.vo.TeacherCertificateVo;

@Service
public class RoleTeacherArchivesService {
	
	@Autowired
	private RoleTeacherArchivesMapper roleTeacherArchivesMapper;
	
	public List<TeacherCertificateVo> selectTeacherCertificate(String name,String idCard,Integer type,Integer certificateType){
		return  roleTeacherArchivesMapper.selectTeacherCertificate(name, idCard, type,certificateType);
	}

}
