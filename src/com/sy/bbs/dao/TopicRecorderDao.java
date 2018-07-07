/**
 * 
 */
package com.sy.bbs.dao;

import java.util.List;

import com.sy.bbs.model.TopicRecorder;

/**
 * @author huangsy
 * @time 2017��4��11�� ����11:42:03
 * TODO
 */
public interface TopicRecorderDao {

	public TopicRecorder add(TopicRecorder topicRecorder);
	
	public List<TopicRecorder> queryAll();
	
	public List<TopicRecorder> queryByTopicId(int TopicId);
	
}
