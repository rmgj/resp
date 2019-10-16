package com.bjsxt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjsxt.app.pojo.Users;
import com.bjsxt.app.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	/***
	 * 处理用户注册请求
	 */
	@PostMapping("/users")
	public String saveOrders(Users users) {
		 usersService.saveUsersService(users);
		 
		 return "注册成功,登录："+users.getEmail()+",进行账户激活......";
	}
}
