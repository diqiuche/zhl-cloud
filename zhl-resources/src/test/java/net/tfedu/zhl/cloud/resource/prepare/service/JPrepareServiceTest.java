
package net.tfedu.zhl.cloud.resource.prepare.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepare;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContent;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContentView;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareView;
import net.tfedu.zhl.cloud.resource.prepare.entity.ResourceSimpleInfo;
import net.tfedu.zhl.cloud.resource.prepare.entity.UserPrepareStatisInfo;
import net.tfedu.zhl.cloud.resource.prepare.util.JPrepareConstant;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.util.Assert;

public class JPrepareServiceTest extends BaseControllerTestCase {

    @Resource
    JPrepareService jPrepareService;

    long userId = 699230739;

    String tfcode = "RJCZ010109";

    /**
     * 增加备课夹
     * 
     * @param obj
     * @return
     */
    @Test
    public void testaddPrepare() {

        // 新建备课夹
        Date currentDate = Calendar.getInstance().getTime();
        String title = "testaddPrepare";

        JPrepare prepare = new JPrepare();
        prepare.setUserid(userId);
        prepare.setCreatetime(currentDate);
        prepare.setTfcode(tfcode);
        prepare.setTitle(title);
        // jPrepareService.addPrepare(prepare);

        Assert.isTrue(prepare.getId() > 0);

    }

    /**
     * 修改备课夹
     * 
     * @param obj
     */
    @Test
    public void testeditPrepare() {

        JPrepare prepare = new JPrepare();
        prepare.setId(140250l);
        prepare.setTitle("xxxxxxx");

        jPrepareService.editPrepare(prepare);

    }

    /**
     * 删除备课夹
     * 
     * @param id
     */
    @Test
    public void testdeletePrepareById() {
        jPrepareService.deletePrepareById(140250l);

    }

    /**
     * 增加备课夹内容
     * 
     * @param content
     * @return
     * @throws Exception 
     */
    @Test
    public void testaddPrepareContent() throws Exception {
        Date currentDate = Calendar.getInstance().getTime();

        // 将资源加入备课夹
        JPrepareContent cont = new JPrepareContent();
        cont.setPreid(140249l);
        cont.setContid(212992l);
        cont.setConttype(JPrepareConstant.CONTTYPE_SYSRES);
        cont.setCreatetime(currentDate);

        jPrepareService.addPrepareContent(cont);

    }
    /**
     * 增加备课夹内容
     * 
     * @param content
     * @return
     * @throws Exception 
     */
    @Test
    public void testaddPrepareContentList() throws Exception {
        Date currentDate = Calendar.getInstance().getTime();

        // 将资源加入备课夹
        JPrepareContent cont = new JPrepareContent();
        cont.setPreid(140249l);
        cont.setContid(212994l);
        cont.setConttype(JPrepareConstant.CONTTYPE_SYSRES);
        cont.setCreatetime(currentDate);
        // 将资源加入备课夹
        JPrepareContent cont2 = new JPrepareContent();
        cont2.setPreid(140249l);
        cont2.setContid(212995l);
        cont2.setConttype(JPrepareConstant.CONTTYPE_SYSRES);
        cont2.setCreatetime(currentDate);
        
        List<JPrepareContent> list = new ArrayList<JPrepareContent>();
        list.add(cont);
        list.add(cont2);
        
        jPrepareService.addPrepareContentList(list);

    }
    /**
     * 修改备课夹内容
     * 
     * @param content
     * @return
     */
    @Test
    public void testeditPrepareContent() {
        JPrepareContent cont = new JPrepareContent();
        cont.setId(560617l);
        cont.setFlag(true);

        jPrepareService.editPrepareContent(cont);
    }

    /**
     * 删除备课夹内容
     * 
     * @param content
     * @return
     * @throws Exception 
     */
    @Test
    public void testdeletePrepareContentById() throws Exception {
        jPrepareService.deletePrepareContentById(560617l);

    }

    /**
     * 清空目标备课夹下的所有备课夹
     * 
     * @param prepareId
     */
    @Test
    public void testclearPrepareContentByPrepareId() {
        jPrepareService.clearPrepareContentByPrepareId(140249l);

    }

    /**
     * 获取备课夹
     * 
     * @param tfcode
     * @return
     */
    @Test
    public void testqueryPrepareList() {

        List<JPrepareView> list = jPrepareService.queryPrepareList(tfcode, userId);

        System.out.println(list.size());
        System.out.println(list.get(0).getTitle());

    }

    /**
     * 获取备课夹及其时间范围
     * 
     * @param tfcode
     * @return
     */
    @Test
    public void testqueryPrepareAndTimeScopeList() {
        List<JPrepareView> list = jPrepareService.queryPrepareAndTimeScopeList(tfcode,null, userId);

        System.out.println(list.size());
        System.out.println(list.get(0).getTimeLabel());

    }

    /**
     * 获取备课夹内容列表
     * 
     * @param prepareId
     * @return
     */
    @Test
    public void testqueryPrepareContentList() {
        long prepareId = 140249l;
        List<JPrepareContentView> list = jPrepareService.queryPrepareContentList(prepareId);

        Assert.isTrue(list.size() > 0);

        System.out.println(list.get(0).getImgPath());

    }

    /**
     * 删除备课夹中指定的类型的资源
     * 
     * @param prepareId
     * @param contType
     * @param contId
     */
    @Test
    public void testremoveResourceFromPrepare() {

        long prepareId = 140249l;
        int contType = 10;
        long contId = 212992;
        jPrepareService.removeResourceFromPrepare(prepareId, contType, contId);

    }

    /**
     * 无节点选择时系统资源加入备课夹接口
     * 
     * @param resCode
     */
    @Test
    public void testaddToPrepareWithOnlySysResource() {
        jPrepareService.addToPrepareWithOnlySysResource("newzy020101806612", userId);
    }

    @Test
    public void testGetAssetInfo() {

        String ids[] = new String[] { "661", "661", "50126" };
        String fromFlags[] = new String[] { "3", "0", "1" };
        List<ResourceSimpleInfo> list = jPrepareService.getResourceSimpleInfo(ids, fromFlags);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());

        }
    }

    @Test
    public void testGetPrepareContentListByUserId() {

        long userId = 390330126;
        long unifyTypeId = 0;
        String fileFormat = "图片";
        int page = 1;
        int prePage = 10;

        Pagination p = jPrepareService.getPrepareContentListByUserId(userId, unifyTypeId, fileFormat, page, prePage);

        System.out.println("getTotal:" + p.getTotal() + ";getPage:" + p.getPage() + ";getPerPage:" + p.getPerPage()
                + ";list.size:" + p.getList().size());

    }

    @Test
    public void testremoveMyPrepareContentResource() throws Exception {
        long userId = 390330126;
        String resIds = "4319500105,212992,212991";
        String fromFlags = "0,0,0";

        jPrepareService.removeMyPrepareContentResource(userId, resIds, fromFlags);

    }

    @Test
    public void testPrepareStatic() {
        long userId = 390320126;
        List<UserPrepareStatisInfo> list = jPrepareService.getMyPrepareStatis(userId);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

}