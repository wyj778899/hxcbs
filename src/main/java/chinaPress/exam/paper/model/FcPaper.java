package chinaPress.exam.paper.model;

import java.util.Date;
import java.util.List;

import chinaPress.exam.paper.vo.PaperVo;

/**
 * fc_paper
 * @author wyj
 * @date 2020-08-18 19:30:36
 */
public class FcPaper {
    /**
     * 试卷表
     */
    private Integer id;

    /**
     * 试卷类型(1固定试题组卷,随机试题组卷)
     */
    private Integer paperType;

    /**
     * 试卷名称
     */
    private String paperName;

    /**
     * 备注(考试评语)
     */
    private String remarks;

    /**
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
     * 试卷和试题关联信息
     */
    private List<PaperVo> papers;

    public List<PaperVo> getPapers() {
		return papers;
	}

	public void setPapers(List<PaperVo> papers) {
		this.papers = papers;
	}

	/**
     * 试卷表
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 试卷表
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 试卷类型(1固定试题组卷,随机试题组卷)
     * @return paperType
     */
    public Integer getPaperType() {
        return paperType;
    }

    /**
     * 试卷类型(1固定试题组卷,随机试题组卷)
     * @param paperType
     */
    public void setPaperType(Integer paperType) {
        this.paperType = paperType;
    }

    /**
     * 试卷名称
     * @return paperName
     */
    public String getPaperName() {
        return paperName;
    }

    /**
     * 试卷名称
     * @param paperName
     */
    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    /**
     * 备注(考试评语)
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注(考试评语)
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return createId
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
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
}