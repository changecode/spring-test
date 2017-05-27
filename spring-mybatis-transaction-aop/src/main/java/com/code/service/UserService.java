package com.code.service;

import com.code.domain.User;

import java.util.Map;

/**
 * Created by Tim on 2017/5/26.
 */
public interface UserService {

    public int  countAll();

    public void insertUser(User user);

    public void update_insert(Map map, User user);
}
