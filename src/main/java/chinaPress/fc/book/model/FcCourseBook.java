package chinaPress.fc.book.model;

import java.util.Date;

/**
 * fc_course_book
 * @author Administrator
 * @date 2020-07-02 14:28:41
 */
public class FcCourseBook {
    /**
     * id
     */
    private Integer id;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 书籍id
     */
    private Integer bookId;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * id
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * id
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
     * 书籍id
     * @return bookId
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * 书籍id
     * @param bookId
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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
}