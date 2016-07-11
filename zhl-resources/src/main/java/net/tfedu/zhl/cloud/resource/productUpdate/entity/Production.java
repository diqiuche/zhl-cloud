package net.tfedu.zhl.cloud.resource.productUpdate.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productcode;

    private String productname;

    /**
     * ProductType：1：pc   2：android     3：ios
     */
    private Integer producttype;

    /**
     * 创建时间
     */
    private Date createtime;

    public Production(String productcode, String productname, Integer producttype, Date createtime) {
        this.productcode = productcode;
        this.productname = productname;
        this.producttype = producttype;
        this.createtime = createtime;
    }

    public Production() {
        super();
    }

    /**
     * @return productcode
     */
    public String getProductcode() {
        return productcode;
    }

    /**
     * @param productcode
     */
    public void setProductcode(String productcode) {
        this.productcode = productcode == null ? null : productcode.trim();
    }

    /**
     * @return productname
     */
    public String getProductname() {
        return productname;
    }

    /**
     * @param productname
     */
    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    /**
     * 获取ProductType：1：pc   2：android     3：ios
     *
     * @return producttype - ProductType：1：pc   2：android     3：ios
     */
    public Integer getProducttype() {
        return producttype;
    }

    /**
     * 设置ProductType：1：pc   2：android     3：ios
     *
     * @param producttype ProductType：1：pc   2：android     3：ios
     */
    public void setProducttype(Integer producttype) {
        this.producttype = producttype;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}