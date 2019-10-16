package com.bjsxt.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjsxt.app.pojo.Users;
/**
 * 创建访问订单数据的dao接口
 * @author EDZ
 *
 */
public interface UsersDao extends JpaRepository<Users, Integer> {

}
