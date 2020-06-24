package chinaPress.fc.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.order.model.FcOrderPerson;
import chinaPress.fc.order.vo.TerminalInstitutionOrderPersonParam;
import chinaPress.fc.order.vo.TerminalInstitutionOrderPersonVo;

@Mapper
@Repository
public interface FcOrderPersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcOrderPerson record);

    FcOrderPerson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcOrderPerson record);

    /**
     * 终端 查询订单人员数据数量
     * @param param
     * @return
     */
    int findTerminalCount(TerminalInstitutionOrderPersonParam param);
    
    /**
     * 终端 查询订单人员数据集合
     * @param param
     * @return
     */
    List<TerminalInstitutionOrderPersonVo> findTerminalList(TerminalInstitutionOrderPersonParam param);
    
}