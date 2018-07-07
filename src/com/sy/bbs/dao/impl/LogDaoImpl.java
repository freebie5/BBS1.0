/**
 * 
 */
package com.sy.bbs.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.sy.bbs.dao.LogDao;
import com.sy.bbs.model.Log;

/**
 * @author huangsy
 * @time 2017年3月19日 下午6:07:51
 * TODO
 */
@Component("logDao")
public class LogDaoImpl implements LogDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	@Override
	public void add(Log log) {
		Session session = (Session)sessionFactory.getCurrentSession();
		session.save(log);
//		throw new RuntimeException();
		System.out.println("log success");
	}

}
