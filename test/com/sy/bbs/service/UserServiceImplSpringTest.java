package com.sy.bbs.service;

import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sy.bbs.model.User;

/**
 * @author john
 *
 * @time 2017年4月5日 下午4:31:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class UserServiceImplSpringTest extends AbstractTransactionalJUnit4SpringContextTests {
	
private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@Test
	public void testRegister() {
		User user = new User();
		user.setName("hello");
		user.setPassword("123");
		boolean flag = userService.register(user);
		Assert.assertEquals(true, flag);
	}
	
}
