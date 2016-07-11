package net.tfedu.zhl.cloud.teaching.discuss.entity;

import java.util.Date;

/**
 * 后台查询结果实体类
 * @author wangwr
 *
 */
public class TDiscussRecommendQueryBack {
    private Long id;

    /**
     * 班级名称
     */
    private String classname;

    /**
     * 学校的id或主键
     */
    private String classid;

    /**
     * 班级图片
     */
    private String classimage;

    /**
     * 学校名称
     */
    private String schoolname;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 资源的推荐人
     */
    private Long creator;

    /**
     * 0有效；1逻辑删除
     */
    private Boolean flag;

    /**
     * 访问链接默认为空
     */
    private String classurl;

    private String note;
    
    
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getClassimage() {
		return classimage;
	}

	public void setClassimage(String classimage) {
		this.classimage = classimage;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getClassurl() {
		return classurl;
	}

	public void setClassurl(String classurl) {
		this.classurl = classurl;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

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
    
	
	
	
	
	
}
