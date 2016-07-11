package net.tfedu.zhl.cloud.resource.bookself.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用于书架浏览 
 * @author wangwr
 *
 */
public class BookSelfView implements Serializable{

	/**
	 * 教材id
	 */
	Long id;
	
	String title ;
	
	String tfcode;
	/**
	 * 是否在书架上  0否  1 是
 	 */
	Integer ismybook;
	/**
	 * 封面缩略图
	 */	
	String imgpath;
	
	
	/**
	 * 最后修改时间
	 */
	Date time ;
	
	
	public BookSelfView(){
		super();
	}
	
	
	public BookSelfView(Long id,String title,String rescode,Integer ismybook,String imgpath,Date time){
		this.id = id ;
		this.title = title;
		this.tfcode = tfcode ;
		this.ismybook = ismybook;
		this.imgpath = imgpath;
		this.time = time ;
	}
	
	
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

	
	public String getTfcode() {
		return tfcode;
	}


	public void setTfcode(String tfcode) {
		this.tfcode = tfcode;
	}


	public Integer getIsmybook() {
		return ismybook;
	}
	public void setIsmybook(Integer ismybook) {
		this.ismybook = ismybook;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
	
}
