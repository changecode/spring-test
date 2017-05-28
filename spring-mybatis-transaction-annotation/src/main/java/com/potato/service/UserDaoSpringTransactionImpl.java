package com.potato.service;

import com.potato.code.User;
import com.potato.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Tim on 2017/5/27.
 */
@Service
public class UserDaoSpringTransactionImpl implements UserDao {

    @Resource
    private UserDao;

    public List<User> selectAllUsers() {
        return null;
    }

    /**
     * 加了@transaction注解却没有给类加@service @repository @controller
     * @component四个注解其一将类声明为一个spring的bean 那么方法的事务管理不会起作用
     * @param user
     * @return
     */
    @Transactional
    public int insertUser(User user) {
        //插入二条记录 模拟出错情况
        return 0 ;
    }
}
