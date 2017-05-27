package com.code.mapper;

import com.code.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Tim on 2017/5/26.
 */
@Service("userMapper")
public interface UserMapper {

    public int countAllUsers();

    public void insertUser(User user);

    public List<User> getAllUser();

    public User getById(String id);

    public void deleteUser(String id);

    public void updateUser(Map<String, Object> map);
}
