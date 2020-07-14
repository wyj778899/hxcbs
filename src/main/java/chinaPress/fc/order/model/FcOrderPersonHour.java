package chinaPress.fc.order.model;

import java.util.Date;

/**
 * fc_order_person_hour
 * 
 * @author 53129
 * @date 2020-06-30 09:55:08
 */
public class FcOrderPersonHour {
	/**
	 */
	private Integer id;

	/**
	 * 订单人员id
	 */
	private Integer orderPersonId;

	/**
	 * 视频id
	 */
	private Integer hourId;

	/**
	 * 小结是否通过：1.已观看完且通过测试，2.已观看完未通过测试，0.只有观看权限，3.已观看完还未考试
	 */
	private Integer isPass;

	/**
	 * 小结通过时间
	 */
	private Date passTime;

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 订单人员id
	 * 
	 * @return orderPersonId
	 */
	public Integer getOrderPersonId() {
		return orderPersonId;
	}

	/**
	 * 订单人员id
	 * 
	 * @param orderPersonId
	 */
	public void setOrderPersonId(Integer orderPersonId) {
		this.orderPersonId = orderPersonId;
	}

	/**
	 * 视频id
	 * 
	 * @return hourId
	 */
	public Integer getHourId() {
		return hourId;
	}

	/**
	 * 视频id
	 * 
	 * @param hourId
	 */
	public void setHourId(Integer hourId) {
		this.hourId = hourId;
	}

	/**
	 * 小结是否通过：1.已观看完且通过测试，2.已观看完未通过测试，0.只有观看权限，3.已观看完还未考试
	 * 
	 * @return isPass
	 */
	public Integer getIsPass() {
		return isPass;
	}

	/**
	 * 小结是否通过：1.已观看完且通过测试，2.已观看完未通过测试，0.只有观看权限，3.已观看完还未考试
	 * 
	 * @param isPass
	 */
	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}

	/**
	 * 获取：passTime
	 */
	public Date getPassTime() {
		return passTime;
	}

	/**
	 * 设置：passTime
	 */
	public void setPassTime(Date passTime) {
		this.passTime = passTime;
	}
}