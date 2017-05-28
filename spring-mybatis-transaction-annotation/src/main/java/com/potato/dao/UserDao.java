package com.potato.dao;

import com.potato.code.User;

import java.util.List;

/**
 * Created by Tim on 2017/5/27.
 */
public interface UserDao {
     List<User> selectAllUsers();
     int insertUser(User user);
}
