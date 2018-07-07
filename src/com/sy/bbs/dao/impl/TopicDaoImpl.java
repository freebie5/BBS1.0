/**
 * 
 */
package com.sy.bbs.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.sy.bbs.dao.TopicDao;
import com.sy.bbs.model.Answer;
import com.sy.bbs.model.Topic;

/**
 * @author huangsy
 * @time 2017年4月9日 下午2:59:19
 * TODO
 */
@Component("topicDao")
public class TopicDaoImpl implements TopicDao {

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public Topic add(Topic topic) {
		hibernateTemplate.save(topic);
		return topic;
	}

	@Override
	public Topic queryById(int id) {
		
		return (Topic)hibernateTemplate.get(Topic.class, id );
	}
	
	@Override
	public List<Topic> queryAll() {
		return (List<Topic>)hibernateTemplate.find("from Topic");
	}
	
	@Override
	public List<Topic> queryAllByUserId(int userId) {
		return (List<Topic>)hibernateTemplate.find("from Topic t where t.user.id='"+userId+"'");
	}
	
	@Override
	public void deleteById(int topicId) {
		Topic topic = (Topic) hibernateTemplate.get(Topic.class, topicId);
		topic.setUser(null);
		for(Answer answer : topic.getAnswers()) {
			answer.setUser(null);
		}
		
		hibernateTemplate.delete(topic);
	}
	
}
