package net.tfedu.zhl.cloud.resource.asset.entity;

import java.util.Date;

/**
 * 我的课件的前端返回 
 * @author wangwr
 *
 */
public class CourseWareView extends ZAssetView {
	

	
	/**
	 * 更新时间
	 */
    private Date updatetime;

    
    /**
     * 资源大小
     */
    private String size;
	
	
	
    
    /**
     * 课件所在的节点的tfcode
     */
    private String tfcode ;
    
    
    /**
     * 课件所在的节点的标题
     */
    private String tf_title ;




	public Date getUpdatetime() {
		return updatetime;
	}


	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getTfcode() {
		return tfcode;
	}


	public void setTfcode(String tfcode) {
		this.tfcode = tfcode;
	}


	public String getTf_title() {
		return tf_title;
	}


	public void setTf_title(String tf_title) {
		this.tf_title = tf_title;
	}
    
    @Override
    public String toString(){
        return "[CourseWareView:{resId:" + super.getResId() + ";title:" + super.getTitle() + ";resCode:" + super.getResCode() + ";unifyType:" + super.getUnifyType()
                + ";imgPath:" + super.getImgPath() + ";fileSuffix:" + super.getFileSuffix() +
                 ";updatetime:" + updatetime +";size:" + size+ ";tfcode:" + tfcode+ ";tf_title:" + tf_title + "}]";

    	
    }
    
	
}
