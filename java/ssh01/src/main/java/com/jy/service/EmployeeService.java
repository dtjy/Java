package com.jy.service;

import com.jy.domain.Employee;
import com.jy.domain.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);


	PageBean<Employee> findByPage(int currPage);


	void save(Employee employee);


	void delete(Employee employee);


	void update(Employee employee);


	Employee findById(Integer eid);

}
