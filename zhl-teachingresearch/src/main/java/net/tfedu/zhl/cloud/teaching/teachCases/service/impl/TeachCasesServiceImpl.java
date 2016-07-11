package net.tfedu.zhl.cloud.teaching.teachCases.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.teaching.teachCases.dao.TContentsMapper;
import net.tfedu.zhl.cloud.teaching.teachCases.dao.TeachCasesMapper;
import net.tfedu.zhl.cloud.teaching.teachCases.entity.TCaseContents;
import net.tfedu.zhl.cloud.teaching.teachCases.entity.TContents;
import net.tfedu.zhl.cloud.teaching.teachCases.entity.TeachCases;
import net.tfedu.zhl.cloud.teaching.teachCases.service.TeachCasesService;
import net.tfedu.zhl.cloud.utils.datatype.JsonUtil;
import net.tfedu.zhl.helper.PaginationHelper;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

/**
 * 教学案例serviceImpl
 * @author WeiCuicui
 *
 */
@Service("teachCasesService")
public class TeachCasesServiceImpl implements TeachCasesService{

	@Resource TeachCasesMapper teachCasesMapper;
	@Resource TContentsMapper tContentsMapper;
	/**
	 * 根据所属平台、学段、学科，查询所有的教学案例
	 * @param fromFlag  0 双课堂； 1 资源中心
	 * @param termId
	 * @param subjectId
	 * @param page
	 * @param perPage
	 * @return
	 */
	public PaginationHelper<TeachCases> selectAllCases(int fromFlag,int termId,int subjectId,int page,int perPage){
		
		PageHelper.startPage(page,perPage);
		
		List<TeachCases> list = teachCasesMapper.selectAllCases(fromFlag, termId, subjectId);
		
		return PaginationHelper.transfer(list);
	}
	
	/**
	 * 新增一个教学案例
	 * @param teachCase
	 */
	public void createOneTeachCase(String teachCase,long userId){
		TeachCases item = new TeachCases();
		
		//将json字符串中的 " 替换为 '
		teachCase = teachCase.replace('"', '\'');
		item = JsonUtil.getInstance().fromJson(teachCase, TeachCases.class);
		item.setCreator(userId);
		
		teachCasesMapper.addOneTeachCase(item);
	}
	
	/**
	 * 编辑一个教学案例
	 * @param teachCase
	 * @param userId
	 */
	public void editOneTeachCase(String teachCase,long userId){
		TeachCases item = new TeachCases();
		//将json字符串中的 " 替换为 '
	    teachCase = teachCase.replace('"', '\'');
		item = JsonUtil.getInstance().fromJson(teachCase, TeachCases.class);
		item.setCreator(userId);
		
		teachCasesMapper.editOneTeachCase(item);
	}
	
	
	/**
	 * 删除一个教学案例
	 * @param caseId
	 */
	public void deleteOneTeachCase(long caseId){
		teachCasesMapper.deleteOneTeachCase(caseId);
	}
	
	/**
	 * 查询一个教学案例的详细信息
	 * @param id
	 * @return
	 */
	public TeachCases selectOneTeachCase(long id){
		return teachCasesMapper.selectOneTeachCase(id);
	}
	
	/**
	 * 查询一个教学案例下的所有内容
	 * @param id  教学案例的id
	 * @return
	 */
	public List<TCaseContents> getAllContents(long id){
		return teachCasesMapper.getAllContentsOfTeachCase(id);
	}
	
	/**
	 * 增加一个内容
	 * @return result 两种状态：上传成功 或 相同类型的内容已经存在
	 */
	public String addOneContent(long caseId,int contentTypeId,String fname,String title,long userId){
		String result = "";
		if(teachCasesMapper.selectOneContent(contentTypeId,caseId) > 0){//已经存在了，不再插入
			//提示 该类型的内容已经存在，请上传其它类型的内容
			result = "已存在该类型的内容，请上传其它类型的内容";
		} else {
			teachCasesMapper.addOneContent(caseId, contentTypeId, fname,title,userId);
			result = "success";
		}
		
		return result;
	}
	
	/**
	 * 删除教学案例下的一个内容
	 * @param caseId
	 * @param contentTypeId
	 */
	public void deleteOneContent(long id){
		teachCasesMapper.deleteOneContent(id);
	}
	
	/**
	 * 查询所有的内容类型
	 * @return
	 */
	public List<TContents> getAllContentTypes(){
		return tContentsMapper.getAllContentTypes();
	}
	
}
