package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmybatis.dao.UserDao;
import com.springmybatis.model.User;

public class SpringmvcMybatisTest {

	private UserDao userDao;
	private ApplicationContext ac;
	
	/**
	 * init params
	 */
	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		userDao = (UserDao)ac.getBean("userDao");
	}
	
	@Test
	public void testSelectUser() {
		User user = userDao.selectByPrimaryKey(1);
		System.out.println("result:\t" + user);
	}
	
	@Test
	public void testInsertUser() throws Exception {
		
	}
	
	/**
	 * destory params
	 */
	@After
	public void after() {
		userDao = null;
		ac = null;
	}
}
