/**
 * 
 */
package com.sy.bbs.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.sy.bbs.dao.AnswerDao;
import com.sy.bbs.dao.TopicDao;
import com.sy.bbs.dao.UserDao;
import com.sy.bbs.model.Answer;
import com.sy.bbs.model.Topic;
import com.sy.bbs.model.User;
import com.sy.bbs.service.UserService;

/**
 * @author huangsy
 * @time 2017年3月19日 上午3:01:56 TODO
 */
@Component("userService")
// @Scope("prototype")
public class UserServiceImpl implements UserService {
	
	//发表一个主题增加10积分
	private static final int PUBLISH_INTEGRAL = 10;
	
	private UserDao userDao;
	private TopicDao topicDao;
	private AnswerDao answerDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
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
	// @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public boolean register(User user) {

		if (userDao.queryByName(user).size() > 0) {
			return false;
		} else {
			userDao.add(user);
			return true;
		}

		// System.out.println("register");
	}
	
	@Override
	public User login(User user) {
		
		List<User> users = userDao.queryByName(user);
		if(users.size() > 0 && users.get(0).getPassword().equals(user.getPassword())) {
			return users.get(0);
		}
		return null;
		
	}
	
	@Override
	public User query(User user) {
		return userDao.queryById(user.getId());
	}
	
	@Override
	public void changeInfo(User user) {
		userDao.changeInfo(user);
	}
	
	@Override
	public boolean changePassword(User user, String newPassword) {
		String password = userDao.queryById(user.getId()).getPassword();
		if(password.equals(user.getPassword())) {
			user.setPassword(newPassword);
			userDao.changePassword(user);
			return true;
		}
		return false;
	}
	
	@Override
	public Topic publish(Topic topic) {
		User user = userDao.queryById(topic.getUser().getId() );
		user.setIntegral(user.getIntegral()+PUBLISH_INTEGRAL);
		topic.setUser(user);
		
		return topicDao.add(topic);
	}
	
	@Override
	public Topic queryTopic(Topic topic) {
		return topicDao.queryById(topic.getId());
	}
	
	@Override
	public Answer reply(Answer answer) {
		Topic topic = topicDao.queryById(answer.getTopic().getId());
		User user = userDao.queryById(answer.getUser().getId());
		answer.setTopic(topic);
		answer.setUser(user);
		return answerDao.add(answer);
	}
	
	@Override
	public List<Answer> queryAllAnswerOfTopic(Topic topic) {
		return answerDao.queryByTopicId(topic.getId());
	}
	
	@Override
	public List<User> queryAllUser() {
		return userDao.queryAll();
	}
	
	@Override
	public void deleteUser(int userId) {
		userDao.deleteById(userId);
	}
}
