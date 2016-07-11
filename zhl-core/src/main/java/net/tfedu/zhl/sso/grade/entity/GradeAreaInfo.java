package net.tfedu.zhl.sso.grade.entity;



/**
 * 班级的地区信息
 * @author wangwr
 *
 */
public class GradeAreaInfo {

	  /**
     * 地区
     */
    private String districtname;
    
    /**
     * 市
     */
    private String cityname;
    
    /**
     * 省
     */
    private String provincename;
	
    /**
     * 学校名称
     */
    private String schoolname;

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getProvincename() {
		return provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	
    
    
}
