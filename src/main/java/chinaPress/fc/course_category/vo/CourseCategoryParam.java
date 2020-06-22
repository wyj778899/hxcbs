package chinaPress.fc.course_category.vo;

import java.util.List;

public class CourseCategoryParam {
	private Integer notId;
	private Integer pId;
	private String code;
	private String name;
	private String checkedCode;
	private List<String> codeList;
	public String getCheckedCode() {
		return checkedCode;
	}
	public void setCheckedCode(String checkedCode) {
		this.checkedCode = checkedCode;
	}
	public Integer getNotId() {
		return notId;
	}
	public void setNotId(Integer notId) {
		this.notId = notId;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getCodeList() {
		return codeList;
	}
	public void setCodeList(List<String> codeList) {
		this.codeList = codeList;
	}
}
