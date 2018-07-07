/**
 * 
 */
package com.sy.bbs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sy.bbs.dao.AdminDao;
import com.sy.bbs.dao.AnswerDao;
import com.sy.bbs.dao.UserDao;
import com.sy.bbs.model.Admin;
import com.sy.bbs.model.Answer;
import com.sy.bbs.model.User;
import com.sy.bbs.service.AdminService;

/**
 * @author huangsy
 * @time 2017年4月14日 上午1:29:51 TODO
 */
@Component("adminService")
public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	@Resource
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	
	


	@Override
	public Admin login(Admin admin) {
		List<Admin> admins = adminDao.queryByName(admin.getName());
		if(admins.size()>0 && admins.get(0).getPassword().equals(admin.getPassword())) {
			return admins.get(0);
		}
		return null;
	}

	
}
