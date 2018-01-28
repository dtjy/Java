/*
 *******************************************************************************
 * @FileName	Employee.java
 * @package		com.jy.domain
 * @author		jiangyao
 * @Date		2018年1月28日 下午10:28:08
 * @description 
 *******************************************************************************
 */
package com.jy.domain;

import java.util.Date;

/**
 * 员工实体
 ******************************************
 * @author jiangyao  [2018年1月28日 下午10:28:08]
 ******************************************
 */
public class Employee {
	private Integer eid;
	private String ename;
	private String sex;
	private Date birthday;
	private Date joinDate;
	private String eno;
	private String username;
	private String password;
	private Department department;
	
	
	
	public Employee() {
	}
	public Employee(Integer eid, String ename, String sex, Date birthday, Date joinDate, String eno, String username,
			String password, Department department) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sex = sex;
		this.birthday = birthday;
		this.joinDate = joinDate;
		this.eno = eno;
		this.username = username;
		this.password = password;
		this.department = department;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	
}
