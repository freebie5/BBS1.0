/**
 * 
 */
package com.sy.bbs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sy.bbs.dao.VisitorDao;
import com.sy.bbs.model.Visitor;
import com.sy.bbs.service.VisitorService;

/**
 * @author huangsy
 * @time 2017年4月19日 上午1:41:04
 * TODO
 */
@Component("visitorService")
public class VisitorServiceImpl implements VisitorService {

	private VisitorDao visitorDao;
	
	public VisitorDao getVisitorDao() {
		return visitorDao;
	}

	@Resource
	public void setVisitorDao(VisitorDao visitorDao) {
		this.visitorDao = visitorDao;
	}


	@Override
	public void visit(Visitor visitor) {
		visitorDao.add(visitor);
	}
	
	@Override
	public List<Visitor> queryAllVisitor() {
		return visitorDao.queryAll();
	}

}
