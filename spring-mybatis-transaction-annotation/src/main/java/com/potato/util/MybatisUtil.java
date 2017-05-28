package com.potato.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.Reader;

/**
 * Created by Tim on 2017/5/27.
 */
public class MybatisUtil {
    protected static SqlSessionFactory sessionFactory;
    protected static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("config.xml");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected SqlSession getSqlSession() {
        return sessionFactory.openSession();
    }
}
