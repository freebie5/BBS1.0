/**
 * 
 */
package com.sy.bbs.dao;

import java.util.List;

import com.sy.bbs.model.Answer;
import com.sy.bbs.model.Topic;

/**
 * @author huangsy
 * @time 2017年4月9日 下午2:58:31
 * TODO
 */
public interface TopicDao {

	public Topic add(Topic topic);
	
	public Topic queryById(int id);
	
	public List<Topic> queryAll();
	
	public List<Topic> queryAllByUserId(int userId);
	
	public void deleteById(int topicId);
}
