package chinaPress.exam.exam.model;

/**
 * fc_exam_paper
 * @author Administrator
 * @date 2020-09-01 16:21:16
 */
public class FcExamPaper {
    /**
     * 考试试卷关联表
     */
    private Integer id;

    /**
     * 考试id
     */
    private Integer examId;

    /**
     * 试卷id
     */
    private Integer paperId;

    /**
     * 考试试卷关联表
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 考试试卷关联表
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
}