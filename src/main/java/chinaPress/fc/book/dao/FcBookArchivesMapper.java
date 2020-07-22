package chinaPress.fc.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.book.model.FcBookArchives;
import chinaPress.fc.book.vo.FcBookArchivesManageListVo;

@Mapper
@Repository
public interface FcBookArchivesMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcBookArchives record);

	int insertSelective(FcBookArchives record);

	FcBookArchives selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcBookArchives record);

	int updateByPrimaryKey(FcBookArchives record);

	/**
	 * id查询书籍信息，书籍信息包括书籍的内容和书籍的目录
	 * 
	 * @param id
	 * @return
	 */
	List<FcBookArchives> selectBookInfos(@Param("id") Integer id);

	/**
	 * 查询书籍档案个数
	 * 
	 * @author maguoliang
	 * @param name 书籍名称
	 * @return
	 */
	int selectBookArchivesCount(@Param("name") String name);

	/**
	 * 查询书籍档案列表
	 * 
	 * @author maguoliang
	 * @param name   书籍名称
	 * @param offset 从哪一条数据开始查询
	 * @param rows   查询多少条数据
	 * @return
	 */
	List<FcBookArchivesManageListVo> selectBookArchivesList(@Param("name") String name,
			@Param("offset") Integer offset, @Param("rows") Integer rows);
}