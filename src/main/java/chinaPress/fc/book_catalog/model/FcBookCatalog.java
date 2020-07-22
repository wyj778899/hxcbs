package chinaPress.fc.book_catalog.model;

/**
 * fc_book_catalog
 * @author wyj
 * @date 2020-07-17 14:31:19
 */
public class FcBookCatalog {
    /**
     * 书籍的章节目录
     */
    private Integer id;

    /**
     * 书籍id
     */
    private Integer bookId;

    /**
     * 目录图片支持多张上传
     */
    private String catalogPhoto;

    /**
     * 图片编号
     */
    private String photoSort;

    /**
     * 书籍的章节目录
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 书籍的章节目录
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
     * 目录图片支持多张上传
     * @return catalogPhoto
     */
    public String getCatalogPhoto() {
        return catalogPhoto;
    }

    /**
     * 目录图片支持多张上传
     * @param catalogPhoto
     */
    public void setCatalogPhoto(String catalogPhoto) {
        this.catalogPhoto = catalogPhoto;
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