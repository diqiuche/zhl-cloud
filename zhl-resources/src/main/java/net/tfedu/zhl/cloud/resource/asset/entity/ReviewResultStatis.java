package net.tfedu.zhl.cloud.resource.asset.entity;

/**
 * 资源评价的统计结果信息
 * 
 * @author wangwr
 *
 */
public class ReviewResultStatis {

    /**
     * 已经评价的资源数
     */
    Integer reviewNumber;

    /**
     * 未评价的资源数
     */
    Integer unReviewNumber;

    public Integer getReviewNumber() {
        return reviewNumber;
    }

    public void setReviewNumber(Integer reviewNumber) {
        this.reviewNumber = reviewNumber;
    }

    public Integer getUnReviewNumber() {
        return unReviewNumber;
    }

    public void setUnReviewNumber(Integer unReviewNumber) {
        this.unReviewNumber = unReviewNumber;
    }

}
