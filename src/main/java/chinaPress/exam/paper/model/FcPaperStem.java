package chinaPress.exam.paper.model;

/**
 * fc_paper_stem
 * @author wyj
 * @date 2020-08-18 19:30:36
 */
public class FcPaperStem {
    /**
     * 试卷关联试题表
     */
    private Integer id;

    /**
     * 试卷id
     */
    private Integer paperId;

    /**
     * 试题id
     */
    private Integer stemId;

    /**
     * 使用分数
     */
    private String useGrade;

    /**
     * 试卷关联试题表
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 试卷关联试题表
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 使用分数
     * @return useGrade
     */
    public String getUseGrade() {
        return useGrade;
    }

    /**
     * 使用分数
     * @param useGrade
     */
    public void setUseGrade(String useGrade) {
        this.useGrade = useGrade;
    }
}