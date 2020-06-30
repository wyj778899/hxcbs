package chinaPress.fc.order.model;

/**
 * fc_order_person_hour
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
     * 小结是否通过：1.是，2.否
     */
    private Integer isPass;

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
     * @return orderPersonId
     */
    public Integer getOrderPersonId() {
        return orderPersonId;
    }

    /**
     * 订单人员id
     * @param orderPersonId
     */
    public void setOrderPersonId(Integer orderPersonId) {
        this.orderPersonId = orderPersonId;
    }

    /**
     * 视频id
     * @return hourId
     */
    public Integer getHourId() {
        return hourId;
    }

    /**
     * 视频id
     * @param hourId
     */
    public void setHourId(Integer hourId) {
        this.hourId = hourId;
    }

    /**
     * 小结是否通过：1.是，2.否
     * @return isPass
     */
    public Integer getIsPass() {
        return isPass;
    }

    /**
     * 小结是否通过：1.是，2.否
     * @param isPass
     */
    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }
}