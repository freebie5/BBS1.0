/**
 * 
 */
package com.sy.bbs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author huangsy
 * @time 2017年3月19日 下午6:01:48
 * TODO
 */
@Entity
@Table(name="mylog")
public class Log {
	private int id;
	private String content;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
