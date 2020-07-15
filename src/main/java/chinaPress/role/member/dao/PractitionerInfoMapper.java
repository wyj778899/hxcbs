package chinaPress.role.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.role.member.model.PractitionerInfo;
import chinaPress.role.member.vo.PractitionerApplyInfoVo;
import chinaPress.role.member.vo.PractitionerEmps;
import chinaPress.role.member.vo.PractitionerParent;

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
}