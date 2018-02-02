/*
 *******************************************************************************
 * @FileName	User.java
 * @package		com.dtjt.entity
 * @author		jy·DT
 * @Date		2018年2月1日 下午8:43:22
 * @description 
 *******************************************************************************
 */
package com.dtjt.entity;

/**
 ******************************************
 * @author jy·DT  [2018年2月1日 下午8:43:22]
 ******************************************
 */
public class User {
	
	private int id;
	
	private String comp;
	
	private String account;
	
	private String password;

	public String getComp() {
		return comp;
	}
	
	public User(String comp, String account, String password) {
		this.comp = comp;
		this.account = account;
		this.password = password;
	}

	public User() {
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [comp=" + comp + ", account=" + account + ", password=" + password + "]";
	}
	
}
