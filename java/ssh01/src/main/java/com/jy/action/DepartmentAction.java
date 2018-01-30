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
 * DepartmentAction
 ******************************************
 * @author jiangyao  [2018年1月29日 上午2:11:23]
 ******************************************
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	/**
	 * 序列化
	 * [2018年1月29日 上午10:23:28]
	 */
	private static final long serialVersionUID = 1L;

	private Department department = new Department();
	public Department getModel() {
		return department;
	}
	
	private DepartmentService departmentService;
	
	private int currPage = 1;
	
	//删除
	public String delete(){
		department = this.departmentService.findById(department.getDid());
		this.departmentService.delete(department);
		return "delete";
	}
	
	//提供一个查询方法
	public String findAll(){
		PageBean<Department> pageBean = this.departmentService.findByPage(currPage);
		//将pageBean存入值栈中
		ActionContext ac = ActionContext.getContext();
		ac.getValueStack().push(pageBean);
		return "findAll";
	}
	
	//添加页面
	public String saveUI(){
		return "add";
	}
	//保存添加
	public String save(){
		this.departmentService.save(department);
		return "save";
	}
	//编辑页面
	public String edit(){
		department = this.departmentService.findById(department.getDid());
		return "edit";
	}
	//更改保存
	public String update(){
		this.departmentService.update(department);
		System.out.println(department.getDid());
		System.out.println(department.getDdesc());
		this.findAll();
		return "findAll";
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}


}
