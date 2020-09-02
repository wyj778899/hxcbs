package chinaPress.exam.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.exam.model.FcExamArea;
import chinaPress.exam.exam.vo.FcExamManageAreaListVo;

@Mapper
@Repository
public interface FcExamAreaMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcExamArea record);

	int insertSelective(FcExamArea record);

	FcExamArea selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcExamArea record);

	int updateByPrimaryKey(FcExamArea record);

	/**
	 * 根据考试id删除
	 * 
	 * @param examId
	 * @return
	 */
	int deleteByFcExamId(Integer examId);

	/**
	 * 查询考试设置下的考试区域
	 * 
	 * @param examId    考试id
	 * @param province  省
	 * @param city      市
	 * @param district  区
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @param status    考试状态1.未开始2.进行中3.已结束
	 * @return
	 */
	int selectFcExamAreaCount(@Param("examId") Integer examId, @Param("province") String province,
			@Param("city") String city, @Param("district") String district, @Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("status") Integer status);

	/**
	 * 查询考试设置下的考试区域
	 * 
	 * @param examId    考试id
	 * @param province  省
	 * @param city      市
	 * @param district  区
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @param status    考试状态1.未开始2.进行中3.已结束
	 * @param offset    从哪一条数据开始查询
	 * @param rows      查询多少条
	 * @return
	 */
	List<FcExamManageAreaListVo> selectFcExamAreaList(@Param("examId") Integer examId,
			@Param("province") String province, @Param("city") String city, @Param("district") String district,
			@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") Integer status,
			@Param("offset") Integer offset, @Param("rows") Integer rows);
}