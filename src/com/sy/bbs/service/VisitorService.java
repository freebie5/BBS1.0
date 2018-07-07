/**
 * 
 */
package com.sy.bbs.service;

import java.util.List;

import com.sy.bbs.model.Visitor;

/**
 * @author huangsy
 * @time 2017年4月19日 上午1:39:49
 * TODO
 */
public interface VisitorService {

	public void visit(Visitor visitor);
	
	public List<Visitor> queryAllVisitor();
}
