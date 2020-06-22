package chinaPress.common.param;

/**
 * 分页参数 使用方法：值为 null，不启用分页查询
 * <if test="pageNumber != null and pageSize != null">LIMIT #{offSet}, #{pageSize}</if>
 */
public class PageParam {
	private Integer pageNumber;
	private Integer pageSize;

	public Integer getOffSet() {
		return (pageNumber - 1) * pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
