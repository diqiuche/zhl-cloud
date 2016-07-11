package net.tfedu.zhl.cloud.teaching.teachCases;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.teaching.teachCases.service.TeachCasesService;
import net.tfedu.zhl.cloud.teaching.videoCourses.service.VideoCommentsService;
import net.tfedu.zhl.cloud.teaching.videoCourses.service.VideoCoursesService;
import net.tfedu.zhl.helper.tests.BaseServiceTestCase;

import org.junit.Test;

/**
 * 服务单元测试
 * @author WeiCuicui
 *
 */
public class TeachCasesServiceTest extends BaseServiceTestCase{

	@Resource TeachCasesService teachCasesService;
	@Resource VideoCoursesService videoCoursesService;
	@Resource VideoCommentsService videoCommentsService;
	
	//新建一个教学案例
	@Test
	public void addOneTeachCase()throws Exception{
		String teachCase = "{title:'haha',teacher:'roma',school:'beijingyoudiandaxue',thumbnailpath:'a/b'," +
				"gradeid:1,fromflag:1,termid:1,subjectid:1,teachdate:'20150607'}";
		long userId = 699230735;
		teachCasesService.createOneTeachCase(teachCase, userId);
		
	}
	
	//编辑一个教学案例
	@Test
	public void editOneTeachCase()throws Exception{
		String teachCase = "{title:'gaga',teacher:'cuicui',school:'beijingyoudiandaxue',thumbnailpath:'a/b'," +
				"gradeid:1,fromflag:1,termid:1,subjectid:1,teachdate:'20150607'}";
		long userId = 699230735;
		teachCasesService.editOneTeachCase(teachCase, userId);
	}
	
	//新增一个内容
	@Test
	public void addOneContent()throws Exception{
		long caseId = 1;
		int typeId = 1;
		String fname = "djdj";
		String title = "内容1";
		long userId = 980;
		teachCasesService.addOneContent(caseId, typeId, fname, title, userId);
	}
	
	//新增一个视频课程
	@Test
	public void addOneVideoCourse()throws Exception{
		String video = "{title:'uuuu',speakerinfo:'张三   北京大学',description:'88799',typeid:1,subjectid:2," +
				"fromflag:1,thumbnailpath:'7/9',fname:'98ij',playtime:10}";
		long userId = 7890;
		videoCoursesService.insertOneVideoCourse(video, userId);
	}
	
	//编辑一个视频课程
	@Test
	public void editOneVideoCourse()throws Exception{
		String video = "{title:'0890',speakerinfo:'李四   清华大学',description:'88799',typeid:1,subjectid:2," +
				"fromflag:1,thumbnailpath:'7/9',fname:'98ij',playtime:10}";
		long userId = 7867889;
		videoCoursesService.editOneVideoCourse(video, userId);
	}
	
	//新建一个评论
	@Test
	public void addOneComment()throws Exception{
		long videoId = 1;
		String comment = "jj";
		int isScore = 0;
		long userId = 2323;
		videoCommentsService.insertOneComment(videoId, comment, isScore, userId);
	}
	
	//编辑一个评论
	@Test
	public void editOneComment()throws Exception{
		long id = 1;
		String comment = "ddd";
		videoCommentsService.editOneComment(comment, id);
	}
	
}
