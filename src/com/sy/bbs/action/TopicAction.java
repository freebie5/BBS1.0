/**
 * 
 */
package com.sy.bbs.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sy.bbs.model.Answer;
import com.sy.bbs.model.Topic;
import com.sy.bbs.model.Visitor;
import com.sy.bbs.service.TopicService;
import com.sy.bbs.service.VisitorService;
import com.sy.bbs.vo.DeleteAnswerInfoRequest;
import com.sy.bbs.vo.DeleteTopicInfoRequest;
import com.sy.bbs.vo.QueryAnswerInfoRequest;
import com.sy.bbs.vo.QueryTopicInfoRequest;

/**
 * @author huangsy
 * @time 2017年4月12日 下午9:32:34
 * TODO
 */
public class TopicAction extends ActionSupport {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 751019830698691880L;
	
	private TopicService topicService;
	private VisitorService visitorService;

	private QueryTopicInfoRequest queryTopicInfoRequest;
	private DeleteTopicInfoRequest deleteTopicInfoRequest;
	private List<Topic> topices;
	
	private QueryAnswerInfoRequest queryAnswerInfoRequest;
	private DeleteAnswerInfoRequest deleteAnswerInfoRequest;
	private List<Answer> answers;
	
	public TopicService getTopicService() {
		return topicService;
	}

	@Resource(name="topicService")
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	
	public QueryTopicInfoRequest getQueryTopicInfoRequest() {
		return queryTopicInfoRequest;
	}

	public void setQueryTopicInfoRequest(QueryTopicInfoRequest queryTopicInfoRequest) {
		this.queryTopicInfoRequest = queryTopicInfoRequest;
	}
	
	public List<Topic> getTopices() {
		return topices;
	}
	
	public void setTopices(List<Topic> topices) {
		this.topices = topices;
	}
	
	public QueryAnswerInfoRequest getQueryAnswerInfoRequest() {
		return queryAnswerInfoRequest;
	}
	
	public void setQueryAnswerInfoRequest(QueryAnswerInfoRequest queryAnswerInfoRequest) {
		this.queryAnswerInfoRequest = queryAnswerInfoRequest;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}
	
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public DeleteAnswerInfoRequest getDeleteAnswerInfoRequest() {
		return deleteAnswerInfoRequest;
	}
	
	public void setDeleteAnswerInfoRequest(DeleteAnswerInfoRequest deleteAnswerInfoRequest) {
		this.deleteAnswerInfoRequest = deleteAnswerInfoRequest;
	}
	
	public DeleteTopicInfoRequest getDeleteTopicInfoRequest() {
		return deleteTopicInfoRequest;
	}
	
	public void setDeleteTopicInfoRequest(DeleteTopicInfoRequest deleteTopicInfoRequest) {
		this.deleteTopicInfoRequest = deleteTopicInfoRequest;
	}
	
	public VisitorService getVisitorService() {
		return visitorService;
	}
	
	@Resource
	public void setVisitorService(VisitorService visitorService) {
		this.visitorService = visitorService;
	}
	
	
	
	




/****************************************action方法开始****************************************/
	public String listTopic() {
		Visitor visitor = new Visitor();
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		visitor.setIp(ip);
		visitor.setCreatetime(new Date());
		visitorService.visit(visitor);
		topices = topicService.queryAllTopic();
		return "listtopicsuccess";
	}
	
	public String queryTopicInfo() {
		topices = topicService.queryByUserId(queryTopicInfoRequest.getUserid() );
		return "mytopic";
	}
	
	public String queryAnswerInfo() {
		answers = topicService.queryAnswerByUserId(queryAnswerInfoRequest.getUserid() );
		return "myanswer";
	}

	public String deleteAnswerInfo() {
		topicService.deleteAnswer(deleteAnswerInfoRequest.getAnswerid());
		answers = topicService.queryAnswerByUserId(deleteAnswerInfoRequest.getUserid());
		return "myanswer";
	}
	
	public String deleteTopicInfo() {
		topicService.deleteTopic(deleteTopicInfoRequest.getTopicid());
		topices = topicService.queryByUserId(deleteTopicInfoRequest.getUserid());
		return "mytopic";
	}
}
