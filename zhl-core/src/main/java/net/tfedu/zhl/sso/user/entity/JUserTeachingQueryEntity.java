package net.tfedu.zhl.sso.user.entity;

/**
 * 用户教研平台查询结果
 * @author wangwr
 *
 */
public class JUserTeachingQueryEntity {

	/**
	 * 用户id
	 */
	String id ;

	
	/**
	 * 用户名
	 */
	String name ;
	
	/**
	 * 真实姓名
	 */
	String trueName;
	
	
	/**
	 * 学校名
	 */
	String schoolName;
	
	/**
	 * 地区名
	 */
	String districtName;
	
	/**
	 * 市名
	 */
	String cityName ;
	
	/**
	 * 省名
	 */
	String provinceName;
	
	/**
	 * 性别名     0 女  1 男 
	 */
	Boolean male;
	
	/**
	 * 角色名
	 */
	String roleName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Boolean getMale() {
		return male;
	}

	public void setMale(Boolean male) {
		this.male = male;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

}
