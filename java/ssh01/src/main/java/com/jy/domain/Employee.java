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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * 员工实体
 ******************************************
 * @author jiangyao  [2018年1月28日 下午10:28:08]
 ******************************************
 */
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer eid;
	@Column
	private String ename;
	@Column
	private String sex;
	@Column
	private Date birthday;
	@Column
	private Date joinDate;
	@Column
	private String eno;
	@Column
	private String username;
	@Column
	private String password;
	@ManyToOne(targetEntity=com.jy.domain.Department.class)
	@JoinColumn(name="dno", nullable=false)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
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
