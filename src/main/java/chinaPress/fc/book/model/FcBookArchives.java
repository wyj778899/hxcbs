package chinaPress.fc.book.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import chinaPress.fc.book_catalog.model.FcBookCatalog;
import chinaPress.fc.book_content.model.FcBookContent;

/**
 * fc_book_archives
 * @author Administrator
 * @date 2020-07-02 14:28:41
 */
public class FcBookArchives {
    /**
     * id
     */
    private Integer id;

    /**
     * 书籍名称
     */
    private String name;

    /**
     * 书籍图片
     */
    private String picture;

    /**
     * 书籍价格
     */
    private BigDecimal price;

    /**
     * 书籍二维码
     */
    private String qrcode;

    /**
     * 几套
     */
    private String sets;
    
    /**
     * 20200717   wyj add   添加  作者，开本，页码，isbn，版次，出版社  字段
     * 作者
     */
    private String author;
    
    /**
     * 开本
     */
    private Integer size;
    
    /**
     * 页码
     */
    private Integer page;
    
    /**
     * isbn
     */
    private String isbn;
    
    /**
     * 版次
     */
    private String edition;
    
    /**
     * 出版社
     */
    private String press;

    /**
     * 书籍创建人
     */
    private Integer createId;

    /**
     * 书籍创建时间
     */
    private Date createTime;

    /**
     * 书籍最后更新人
     */
    private Integer updateId;

    /**
     * 书籍最后更新时间
     */
    private Date updateTime;
    
    
    /**
     * 编辑推荐
     */
    private String editRecommend;

    /**
     * 内容介绍
     */
    private String contentIntroduce;
    
    /**
     * 作者介绍
     */
    private String authorIntroduce;
    
    /**
     * 介绍
     */
    private String introduce;
    /**
     * 书籍目录
     */
    private List<FcBookCatalog> catalogs;   
    
    /**
     * 书籍内容
     */
    private List<FcBookContent> contents;
    
    
    public String getEditRecommend() {
		return editRecommend;
	}

	public void setEditRecommend(String editRecommend) {
		this.editRecommend = editRecommend;
	}

	public String getContentIntroduce() {
		return contentIntroduce;
	}

	public void setContentIntroduce(String contentIntroduce) {
		this.contentIntroduce = contentIntroduce;
	}

	public String getAuthorIntroduce() {
		return authorIntroduce;
	}

	public void setAuthorIntroduce(String authorIntroduce) {
		this.authorIntroduce = authorIntroduce;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public List<FcBookCatalog> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<FcBookCatalog> catalogs) {
		this.catalogs = catalogs;
	}

	public List<FcBookContent> getContents() {
		return contents;
	}

	public void setContents(List<FcBookContent> contents) {
		this.contents = contents;
	}

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
     * 书籍名称
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 书籍名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 书籍图片
     * @return picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 书籍图片
     * @param picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 书籍价格
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 书籍价格
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 书籍二维码
     * @return qrcode
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * 书籍二维码
     * @param qrcode
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * 几套
     * @return sets
     */
    public String getSets() {
        return sets;
    }

    /**
     * 几套
     * @param sets
     */
    public void setSets(String sets) {
        this.sets = sets;
    }

    /**
     * 书籍创建人
     * @return createId
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * 书籍创建人
     * @param createId
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 书籍创建时间
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 书籍创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 书籍最后更新人
     * @return updateId
     */
    public Integer getUpdateId() {
        return updateId;
    }

    /**
     * 书籍最后更新人
     * @param updateId
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 书籍最后更新时间
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 书籍最后更新时间
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}
    
}