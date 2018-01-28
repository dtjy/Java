/*
 *******************************************************************************
 * @FileName	DepartmentAction.java
 * @package		com.jy.action
 * @author		jiangyao
 * @Date		2018年1月29日 上午2:11:23
 * @description 
 *******************************************************************************
 */
package com.jy.action;

import com.jy.domain.Department;
import com.jy.domain.PageBean;
import com.jy.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 ******************************************
 * @author jiangyao  [2018年1月29日 上午2:11:23]
 ******************************************
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	private Department department = new Department();
	public Department getModel() {
		return department;
	}
	
	private DepartmentService departmentService;
	
	private Integer currPage = 1;
	
	//提供一个查询方法
	public String findAll(){
		PageBean<Department> pageBean = this.departmentService.findByPage(currPage);
		//将pageBean存入值栈中
		ActionContext ac = ActionContext.getContext();
		ac.getValueStack().push(pageBean);
		return "findAll";
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	

}
