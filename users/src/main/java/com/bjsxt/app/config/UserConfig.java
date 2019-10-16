package com.bjsxt.app.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

	/***
	 * 创建队列
	 */
	@Bean
	public Queue queue() {
		System.out.println("==========Queue");
		return new Queue("email");
	}
	
}
