package chinaPress.fc.apply.dao;

import chinaPress.fc.apply.model.FcApplyPerson;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcApplyPersonMapper {
	int deleteByPrimaryKey(Integer id);

	int insertSelective(FcApplyPerson record);

	FcApplyPerson selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcApplyPerson record);

	List<FcApplyPerson> findByApplyId(Integer applyId);

}