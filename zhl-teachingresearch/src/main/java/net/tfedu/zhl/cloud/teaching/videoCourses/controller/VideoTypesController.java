package net.tfedu.zhl.cloud.teaching.videoCourses.controller;

import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.teaching.teachCases.entity.TSubject;
import net.tfedu.zhl.cloud.teaching.videoCourses.entity.TVideoType;
import net.tfedu.zhl.cloud.teaching.videoCourses.service.VideoTypesService;
import net.tfedu.zhl.helper.ResultJSON;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 视频课程类型及相应类型下的学科
 * @author WeiCuicui
 *
 */
@Controller
@RequestMapping("/teachingServiceRestAPI")
public class VideoTypesController {

	@Resource VideoTypesService videoTypesService;
	/**
	 * 查询所有的视频课程类型
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/videoCourses/types", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getAllTypes() throws Exception{
		
		List<TVideoType> list = videoTypesService.getAllTypes();
		
		return ResultJSON.getSuccess(list);
	}
	
	/**
	 * 查询特定类型下的学科
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/videoCourses/subjects", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getSubjectsByType(int typeId) throws Exception{
		
		List<TSubject> list = videoTypesService.getSubjectsByType(typeId);	
		return ResultJSON.getSuccess(list);
	}
}
