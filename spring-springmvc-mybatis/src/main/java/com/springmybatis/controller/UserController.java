package com.springmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmybatis.model.User;
import com.springmybatis.service.UserService;

/**
 * @RestController ��ע���൱��@Controller + @ResponseBody����ע��֮�͵�����
 * 
 **/
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public User getUserInfoById(Integer id){
		return userService.selectByPrimaryKey(id);
	}
	
	@RequestMapping("/test")
	public String redictjsp(){
		return "index";
	}
}
