package com.sy.bbs.dao;

import java.util.Date;

import org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sy.bbs.model.Answer;
import com.sy.bbs.model.Topic;
import com.sy.bbs.model.User;

import org.junit.Test;

/**
 * @author john
 *
 * @time 2017年4月10日 下午3:20:58
 */
public class AnswerDaoImplTest {

	@Test
	public void testAdd() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AnswerDao answerDao = (AnswerDao)ctx.getBean("answerDao");
		
		Answer answer = new Answer();
		answer.setContent("发发呆是发的发");
		answer.setCreatetime(new Date());
		
		Topic topic = new Topic();
		topic.setId(1);
		
		User user = new User();
		user.setId(1);
		
		answer.setTopic(topic);
		answer.setUser(user);
		
		answerDao.add(answer);
		
	}

}
