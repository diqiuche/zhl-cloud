package net.tfedu.zhl.sso.thirdpartyAPI.jnzx.entity;

/**
 * 班级信息
 * @author wangwr
 
  				"GRADE_NAME": "六年级",
                "CLASS_NAME": "六（4）班",
                "GRADE_ID": "6",
                "CLASS_ID": "476"
 */
public class ZXClassEntity {

	
	/**
	 * 年级
	 */
	public String GRADE_NAME;
	/**
	 * 班级 
	 */
	public String CLASS_NAME;
	
	
	/**年级ID
	 * 
	 */
	public String GRADE_ID;
	/**
	 * 班级 ID
	 */
	public String CLASS_ID;
	public String getGRADE_NAME() {
		return GRADE_NAME;
	}
	public void setGRADE_NAME(String gRADE_NAME) {
		GRADE_NAME = gRADE_NAME;
	}
	public String getCLASS_NAME() {
		return CLASS_NAME;
	}
	public void setCLASS_NAME(String cLASS_NAME) {
		CLASS_NAME = cLASS_NAME;
	}
	public String getGRADE_ID() {
		return GRADE_ID;
	}
	public void setGRADE_ID(String gRADE_ID) {
		GRADE_ID = gRADE_ID;
	}
	public String getCLASS_ID() {
		return CLASS_ID;
	}
	public void setCLASS_ID(String cLASS_ID) {
		CLASS_ID = cLASS_ID;
	}
}
