package com.springmybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springmybatis.dao.UserDao;
import com.springmybatis.model.User;
import com.springmybatis.service.UserService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User selectByPrimaryKey(Integer id) {
		return userDao.selectByPrimaryKey(id);
	}

	@Override
	public void insertUser(User user) throws Exception{
		userDao.insertUser(user);
	}

	@Override
	public void insertDouble() {
		User user = new User();
		user.setId(2);
		userDao.insertUser(user);
		int a = 1 / 0;
		User user1 = new User();
		user1.setId(4);
		userDao.insertUser(user1);
	}

}
