package chinaPress.role.member.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.role.member.model.CertificateInfo;
import chinaPress.role.member.vo.CertVo;

@Mapper
@Repository
public interface CertificateInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(CertificateInfo record);

    CertificateInfo selectByPrimaryKey(Integer id);
    
    CertVo selectById(Integer id);

    int updateByPrimaryKeySelective(CertificateInfo record);
    
    CertificateInfo selectByCode(String code);
    
}