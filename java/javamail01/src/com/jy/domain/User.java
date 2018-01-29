/*
 *******************************************************************************
 * @FileName	User.java
 * @package		com.jy.domain
 * @author		jy·DT
 * @Date		2018年1月30日 上午2:01:12
 * @description 
 *******************************************************************************
 */
package com.jy.domain;

/**
 ******************************************
 * @author jy·DT  [2018年1月30日 上午2:01:12]
 ******************************************
 */
public class User {
	private int uid;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String code;
	private int status;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
