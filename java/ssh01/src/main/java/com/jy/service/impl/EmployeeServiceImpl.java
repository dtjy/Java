package com.jy.service.impl;

import java.util.List;

import com.jy.dao.EmployeeDao;
import com.jy.domain.Employee;
import com.jy.domain.PageBean;
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

	public PageBean<Employee> findByPage(int currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		pageBean.setCurrPage(currPage);
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		int totalCount = this.employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		int pageCount;
		if(totalCount%pageSize == 0){
			pageCount = totalCount/pageSize;
		}else {
			pageCount = totalCount/pageSize + 1;
		}
		pageBean.setTotalPage(pageCount);
		int begin = (currPage-1)*pageSize;
		List<Employee> list = this.employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
		
	}

	public void save(Employee employee) {
		this.employeeDao.saveEmployee(employee);
	}

	public void delete(Employee employee) {
		this.employeeDao.delete(employee);
	}

	public Employee findById(Integer eid) {
		this.employeeDao.findById(eid);
		return this.employeeDao.findById(eid);
	}

	public void update(Employee employee) {
		this.employeeDao.update(employee);
	}
	
	
}
