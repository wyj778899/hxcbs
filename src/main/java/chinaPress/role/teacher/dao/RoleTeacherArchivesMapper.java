package chinaPress.role.teacher.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.role.member.model.CertificateInfo;
import chinaPress.role.teacher.model.RoleTeacherArchives;
import chinaPress.role.teacher.vo.TeacherArchivesParam;
import chinaPress.role.teacher.vo.TeacherCertificateVo;

@Mapper
@Repository
public interface RoleTeacherArchivesMapper {
	
	/**
	 * 根据id查询教师详情
	 * @param id
	 * @return
	 */
	TeacherArchivesParam selectTeacherById(Integer id);
	
	List<TeacherCertificateVo> selectTeacherCertificate(String name,String idCard,Integer type,Integer certificateType);
	
	List<CertificateInfo> selectcertificateList(Integer roleId,Integer roleType);
	
    int deleteByPrimaryKey(Integer id);

    int insertSelective(RoleTeacherArchives record);

    RoleTeacherArchives selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleTeacherArchives record);
}