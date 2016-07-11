package net.tfedu.zhl.sso.school.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "j_school")
public class JSchool implements Serializable {
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学校所在区域
     */
    @Column(name = "districtId")
    private String districtid;

    /**
     * 校名
     */
    private String name;

    /**
     * 校长手机联系方式
     */
    @Column(name = "MasterPhone")
    private String masterphone;

    /**
     * 办公室电话
     */
    @Column(name = "OfficePhone")
    private String officephone;

    /**
     * 传真
     */
    @Column(name = "Fax")
    private String fax;

    /**
     * 地址
     */
    @Column(name = "Address")
    private String address;

    /**
     * 学校的创建时间
     */
    @Column(name = "CreateDate")
    private Date createdate;

    /**
     * 邮编号码
     */
    @Column(name = "PostNo")
    private String postno;

    /**
     * 学校评价
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 学校简介
     */
    @Column(name = "Brief")
    private String brief;

    /**
     * 学校图片路径
     */
    @Column(name = "PicPath")
    private String picpath;

    /**
     * 是否删除标示，0-----未删除；1----删除
     */
    @Column(name = "Flag")
    private Boolean flag;

    public JSchool(Long id, String districtid, String name, String masterphone, String officephone, String fax, String address, Date createdate, String postno, String remark, String brief,
            String picpath, Boolean flag) {
        this.id = id;
        this.districtid = districtid;
        this.name = name;
        this.masterphone = masterphone;
        this.officephone = officephone;
        this.fax = fax;
        this.address = address;
        this.createdate = createdate;
        this.postno = postno;
        this.remark = remark;
        this.brief = brief;
        this.picpath = picpath;
        this.flag = flag;
    }

    public JSchool() {
        super();
    }

    /**
     * 获取自增id
     *
     * @return Id - 自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id
     *            自增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取学校所在区域
     *
     * @return districtId - 学校所在区域
     */
    public String getDistrictid() {
        return districtid;
    }

    /**
     * 设置学校所在区域
     *
     * @param districtid
     *            学校所在区域
     */
    public void setDistrictid(String districtid) {
        this.districtid = districtid == null ? null : districtid.trim();
    }

    /**
     * 获取校名
     *
     * @return name - 校名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置校名
     *
     * @param name
     *            校名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取校长手机联系方式
     *
     * @return MasterPhone - 校长手机联系方式
     */
    public String getMasterphone() {
        return masterphone;
    }

    /**
     * 设置校长手机联系方式
     *
     * @param masterphone
     *            校长手机联系方式
     */
    public void setMasterphone(String masterphone) {
        this.masterphone = masterphone == null ? null : masterphone.trim();
    }

    /**
     * 获取办公室电话
     *
     * @return OfficePhone - 办公室电话
     */
    public String getOfficephone() {
        return officephone;
    }

    /**
     * 设置办公室电话
     *
     * @param officephone
     *            办公室电话
     */
    public void setOfficephone(String officephone) {
        this.officephone = officephone == null ? null : officephone.trim();
    }

    /**
     * 获取传真
     *
     * @return Fax - 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真
     *
     * @param fax
     *            传真
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * 获取地址
     *
     * @return Address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address
     *            地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取学校的创建时间
     *
     * @return CreateDate - 学校的创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置学校的创建时间
     *
     * @param createdate
     *            学校的创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取邮编号码
     *
     * @return PostNo - 邮编号码
     */
    public String getPostno() {
        return postno;
    }

    /**
     * 设置邮编号码
     *
     * @param postno
     *            邮编号码
     */
    public void setPostno(String postno) {
        this.postno = postno == null ? null : postno.trim();
    }

    /**
     * 获取学校评价
     *
     * @return Remark - 学校评价
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置学校评价
     *
     * @param remark
     *            学校评价
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取学校简介
     *
     * @return Brief - 学校简介
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 设置学校简介
     *
     * @param brief
     *            学校简介
     */
    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    /**
     * 获取学校图片路径
     *
     * @return PicPath - 学校图片路径
     */
    public String getPicpath() {
        return picpath;
    }

    /**
     * 设置学校图片路径
     *
     * @param picpath
     *            学校图片路径
     */
    public void setPicpath(String picpath) {
        this.picpath = picpath == null ? null : picpath.trim();
    }

    /**
     * 获取是否删除标示，0-----未删除；1----删除
     *
     * @return Flag - 是否删除标示，0-----未删除；1----删除
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除标示，0-----未删除；1----删除
     *
     * @param flag
     *            是否删除标示，0-----未删除；1----删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}