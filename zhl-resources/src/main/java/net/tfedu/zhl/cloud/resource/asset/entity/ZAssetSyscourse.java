package net.tfedu.zhl.cloud.resource.asset.entity;

import javax.persistence.*;

@Table(name = "z_asset_syscourse")
public class ZAssetSyscourse {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 自建资源id
     */
    private Long assetid;

    /**
     * 资源类型id(z_unfiy_resource_type)
     */
    private String tfcode;

    /**
     * 逻辑删除表示
     */
    private Boolean flag;
    
    
    /**
     * 共享范围   0 个人可见 1 校本共享 2 区本共享
     * 
     */
    private Integer sharescope;
    

    public ZAssetSyscourse(Long id, Long assetid, String tfcode, Boolean flag,Integer sharescope) {
        this.id = id;
        this.assetid = assetid;
        this.tfcode = tfcode;
        this.flag = flag;
        this.sharescope = sharescope;
    }

    public ZAssetSyscourse() {
        super();
    }

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id
     *            自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取自建资源id
     *
     * @return assetid - 自建资源id
     */
    public Long getAssetid() {
        return assetid;
    }

    /**
     * 设置自建资源id
     *
     * @param assetid
     *            自建资源id
     */
    public void setAssetid(Long assetid) {
        this.assetid = assetid;
    }

    /**
     * 获取资源类型id(z_unfiy_resource_type)
     *
     * @return tfcode - 资源类型id(z_unfiy_resource_type)
     */
    public String getTfcode() {
        return tfcode;
    }

    /**
     * 设置资源类型id(z_unfiy_resource_type)
     *
     * @param tfcode
     *            资源类型id(z_unfiy_resource_type)
     */
    public void setTfcode(String tfcode) {
        this.tfcode = tfcode == null ? null : tfcode.trim();
    }

    /**
     * 获取逻辑删除表示
     *
     * @return flag - 逻辑删除表示
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置逻辑删除表示
     *
     * @param flag
     *            逻辑删除表示
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

	public Integer getSharescope() {
		return sharescope;
	}

	public void setSharescope(Integer sharescope) {
		this.sharescope = sharescope;
	}
    
    
    
}