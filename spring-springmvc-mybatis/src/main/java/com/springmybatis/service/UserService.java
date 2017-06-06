package com.springmybatis.service;

import com.springmybatis.model.User;

/**
 * controller invoke service layer
 * 
 * @author Tim
 *
 */
public interface UserService {

	User selectByPrimaryKey(Integer id);
	
	void insertUser(User user) throws Exception;
	
	void insertDouble();
}
