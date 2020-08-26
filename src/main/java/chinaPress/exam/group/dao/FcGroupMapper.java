package chinaPress.exam.group.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.group.model.FcGroup;
import chinaPress.exam.group.vo.GroupAndUser;
import chinaPress.exam.group.vo.GroupVo;

@Mapper
@Repository
public interface FcGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcGroup record);

    int insertSelective(FcGroup record);

    FcGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcGroup record);

    int updateByPrimaryKey(FcGroup record);
    
    /**
     * 查询分组名称信息用于用户添加和更新
     * @param groupName
     * @param id
     * @return
     */
    int selectByGroupName(@Param("groupName")String groupName,@Param("id")Integer id);
    
    /**
     * 通过id查询分组信息
     * @param id
     * @return
     */
    GroupVo selectByGroupId(Integer id);
    
    
    /**
     * 分组名称查询分组信息
     * @return
     */
    List<GroupAndUser> selectByNameLikeAll(@Param("groupName")String groupName,@Param("page")Integer page,@Param("limit")Integer limit);
    
    /**
     * 分组名称查询分组信息个数
     * @param groupName
     * @return
     */
    int selectByNameLikeAllCount(@Param("groupName")String groupName);
}