	package net.tfedu.zhl.cloud.teaching.discuss.controller;

	import java.util.Calendar;
	import java.util.Iterator;
	import java.util.List;

	import javax.annotation.Resource;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

	import net.tfedu.zhl.cloud.teaching.discuss.entity.TDiscussLog;
	import net.tfedu.zhl.cloud.teaching.discuss.entity.TDiscussRecommend;
import net.tfedu.zhl.cloud.teaching.discuss.entity.TDiscussRecommendQueryBack;
import net.tfedu.zhl.cloud.teaching.discuss.service.DiscussLogService;
	import net.tfedu.zhl.cloud.teaching.discuss.service.DiscussRecommendService;
	import net.tfedu.zhl.config.CommonWebConfig;
	import net.tfedu.zhl.helper.ControllerHelper;
	import net.tfedu.zhl.helper.ResultJSON;
	import net.tfedu.zhl.sso.users.entity.SRegister;
	import net.tfedu.zhl.sso.users.service.RegisterService;




	/**
	 * 推荐班级及其访问记录的相关接口
	 * @author wangwr
	 *
	 */

	@Controller
	@RequestMapping("/teachingServiceRestAPI")
	public class DiscussController {

		
		@Resource
		RegisterService regSerivce;
		
		
		@Resource
		DiscussRecommendService discussService;
		

		@Resource
		DiscussLogService  discussLogService;
		
		
		@Resource
		CommonWebConfig config;
		
		
		/**
		 * 返回推荐班级列表
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="v1.0/discuss/recommend",method=RequestMethod.GET)
		@ResponseBody
		public ResultJSON getRecomended(HttpServletRequest request, int page,int perPage ) throws Exception{
			//http://chat.tfedu.net:7070/circle/ff808181520fcf4401521f1118c50130
			// 当前登录用户id
			Long currentUserId = (Long) request.getAttribute("currentUserId");

			//返回推荐班级列表
			ResultJSON result = null;

			
			//准备重置url
			SRegister register = regSerivce.getRegister(currentUserId);
			String userName = register.getName();
			String  forum3 =  config.getCurrentForum3(request);		

			
			PageInfo<TDiscussRecommend> _page = discussService.queryRecommendRecordsPage(page, perPage);
			List<TDiscussRecommend> list =  _page.getList();
			if(list!=null && list.size()>0){
				for (Iterator<TDiscussRecommend> iterator = list.iterator(); iterator.hasNext();) {
					TDiscussRecommend tDiscussRecommend = (TDiscussRecommend) iterator.next();
					String _url = forum3+"/auth/process?username="+userName+"&target="+
							forum3 +"/circle/"+tDiscussRecommend.getClassid();
					tDiscussRecommend.setClassurl(_url);
				}
			}
			return ResultJSON.getSuccess(_page);
		}
		
		/**
		 * 返回推荐班级列表(后台)
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="v1.0/discuss/recommend_back",method=RequestMethod.GET)
		@ResponseBody
		public ResultJSON getRecomendedBack(HttpServletRequest request, int page,int perPage,String orderBy ) throws Exception{
			//http://chat.tfedu.net:7070/circle/ff808181520fcf4401521f1118c50130
			// 当前登录用户id
			Long currentUserId = (Long) request.getAttribute("currentUserId");

			//返回推荐班级列表
			ResultJSON result = discussService.queryRecommendRecordsPageForBack(page, perPage, orderBy);

			
			//准备重置url
			SRegister register = regSerivce.getRegister(currentUserId);
			String userName = register.getName();
			String  forum3 =  config.getCurrentForum3(request);		

			
			PageInfo<TDiscussRecommendQueryBack> _page = ((PageInfo<TDiscussRecommendQueryBack>)result.getData());
			List<TDiscussRecommendQueryBack> list =  _page.getList();
			if(list!=null && list.size()>0){
				for (Iterator<TDiscussRecommendQueryBack> iterator = list.iterator(); iterator.hasNext();) {
					TDiscussRecommendQueryBack tDiscussRecommend = iterator.next();
					String _url = forum3+"/auth/process?username="+userName+"&target="+
							forum3 +"/circle/"+tDiscussRecommend.getClassid();
					tDiscussRecommend.setClassurl(_url);
				}
			}
			return result;
		}
	
	/**
	 * 增加访问记录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="v1.0/discuss/readed",method=RequestMethod.POST)
	@ResponseBody
	public ResultJSON addReadRecord(HttpServletRequest request,String classId) throws Exception{
		classId = ControllerHelper.checkEmpty(classId);
	
		Long currentUserId = (Long)request.getAttribute("currentUserId");


		
		TDiscussLog c = new TDiscussLog();
		c.setClassid(classId);
		c.setUserid(currentUserId);
		c.setCreatetime(Calendar.getInstance().getTime());
		
		return discussLogService.insert(c);
	}
	
	

	/**
	 * 返回最近访问列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="v1.0/discuss/readed",method=RequestMethod.GET)
	@ResponseBody	
	public ResultJSON getReaded( HttpServletRequest request,HttpServletResponse response ) throws Exception{
		
		Long currentUserId = (Long)request.getAttribute("currentUserId");	
		
		//返回最近访问列表
		ResultJSON result = discussLogService.getReadLog(currentUserId);

		//准备重置url
		SRegister register = regSerivce.getRegister(currentUserId);
		String userName = register.getName();
		String  forum3 =  config.getCurrentForum3(request);		
		
		
		List<TDiscussRecommend> data = (List<TDiscussRecommend>)result.getData();
		for (Iterator iterator = data.iterator(); iterator.hasNext();) {
			TDiscussRecommend tDiscussRecommend = (TDiscussRecommend) iterator.next();
			String _url = forum3+"/auth/process?username="+userName+"&target="+
							forum3 +"/circle/"+tDiscussRecommend.getClassid();
					
			tDiscussRecommend.setClassurl(_url);
		}
		
		return  result;
	}
	
	
	
	
	
	/**
	 * 增加推荐班级列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="v1.0/discuss/recommend",method=RequestMethod.POST)
	@ResponseBody		
	public ResultJSON addRecomended( HttpServletRequest request,HttpServletResponse response ) throws Exception{
		Long currentUserId = (Long)request.getAttribute("currentUserId");	

		String className = ControllerHelper.getParameter(request, "className"); //	班级名称
		String classImage	 = ControllerHelper.getParameter(request, "classImage");	//班级图片路径
		String schoolName = ControllerHelper.getParameter(request, "schoolName");		//学校名称
		String classId	 = ControllerHelper.getParameter(request, "classId");	//班级id
		String note		 = ControllerHelper.getOptionalParameter(request, "note");//班级简介
		
		TDiscussRecommend record = new TDiscussRecommend();
		record.setClassid(classId);
		record.setClassname(className);
		record.setClassimage(classImage);
		record.setSchoolname(schoolName);
		record.setNote(note);
		record.setCreator(currentUserId);
		record.setCreatetime(Calendar.getInstance().getTime());
		record.setFlag(false);
		return discussService.insert(record);
	}
	
	

	/**
	 * 获取指定班级
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value="v1.0/discuss/recommend/{id}",method=RequestMethod.GET)
	@ResponseBody		
	public ResultJSON getOne(@PathVariable Long id) throws Exception{
		
		return discussService.get(id) ;
	}
	
	
	/**
	 * 修改推荐班级列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value="v1.0/discuss/recommend/{id}",method=RequestMethod.POST)
	@ResponseBody		
	public ResultJSON updateRecomended(HttpServletRequest request,@PathVariable Long id) throws Exception{
		
		
		
		String className = ControllerHelper.getParameter(request, "className"); //	班级名称
		String classImage	 = ControllerHelper.getParameter(request, "classImage");	//班级图片路径
		String schoolName = ControllerHelper.getParameter(request, "schoolName");		//学校名称
		String classId	 = ControllerHelper.getParameter(request, "classId");	//班级id
		String note		 = ControllerHelper.getOptionalParameter(request, "note");//班级简介
		TDiscussRecommend record = new TDiscussRecommend();
		record.setId(id);
		record.setClassid(classId);
		record.setClassname(className);
		record.setClassimage(classImage);
		record.setSchoolname(schoolName);
		record.setNote(note);
		
		return discussService.update(record) ;
	}
	
	
	
	
	/**
	 * 删除推荐班级列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="v1.0/discuss/remove",method=RequestMethod.POST)
	@ResponseBody		
	public ResultJSON delRecomended(String ids ) throws Exception{
		
		ControllerHelper.checkEmpty(ids);
		
		return discussService.removeRecommendRecords(ids);
	}
	
	
	
	
	
	
	
	
}
