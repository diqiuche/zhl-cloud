
package net.tfedu.zhl.cloud.resource.personal.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tfedu.zhl.cloud.resource.asset.entity.ReviewResultStatis;
import net.tfedu.zhl.cloud.resource.asset.service.ZAssetService;
import net.tfedu.zhl.cloud.resource.customizeres.entity.CustomizeResResult;
import net.tfedu.zhl.cloud.resource.customizeres.service.CustomizeResService;
import net.tfedu.zhl.cloud.resource.downloadrescord.service.ResZipDownloadService;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContentViewUtil;
import net.tfedu.zhl.cloud.resource.prepare.service.JPrepareService;
import net.tfedu.zhl.cloud.resource.resourceList.entity.PageInfoToPagination;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.cloud.resource.userlog.service.UserLogService;
import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.cloud.utils.security.PWDEncrypt;
import net.tfedu.zhl.config.CommonWebConfig;
import net.tfedu.zhl.core.exception.ParamsException;
import net.tfedu.zhl.fileservice.Base64;
import net.tfedu.zhl.fileservice.MD5;
import net.tfedu.zhl.fileservice.xxtea;
import net.tfedu.zhl.helper.ControllerHelper;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.sso.user.service.UserService;
import net.tfedu.zhl.sso.users.entity.SRegister;
import net.tfedu.zhl.sso.users.service.RegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

/**
 * 个人空间 controller
 * 
 * @author wangwr
 * 
 */
@Controller
@RequestMapping("/resRestAPI")
public class PersonalController {

	/**
	 * 自建资源service
	 */
	@Resource
	ZAssetService assetService;

	/**
	 * 备课夹service
	 */
	@Resource
	JPrepareService prepareService;

	/**
	 * 下载记录service
	 */
	@Resource
	ResZipDownloadService downService;

	/**
	 * 日志service
	 */
	@Resource
	UserLogService userLogService;

	@Resource
	private UserService userService;

	@Resource
	private RegisterService registerService;

	@Resource
	private CustomizeResService customizeResService;

	/**
	 * web配置组件
	 */
	@Autowired
	private CommonWebConfig commonWebConfig;

	/**
	 * 获取统一资源类型(改为获取全部)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resource/unifyType", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getUnifyType(HttpServletRequest request, HttpServletResponse response) {
		// 返回
		Object data = assetService.getAllResType();
		return ResultJSON.getSuccess(data);
	}

	/**
	 * 获取资源类型(根据文件的后缀)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resource/unifyType4ext", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getUnifyType4ext(String ext) throws Exception {
		// 返回
		Object data = assetService.getTypeForExt(ext);
		return ResultJSON.getSuccess(data);
	}

	/**
	 * 获取文件格式
	 * 
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resource/fileFormat", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getFileFormat(HttpServletRequest request, HttpServletResponse response) {
		// 返回
		Object data = assetService.getAllFileFormat();
		return ResultJSON.getSuccess(data);
	}

	/**
	 * 分页获取我的备课资源
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resource/prepareResource", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getMyPrepareResource(HttpServletRequest request, HttpServletResponse response) {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		Object data = null;
		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);

		long userId = currentUserId;
		long unifyTypeId = 0;
		int page = 1;
		int prePage = 10;

		String _unifyTypeId = request.getParameter("unifyTypeId");
		String _page = request.getParameter("page");
		String _prePage = request.getParameter("perPage");
		String fileFormat = request.getParameter("fileFormat");
		if (StringUtils.isNotEmpty(_unifyTypeId)) {
			unifyTypeId = Long.parseLong(_unifyTypeId);
		}
		if (StringUtils.isNotEmpty(_page)) {
			page = Integer.parseInt(_page);
		}
		if (StringUtils.isNotEmpty(_prePage)) {
			prePage = Integer.parseInt(_prePage);
		}
		Pagination page_result = prepareService.getPrepareContentListByUserId(userId, unifyTypeId, fileFormat, page,
				prePage);

		JPrepareContentViewUtil.convertToPurpose(page_result.getList(), resServiceLocal, currentResPath);
		data = page_result;
		return ResultJSON.getSuccess(data);
	}

	/**
	 * 删除备课资源
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resource/prepareResource", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON removeMyPrepareResource(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 返回
		Object data = null;
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");

		String _method = request.getParameter("_method");
		String resIds = request.getParameter("resIds");
		String fromFlags = request.getParameter("fromFlags");
		if (StringUtils.isNotEmpty(_method) && RequestMethod.DELETE.name().equalsIgnoreCase(_method)) {
			prepareService.removeMyPrepareContentResource(currentUserId, resIds, fromFlags);
		} else {
			throw new ParamsException();
		}
		return ResultJSON.getSuccess(data);
	}

	/**
	 * 分页获取我的下载
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resource/myDownload", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getMyDownload(HttpServletRequest request, HttpServletResponse response) {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;
		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);

		long userId = currentUserId;
		long unifyTypeId = 0;
		int page = 1;
		int prePage = 10;

		String _unifyTypeId = request.getParameter("unifyTypeId");
		String _page = request.getParameter("page");
		String _prePage = request.getParameter("perPage");
		String fileFormat = request.getParameter("fileFormat");
		if (StringUtils.isNotEmpty(_unifyTypeId)) {
			unifyTypeId = Long.parseLong(_unifyTypeId);
		}
		if (StringUtils.isNotEmpty(_page)) {
			page = Integer.parseInt(_page);
		}
		if (StringUtils.isNotEmpty(_prePage)) {
			prePage = Integer.parseInt(_prePage);
		}
		Pagination page_result = downService.getMydownload(userId, unifyTypeId, fileFormat, page, prePage);
		JPrepareContentViewUtil.convertToPurpose(page_result.getList(), resServiceLocal, currentResPath);
		data = page_result;
		return ResultJSON.getSuccess(data);
	}

	/**
	 * 分页我获取的资源评论
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resource/userReview", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getMyReview(HttpServletRequest request, HttpServletResponse response) {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;
		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);

		long userId = currentUserId;
		int reviewType = 0;
		int page = 1;
		int prePage = 10;

		String _reviewType = request.getParameter("reviewType");
		String _page = request.getParameter("page");
		String _prePage = request.getParameter("perpage");
		if (StringUtils.isNotEmpty(_reviewType)) {
			reviewType = Integer.parseInt(_reviewType);
		}
		if (StringUtils.isNotEmpty(_page)) {
			page = Integer.parseInt(_page);
		}
		if (StringUtils.isNotEmpty(_prePage)) {
			prePage = Integer.parseInt(_prePage);
		}
		Pagination page_result = assetService.getMyReview(userId, reviewType, page, prePage);
		JPrepareContentViewUtil.convertToPurpose_Review(page_result.getList(), resServiceLocal, currentResPath);
		data = page_result;
		return ResultJSON.getSuccess(data);
	}

	/**
	 * 分页未评论的资源
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resource/unReview", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getUnReview(HttpServletRequest request, HttpServletResponse response) {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;
		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);

		long userId = currentUserId;
		int page = 1;
		int prePage = 10;

		String _page = request.getParameter("page");
		String _prePage = request.getParameter("perpage");

		if (StringUtils.isNotEmpty(_page)) {
			page = Integer.parseInt(_page);
		}
		if (StringUtils.isNotEmpty(_prePage)) {
			prePage = Integer.parseInt(_prePage);
		}
		Pagination page_result = assetService.getUnReview(userId, page, prePage);

		JPrepareContentViewUtil.convertToPurpose_Review(page_result.getList(), resServiceLocal, currentResPath);
		data = page_result;

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 删除资源评论
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resource/userReview", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON removeMyReview(HttpServletRequest request, HttpServletResponse response) {
		// 返回
		Object data = null;
		String ids = request.getParameter("ids");
		assetService.removeMyReview(ids);
		return ResultJSON.getSuccess(data);
	}

	/**
	 * 资源评论统计
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resource/userReviewStatis", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON statisMyReview(HttpServletRequest request, HttpServletResponse response) {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		ReviewResultStatis _result = assetService.getReviewStatis(currentUserId);
		data = _result;

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 分页获取我的最近浏览
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resource/userview", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getMyViewList(HttpServletRequest request, HttpServletResponse response) {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;
		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);

		long userId = currentUserId;
		long unifyTypeId = 0;
		int page = 1;
		int prePage = 10;

		String _unifyTypeId = request.getParameter("unifyTypeId");
		String _page = request.getParameter("page");
		String _prePage = request.getParameter("perPage");
		String fileFormat = request.getParameter("fileFormat");
		if (StringUtils.isNotEmpty(_unifyTypeId)) {
			unifyTypeId = Long.parseLong(_unifyTypeId);
		}
		if (StringUtils.isNotEmpty(_page)) {
			page = Integer.parseInt(_page);
		}
		if (StringUtils.isNotEmpty(_prePage)) {
			prePage = Integer.parseInt(_prePage);
		}

		// 获取结果
		PageInfo info = userLogService.getMyViewLogFroResource(userId, unifyTypeId, fileFormat, page, prePage);
		Pagination _p = new PageInfoToPagination().transfer(info.getList());
		// 获取缩略图的最终url
		JPrepareContentViewUtil.convertToPurpose_view(_p.getList(), resServiceLocal, currentResPath);
		data = _p;
		return ResultJSON.getSuccess(data);
	}

	/**
	 * 统计备课夹信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/resource/prepareStatis", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON prepareStatis(HttpServletRequest request, HttpServletResponse response) {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;
		long userId = currentUserId;
		data = prepareService.getMyPrepareStatis(userId);

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 个人空间中的类型
	 * 
	 * tabCode: myPrepareRes,myUpload,myDownload,myView。不传递该参数时默认为myPrepareRes
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/personalTab/resType", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getResTypeForPersonal(HttpServletRequest request, HttpServletResponse response) {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;
		long userId = currentUserId;

		String tabCode = request.getParameter("tabCode");
		data = assetService.getResTypeForPersonalTab(tabCode, userId);

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 分页我获取的资源评论
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/resource/userReviewComment", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getMyReviewComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;
		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);

		long userId = currentUserId;
		int reviewType = ControllerHelper.getIntWithDefault(request, "reviewType");
		int page = ControllerHelper.getPage(request);
		int prePage = ControllerHelper.getPageSize(request);

		// String _reviewType = request.getParameter("reviewType");
		// String _page = ControllerHelper.getPage(request);
		// String _prePage = request.getParameter("perPage");
		// if (StringUtils.isNotEmpty(_reviewType)) {
		// reviewType = Integer.parseInt(_reviewType);
		// }
		// if (StringUtils.isNotEmpty(_page)) {
		// page = Integer.parseInt(_page);
		// }
		// if (StringUtils.isNotEmpty(_prePage)) {
		// prePage = Integer.parseInt(_prePage);
		// }
		Pagination page_result = assetService.getMyReviewComment(userId, reviewType, page, prePage);
		JPrepareContentViewUtil.convertToPurpose_Review(page_result.getList(), resServiceLocal, currentResPath);
		data = page_result;

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 
	 * 跳转到自主学习中心 教师学生通用接口
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/autoLearning")
	@ResponseBody
	public ResultJSON autoLearning(HttpServletRequest request, HttpServletResponse response) throws Exception {

		/**
		 * 默认使用这个
		 */
		String host = "http://fd.zhihaole.net/";
		String sub = "0101";
		String term = "GZ";

		// 拦截器读取配置文件 写入request
		String currentFDHost = commonWebConfig.getCurrentFdHost(request);

		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;
		long userId = currentUserId;
		SRegister record = registerService.getRegister(userId);
		String userName = record.getName();
		Long roleId = record.getRoleid();
		String userPwd = PWDEncrypt.getPWD(record.getPwd());

		HashMap<String, String> map = userService.getUserTermAndSubject(userId);
		if (map != null) {

			sub = map.get("subjectcode");
			term = map.get("termcode");

			if (sub.contains(",")) {
				sub = sub.split(",")[0];
			}

		}

		String params = "user=" + userName + "&pass=" + userPwd + "&page=1" + "&grd=" + term.toUpperCase() + "&sub="
				+ sub + "&ST=" + (1 == roleId ? "S" : 2 == roleId ? "T" : 5 == roleId ? "J" : "S");
		String sign = MD5.MD5(params + "&key=9k8i78jug6hd93kjf84h");
		String s = params + "&sign=" + sign;
		byte[] sbytes;
		sbytes = xxtea.encrypt(s.getBytes("utf-8"), "9k8i78jug6hd93kjf84h".getBytes());
		s = Base64.encode(sbytes, 0, sbytes.length);
		s = URLEncoder.encode(s, "utf-8");

		String str = ((currentFDHost != null && !"".equals(currentFDHost) && currentFDHost.length() > 0) ? currentFDHost
				: host) + "eblogin.do?s=";
		String url = str + s;
		data = url;

		System.out.println("-----autoLearning---" + url);

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 获取资源定制信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/customizeRes", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getCustomizeRes(HttpServletRequest request, HttpServletResponse response) {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;
		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);

		long userId = currentUserId;

		List<CustomizeResResult> resultList = customizeResService.getCustomizeResResult();
		for (CustomizeResResult customizeResResult : resultList) {
			if (customizeResResult != null && customizeResResult.getList() != null) {
				JPrepareContentViewUtil.convertToPurpose_Asset(customizeResResult.getList(), resServiceLocal,
						currentResPath);
			}
		}
		data = resultList;

		return ResultJSON.getSuccess(data);
	}

}
