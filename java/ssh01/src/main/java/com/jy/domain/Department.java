/*
 *******************************************************************************
 * @FileName	Department.java
 * @package		com.jy.domain
 * @author		jiangyao
 * @Date		2018年1月28日 下午10:27:48
 * @description 
 *******************************************************************************
 */
package com.jy.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门实体
 ******************************************
 * @author jiangyao  [2018年1月28日 下午10:27:48]
 ******************************************
 */
public class Department {
	private Integer did;
	private String dname;
	private String ddesc;
	//员工集合
	private Set<Employee> employees = new HashSet<Employee>();
 	
	public Department() {
	}
	public Department(Integer did, String dname, String ddesc, Set<Employee> employees) {
		super();
		this.did = did;
		this.dname = dname;
		this.ddesc = ddesc;
		this.employees = employees;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
