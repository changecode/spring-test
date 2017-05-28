package com.potato.main;

import com.potato.code.User;
import com.potato.dao.UserDao;
import com.potato.service.UserDaoImpl;

/**
 * Created by Tim on 2017/5/27.
 */
public class UserTest {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        User user = new User();
        user.setName("test mybatis");
    }
}
