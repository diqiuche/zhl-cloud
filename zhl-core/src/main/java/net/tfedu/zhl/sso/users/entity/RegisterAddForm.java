package net.tfedu.zhl.sso.users.entity;

public class RegisterAddForm {
	
	 
	/**
	 * 必选  登录名
	 */
    String userName ;
    /**
     * 必选  真实姓名
     */
    String trueName ;
    /**
     * 必选  呢称
     */
    String nickName ;
    /**
     * 必选  性别  true 女  false  男
     */
    boolean sex ;
	/**
	 * 必选  1 学生   2  老师 
	 */
	long role;
	
	/**
	 * 必选  格言
	 */
	String motto;
	
	/**
	 * 必选  生日
	 */
	String birthDate;

	/**
	 * 必选  省
	 */
	String provinceName;
	/**
	 * 必选  市
	 */
	String cityName;
	/**
	 * 必选  区
	 */
	String arealName;
	/**
	 * 必选  校
	 */
	String schoolName;
	
	
	
	/**
	 * 学段
	 */
	String termName;
	
	
	/**
	 * 学科
	 */
	String subjectName;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public long getRole() {
		return role;
	}
	public void setRole(long role) {
		this.role = role;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getArealName() {
		return arealName;
	}
	public void setArealName(String arealName) {
		this.arealName = arealName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getTermName() {
		return termName;
	}
	public void setTermName(String termName) {
		this.termName = termName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	

}
