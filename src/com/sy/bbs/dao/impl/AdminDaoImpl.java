/**
 * 
 */
package com.sy.bbs.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.sy.bbs.dao.AdminDao;
import com.sy.bbs.model.Admin;

/**
 * @author huangsy
 * @time 2017年4月14日 上午1:21:44 TODO
 */
@Component("adminDao")
public class AdminDaoImpl implements AdminDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Admin> queryByName(String adminName) {
		
		return (List<Admin>)hibernateTemplate.find("from Admin a where a.name='"+adminName+"'");
		
	}

}
