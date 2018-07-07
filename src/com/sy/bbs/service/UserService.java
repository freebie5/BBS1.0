/**
 * 
 */
package com.sy.bbs.service;

import java.util.List;

import com.sy.bbs.model.Answer;
import com.sy.bbs.model.Topic;
import com.sy.bbs.model.User;

/**
 * @author huangsy
 * @time 2017年3月19日 上午3:01:12
 * TODO
 */
public interface UserService {
	
	public boolean register(User user);
	
	public User login(User user);
	
	public User query(User user);
	
	public void changeInfo(User user);
	
	public boolean changePassword(User user, String newPassword);
	
	public Topic publish(Topic topic);
	
	public Topic queryTopic(Topic topic);
	
	public Answer reply(Answer answer);
	
	public List<Answer> queryAllAnswerOfTopic(Topic topic);
	
	public List<User> queryAllUser();
	
	public void deleteUser(int userId);
	
}
