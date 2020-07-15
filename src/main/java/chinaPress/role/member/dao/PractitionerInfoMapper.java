package chinaPress.role.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.role.member.model.PractitionerInfo;
import chinaPress.role.member.vo.PractitionerApplyInfoVo;
import chinaPress.role.member.vo.PractitionerEmps;
import chinaPress.role.member.vo.PractitionerParent;
import chinaPress.role.member.vo.TeacherAndCertVo;
import chinaPress.role.member.vo.TeacherCerInfos;
import chinaPress.role.member.vo.TeacherCertVo;
import chinaPress.role.member.vo.TeacherScoreVo;

@Mapper
@Repository
public interface PractitionerInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(PractitionerInfo record);

    PractitionerInfo selectByPrimaryKey(Integer id);
    
    /**
     * 根据身份证号查询
     * @param record
     * @return
     */
    PractitionerInfo selectByCertificate(String certificateNumber);

    int updateByPrimaryKeySelective(PractitionerInfo record);
    
    /**
     * 查询申请人员信息
     * @param id
     * @return
     */
    PractitionerApplyInfoVo findApplyInfo(Integer id);
    
    /**
     * 通过用户名，手机号，证件号查询家长信息
     * @param practitioner
     * @return
     */
    List<PractitionerParent> selectPractitionerParents(PractitionerInfo practitioner);
    
    /**
     * 通过用户名，手机号，证件号查询家长信息
     * @param practitioner
     * @return
     */
    List<PractitionerEmps> selectPractitionerEmps(PractitionerInfo practitioner);
    
    /**
     * 用于分页展示所有从业者/家长信息
     * @param practitioner
     * @return
     */
    int selectCount(PractitionerInfo practitioner);
    
    /**
     * 通过姓名和身份证号查询教师信息      从业者又是老师
     * @param  teacherScoreVo
     * @return
     */
    List<TeacherScoreVo> selectTeacherAndScore(PractitionerInfo practitioner);
    
    
    /**
     * 通过姓名和身份证号查询教师信息个数
     * @param teacherScoreVo
     * @return
     */
    int selectTeacherAndScoreCount(PractitionerInfo practitioner);
    
    /**
     * 通过姓名，身份证号，证书编号查询教师信息
     * @param teacherCertVo
     * @return
     */
    List<TeacherCertVo> selectTeacherAndCert(PractitionerInfo practitioner);
    
    /**
     * 通过姓名，身份证号，证书编号查询教师信息个数
     * @param teacherCertVo
     * @return
     */
    int selectTeacherAndCertCount(PractitionerInfo practitioner);
    
    /**
     * 通过姓名，证书类型，证书编号查询教师信息
     * @param teacherCertVo
     * @return
     */
    List<TeacherAndCertVo> selectTeacherAndCertInfos(PractitionerInfo practitioner);
    
    /**
     * 通过姓名，证书类型，证书编号查询教师信息个数
     * @param teacherCertVo
     * @return
     */
    int selectTeacherAndCertInfosCount(PractitionerInfo practitioner);
    
    
    /**
     * 通过教师id查询教师信息
     * @param teaId
     * @return
     */
    TeacherCerInfos selectTeacherByCers(@Param("teaId")Integer teaId);
}