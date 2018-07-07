/**
 * 
 */
package com.sy.bbs.dao;

import java.util.List;

import com.sy.bbs.model.Admin;

/**
 * @author huangsy
 * @time 2017年4月14日 上午1:20:07
 * TODO
 */
public interface AdminDao {

	public List<Admin> queryByName(String adminName);
	
}
