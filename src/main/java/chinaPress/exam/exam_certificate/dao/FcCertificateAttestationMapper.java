package chinaPress.exam.exam_certificate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.exam_certificate.model.FcCertificateAttestation;
import chinaPress.exam.exam_certificate.vo.ExamCertificate;
import chinaPress.exam.exam_certificate.vo.UserCertificate;

@Mapper
@Repository
public interface FcCertificateAttestationMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcCertificateAttestation record);

    FcCertificateAttestation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcCertificateAttestation record);
    
    /**
     * 所有证书信息
     * @return
     */
    List<ExamCertificate> selectCertAll(@Param("page")Integer page,@Param("limit")Integer limit);
    
    /**
     * 所有证书个数
     * @return
     */
    int selectCertAllCount();
    
    /**
     * 查询证书名称个数
     * @param name
     * @param id
     * @return
     */
    int selectCertName(@Param("name")String name,@Param("id")Integer id);
    
    /**
     * 通过角色类型和角色id查询用户考试发放的证书信息
     * @param roleId
     * @param roleType
     * @return
     */
    List<UserCertificate> selectCertificates(@Param("roleId")Integer roleId,@Param("roleType")Integer roleType);
}