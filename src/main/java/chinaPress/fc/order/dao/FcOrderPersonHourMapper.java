package chinaPress.fc.order.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.order.model.FcOrderPersonHour;
import io.lettuce.core.dynamic.annotation.Param;

@Mapper
@Repository
public interface FcOrderPersonHourMapper {

	int insertSelective(FcOrderPersonHour record);

	FcOrderPersonHour selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcOrderPersonHour record);

	/**
	 * 修改是否通过
	 * 
	 * @param record
	 * @return
	 */
	int updateIsPass(FcOrderPersonHour record);

	/**
	 * 查询某课程第一次自测通过的时间
	 * 
	 * @author maguoliang
	 * @param courseId 课程id
	 * @param roleId   角色id
	 * @param roleType 角色类型1.家长2.从业者
	 * @return
	 */
	Date selectCourseFirstPassTime(@Param("courseId") Integer courseId, @Param("roleId") Integer roleId,
			@Param("roleType") Integer roleType);

	/**
	 * 根据orderPersonId和hourId查询
	 * 
	 * @author maguoliang
	 * @param orderPersonId 订单人员表id
	 * @param hourId        课时id
	 * @return
	 */
	FcOrderPersonHour selectByOrderPersonAndHour(@Param("orderPersonId") Integer orderPersonId,
			@Param("hourId") Integer hourId);

	/**
	 * 查询某个人正在学习某课程的最新进度
	 * 
	 * @author maguoliang
	 * @param courseId 课程id
	 * @param roleId   角色id
	 * @param roleType 角色类型1.家长2.从业者
	 * @return
	 */
	FcOrderPersonHour selectTheNewestHour(@Param("courseId") Integer courseId, @Param("roleId") Integer roleId,
			@Param("roleType") Integer roleType);
}