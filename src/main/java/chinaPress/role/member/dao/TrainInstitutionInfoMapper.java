package chinaPress.role.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.role.member.model.TrainInstitutionInfo;
import chinaPress.role.member.vo.InstitutionAndEmpInfo;

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
    
    /**
     * 通过地区，机构名称查询机构信息
     * @param area  地区编码
     * @param name  公司名称
     * @param page  当前页数
     * @param limit 每页显示的条数
     * @return
     */
    List<InstitutionAndEmpInfo> selectInstAndEmpInfo(String area,String name,Integer page,Integer limit);
    
    
    /**
     * 通过地区，机构名称查询机构信息个数
     * @param area  地区编码
     * @param name  公司名称
     * @return
     */
    int selectInstAndEmpInfoCount(String area,String name);
}