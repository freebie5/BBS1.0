package com.sy.bbs.vo;

/**
 * @author john
 *
 * @time 2017年4月11日 上午9:58:27
 */
public class ChangePasswordRequest {
	private int id;
	private String oldpassword;
	private String newpassword;
	private String newpassword2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getNewpassword2() {
		return newpassword2;
	}

	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}

}
