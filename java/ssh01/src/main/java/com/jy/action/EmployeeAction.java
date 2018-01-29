/*
 *******************************************************************************
 * @FileName	EmployeeAction.java
 * @package		com.jy.action
 * @author		jiangyao
 * @Date		2018年1月29日 上午12:05:03
 * @description 
 *******************************************************************************
 */
package com.jy.action;

import java.util.List;
import java.util.Map;

import com.jy.domain.Department;
import com.jy.domain.Employee;
import com.jy.domain.PageBean;
import com.jy.service.DepartmentService;
import com.jy.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 员工管理action
 ******************************************
 * @author jiangyao  [2018年1月29日 上午12:05:03]
 ******************************************
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	/**
	 * 序列化
	 * [2018年1月29日 下午2:32:20]
	 */
	private static final long serialVersionUID = 1L;

	private Employee employee = new Employee();
	
	private EmployeeService employeeService;
	
	private DepartmentService departmentService;
	
	private int currPage = 1;
	
	//删除
	public String delete(){
		employee = employeeService.findById(employee.getEid());
		this.employeeService.delete(employee);
		return "delete";
	}
	
	//编辑修改
	public String edit(){
		employee = employeeService.findById(employee.getEid());
		List<Department> list = this.departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "edit";
	}
	
	//修改保存
	public String update(){
		this.employeeService.update(employee);
		return "update";
	}
	
	//打开添加页面
	public String add(){
		List<Department> list = this.departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "add";
	}
	//增加保存
	public String save(){
		this.employeeService.save(employee);
		return "save";
	}
	/**
	 * 登录执行方法
	 * [2018年1月29日 上午12:05:44]
	 * @return 
	 */
	public String login(){
		System.out.println("login()执行");
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee!=null){
			//登陆后成功
			ActionContext ac = ActionContext.getContext();
			Map<String,Object> httpSession = ac.getSession();
			httpSession.put("existEmployee", existEmployee);
			return SUCCESS;
		}else{
			//登陆失败
			this.addActionError("用户名或密码错误");
			return INPUT;
		}
	}
	//查询全部
	public String findAll(){
		PageBean<Employee> pageBean =  this.employeeService.findByPage(currPage);
		ActionContext actionContext = ActionContext.getContext();
		actionContext.getValueStack().push(pageBean);
		return "findAll";
	}
	
	public Employee getModel() {
		return employee;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
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
