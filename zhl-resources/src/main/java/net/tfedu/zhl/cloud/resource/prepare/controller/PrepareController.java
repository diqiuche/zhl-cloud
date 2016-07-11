package net.tfedu.zhl.cloud.resource.prepare.controller;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tfedu.zhl.cloud.resource.config.ResourceWebConfig;
import net.tfedu.zhl.cloud.resource.downloadrescord.entity.ResZipDownRecord;
import net.tfedu.zhl.cloud.resource.downloadrescord.service.ResZipDownloadService;
import net.tfedu.zhl.cloud.resource.navigation.service.TreeService;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepare;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContent;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContentView;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContentViewUtil;
import net.tfedu.zhl.cloud.resource.prepare.entity.ResourceSimpleInfo;
import net.tfedu.zhl.cloud.resource.prepare.service.JPrepareService;
import net.tfedu.zhl.cloud.resource.prepare.util.JPrepareConstant;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.config.CommonWebConfig;
import net.tfedu.zhl.core.exception.CustomException;
import net.tfedu.zhl.core.exception.ParamsException;
import net.tfedu.zhl.fileservice.ZhlResourceCenterWrap;
import net.tfedu.zhl.fileservice.ZipTaskContent;
import net.tfedu.zhl.helper.ControllerHelper;
import net.tfedu.zhl.helper.ResultJSON;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

/**
 * 备课夹相关接口
 * 
 * @author wangwr
 * 
 */

@Controller
@RequestMapping("/resRestAPI")
public class PrepareController {

	@Resource
	JPrepareService jPrepareService;

	@Resource
	ResZipDownloadService resZipDownloadService;

	@Resource
	CommonWebConfig commonWebConfig;
	
	@Resource
	TreeService treeService;
	
	@Resource
	ResourceWebConfig resourceConfig;
	
	

	Logger logger = LoggerFactory.getLogger(PrepareController.class);

	/**
	 * 新增编辑 备课夹 v1.0
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/prepare", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON addPrepare(HttpServletRequest request,
			HttpServletResponse response) {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;
		long userId = currentUserId;
		String title = request.getParameter("title");
		String tfcode = request.getParameter("tfcode");
		String _method = request.getParameter("_method");
		String _id = request.getParameter("id");
		long prepareId = 0;
		if (StringUtils.isNotEmpty(_id)) {
			prepareId = Long.parseLong(_id);
		}
		// 是否为编辑备课夹
		if (StringUtils.isNotEmpty(_method)
				&& RequestMethod.PATCH.name().equalsIgnoreCase(_method)) {
			Date currentDate = Calendar.getInstance().getTime();
			JPrepare prepare = new JPrepare();
			prepare.setId(prepareId);
			prepare.setTitle(title.trim());
			prepare.setUpdatetime(currentDate);
			jPrepareService.editPrepare(prepare);

			logger.debug("编辑id为" + prepareId + "的备课夹的标题为：" + title);

			// 否则为delete备课夹
		} else if (StringUtils.isNotEmpty(_method)
				&& RequestMethod.DELETE.name().equalsIgnoreCase(_method)) {
			logger.debug("删除id为" + prepareId + "的备课夹");

			jPrepareService.deletePrepareById(prepareId);

			// 否则为新建备课夹
		} else {
			// 新建备课夹
			Date currentDate = Calendar.getInstance().getTime();
			JPrepare prepare = new JPrepare();
			prepare.setUserid(userId);
			prepare.setCreatetime(currentDate);
			prepare.setUpdatetime(currentDate);
			prepare.setTfcode(tfcode);
			prepare.setTitle(title.trim());

			jPrepareService.addPrepare(prepare);

			data = prepare;
		}

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 获取当前节点及其以下节点的备课夹
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/prepare", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getPrepare(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 返回json的结果对象
		ResultJSON result = new ResultJSON();
		// 异常
		CustomException exception = (CustomException) request
				.getAttribute(CustomException.request_key);
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		long userId = currentUserId;
		String tfcode = request.getParameter("tfcode");
		if (StringUtils.isNotEmpty(tfcode)) {
			data = jPrepareService.queryPrepareList(tfcode, userId);
			logger.debug("获取节点" + tfcode + "下的所有当前用户（" + userId + "）的备课夹");
		} else {
			throw new ParamsException();
		}

		return ResultJSON.getSuccess(data);
	}

	
	/**
	 * 仅获取当前节点下的备课夹
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/selfPrepare", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getSelfPrepare(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 返回json的结果对象
		ResultJSON result = new ResultJSON();
		// 异常
		CustomException exception = (CustomException) request
				.getAttribute(CustomException.request_key);
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		long userId = currentUserId;
		String tfcode = request.getParameter("tfcode");
		if (StringUtils.isNotEmpty(tfcode)) {
			data = jPrepareService.querySelfPrepareList(tfcode, userId);
			logger.debug("获取节点" + tfcode + "下的所有当前用户（" + userId + "）的备课夹");
		} else {
			throw new ParamsException();
		}

		return ResultJSON.getSuccess(data);
	}
	
	
	
	/**
	 * 分页获取节点下的备课夹
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/prepare_page", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getPreparePage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		int page = 1;
		int prePage = 10;

		String _page = request.getParameter("page");
		String _prePage = request.getParameter("perPage");

		if (StringUtils.isNotEmpty(_page)) {
			page = Integer.parseInt(_page);
		}
		if (StringUtils.isNotEmpty(_prePage)) {
			prePage = Integer.parseInt(_prePage);
		}

		long userId = currentUserId;
		String tfcode = request.getParameter("tfcode");
		if (StringUtils.isNotEmpty(tfcode)) {
			data = jPrepareService.queryPreparePage(tfcode, userId, page,
					prePage);
			logger.debug("分页获取节点" + tfcode + "下的所有当前用户（" + userId
					+ "）的备课夹：page=" + page + ";prePage=" + prePage);
		} else {
			throw new ParamsException();
		}

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 获取最新更新的备课夹（3个）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/latestPrepare", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getLatestPrepare(HttpServletRequest request,
			HttpServletResponse response) {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = jPrepareService.getLatestPrepare(currentUserId);
		return ResultJSON.getSuccess(data);
	}

	/**
	 * 分页获取整本书下的备课夹列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/prepare4book", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getPrepare4book(Integer page,Integer perPage, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		long userId = currentUserId;
		long termId = 0;
		long subjectId = 0;

		String title = request.getParameter("title");
		String _termId = request.getParameter("termId");
		String _subjectId = request.getParameter("subjectId");
		//时间范围：withinweek、withinmonth、moreearly
		String timeLabel =  request.getParameter("timeLabel");
		
		
		
		if (StringUtils.isNotEmpty(_termId)) {
			termId = Long.parseLong(_termId);
		}
		if (StringUtils.isNotEmpty(_subjectId)) {
			subjectId = Long.parseLong(_subjectId);
		}
		
		if(page ==null){
			page = 1;
		}

		if(perPage == null){
			perPage = 8 ;
		}
		
		if (termId != 0 && subjectId != 0) {
			title = title == null ? "" : title.trim();
			data = jPrepareService.queryPrepareByTermSubject(termId, subjectId, title, userId, page, perPage,timeLabel);
		} else {
			throw new ParamsException();

		}

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 获取备课夹内容列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/prepareContent/{prepareId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON queryPrepareContent(@PathVariable Long prepareId,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);

		if (prepareId > 0) {
			// 获取备课夹内容
			List<JPrepareContentView> list = jPrepareService
					.queryPrepareContentList(prepareId);
			JPrepareContentViewUtil.convertToPurpose(list, resServiceLocal,
					currentResPath);

			data = list;

		} else {
			throw new ParamsException();
		}

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 分页获取备课夹内容列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/prepareContentPage/{prepareId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON queryPrepareContentPage(@PathVariable Long prepareId,
			Integer perPage, Integer page, HttpServletRequest request)
			throws Exception {
		// 返回
		Object data = null;
		
		if(page ==null){
			page = 1;
		}

		if(perPage == null){
			perPage = 10 ;
		}

		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);

		if (prepareId > 0) {
			// 获取备课夹内容
			Pagination<JPrepareContentView> _page = jPrepareService
					.queryPrepareContentPage(prepareId, page, perPage);
			JPrepareContentViewUtil.convertToPurpose(_page.getList(), resServiceLocal,
					currentResPath);
			data = _page;

		} else {
			throw new ParamsException();
		}

		return ResultJSON.getSuccess(data);
	}
	
	/**
	 * 分页获取备课夹内容列表(受限的----e备课排除部分类型的资源)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/limitedPrepareContentPage/{prepareId}", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON querylimitedPrepareContentPage(@PathVariable Long prepareId,
			Integer perPage, Integer page, HttpServletRequest request)
			throws Exception {
		//是否是e备课的请求
		int  isEPrepare = ControllerHelper.getIntWithDefault(request, "isEPrepare");
		//是否获取网络资源
		boolean ifGetNet = true ;
		
		if(isEPrepare==1){
			ifGetNet = false ;
		}
		
		// 返回
		Object data = null;
		
		if(page ==null){
			page = 1;
		}

		if(perPage == null){
			perPage = 10 ;
		}

		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);
		//获取受限的（e备课排除的）资源类型
		String removeTypeIds = resourceConfig.getRemoveTypeIds();
		

		if (prepareId > 0) {
			// 获取备课夹内容
			Pagination<JPrepareContentView> _page = jPrepareService
					.queryLimitedPrepareContentPage(prepareId, page, perPage,removeTypeIds.split(",")							
					,ifGetNet);
			JPrepareContentViewUtil.convertToPurpose(_page.getList(), resServiceLocal,
					currentResPath);
			data = _page;

		} else {
			throw new ParamsException();
		}

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 插入备课夹
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/prepareContent/{prepareId}", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON addPrepareContent(@PathVariable Long prepareId,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		String resIds = request.getParameter("resIds");
		String fromFlags = request.getParameter("fromFlags");
		// 参数传递有问题
		if (prepareId == 0 || StringUtils.isEmpty(fromFlags)
				|| StringUtils.isEmpty(resIds)) {
			throw new ParamsException();
		} else {
			String ids[] = resIds.split(",");
			String fromFlag[] = fromFlags.split(",");
			if (ids.length == 0 || fromFlag.length != ids.length) {
				throw new ParamsException();
			} else {
				Date currentDate = Calendar.getInstance().getTime();
				if (ids.length == 1) {
					JPrepareContent cont = new JPrepareContent();
					String _fromFlag = fromFlag[0];
					String _resId = ids[0];
					cont.setPreid(prepareId);
					cont.setContid(Long.parseLong(_resId));
					cont.setConttype(JPrepareConstant
							.getContTypeByFromFlag(Integer.parseInt(_fromFlag)));
					cont.setCreatetime(currentDate);
					jPrepareService.addPrepareContent(cont);

				} else {
					List<JPrepareContent> list = new ArrayList<JPrepareContent>();
					for (int i = 0; i < fromFlag.length; i++) {
						String _fromFlag = fromFlag[i];
						String _resId = ids[i];
						// 将资源加入备课夹
						JPrepareContent cont = new JPrepareContent();
						cont.setPreid(prepareId);
						cont.setContid(Long.parseLong(_resId));
						cont.setConttype(JPrepareConstant
								.getContTypeByFromFlag(Integer
										.parseInt(_fromFlag)));
						cont.setCreatetime(currentDate);
						list.add(cont);
					}
					jPrepareService.addPrepareContentList(list);
				}
			}
		}

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 清空备课夹 移出备课夹 调整顺序
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/prepareContent", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON delPrepareContent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		String ids = request.getParameter("ids");
		String _method = request.getParameter("_method");

		// 清空备课夹
		if (StringUtils.isNotEmpty(_method)
				&& "CLEAR".equalsIgnoreCase(_method)) {
			String _id = request.getParameter("id");
			long id = 0;
			if (StringUtils.isEmpty(_id)) {
				throw new ParamsException();
			} else {
				id = Long.parseLong(_id);
				jPrepareService.clearPrepareContentByPrepareId(id);
			}

			// 调整顺序
		} else if (StringUtils.isNotEmpty(_method)
				&& RequestMethod.PATCH.name().equalsIgnoreCase(_method)) {
			String _prevId = request.getParameter("prevId");
			String _nextId = request.getParameter("nextId");
			long nextId = 0;
			long prevId = 0;
			if (StringUtils.isNotEmpty(_prevId)
					&& StringUtils.isNotEmpty(_nextId)) {
				nextId = Long.parseLong(_nextId);
				prevId = Long.parseLong(_prevId);
				jPrepareService.exchangeContOrderIdx(prevId, nextId);
			} else {
				throw new ParamsException();
			}
		} else {

			// 移出备课夹参数传递有问题
			if (StringUtils.isEmpty(ids)) {
				throw new ParamsException();
			} else {
				String _ids[] = ids.split(",");
				if (_ids.length == 0) {
					throw new ParamsException();
				} else {
					for (int i = 0; i < _ids.length; i++) {
						// 将资源移出备课夹
						jPrepareService.deletePrepareContentById(Long
								.parseLong(_ids[i]));
					}
				}
			}

		}

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 无节点选择时系统资源加入备课夹接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/v1.0/prepareContentFill", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON fillPrepareContent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		String rescode = request.getParameter("rescode");
		String _method = request.getParameter("_method");

		long userId = currentUserId;
		// 无节点选择时系统资源加入备课夹接口
		if (StringUtils.isNotEmpty(_method)
				&& "RESOURCEFILL".equalsIgnoreCase(_method)) {
			jPrepareService.addToPrepareWithOnlySysResource(rescode, userId);
		} else {
			throw new ParamsException();
		}

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 打包下载请求 返回 一个打包下载记录的id
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/prepareZip", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON prepareZip(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		String resIds = request.getParameter("ids");
		String fromFlags = request.getParameter("fromflags");
		// 下载的zip包的名称
		String zipname = request.getParameter("zipname");
		String hostLocal = commonWebConfig.getHostLocalOne();
		String resServiceLocal = commonWebConfig.getResServiceLocal();

		long userId = currentUserId;
		String zippath = ZhlResourceCenterWrap.getUserZipPath(userId);
		String rollBackUrl = "";// 回调函数

		// 参数传递有问题
		if (StringUtils.isEmpty(fromFlags) || StringUtils.isEmpty(resIds)
				|| StringUtils.isEmpty(zipname)) {
			throw new ParamsException();
		} else {
			String ids[] = resIds.split(",");
			String fromFlag[] = fromFlags.split(",");
			if (ids.length == 0 || fromFlag.length != ids.length) {
				throw new ParamsException();
			} else {
				List<ResourceSimpleInfo> list = jPrepareService
						.getResourceSimpleInfo(ids, fromFlag);
				// 将原始的path重置为可用对应的下载文件的路径
				JPrepareConstant.resetResourceDownLoadForZip(list,
						resServiceLocal);

				ResZipDownRecord record = new ResZipDownRecord();
				record.setUserid(userId);
				record.setFromflags(fromFlags);
				record.setIds(resIds);
				record.setStatus(false);
				record.setZippath(zippath);
				record.setZipname(zipname == null ? "" : zipname.trim());
				record.setTime(Calendar.getInstance().getTime());
				// 增加下载记录
				resZipDownloadService.addZipDownRecord(record);
				Long recordId = record.getId();
				rollBackUrl = hostLocal
						+ "/resRestAPI/v1.0/zipDownload_status?id=" + recordId;// 回调函数
				// 创建打包任务
				ZipTaskContent content = new ZipTaskContent();
				// 指定打包文件路径
				content.setZipFileName(zippath);
				String[] src = new String[list.size()];
				String[] end = new String[list.size()];
				for (int i = 0; i < list.size(); i++) {
					ResourceSimpleInfo info = list.get(i);
					String title = info.getTitle();
					String path = info.getPath().replaceAll("\\\\", "/");
					String name = path.substring(path.lastIndexOf("/") + 1,
							path.length());
					name = name.replace(
							name.substring(0, name.lastIndexOf(".")), title);
					src[i] = path;
					end[i] = name;

				}

				content.setSourceFile(src);
				content.setEntryName(end);
				// 增加回调
				content.setNotifyUrl(rollBackUrl);
				// 打包
				ZhlResourceCenterWrap.sendZipTask(content, resServiceLocal);
				data = record.getId();
			}
		}

		return ResultJSON.getSuccess(data);

	}

	/**
	 * 更新历史的打包下载的状态
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/zipDownload_status", method = RequestMethod.GET)
	@ResponseBody
	public String updateZipDownloadStatus(HttpServletRequest request,
			HttpServletResponse response) {
		String _id = request.getParameter("id");
		long id = 0;
		if (StringUtils.isNotEmpty(_id)) {
			logger.debug("更新历史的打包下载的状态,id='" + _id + "'");
			id = Long.parseLong(_id);
			ResZipDownRecord record = new ResZipDownRecord();
			record.setId(id);
			record.setStatus(true);
			resZipDownloadService.updateZipDownRecord(record);
			return "SUCCESS";
		} else {
			return "ERROR";
		}

	}

	/**
	 * 获取指定的下载的zip打包 是否完成
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/prepareZip_staus", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getZipDownloadStatus(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);

		String _id = request.getParameter("id");
		long id = 0;
		if (StringUtils.isNotEmpty(_id)) {
			id = Long.parseLong(_id.trim());
		}
		logger.debug("获取指定的历史打包下载的状态,id='" + _id + "'");

		ResZipDownRecord record = resZipDownloadService.getZipDownRecord(id);
		String zippath = record.getZippath();
		
		if(!record.getStatus()){
			//检查zippath是否存在
			// 判断是否存在
            String s = ZhlResourceCenterWrap.GetFileInfo(resServiceLocal, zippath);
            if (StringUtils.isNotEmpty(s)) {
                HashMap m = JSONObject.parseObject(s, HashMap.class);
                if (m != null && ((Integer) m.get("FileSize") > 0)) {
                	record.setStatus(true);
                	resZipDownloadService.updateZipDownRecord(record);
                }
            } 			
		}
		
		
		
		
		
		
		// 如果打包成功
		if (record.getStatus()) {
			// 转换为最终的下载路径
			zippath = ZhlResourceCenterWrap
					.getDownUrl(resServiceLocal, zippath);
			String zipname = record.getZipname();

			// 增加title,支持下载文件的重命名
			if (zipname != null && !"".equals(zipname)) {
				zippath += (zippath.indexOf("?") > 0 ? "&" : "?") + "title="
						+ URLEncoder.encode(zipname, "utf-8");
			}

			zippath = zippath.replace(resServiceLocal, currentResPath);
		} else {
			zippath = "";
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", record.getId());
		map.put("status", record.getStatus());
		map.put("zippath", zippath);
		data = map;

		return ResultJSON.getSuccess(data);

	}

	/**
	 * 
	 * 获取资源 的播放地址
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resViewUrl", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getResViewUrl(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String resIds = request.getParameter("resIds");
		String fromFlags = request.getParameter("fromFlags");

		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);
		String clientType = request.getParameter("clientType");// browser,ePrepareClient

		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		// 参数传递有问题
		if (StringUtils.isEmpty(fromFlags) || StringUtils.isEmpty(resIds)) {
			throw new ParamsException();
		} else {
			String ids[] = resIds.split(",");
			String fromFlag[] = fromFlags.split(",");
			if (ids.length == 0 || fromFlag.length != ids.length) {
				throw new ParamsException();
			} else {
				logger.debug("获取资源 的播放地址,resIds='" + resIds + "',fromFlags='"
						+ fromFlags + "'");
				List<ResourceSimpleInfo> list = jPrepareService
						.getResourceSimpleInfoForView(ids, fromFlag,
								currentUserId);
				// 将原始的path重置为可用的web链接

				JPrepareConstant.resetResourceViewUrl(list, resServiceLocal,
						currentResPath,"ePrepareClient".equalsIgnoreCase(clientType));
				data = list;
			}
		}

		return ResultJSON.getSuccess(data);

	}

	/**
	 * 
	 * 获取资源 的下载地址
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/res_down", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getDown(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String resIds = request.getParameter("resIds");
		String fromFlags = request.getParameter("fromFlags");
		String clientType = request.getParameter("clientType");// browser,ePrepareClient

		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);

		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		// 参数传递有问题
		if (StringUtils.isEmpty(fromFlags) || StringUtils.isEmpty(resIds)) {
			throw new ParamsException();
		} else {
			String ids[] = resIds.split(",");
			String fromFlag[] = fromFlags.split(",");
			if (ids.length == 0 || fromFlag.length != ids.length) {
				throw new ParamsException();
			} else {
				logger.debug("获取资源 的下载地址,resIds='" + resIds + "',fromFlags='"
						+ fromFlags + "'");
				List<ResourceSimpleInfo> list = jPrepareService
						.getResourceSimpleInfoForDownload(ids, fromFlag,
								currentUserId);
				// 将原始的path重置为可用的web链接

				if (list != null && list.size() > 0) {
					// 如果是e备课客户端,返回加密文件
					if ("ePrepareClient".equals(clientType)) {
						JPrepareConstant
								.resetResourceDownLoadURLForEPrepareClient(
										list, resServiceLocal, currentResPath);
					} else {

						JPrepareConstant.resetResourceDownLoadURLWeb(list,
								resServiceLocal, currentResPath);
					}
					data = list;

				}

			}
		}

		return ResultJSON.getSuccess(data);

	}
	
	
	
	
	/**
	 *  复制备课夹
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/prepareCopy", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON copyPrepare(Long prepareId,String tfcode) throws Exception {
		

		return jPrepareService.copyPrepare(prepareId, tfcode);

	}
	
	/**
	 * 
	 * 移动备课夹
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/prepareMove", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON movePrepare(Long prepareId,String tfcode) throws Exception {

		return jPrepareService.movePrepare(prepareId, tfcode);

	}
	
	

	/**
	 * 备课夹导航节点的信息（包括分页页码信息）
	 * @param prepareId
	 * @param perPage  每页有多少条
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/prepareNodeInfo", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getPrepareNodeInfo(Long prepareId,int perPage) throws Exception {
		return jPrepareService.getPrepareNodeInfo(prepareId,perPage);

	}
	
	
	
	
	
	

	public static void main(String[] args) {
		String s = "20150416160806813.swf";

		System.out.println("1212112");

		Date d = new Date(1460603943000l);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(format.format(d));
	}

}