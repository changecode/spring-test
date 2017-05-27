package com.code.daoimpl;

import com.code.dao.UserDao;
import com.code.domain.User;
import com.code.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Tim on 2017/5/26.
 */
@Service("userDao")
public class UserDaoImpl implements UserDao{

    @Autowired
    private UserMapper userMapper;

    public int countAllUsers() {
        return this.userMapper.countAllUsers();
    }

    public void insertUser(User user) {
        this.userMapper.insertUser(user);
    }

    public List<User> getAllUser() {
        return this.userMapper.getAllUser();
    }

    public User getById(String id) {
        return this.userMapper.getById(id);
    }

    public void deleteUser(String id) {
        this.userMapper.deleteUser(id);
    }

    public void updateUser(Map<String, Object> map) {
        this.userMapper.updateUser(map);
    }

}
