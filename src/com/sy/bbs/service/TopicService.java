/**
 * 
 */
package com.sy.bbs.service;

import java.util.List;
import com.sy.bbs.model.Answer;
import com.sy.bbs.model.Topic;
import com.sy.bbs.model.TopicRecorder;

/**
 * @author huangsy
 * @time 2017年4月11日 下午11:33:36 TODO
 */
public interface TopicService {

	public int record(TopicRecorder topicRecorder);

	public List<Topic> queryByUserId(int userId);

	public List<Answer> queryAnswerByUserId(int userId);

	public void deleteAnswer(int answerId);

	public void deleteTopic(int topicId);

	public List<Answer> queryAllAnswer();

	public List<Topic> queryAllTopic();
}
