/**
 * 
 */
package com.sy.bbs.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.sy.bbs.dao.UserDao;
import com.sy.bbs.model.User;

/**
 * @author huangsy
 * @time 2017年3月19日 上午3:04:58
 * TODO
 */
@Component("userDao")
public class UserDaoImpl implements UserDao {

//	private DataSource dataSource;
//	
//	public DataSource getDataSource() {
//		return dataSource;
//	}
//
//	@Resource(name="dataSource")
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}

//	private SessionFactory sessionFactory;
//	
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	@Resource(name="sessionFactory")
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void add(User user) {
		//datasource方式
//		try {
//			Connection conn = (Connection) dataSource.getConnection();
//			conn.createStatement().executeUpdate("insert into user values('100','john')");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		//hibernate声明式事务方式
//		Session session = (Session)sessionFactory.getCurrentSession();
//		session.save(user);
		//hibernatetemplate方式
		hibernateTemplate.save(user);
//		System.out.println("register success");
	}

	@Override
	public List<User> queryAll() {
		
		return (List<User>)hibernateTemplate.find("from User u");
		
	}

	@Override
	public List<User> queryByName(User user) {
		
		return (List<User>)hibernateTemplate.find("from User u where u.name='"+user.getName()+"'");
	}
	
	@Override
	public User queryById(int id) {
		return (User) hibernateTemplate.get(User.class, id);
	}
	
	@Override
	public void changeInfo(User user) {
		User toChange = (User)hibernateTemplate.get(User.class, user.getId());
		toChange.setIntroduction(user.getIntroduction());
		toChange.setSex(user.getSex());
		toChange.setAge(user.getAge());
		toChange.setOccupation(user.getOccupation());
		toChange.setWorkyear(user.getWorkyear());
		toChange.setHobby(user.getHobby());
		toChange.setQq(user.getQq());
		toChange.setHomepage(user.getHomepage());
		hibernateTemplate.update(toChange);
	}
	
	@Override
	public void changePassword(User user) {
		User toChange = (User)hibernateTemplate.get(User.class, user.getId());
		toChange.setPassword(user.getPassword());
		hibernateTemplate.update(toChange);
	}
	
	@Override
	public void deleteById(int id) {
		User toDelete = (User)hibernateTemplate.get(User.class, id);
		hibernateTemplate.delete(toDelete);
	}
}
