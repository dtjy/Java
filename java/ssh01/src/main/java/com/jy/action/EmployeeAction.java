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

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.jy.domain.Employee;
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
	
	private Employee employee = new Employee();
	
	private EmployeeService employeeService;
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

	public Employee getModel() {
		return employee;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
}
