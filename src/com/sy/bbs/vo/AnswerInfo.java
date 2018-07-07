package com.sy.bbs.vo;

import java.util.Date;
import com.sy.bbs.model.Topic;

/**
 * @author john
 *
 * @time 2017年4月10日 下午6:09:43
 */
public class AnswerInfo {
	
	private int id;
	private String content;
	private Date createtime;
	private Topic topic;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
