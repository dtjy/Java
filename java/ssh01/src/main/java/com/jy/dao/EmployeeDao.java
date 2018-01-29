package com.jy.dao;

import java.util.List;

import com.jy.domain.Employee;

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void saveEmployee(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);


}
