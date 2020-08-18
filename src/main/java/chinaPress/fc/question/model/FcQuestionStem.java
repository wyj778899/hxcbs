package chinaPress.fc.question.model;

import java.util.Date;
import java.util.List;

/**
 * fc_question_stem
 * @author Administrator
 * @date 2020-06-18 16:48:19
 */
public class FcQuestionStem {
    /**
     * 题库
     */
    private Integer id;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 课时id
     */
    private Integer hourId;

    /**
     * 类型（1.单选2.多选3.判断）
     */
    private Integer questionType;

    /**
     * 题目难度(1.简单2.一般3.困难)
     */
    private Integer taskDifficulty;

    /**
     * 题干
     */
    private String questionStem;

    /**
     * 1.删除0.不可以删除
     */
    private Integer isDelete;

    /**
     * 状态(0.否,1.是)
     */
    private Integer state;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private Integer updateId;

    /**
     * 更新时间
     */
    private Date updateTime;
    
    /**
     * 书籍分类id
     */
    private Integer catalogId;
    
    /**
     * 视频解析
     */
    private String analysis;
    
    /**
     * 1.小结2.自测,3考试
     */
    private Integer type;
    
    /**
     * 分数
     */
    private String grade;
    
    private List<FcQuestionOption> optionList;

    public List<FcQuestionOption> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<FcQuestionOption> optionList) {
		this.optionList = optionList;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	/**
     * 题库
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 题库
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 课程id
     * @return courseId
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 课程id
     * @param courseId
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 课时id
     * @return hourId
     */
    public Integer getHourId() {
        return hourId;
    }

    /**
     * 课时id
     * @param hourId
     */
    public void setHourId(Integer hourId) {
        this.hourId = hourId;
    }

    /**
     * 类型（1.单选2.多选3.判断）
     * @return questionType
     */
    public Integer getQuestionType() {
        return questionType;
    }

    /**
     * 类型（1.单选2.多选3.判断）
     * @param questionType
     */
    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    /**
     * 题目难度(1.简单2.一般3.困难)
     * @return taskDifficulty
     */
    public Integer getTaskDifficulty() {
        return taskDifficulty;
    }

    /**
     * 题目难度(1.简单2.一般3.困难)
     * @param taskDifficulty
     */
    public void setTaskDifficulty(Integer taskDifficulty) {
        this.taskDifficulty = taskDifficulty;
    }

    /**
     * 题干
     * @return questionStem
     */
    public String getQuestionStem() {
        return questionStem;
    }

    /**
     * 题干
     * @param questionStem
     */
    public void setQuestionStem(String questionStem) {
        this.questionStem = questionStem;
    }

    /**
     * 1.删除0.不可以删除
     * @return isDelete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 1.删除0.不可以删除
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 状态(0.否,1.是)
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态(0.否,1.是)
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 创建人
     * @return createId
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * 创建人
     * @param createId
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 创建时间
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新人
     * @return updateId
     */
    public Integer getUpdateId() {
        return updateId;
    }

    /**
     * 更新人
     * @param updateId
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 更新时间
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
    
}