/**
 * 
 */
package com.sy.bbs.dao;

import java.util.List;

import com.sy.bbs.model.TopicRecorder;

/**
 * @author huangsy
 * @time 2017年4月11日 下午11:42:03
 * TODO
 */
public interface TopicRecorderDao {

	public TopicRecorder add(TopicRecorder topicRecorder);
	
	public List<TopicRecorder> queryAll();
	
	public List<TopicRecorder> queryByTopicId(int TopicId);
	
}
