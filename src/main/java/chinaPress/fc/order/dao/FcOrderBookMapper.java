package chinaPress.fc.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.book.vo.FcCourseBookVo;
import chinaPress.fc.order.model.FcOrderBook;

@Mapper
@Repository
public interface FcOrderBookMapper {
	int deleteByOrderId(Integer orderId);

	int insertSelective(FcOrderBook record);

	FcOrderBook selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcOrderBook record);

	List<Integer> findBookIds(Integer orderId);

	/**
	 * 根据订单id查询订单关联的书籍信息
	 * 
	 * @author maguoliang
	 * @param orderId
	 * @return
	 */
	List<FcCourseBookVo> selectBookByOrderId(Integer orderId);
}