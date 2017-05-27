package com.code;

import com.code.domain.User;
import com.code.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tim on 2017/5/26.
 */
public class UserTransactionAopTestTest {

    @Test
    public void testTestName() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)context.getBean("userService");

        User user = new User();
        user.setId("002");
        user.setName("索大");

        Map map = new HashMap();
        map.put("id", "003");
        map.put("name", "阿修罗");

        try {
            System.out.println(userService.countAll());
            userService.update_insert(map, user);
//            userService.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}