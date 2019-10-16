package com.bjsxt.app.service.impl;

import javax.transaction.Transactional;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.app.dao.UsersDao;
import com.bjsxt.app.pojo.Users;
import com.bjsxt.app.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	//注入Dao接口
	@Autowired
	private UsersDao ordersDao;
	//注入访问mq的模板对象
	@Autowired
	private AmqpTemplate amqpTemplate;
	 

	@Transactional
	@Override
	public String saveUsersService(Users users) {
		// TODO Auto-generated method stub
		users.setLocks("0"); //默认账户锁定
		//完成用户信息持久化
		ordersDao.save(users);
		System.out.println("当前用户id----------"+users.getId());
		String msg=users.getEmail()+","+users.getId();
		//将用户注册时候的邮件地址和用户id保存到mq中
		amqpTemplate.convertAndSend("email", msg);
		return "success";
	}

}
