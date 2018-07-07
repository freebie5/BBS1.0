/**
 * 
 */
package com.sy.bbs.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.sy.bbs.model.Admin;
import com.sy.bbs.model.Answer;
import com.sy.bbs.model.Topic;
import com.sy.bbs.model.User;
import com.sy.bbs.model.Visitor;
import com.sy.bbs.service.AdminService;
import com.sy.bbs.service.TopicService;
import com.sy.bbs.service.UserService;
import com.sy.bbs.service.VisitorService;
import com.sy.bbs.vo.AdminInfo;
import com.sy.bbs.vo.AdminLoginRequest;
import com.sy.bbs.vo.DeleteAnswerInfoRequest;
import com.sy.bbs.vo.DeleteTopicInfoRequest;
import com.sy.bbs.vo.DeleteUserInfoRequest;

/**
 * @author huangsy
 * @time 2017年4月14日 上午1:12:30 TODO
 */
public class AdminAction extends ActionSupport implements SessionAware {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -6228719783653411624L;
	
	private AdminLoginRequest adminLoginRequest;
	private AdminInfo adminInfo;
	
	private List<Topic> topices;
	private List<Answer> answers;
	private List<User> users;
	private List<Visitor> visitors;
	private DeleteTopicInfoRequest deleteTopicInfoRequest;
	private DeleteAnswerInfoRequest deleteAnswerInfoRequest;
	private DeleteUserInfoRequest deleteUserInfoRequest;
	
	private AdminService adminService;
	private TopicService topicService;
	private UserService userService;
	private VisitorService visitorService;
	
	public AdminLoginRequest getAdminLoginRequest() {
		return adminLoginRequest;
	}

	public void setAdminLoginRequest(AdminLoginRequest adminLoginRequest) {
		this.adminLoginRequest = adminLoginRequest;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public AdminInfo getAdminInfo() {
		return adminInfo;
	}
	
	public void setAdminInfo(AdminInfo adminInfo) {
		this.adminInfo = adminInfo;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}
	
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Topic> getTopices() {
		return topices;
	}
	
	public void setTopices(List<Topic> topices) {
		this.topices = topices;
	}

	public TopicService getTopicService() {
		return topicService;
	}
	
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public DeleteTopicInfoRequest getDeleteTopicInfoRequest() {
		return deleteTopicInfoRequest;
	}

	public void setDeleteTopicInfoRequest(DeleteTopicInfoRequest deleteTopicInfoRequest) {
		this.deleteTopicInfoRequest = deleteTopicInfoRequest;
	}

	public DeleteAnswerInfoRequest getDeleteAnswerInfoRequest() {
		return deleteAnswerInfoRequest;
	}

	public void setDeleteAnswerInfoRequest(DeleteAnswerInfoRequest deleteAnswerInfoRequest) {
		this.deleteAnswerInfoRequest = deleteAnswerInfoRequest;
	}

	public DeleteUserInfoRequest getDeleteUserInfoRequest() {
		return deleteUserInfoRequest;
	}

	public void setDeleteUserInfoRequest(DeleteUserInfoRequest deleteUserInfoRequest) {
		this.deleteUserInfoRequest = deleteUserInfoRequest;
	}

	public VisitorService getVisitorService() {
		return visitorService;
	}

	@Resource
	public void setVisitorService(VisitorService visitorService) {
		this.visitorService = visitorService;
	}

	public List<Visitor> getVisitors() {
		return visitors;
	}

	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}

/**************************************************************************************/
	Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	
/***********************************action方法部分***************************************/
	
	public String login() {

		if("".equals(adminLoginRequest.getName())) {
			this.addFieldError("loginError", "用户名不能为空");
			return ERROR;
		}
		
		if("".equals(adminLoginRequest.getPassword())) {
			this.addFieldError("loginError", "密码不能为空");
			return ERROR;
		}
		
		Admin admin = new Admin();
		admin.setName(adminLoginRequest.getName());
		admin.setPassword(adminLoginRequest.getPassword());
		
		if(adminService.login(admin)!=null) {
			admin = adminService.login(admin);
			adminInfo = new AdminInfo();
			adminInfo.setId(admin.getId());
			adminInfo.setName(admin.getName());
			session.put("loginAdminInfo", adminInfo);
			return "loginsuccess";
		} else {
			this.addFieldError("loginError", "用户名或密码错误");
			return ERROR;
		}
		
	}

	public String listTopic() {
		topices = topicService.queryAllTopic();
		return "listtopicsuccess";
	}
	
	public String listAnswer() {
		answers = topicService.queryAllAnswer();
		return "listanswersuccess";
	}
	
	public String listUser() {
		users = userService.queryAllUser();
		return "listusersuccess";
	}
	
	public String deleteTopic() {
		topicService.deleteTopic(deleteTopicInfoRequest.getTopicid());
		topices = topicService.queryAllTopic();
		return "deletetopicsuccess";
	}
	
	public String deleteAnswer() {
		topicService.deleteAnswer(deleteAnswerInfoRequest.getAnswerid());
		answers = topicService.queryAllAnswer();
		return "deleteanswersuccess";
	}
	
	public String deleteUser() {
		userService.deleteUser(deleteUserInfoRequest.getUserid());
		users = userService.queryAllUser();
		return "deleteusersuccess";
	}
	
	public String listVisitor() {
		visitors = visitorService.queryAllVisitor();
		return "listvisitorsuccess";
	}
}
