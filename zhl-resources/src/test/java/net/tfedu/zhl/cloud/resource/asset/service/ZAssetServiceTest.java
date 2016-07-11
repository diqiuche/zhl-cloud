package net.tfedu.zhl.cloud.resource.asset.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.asset.entity.ReviewResultStatis;
import net.tfedu.zhl.cloud.resource.asset.entity.ZAsset;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.FirstLevelResType;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;

public class ZAssetServiceTest  extends BaseControllerTestCase{

	
	@Resource
	ZAssetService  zAssetService ;
	
	
	@Test
	public void testGetAllResType() {
		List<FirstLevelResType> list =  zAssetService.getAllFirstLevelResType();
		for (int i = 0; i < list.size(); i++) {
			FirstLevelResType o  = list.get(i);
			System.out.println(o.getId()+o.getMtype()+o.getCode());			
		}
	}

	
	@Test
	public void testGetAllFileFormat() {
	   List<String> list = zAssetService.getAllFileFormat();
	   for (String string : list) {
		   System.out.println(string);
	   }
	}

	
	
	
	@Test
	public void testReviewStatic(){
		long userId =390330126;
		ReviewResultStatis s =  zAssetService.getReviewStatis(userId);
		System.out.println(s.getReviewNumber()+"-------"+s.getUnReviewNumber());
	}
	
	
	@Test
	public void testAdd(){
		Date createtime = Calendar.getInstance().getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhMMssSSS");

		
		long userId =390330126;
		String resourceId = userId+format.format(createtime) ;
		String keyword = "";
		Boolean iscourseware= false ;
		Boolean isIssue = false ;
		int islocal = 0 ;
		String filePath = "";
		
		
		ZAsset a  = new ZAsset();
		a.setUserid(userId);
		a.setFiletype("A");
		a.setCreatetime(createtime);
		a.setAssetpath("/upFile/2016/336/390330126/2016022816102398126-1.mp4");
		a.setAssetsize("2252258");
		a.setAssetdesc("");
		a.setIsfinished(1);
		a.setUnifytypeid(1);
		a.setName("20151105151125640.mp4");
		a.setTypeid(560413l);
		a.setIscourseware(iscourseware);
		a.setIslocal(islocal);
		a.setResourceid(resourceId);
		a.setIsissue(isIssue);
		a.setKeyword(keyword);
		a.setFilepath(filePath);
		List<ZAsset> list = new ArrayList<ZAsset>();
		List<String> codes = new ArrayList<String>();
		list.add(a);
		codes.add("RJCZ0101010101");
//		zAssetService.addAssetBatch(list,codes,"","","");
	}
	
	
	@Test
	public void testUpdate(){
		ZAsset a  = new ZAsset();
		a.setId(2705966l);
		a.setAssetdesc("setAssetdesc");
//		zAssetService.updateAsset(a,"","","");
	}
	
	@Test
	public void testDel(){
		Long id = 2705934l;
		zAssetService.delAsset(id.toString());
	}
	
	
	@Test
	public void testquery(){
		Long userId = 390330126l;
		String hostLocal = "http://192.168.111.160:8080/zhl-resources/";
		String resServiceLocal = "http://192.168.111.22:8099/down/";
		
		Pagination p =  zAssetService.queryMyAssets(userId, 0l, null, 1, 10,hostLocal,resServiceLocal);
		List list = p.getList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
	}


	@Test
	public void testQuery(){
		String path = "upFile\\2016\\390410126\\10105\\2016070415531745742-31.mp4";
		String newPath = "upFile\\2016\\390410126\\10105\\2016070415531745742-31-h264.mp4";

		zAssetService.updateAssetPath(path, newPath);
	}
	
	
	

}

