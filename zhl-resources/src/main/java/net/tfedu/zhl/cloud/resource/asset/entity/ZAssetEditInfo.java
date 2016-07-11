package net.tfedu.zhl.cloud.resource.asset.entity;


/**
 * 自建资源更新编辑信息
 * @author wangwr
 *
 */
public class ZAssetEditInfo {
	
	
	
	/**
	 * asset 的id
	 */
	private Long id ;
	
	
	private String title ;
	
	/**
	 * 描述
	 */
	private String assetdesc;
	
	
	/**
	 * 路径
	 */
	private String assetpath ;
	
	/**
	 * 大小
	 */
	private String assetsize;
	
	/**
	 * 关键字
	 */
	private String keyword ;
	
	
	/**
	 * 共享范围   0 个人可见 1 校本共享 2 区本共享
	 */
	private Integer sharescope;
	
	
	/**
	 * 目录节点（上传至）
	 */
	private String tfcode ;
	
	
	/**
	 * 学段id
	 */
	public String termId;
	
	/**
	 * 学段id
	 */
	public String subjectId;
	

	/**
	 * 资源类型id
	 */
	public String unifytypeId;
	
	/**
	 * 资源类型描述
	 */
	public String mtype ;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAssetdesc() {
		return assetdesc;
	}


	public void setAssetdesc(String assetdesc) {
		this.assetdesc = assetdesc;
	}


	public String getAssetpath() {
		return assetpath;
	}


	public void setAssetpath(String assetpath) {
		this.assetpath = assetpath;
	}


	public String getAssetsize() {
		return assetsize;
	}


	public void setAssetsize(String assetsize) {
		this.assetsize = assetsize;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public Integer getSharescope() {
		return sharescope;
	}


	public void setSharescope(Integer sharescope) {
		this.sharescope = sharescope;
	}


	public String getTfcode() {
		return tfcode;
	}


	public void setTfcode(String tfcode) {
		this.tfcode = tfcode;
	}


	public String getTermId() {
		return termId;
	}


	public void setTermId(String termId) {
		this.termId = termId;
	}


	public String getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}


	public String getUnifytypeId() {
		return unifytypeId;
	}


	public void setUnifytypeId(String unifytypeId) {
		this.unifytypeId = unifytypeId;
	}


	public String getMtype() {
		return mtype;
	}


	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	
	
	
	
	
}
