package com.code.dao;

import com.code.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Tim on 2017/5/26.
 */
public interface UserDao {

    public int countAllUsers();

    public void insertUser(User user);

    public List<User> getAllUser();

    public User getById(String id);

    public void deleteUser(String id);

    public void updateUser(Map<String, Object> map);
}
