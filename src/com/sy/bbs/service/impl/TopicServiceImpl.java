/**
 * 
 */
package com.sy.bbs.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.sy.bbs.dao.AnswerDao;
import com.sy.bbs.dao.TopicDao;
import com.sy.bbs.dao.TopicRecorderDao;
import com.sy.bbs.model.Answer;
import com.sy.bbs.model.Topic;
import com.sy.bbs.model.TopicRecorder;
import com.sy.bbs.service.TopicService;

/**
 * @author huangsy
 * @time 2017年4月11日 下午11:47:56 TODO
 */
@Component("topicService")
public class TopicServiceImpl implements TopicService {

	private TopicRecorderDao topicRecorderDao;
	private TopicDao topicDao;
	private AnswerDao answerDao;

	public TopicRecorderDao getTopicRecorderDao() {
		return topicRecorderDao;
	}

	@Resource
	public void setTopicRecorderDao(TopicRecorderDao topicRecorderDao) {
		this.topicRecorderDao = topicRecorderDao;
	}

	public TopicDao getTopicDao() {
		return topicDao;
	}

	@Resource
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public AnswerDao getAnswerDao() {
		return answerDao;
	}
	
	@Resource
	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}
	
	
	
	
	

	@Override
	public int record(TopicRecorder topicRecorder) {
		topicRecorderDao.add(topicRecorder);
		return topicRecorderDao.queryByTopicId(topicRecorder.getTopicid()).size();
	}

	@Override
	public List<Topic> queryByUserId(int userId) {
		return topicDao.queryAllByUserId(userId);
	}
	
	@Override
	public List<Answer> queryAnswerByUserId(int userId) {
		return answerDao.queryAllByUserId(userId);
	}
	
	@Override
	public void deleteAnswer(int answerId) {
		answerDao.delete(answerId);
		
	}
	
	@Override
	public void deleteTopic(int topicId) {
		topicDao.deleteById(topicId);
	}
	
	@Override
	public List<Answer> queryAllAnswer() {
		return answerDao.queryAll();
	}
	
	@Override
	public List<Topic> queryAllTopic() {
		return topicDao.queryAll();
	}
	
}
