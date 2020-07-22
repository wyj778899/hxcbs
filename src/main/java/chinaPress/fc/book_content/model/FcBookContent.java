package chinaPress.fc.book_content.model;

/**
 * fc_book_content
 * @author wyj
 * @date 2020-07-17 14:32:29
 */
public class FcBookContent {
    /**
     * 书籍的内容信息
     */
    private Integer id;

    /**
     * 书籍id
     */
    private Integer bookId;

    /**
     * 内容图片支持多张上传
     */
    private String contentPhoto;

    /**
     * 图片编号
     */
    private String photoSort;

    /**
     * 书籍的内容信息
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 书籍的内容信息
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 内容图片支持多张上传
     * @return contentPhoto
     */
    public String getContentPhoto() {
        return contentPhoto;
    }

    /**
     * 内容图片支持多张上传
     * @param contentPhoto
     */
    public void setContentPhoto(String contentPhoto) {
        this.contentPhoto = contentPhoto;
    }

    /**
     * 图片编号
     * @return photoSort
     */
    public String getPhotoSort() {
        return photoSort;
    }

    /**
     * 图片编号
     * @param photoSort
     */
    public void setPhotoSort(String photoSort) {
        this.photoSort = photoSort;
    }
}