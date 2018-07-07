/**
 * 
 */
package com.sy.bbs.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sy.bbs.model.Topic;
import com.sy.bbs.model.User;

import org.junit.Test;

/**
 * @author huangsy
 * @time 2017年4月9日 下午10:51:35
 * TODO
 */
public class TopicDaoImplTest {

//	@Test
//	public void testQueryById() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testQueryAll() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		TopicDao topicDao = (TopicDao)ctx.getBean("topicDao");
		
		List<Topic> topices = topicDao.queryAll();
		
		for(Topic topic : topices) {
			System.out.println(topic.getName() + "->" + topic.getUser().getName());
		}
	}

}
