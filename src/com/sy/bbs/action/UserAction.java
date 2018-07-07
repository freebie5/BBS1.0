/**
 * 
 */
package com.sy.bbs.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sy.bbs.model.Topic;
import com.sy.bbs.model.TopicRecorder;
import com.sy.bbs.model.User;
import com.sy.bbs.service.TopicService;
import com.sy.bbs.service.UserService;
import com.sy.bbs.vo.ChangePasswordRequest;
import com.sy.bbs.vo.ChangePasswordResponse;
import com.sy.bbs.vo.ChangeUserInfoRequest;
import com.sy.bbs.vo.ChangeUserInfoResponse;
import com.sy.bbs.vo.LoginRequest;
import com.sy.bbs.vo.QueryUserInfoRequest;
import com.sy.bbs.vo.QueryUserInfoResponse;
import com.sy.bbs.vo.RegisterRequest;
import com.sy.bbs.vo.RegisterResponse;
import com.sy.bbs.vo.UserInfo;
import com.sy.bbs.model.Answer;

/**
 * @author huangsy
 * @time 2017��3��20�� ����5:19:58 TODO
 */
public class UserAction extends ActionSupport implements SessionAware/* , ModelDriven<T> */ {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4062428662795519444L;

	private UserService userService;
	private TopicService topicService;
	
	private RegisterRequest registerRequest;
	private RegisterResponse registerResponse;
	
	private LoginRequest loginRequest;
	private UserInfo userInfo;
	
	private QueryUserInfoRequest queryUserInfoRequest;
	private QueryUserInfoResponse queryUserInfoResponse;
	
	private ChangeUserInfoRequest changeUserInfoRequest;
	
	private ChangePasswordRequest changePasswordRequest;
	private ChangePasswordResponse changePasswordResponse;
	
	private Topic topic;
	private List<Topic> topices;
	private List<Answer> answers;
	private Answer answer;
	
	private int count;

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public TopicService getTopicService() {
		return topicService;
	}
	
	@Resource
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public RegisterRequest getRegisterRequest() {
		return registerRequest;
	}

	public void setRegisterRequest(RegisterRequest registerRequest) {
		this.registerRequest = registerRequest;
	}

	public RegisterResponse getRegisterResponse() {
		return registerResponse;
	}

	public void setRegisterResponse(RegisterResponse registerResponse) {
		this.registerResponse = registerResponse;
	}

	public LoginRequest getLoginRequest() {
		return loginRequest;
	}
	
	public void setLoginRequest(LoginRequest loginRequest) {
		this.loginRequest = loginRequest;
	}
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public QueryUserInfoRequest getQueryUserInfoRequest() {
		return queryUserInfoRequest;
	}
	
	public void setQueryUserInfoRequest(QueryUserInfoRequest queryUserInfoRequest) {
		this.queryUserInfoRequest = queryUserInfoRequest;
	}
	
	public QueryUserInfoResponse getQueryUserInfoResponse() {
		return queryUserInfoResponse;
	}
	
	public void setQueryUserInfoResponse(QueryUserInfoResponse queryUserInfoResponse) {
		this.queryUserInfoResponse = queryUserInfoResponse;
	}
	
	public ChangeUserInfoRequest getChangeUserInfoRequest() {
		return changeUserInfoRequest;
	}
	
	public void setChangeUserInfoRequest(ChangeUserInfoRequest changeUserInfoRequest) {
		this.changeUserInfoRequest = changeUserInfoRequest;
	}
	
	public ChangePasswordRequest getChangePasswordRequest() {
		return changePasswordRequest;
	}
	
	public void setChangePasswordRequest(ChangePasswordRequest changePasswordRequest) {
		this.changePasswordRequest = changePasswordRequest;
	}

	public ChangePasswordResponse getChangePasswordResponse() {
		return changePasswordResponse;
	}
	
	public void setChangePasswordResponse(ChangePasswordResponse changePasswordResponse) {
		this.changePasswordResponse = changePasswordResponse;
	}

	public Topic getTopic() {
		return topic;
	}
	
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<Topic> getTopices() {
		return topices;
	}
	
	public void setTopices(List<Topic> topices) {
		this.topices = topices;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}
	
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public Answer getAnswer() {
		return answer;
	}
	
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	


/***********************************action��������**************************************/

	public String register() {
		
		if ("".equals(registerRequest.getName())) {
			this.addFieldError("registerError", "�û�������Ϊ��");
			return ERROR;
		}
		
		if ("".equals(registerRequest.getPassword())) {
			this.addFieldError("registerError", "���벻��Ϊ��");
			return ERROR;
		}
		
		if (!registerRequest.getPassword().equals(registerRequest.getPassword2())) {
			this.addFieldError("registerError", "�����ȷ�����벻һ��");
			return ERROR;
		}
		
		User user = new User();
		user.setName(registerRequest.getName());
		user.setPassword(registerRequest.getPassword());
		user.setCreatetime(new Date() );

		if (userService.register(user)) {
			registerResponse = new RegisterResponse();
			registerResponse.setResult("ע��ɹ����������û����������¼");
			return "registersuccess";
		} else {
			this.addFieldError("registerError", "�û����Ѿ���ע��");
			return ERROR;
		}
	}

	public String login() {

		if("".equals(loginRequest.getName())) {
			this.addFieldError("loginError", "�û�������Ϊ��");
			return ERROR;
		}
		
		if("".equals(loginRequest.getPassword())) {
			this.addFieldError("loginError", "���벻��Ϊ��");
			return ERROR;
		}
		
		User user = new User();
		user.setName(loginRequest.getName());
		user.setPassword(loginRequest.getPassword());

		if(userService.login(user) != null) {
			
			user = userService.login(user);
			userInfo = new UserInfo();
			userInfo.setId(user.getId());
			userInfo.setName(user.getName() );
			userInfo.setIntegral(user.getIntegral() );
			userInfo.setCreatetime(user.getCreatetime() );
			userInfo.setIntroduction(user.getIntroduction() );
			userInfo.setSex(user.getSex() );
			userInfo.setAge(user.getAge() );
			userInfo.setOccupation(user.getOccupation() );
			userInfo.setWorkyear(user.getWorkyear() );
			userInfo.setHobby(user.getHobby() );
			userInfo.setQq(user.getQq() );
			userInfo.setHomepage(user.getHomepage() );
			
			session.put("loginUserInfo", userInfo);
			return "loginsuccess";
		} else {
			this.addFieldError("loginError", "�û������������");
			return ERROR;
		}
		
	}
	
	public String queryUserInfo() throws UnsupportedEncodingException {
		
		User user = new User();
		int id = queryUserInfoRequest.getUserid();
//		String name = new String(userInfo.getName().getBytes("ISO-8859-1"), "UTF-8");
//		String name = URLDecoder.decode(userInfo.getName(), "GBK");
		user.setId(id);
//		user.setName(name);
		
		user = userService.query(user);
		
		queryUserInfoResponse = new QueryUserInfoResponse(); 
		queryUserInfoResponse.setId(user.getId());
		queryUserInfoResponse.setName(user.getName() );
		queryUserInfoResponse.setIntegral(user.getIntegral() );
		queryUserInfoResponse.setCreatetime(user.getCreatetime() );
		queryUserInfoResponse.setIntroduction(user.getIntroduction() );
		queryUserInfoResponse.setSex(user.getSex() );
		queryUserInfoResponse.setAge(user.getAge() );
		queryUserInfoResponse.setOccupation(user.getOccupation() );
		queryUserInfoResponse.setWorkyear(user.getWorkyear() );
		queryUserInfoResponse.setHobby(user.getHobby() );
		queryUserInfoResponse.setQq(user.getQq() );
		queryUserInfoResponse.setHomepage(user.getHomepage() );
		
		
		return "queryuserinfosuccess";
	}

	public String changeUserInfo() {
		User user = new User();
		user.setId(changeUserInfoRequest.getId());
		user.setIntroduction(changeUserInfoRequest.getIntroduction());
		user.setSex(changeUserInfoRequest.getSex());
		user.setAge(changeUserInfoRequest.getAge());
		user.setOccupation(changeUserInfoRequest.getOccupation());
		user.setWorkyear(changeUserInfoRequest.getWorkyear());
		user.setHobby(changeUserInfoRequest.getHobby());
		user.setQq(changeUserInfoRequest.getQq());
		user.setHomepage(changeUserInfoRequest.getHomepage());
		
		//�޸��û���Ϣ
		userService.changeInfo(user);
		//�޸ĺ����²�ѯ�û���Ϣ
		user = userService.query(user);
		
		queryUserInfoResponse = new QueryUserInfoResponse(); 
		queryUserInfoResponse.setId(user.getId());
		queryUserInfoResponse.setName(user.getName() );
		queryUserInfoResponse.setIntegral(user.getIntegral() );
		queryUserInfoResponse.setCreatetime(user.getCreatetime() );
		queryUserInfoResponse.setIntroduction(user.getIntroduction() );
		queryUserInfoResponse.setSex(user.getSex() );
		queryUserInfoResponse.setAge(user.getAge() );
		queryUserInfoResponse.setOccupation(user.getOccupation() );
		queryUserInfoResponse.setWorkyear(user.getWorkyear() );
		queryUserInfoResponse.setHobby(user.getHobby() );
		queryUserInfoResponse.setQq(user.getQq() );
		queryUserInfoResponse.setHomepage(user.getHomepage() );
		queryUserInfoResponse.setResult("�޸��û���Ϣ�ɹ�");
		
		return "changeuserinfosuccess";
	}
	
	public String changePassword() {
		
		String oldpassword = changePasswordRequest.getOldpassword();
		String newpassword = changePasswordRequest.getNewpassword();
		String newpassword2 = changePasswordRequest.getNewpassword2(); 
		
		if("".equals(oldpassword)) {
			this.addFieldError("changepasswordError", "�����벻��Ϊ��");
			return "changepassword";
		}
		
		if("".equals(newpassword)) {
			this.addFieldError("changepasswordError", "�����벻��Ϊ��");
			return "changepassword";
		}
		
		if("".equals(newpassword2)) {
			this.addFieldError("changepasswordError", "ȷ�����벻��Ϊ��");
			return "changepassword";
		}
		
		if(!newpassword.equals(newpassword2)) {
			this.addFieldError("changepasswordError", "�����ȷ�����벻һ��");
			return "changepassword";
		}
		
		User user = new User();
		user.setId(changePasswordRequest.getId());
		user.setPassword(oldpassword);
		
		changePasswordResponse = new ChangePasswordResponse();
		if(userService.changePassword(user, newpassword) ) {
			changePasswordResponse.setResult("�޸�����ɹ�");
		} else {
			changePasswordResponse.setResult("���������");
		}
		return "changepassword";
		
	}
	
	public String publish() {
		
		//����󷵻�����
		topic.setCreatetime(new Date() );
		topic = userService.publish(topic);
		return "publishsuccess";
	}
	
	public String queryTopic() {
		topic = userService.queryTopic(topic);
		
		answers = userService.queryAllAnswerOfTopic(topic);
		
		TopicRecorder topicRecorder = new TopicRecorder();
		topicRecorder.setTopicid(topic.getId());
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		topicRecorder.setIp(ip);
		count = topicService.record(topicRecorder);
		
		return "querytopicsuccess";
	}
	
	public String reply() {
		
//		Topic topic = new Topic();
//		topic.setId(topicInfo.getId());
		
		if(answer.getUser().getId() != 0) {
			answer.setCreatetime(new Date());
			userService.reply(answer);
		} else {
			this.addFieldError("replyError", "���¼��ظ�");
		}
		
		
		//�ظ��󣬷�����������
		
		topic = userService.queryTopic(answer.getTopic());
		
		answers = userService.queryAllAnswerOfTopic(topic);
		
		return "replysuccess";
	}

/*********************************************************************************/
	Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	// @Override
	// public Object getModel() {
	// return registerOrLoginInfo;
	// }

}
