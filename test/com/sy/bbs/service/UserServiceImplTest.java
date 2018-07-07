package com.sy.bbs.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sy.bbs.model.Answer;
import com.sy.bbs.model.Topic;
import com.sy.bbs.model.User;

/**
 * @author john
 *
 * @time 2017年4月5日 下午4:22:55
 */
public class UserServiceImplTest {

	@Test
	public void testReply() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserService us = (UserService)ctx.getBean("userService");
		
		Answer answer = new Answer();
		answer.setContent("junittest");
		answer.setCreatetime(new Date());
		
		Topic topic = new Topic();
		topic.setId(1);
		topic = us.queryTopic(topic);
		answer.setTopic(topic);
		
		us.reply(answer);
		
	}

}
