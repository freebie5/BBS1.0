/**
 * 
 */
package com.sy.bbs.dao;

import java.util.List;

import com.sy.bbs.model.Visitor;

/**
 * @author huangsy
 * @time 2017��4��18�� ����11:29:08
 * TODO
 */
public interface VisitorDao {

	public Visitor add(Visitor visitor);
	
	public List<Visitor> queryAll();
}
