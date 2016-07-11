package net.tfedu.zhl.cloud.resource.resourceList.entity;

import java.io.Serializable;

/**
 * 用户所在区、校的id
 * 
 * @author WeiCuicui
 *
 */
public class DisAndSchoolEntity implements Serializable {
    private static final long serialVersionUID = 8160030266758656476L;

    /**
     * 学校id
     */
    private long schoolId;

    /**
     * 区id
     */
    private long districtId;

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(long districtId) {
        this.districtId = districtId;
    }

}
