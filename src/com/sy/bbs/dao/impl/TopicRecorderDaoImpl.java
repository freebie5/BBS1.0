/**
 * 
 */
package com.sy.bbs.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.sy.bbs.dao.TopicRecorderDao;
import com.sy.bbs.model.TopicRecorder;

/**
 * @author huangsy
 * @time 2017年4月11日 下午11:43:40
 * TODO
 */
@Component("topicRecorderDao")
public class TopicRecorderDaoImpl implements TopicRecorderDao {

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public TopicRecorder add(TopicRecorder topicRecorder) {

		hibernateTemplate.save(topicRecorder);
		return topicRecorder;
	}

	@Override
	public List<TopicRecorder> queryAll() {
		return (List<TopicRecorder>)hibernateTemplate.find("from TopicRecorder");
	}
	
	@Override
	public List<TopicRecorder> queryByTopicId(int topicId) {
		return (List<TopicRecorder>)hibernateTemplate.find("from TopicRecorder t where t.topicid='"+topicId+"'");
	}
}
