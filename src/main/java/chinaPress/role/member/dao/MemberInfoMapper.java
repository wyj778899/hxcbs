package chinaPress.role.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.role.member.model.MemberInfo;
import chinaPress.role.member.vo.MemberAndCer;
import chinaPress.role.member.vo.MemberCouponInfo;
import chinaPress.role.member.vo.UserAndCerVo;

@Mapper
@Repository
public interface MemberInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(MemberInfo memberInfo);

    MemberInfo selectByPrimaryKey(MemberInfo memberInfo);
    
    int updateByPrimaryKeySelective(MemberInfo memberInfo);
    
    /**
     * 根据手机号查询从业者
     * @param tellPhone
     * @return
     */
    int findPractitionerByTellPhone(String tellPhone);
    
    /**
     * 根据员工用户名，手机号，证书类型，审核状态查询用户的证书信息
     * @param m
     * @return
     */
    List<MemberAndCer> selectMemberAndCertificate(MemberInfo memberInfo);
    
    /**
     * 根据员工用户名，手机号，证书类型，审核状态查询用户的证书个数
     * @return
     */
    int queryCerCount(MemberInfo memberInfo);
    
    
    /**
     * 通过证书编号查询证书和用户的关联信息
     * @param id
     * @return
     */
    MemberAndCer selectByCerId(Integer id);
    
    /**
     * 通过手机号和用户名模糊查询员工信息
     * @param memberInfo
     * @return
     */
    List<MemberCouponInfo> selectNameAndTell(MemberInfo memberInfo);
    
    /**
     * 通过手机号和用户名模糊查询员工信息的个数，用于分页展示
     * @param memberInfo
     * @return
     */
    int selectNameAndTellCount(MemberInfo memberInfo);
    
    /**
     * 通过角色类型和角色id 查询用户证书信息
     * @param roleId
     * @param roleType
     * @return
     */
    List<UserAndCerVo> selectUserAndCers(Integer roleId,Integer roleType);
    
    
    /**
     * 通过角色类型和角色id 查询用户证书信息个数
     * @param roleId
     * @param roleType
     * @return
     */
    int selectUserAndCerCounts(Integer roleId,Integer roleType);
    
    
    /**
     * 通过用户名和手机号查询用户信息排除当前条     返回个数
     * @param memberInfo
     * @return
     */
    int selectUserAndTellPhone(MemberInfo memberInfo);
}