package net.tfedu.zhl.cloud;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.demo.controller.CountryController;
import net.tfedu.zhl.cloud.demo.entity.Country;
import net.tfedu.zhl.cloud.utils.datatype.JsonUtil;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @Transactional 注释标签是表明此测试类的事务启用，这样所有的测试方案都会自动的 rollback，
 *  即您不用自己清除自己所做的任何对数据库的变更了
 * @author bruce
 *
 */
@Transactional
public class CountryControllerTest extends BaseControllerTestCase {

    @Resource
    CountryController countryController;

    @Test
    // @Rollback(false)
    public void testAdd() throws Exception {
        Country c = new Country();
        c.setCname("china");
        c.setCcode("1000");
        ResultJSON json = countryController.create(request, response, c);
        JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
    }

    @Test
    // @Rollback(false)
    public void testAddArray() throws Exception {
        Country[] list = new Country[10];
        for (int i = 0; i < 10; i++) {
            Country c = new Country();
            c.setCname("china");
            c.setCcode("1000" + i);
            list[i] = c;
        }

        ResultJSON json = countryController.addArray(request, response, list);
        JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
    }

    @Test
    // @Rollback(false)
    public void testUpdate() throws Exception {
        Country entity = new Country();
        entity.setCname("china");
        ResultJSON json = countryController.update(request, response, entity);
        JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
    }

    @Test
    // @Rollback(false)
    public void testDelete() throws Exception {
        ResultJSON json = countryController.delete(request, 6);
        JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
    }

    @Test
    public void testGetPage() {
        request.addParameter("pageNum", "1");
        request.addParameter("pageSize", "10");
        ResultJSON json = countryController.getPage(request, response);
        JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
    }

    @Test
    public void testGetSelective() {
        ResultJSON json = countryController.queryMaps(request, response);
        JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
    }

    @Test
    public void testGetByProperty() {
        ResultJSON json = countryController.queryIds(request, response);
        JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
    }
}
