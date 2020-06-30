package chinaPress.role.member.vo;

/**
 * 机构信息查询
 * @author wyj
 *
 */
public class InstitutionAndEmpInfo {

	/**
	 * 办公省
	 */
	private String area;
	
	/**
	 * 公司名称
	 */
	private String name;
	
	/**
	 * 从业人员个数
	 */
	private Integer count;
	
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	
	
	
}
