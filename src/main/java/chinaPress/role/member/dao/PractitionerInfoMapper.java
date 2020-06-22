package chinaPress.role.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.role.member.model.PractitionerInfo;

@Mapper
@Repository
public interface PractitionerInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(PractitionerInfo record);

    PractitionerInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PractitionerInfo record);
    
    /**
     * 通过用户名，手机号，证件号查询家长/从业者信息
     * @param practitioner
     * @return
     */
    List<PractitionerInfo> selectPractitionerAll(PractitionerInfo practitioner);
    
    /**
     * 用于分页展示所有从业者/家长信息
     * @param practitioner
     * @return
     */
    int selectCount(PractitionerInfo practitioner);
}