/**
 * 
 */
package net.tfedu.zhl.cloud.core.online.service;

import java.util.Calendar;

import javax.annotation.Resource;

import org.junit.Test;

import net.tfedu.zhl.helper.tests.BaseControllerTestCase;
import net.tfedu.zhl.sso.online.entity.JOnlineUsers;
import net.tfedu.zhl.sso.online.service.JOnlineUsersService;

/**
 * @author wangwr
 *
 */
public class JOnlineUsersServiceTest extends BaseControllerTestCase {

    @Resource
    JOnlineUsersService service;

    @Test
    public void testgetUserOnlines() {
        // service.getUserOnlines(1l,null);

    }

    @Test
    public void testaddUserOnline() {
        JOnlineUsers user = new JOnlineUsers();

        user.setUserid(1l);
        user.setClienttype(1);
        user.setClientversion("dddd");
        user.setDeviceinfo("xxxxxxxxxxxxx");
        user.setLoginip("xxxx");
        user.setLoginnodeid(1l);
        user.setLogintime(Calendar.getInstance().getTime());
        user.setLastopertime(Calendar.getInstance().getTime());
        user.setFlag(true);
        user.setStatus(1);
        user.setToken("xxxxxxxtoken");
        // service.addUserOnline(user);
    }

    @Test
    public void testupdateOnlineStatus() {
        service.updateOnlineStatus("xxxxxxxtoken", 4);
    }

    @Test
    public void testupdateLastOperTime() {

        service.updateLastOperTime("xxxxxxxtoken", Calendar.getInstance().getTime());
    }

    @Test
    public void testuplogout() {

        service.logout("xxxxxxxtoken");
    }

}
