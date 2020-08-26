package chinaPress.exam.exam.model;

/**
 * fc_exam_area
 * @author Administrator
 * @date 2020-08-26 17:21:38
 */
public class FcExamArea {
    /**
     * 考试关联区域
     */
    private Integer id;

    /**
     * 考试id
     */
    private Integer examId;

    /**
     * 考试报名区域id
     */
    private Integer examSignupAreaId;

    /**
     * 考试关联区域
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 考试关联区域
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
}