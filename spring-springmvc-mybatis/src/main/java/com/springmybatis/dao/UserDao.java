package com.springmybatis.dao;

import com.springmybatis.model.User;

/**
 * user dao
 * 
 * @author Tim
 *
 */
public interface UserDao {

	User selectByPrimaryKey(Integer id);
	
	void insertUser(User user);
}
