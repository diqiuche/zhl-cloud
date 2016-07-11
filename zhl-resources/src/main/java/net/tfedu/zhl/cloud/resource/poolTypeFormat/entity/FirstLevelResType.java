package net.tfedu.zhl.cloud.resource.poolTypeFormat.entity;

import java.io.Serializable;

/**
 * 自建资源，获取一级资源类型
 * 
 * @author wangwr
 *
 */
public class FirstLevelResType implements Serializable {
    private static final long serialVersionUID = 8160030266758656476L;

    Long id;

    String mtype;

    String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
