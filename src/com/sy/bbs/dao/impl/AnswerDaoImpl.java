package com.sy.bbs.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.sy.bbs.dao.AnswerDao;
import com.sy.bbs.model.Answer;
import com.sy.bbs.model.Topic;

/**
 * @author john
 *
 * @time 2017年4月10日 下午3:14:50
 */
@Component("answerDao")
public class AnswerDaoImpl implements AnswerDao {

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public Answer add(Answer answer) {
//		hibernateTemplate.save(answer);
		hibernateTemplate.merge(answer);
		return answer;
	}

	@Override
	public List<Answer> queryByTopicId(int topicid) {
		return (List<Answer>)hibernateTemplate.find(
				"from Answer a where a.topic.id='"+topicid+"'");
	}
	
	@Override
	public List<Answer> queryAllByUserId(int userId) {
		return (List<Answer>)hibernateTemplate.find("from Answer a where a.user.id='"+userId+"'");
	}
	
	@Override
	public void delete(int answerId) {
		Answer answer = (Answer) hibernateTemplate.get(Answer.class, answerId);
		answer.setTopic(null);
		answer.setUser(null);
		hibernateTemplate.delete(answer);
	}
	
	@Override
	public List<Answer> queryAll() {
		return (List<Answer>)hibernateTemplate.find("from Answer");
	}
}
