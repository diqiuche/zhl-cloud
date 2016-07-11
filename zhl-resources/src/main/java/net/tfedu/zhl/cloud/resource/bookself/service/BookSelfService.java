package net.tfedu.zhl.cloud.resource.bookself.service;

import java.util.List;

import net.tfedu.zhl.cloud.resource.asset.entity.CourseWareView;
import net.tfedu.zhl.cloud.resource.bookself.bean.BookSelfView;

public interface BookSelfService {

	
	
	/**
	 * 获取我的全部书架
	 * @param userId
	 * @return
	 */
	public List<BookSelfView> getAllMyBook(Long userId, String title );
	
	
	/**根据条件删除
	 * 
	 * @param userId
	 * @param syscourseId
	 */
	public void  delMyBook(Long userId,String tfcode);
	
	
	
	
	
	/**
	 * 增加我的书架书籍
	 * @param userId
	 * @param syscourseId
	 */
	public void addMyBook(Long userId,String tfcode);
	
	
	
	/**
	 * 获取版本下的书籍
	 * @param userId
	 * @param tfcode
	 * @return
	 */
	public List<BookSelfView> queryBook(Long userId,String tfcode);
	
	
	
	
	/**
	 * 获取用户的课件
	 * @param userId
	 * @param tfcode
	 * @param title
	 * @param orderby
	 * @return
	 */
	public List<CourseWareView> queryUserCourseware(Long userId,String tfcode,String title,String orderby);
	
	
	/**
	 * 重命名课件
	 */
	public void renameAsset(Long id,String name);


	/**
	 * 检索用户书架教材下的全部课件
	 * @param userId
	 * @param title
	 * @param orderby
	 * @return
	 */
	public List<CourseWareView> queryUserCoursewareAll(long userId,
			String title, String orderby);
	
}
