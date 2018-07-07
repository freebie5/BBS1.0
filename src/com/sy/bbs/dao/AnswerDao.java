package com.sy.bbs.dao;

import java.util.List;

import com.sy.bbs.model.Answer;

/**
 * @author john
 *
 * @time 2017��4��10�� ����3:13:09
 */
public interface AnswerDao {
	
	public Answer add(Answer answer);
	
	public List<Answer> queryByTopicId(int topicid);
	
	public List<Answer> queryAllByUserId(int userId);
	
	public void delete(int answerId);
	
	public List<Answer> queryAll();
}
