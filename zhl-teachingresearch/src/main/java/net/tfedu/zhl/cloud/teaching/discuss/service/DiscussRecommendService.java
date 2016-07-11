package net.tfedu.zhl.cloud.teaching.discuss.service;

import com.github.pagehelper.PageInfo;

import net.tfedu.zhl.cloud.teaching.discuss.entity.TDiscussRecommend;
import net.tfedu.zhl.core.service.BaseService;
import net.tfedu.zhl.helper.ResultJSON;

public interface DiscussRecommendService  extends BaseService<TDiscussRecommend> {


	
	/**
	 * 批量删除推荐班级
	 * @return
	 * @throws Exception
	 */
	public ResultJSON removeRecommendRecords(String ids) throws Exception;
	
	
	/**
	 * 分页查询推荐班级列表（后台使用）
	 * @param page
	 * @param perPage
	 * @param orderBy
	 * @return
	 * @throws Exception
	 */
	public ResultJSON queryRecommendRecordsPageForBack(int page,int perPage,String orderBy)throws Exception;
	
	
	
	/**
	 * 分页查询推荐班级列表（后台使用）
	 * @param page
	 * @param perPage
	 * @param orderBy
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TDiscussRecommend> queryRecommendRecordsPage(int page,int perPage)throws Exception;
	
	
	
	
	
	
	
	
}
