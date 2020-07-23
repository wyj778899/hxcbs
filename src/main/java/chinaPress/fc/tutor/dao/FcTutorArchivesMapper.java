package chinaPress.fc.tutor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.tutor.model.FcTutorArchives;
import chinaPress.fc.tutor.vo.FcTurorArchivesManageDetailVo;
import chinaPress.fc.tutor.vo.FcTurorArchivesManageListVo;

@Mapper
@Repository
public interface FcTutorArchivesMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcTutorArchives record);

	int insertSelective(FcTutorArchives record);

	FcTutorArchives selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcTutorArchives record);

	int updateByPrimaryKey(FcTutorArchives record);

	/**
	 * 查询导师档案个数
	 * 
	 * @author maguoliang
	 * @param name 导师姓名
	 * @return
	 */
	int selectFcTutorArchivesCount(@Param("name") String name);

	/**
	 * 查询导师档案列表
	 * 
	 * @author maguoliang
	 * @param name   导师姓名
	 * @param offset 从第几条数据开始查询
	 * @param rows   查询多少条数据
	 * @return
	 */
	List<FcTurorArchivesManageListVo> selectFcTutorArchivesList(@Param("name") String name,
			@Param("offset") Integer offset, @Param("rows") Integer rows);

	/**
	 * 查询详情
	 * 
	 * @author maguoliang
	 * @param id
	 * @return
	 */
	FcTurorArchivesManageDetailVo selectFcTutorArchivesDetail(Integer id);
}