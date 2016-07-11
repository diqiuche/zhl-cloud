package net.tfedu.zhl.cloud.teaching.videoCourses.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tfedu.zhl.cloud.teaching.videoCourses.entity.TVideoResources;
import net.tfedu.zhl.cloud.teaching.videoCourses.entity.VideoPreviewEntity;
import net.tfedu.zhl.cloud.teaching.videoCourses.service.VideoCoursesService;
import net.tfedu.zhl.helper.ControllerHelper;
import net.tfedu.zhl.helper.PaginationHelper;
import net.tfedu.zhl.helper.ResultJSON;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 视频课程相关的接口
 * @author WeiCuicui
 *
 */
@Controller
@RequestMapping("/teachingServiceRestAPI")
public class VideoCoursesController {
	
	//日志
    Logger logger = LoggerFactory.getLogger(VideoCoursesController.class);
    
    @Resource VideoCoursesService videoCoursesService;
	
	/**
	 * 分页查询视频课程资源
	 * @param request
	 * @param response
	 * @param fromFlag 所属平台 0 双课堂 1 资源中心
	 * @param typeId 视频类型id：初级、进阶、高级
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/videoCourses",method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getAllVideoCourses(HttpServletRequest request,HttpServletResponse response,int fromFlag,int typeId)throws Exception{
		
		// 当前登录用户id
        Long currentUserId = (Long) request.getAttribute("currentUserId");
        
        
        int curPage = 1; //当前第几页，默认为1
        int perPageNum = 10; //每页记录数目，默认为10
        int order = 0; //排序，默认按照时长顺序排列
        int subject = 0; //学科id，默认为0
        
        
        if(request.getParameter("page") != null )//若有传递页码
			curPage = Integer.parseInt(request.getParameter("page").toString().trim());
		if(request.getParameter("perPage") != null )//若有传递每页记录数
			perPageNum = Integer.parseInt(request.getParameter("perPage").toString().trim());
		if(request.getParameter("orderBy") != null )//若有传递排序方式
			order = Integer.parseInt(request.getParameter("orderBy").toString().trim());
		if(request.getParameter("subjectId") != null )//若有传递学科id
			subject = Integer.parseInt(request.getParameter("subjectId").toString().trim());
        
		
		PaginationHelper<TVideoResources> pagination = videoCoursesService.getAllVideoCourses(fromFlag, typeId, subject, order, curPage, perPageNum, currentUserId);
	    
		return ResultJSON.getSuccess(pagination);
	}
	
	
	/**
	 * 新增一条视频课程资源
	 * @param request
	 * @param video 上传一条视频资源的 json字符串
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/videoCourses",method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON createOneVideoCourse(HttpServletRequest request,String video)throws Exception{
		
		// 当前登录用户id
        Long currentUserId = (Long) request.getAttribute("currentUserId");
		
        videoCoursesService.insertOneVideoCourse(video, currentUserId);
        
		return ResultJSON.getSuccess(null);
	}
	
	/**
	 * 编辑一条视频课程资源
	 * @param request
	 * @param video  编辑的一条视频资源的json字符串
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/videoCoursesEdit",method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON editOneVideoCourse(HttpServletRequest request,String video)throws Exception{
		
		// 当前登录用户id
        Long currentUserId = (Long) request.getAttribute("currentUserId");
        
        videoCoursesService.editOneVideoCourse(video, currentUserId);
		
		return ResultJSON.getSuccess(null);
	}
	
	/**
	 * 批量删除视频资源
	 * @param ids  批量删除的视频课程id集合
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/videoCoursesDelete",method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON deleteVideoCourses(String ids)throws Exception{
		
		videoCoursesService.delVideoCourses(ids);
		
		return ResultJSON.getSuccess(null);
	}
	
	/**
	 * 检索视频课程
	 * @param request
	 * @param fromFlag  所属平台 0 双课堂 1 资源中心
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/videoCourses/search",method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON searchVideoCourses(HttpServletRequest request,int fromFlag)throws Exception{
		
		int order = 0; //排序方式，默认为0，按上传时间顺序
		int curPage = 1; //要查询的页码
		int perPageNum = 10; //每页记录数目
		String keyWord = null;//检索关键字，默认为null，不进行关键字匹配
		
		if(request.getParameter("orderBy") != null )//若有传递排序方式
			order = Integer.parseInt(request.getParameter("orderBy").toString().trim());
		if(request.getParameter("page") != null )//若有传递页码
			curPage = Integer.parseInt(request.getParameter("page").toString().trim());
		if(request.getParameter("perPage") != null )//若有传递每页记录数
			perPageNum = Integer.parseInt(request.getParameter("perPage").toString().trim());
		if(request.getParameter("keyWord") != null )//若有传递检索关键字
			keyWord = ControllerHelper.getParameter(request, "keyWord");
		
		PaginationHelper<TVideoResources> pagination = videoCoursesService.getVideoSearchResults(keyWord, fromFlag, order, curPage, perPageNum);
		
		return ResultJSON.getSuccess(pagination);
	}
	
	/**
	 * 预览一条视频课程资源
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/videoCourses/previewInfo",method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getOneVideoCourseInfo(HttpServletRequest request,long id)throws Exception{
		
		// 当前登录用户id
        Long currentUserId = (Long) request.getAttribute("currentUserId");
		
		VideoPreviewEntity videoResource = videoCoursesService.getOneVideoCourse(id, currentUserId);
		
		return ResultJSON.getSuccess(videoResource);
	}
	
	/**
	 * 用户浏览某个视频课程时，设置已看标记，向数据库的用户已看视频中插入记录
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/videoCourses/visit", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON setViewState(HttpServletRequest request,long videoId)throws Exception{
	
		// 当前登录用户id
        Long currentUserId = (Long) request.getAttribute("currentUserId");
        
        videoCoursesService.addOneVisitItem(currentUserId, videoId);
        
		return ResultJSON.getSuccess(null);
	}
	
}
