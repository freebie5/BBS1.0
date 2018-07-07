/**
 * 
 */
package com.sy.bbs.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.sy.bbs.dao.VisitorDao;
import com.sy.bbs.model.Visitor;

/**
 * @author huangsy
 * @time 2017年4月18日 下午11:30:49 TODO
 */
@Component("visitorDao")
public class VisitorDaoImpl implements VisitorDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public Visitor add(Visitor visitor) {
		hibernateTemplate.save(visitor);
		return visitor;
	}

	@Override
	public List<Visitor> queryAll() {
		return (List<Visitor>)hibernateTemplate.find("from Visitor");
	}
}
