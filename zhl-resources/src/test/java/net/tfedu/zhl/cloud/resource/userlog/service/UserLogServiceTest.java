package net.tfedu.zhl.cloud.resource.userlog.service;

import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.userlog.entity.ResourceViewLog;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;

import com.github.pagehelper.PageInfo;

public class UserLogServiceTest extends BaseControllerTestCase {

    @Resource
    UserLogService logService;

    @Test
    public void testGetMyViewList() {
        long userId = 390320126;

        long unifyTypeId = 0;
        String fileFormat = null;
        int page = 1;
        int prePage = 10;

        PageInfo info = logService.getMyViewLogFroResource(userId, unifyTypeId, fileFormat, page, prePage);
        List<ResourceViewLog> list = info.getList();
        System.out.println(info.getNavigatePages());
        for (ResourceViewLog log : list) {
            System.out.println(log.toString());
        }

    }

}
