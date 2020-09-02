package chinaPress.exam.exam_record.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * fc_exam_record
 * @author wyj
 * @date 2020-09-01 14:28:01
 */
public class FcExamRecord {
    /**
     * 考生考试记录表
     */
    private Integer id;

    /**
     * 考试id
     */
    private Integer examId;

    /**
     * 考试报名id
     */
    private Integer examSignupId;

    /**
     * 考试报名区域id
     */
    private Integer examSignupAreaId;

    /**
     * 考试报名用户id
     */
    private Integer signupUserId;

    /**
     * 签到时间
     */
    private Date reportTime;

    /**
     * 交卷时间
     */
    private Date completeTime;

    /**
     * 分数
     */
    private BigDecimal grade;

    /**
     * 考生考试记录表
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 考生考试记录表
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 考试id
     * @return examId
     */
    public Integer getExamId() {
        return examId;
    }

    /**
     * 考试id
     * @param examId
     */
    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    /**
     * 考试报名id
     * @return examSignupId
     */
    public Integer getExamSignupId() {
        return examSignupId;
    }

    /**
     * 考试报名id
     * @param examSignupId
     */
    public void setExamSignupId(Integer examSignupId) {
        this.examSignupId = examSignupId;
    }

    /**
     * 考试报名区域id
     * @return examSignupAreaId
     */
    public Integer getExamSignupAreaId() {
        return examSignupAreaId;
    }

    /**
     * 考试报名区域id
     * @param examSignupAreaId
     */
    public void setExamSignupAreaId(Integer examSignupAreaId) {
        this.examSignupAreaId = examSignupAreaId;
    }

    /**
     * 考试报名用户id
     * @return signupUserId
     */
    public Integer getSignupUserId() {
        return signupUserId;
    }

    /**
     * 考试报名用户id
     * @param signupUserId
     */
    public void setSignupUserId(Integer signupUserId) {
        this.signupUserId = signupUserId;
    }

    /**
     * 签到时间
     * @return reportTime
     */
    public Date getReportTime() {
        return reportTime;
    }

    /**
     * 签到时间
     * @param reportTime
     */
    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    /**
     * 交卷时间
     * @return completeTime
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * 交卷时间
     * @param completeTime
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    /**
     * 分数
     * @return grade
     */
    public BigDecimal getGrade() {
        return grade;
    }

    /**
     * 分数
     * @param grade
     */
    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }
}