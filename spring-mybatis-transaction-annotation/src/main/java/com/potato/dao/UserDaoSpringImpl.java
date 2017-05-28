package com.potato.dao;

import com.potato.code.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Tim on 2017/5/27.
 */
@org.springframework.stereotype.Repository
public class UserDaoSpringImpl extends SqlSessionDaoSupport implements UserDao {

    private static final String NAMESPACESTRING ="UserMapper.";

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<User> selectAllUsers() {
        return getSqlSession().selectList(NAMESPACESTRING + "selectAllUser");
    }

    public int insertUser(User user) {
        return getSqlSession().insert(NAMESPACESTRING + "insertUser", user);
    }
}
