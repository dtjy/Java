package com.jy.dao;

import com.jy.domain.Employee;

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

}
