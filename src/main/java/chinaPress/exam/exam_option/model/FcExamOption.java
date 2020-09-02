package chinaPress.exam.exam_option.model;

/**
 * fc_exam_option
 * @author wyj
 * @date 2020-09-02 14:35:31
 */
public class FcExamOption {
    /**
     * 考生考试答案信息表
     */
    private Integer id;

    /**
     * 考生id
     */
    private Integer userId;

    /**
     * 考试id
     */
    private Integer examId;

    /**
     * 试卷id
     */
    private Integer paperId;

    /**
     * 试题id
     */
    private Integer stemId;

    /**
     * 答案id
     */
    private String optionId;

    /**
     * 分数
     */
    private String grade;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否正确 1正确 0错误
     */
    private Integer isCorrect;

    /**
     * 考生考试答案信息表
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 考生考试答案信息表
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 考生id
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 考生id
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * 试卷id
     * @return paperId
     */
    public Integer getPaperId() {
        return paperId;
    }

    /**
     * 试卷id
     * @param paperId
     */
    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    /**
     * 试题id
     * @return stemId
     */
    public Integer getStemId() {
        return stemId;
    }

    /**
     * 试题id
     * @param stemId
     */
    public void setStemId(Integer stemId) {
        this.stemId = stemId;
    }

    /**
     * 答案id
     * @return optionId
     */
    public String getOptionId() {
        return optionId;
    }

    /**
     * 答案id
     * @param optionId
     */
    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    /**
     * 分数
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 分数
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 备注
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 是否正确 1正确 0错误
     * @return isCorrect
     */
    public Integer getIsCorrect() {
        return isCorrect;
    }

    /**
     * 是否正确 1正确 0错误
     * @param isCorrect
     */
    public void setIsCorrect(Integer isCorrect) {
        this.isCorrect = isCorrect;
    }
}