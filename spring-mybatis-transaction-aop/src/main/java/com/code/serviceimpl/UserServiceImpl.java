package com.code.serviceimpl;

import com.code.dao.UserDao;
import com.code.domain.User;
import com.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Tim on 2017/5/26.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public int countAll() {
        return this.userDao.countAllUsers();
    }

    public void insertUser(User user) {
        this.userDao.insertUser(user);
    }

    public void update_insert(Map map, User user) {
        this.userDao.updateUser(map);
        this.userDao.insertUser(user);
        throw new RuntimeException("Error");
    }
}
