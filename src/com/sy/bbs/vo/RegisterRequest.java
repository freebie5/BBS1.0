/**
 * 
 */
package com.sy.bbs.vo;

/**
 * @author huangsy
 * @time 2017年4月10日 下午11:58:57
 * TODO
 */
public class RegisterRequest {
	private String name;
	private String password;
	private String password2;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
}
