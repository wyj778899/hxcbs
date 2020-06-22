package chinaPress.role.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.role.member.model.TrainInstitutionInfo;

@Mapper
@Repository
public interface TrainInstitutionInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TrainInstitutionInfo trainInstitutionInfo);

    TrainInstitutionInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainInstitutionInfo trainInstitutionInfo);

    /**
     * 通过公司名称，企业编码，企业法人，注册人手机号查询培训机构信息
     * @param t
     * @return
     */
    List<TrainInstitutionInfo> selectTrainInstitutionAll(TrainInstitutionInfo trainInstitutionInfo);
    
    /**
     * 通过公司名称，企业编码，企业法人，注册人手机号查询培训机构个数
     * @return
     */
    int selectCount(TrainInstitutionInfo trainInstitutionInfo);
}