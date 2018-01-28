package com.jy.service.impl;

import com.jy.dao.EmployeeDao;
import com.jy.domain.Employee;
import com.jy.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao employeeDao;

	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		if(existEmployee!=null){
			//登陆后成功
			return existEmployee;
		}
		//登陆失败
		return null;
	}
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

}
