package com.potato.service;

import com.potato.code.User;
import com.potato.dao.UserDao;
import com.potato.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Tim on 2017/5/27.
 */
public class UserDaoImpl extends MybatisUtil implements UserDao{
    private static final String NAMESPACE = "UserMapper.";

    public List<User> selectAllUsers(){
        SqlSession ss = getSqlSession();
        List<User> list = ss.selectList(NAMESPACE + "selectAllUsers");
        ss.close();
        return list;
    }

    public int insertUser(User user) {
        SqlSession ss = getSqlSession();
        int id = ss.insert(NAMESPACE + "insertUser", user);
        ss.close();
        return id;
    }


}
