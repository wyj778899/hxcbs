package chinaPress.role.member.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.role.member.model.CertificateInfo;

@Mapper
@Repository
public interface CertificateInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(CertificateInfo record);

    CertificateInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CertificateInfo record);
    
}