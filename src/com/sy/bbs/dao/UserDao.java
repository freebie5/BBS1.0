/**
 * 
 */
package com.sy.bbs.dao;

import java.util.List;

import com.sy.bbs.model.User;

/**
 * @author huangsy
 * @time 2017��3��19�� ����3:04:00
 * TODO
 */
public interface UserDao {

	public void add(User user);
	
	public List<User> queryAll();
	
	public List<User> queryByName(User user);
	
	public User queryById(int id);
	
	public void changeInfo(User user);
	
	public void changePassword(User user);
	
	public void deleteById(int id);
}
