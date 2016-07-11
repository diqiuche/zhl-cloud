package net.tfedu.zhl.cloud.resource.sysRes.userComment;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.userComment.controller.UserCommentController;
import net.tfedu.zhl.cloud.utils.datatype.JsonUtil;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * 资源评论 相关controller的单元测试
 * @author WeiCuicui
 *
 */
public class UserCommentControllerTest extends BaseControllerTestCase{

	@Resource UserCommentController userCommentController;
	
	/**
	 * 添加评论
	 * @throws Exception
	 */
	@Test
	public void testAddUserComments()throws Exception{
		request.setParameter("resId", "31250");
		request.setParameter("displayContent", "It is good.");
		request.setParameter("fromFlag", "0");
		request.setParameter("ascore", "3");
		request.setParameter("isScore", "0");
		
		ResultJSON json = userCommentController.updateUserComment(request, response);
		JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
		
	}
	
	/**
	 * 修改评论
	 * @throws Exception
	 */
	@Test
	public void testUpdateUserComments()throws Exception{
		request.setParameter("_method", "PATCH");
		request.setParameter("commentId", "10600");
		request.setParameter("displayContent", "It is good.");
		
		ResultJSON json = userCommentController.updateUserComment(request, response);
	
		JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	
	/**
	 * 查询我的评论
	 * @throws Exception
	 */
	@Test
	public void testGetMycomments()throws Exception{
		request.setParameter("resId", "31250");
		request.setParameter("fromFlag", "0");
		
		ResultJSON json = userCommentController.getMycomments(request, response);
		
		JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 查询其他人的评论
	 * @throws Exception
	 */
	@Test
	public void testGetOtherComments()throws Exception{
		request.setParameter("resId", "31250");
		request.setParameter("fromFlag", "0");
		
		ResultJSON json = userCommentController.getOthercomments(request, response);
		
		JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 删除评论
	 * @throws Exception
	 */
	@Test
	public void testDeleteUserComments()throws Exception{
		request.setParameter("_method", "DELETE");
		request.setParameter("commentId", "10600");
		
		ResultJSON json = userCommentController.updateUserComment(request, response);
		
		JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
}
