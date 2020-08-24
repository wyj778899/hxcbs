package chinaPress.exam.exam.model;

/**
 * fc_exam_user
 * @author Administrator
 * @date 2020-08-24 18:03:58
 */
public class FcExamUser {
    /**
     */
    private Integer id;

    /**
     * 考试id
     */
    private Integer examId;

    /**
     * 考试报名人员id
     */
    private Integer signupUserId;

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
     * 考试报名人员id
     * @return signupUserId
     */
    public Integer getSignupUserId() {
        return signupUserId;
    }

    /**
     * 考试报名人员id
     * @param signupUserId
     */
    public void setSignupUserId(Integer signupUserId) {
        this.signupUserId = signupUserId;
    }
}