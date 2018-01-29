/*
 *******************************************************************************
 * @FileName	DepartmentService.java
 * @package		com.jy.service
 * @author		jiangyao
 * @Date		2018年1月29日 上午2:13:39
 * @description 
 *******************************************************************************
 */
package com.jy.service;

import java.util.List;

import com.jy.domain.Department;
import com.jy.domain.PageBean;

/**
 ******************************************
 * @author jiangyao  [2018年1月29日 上午2:13:39]
 ******************************************
 */
public interface DepartmentService {

	PageBean<Department> findByPage(int currPage);

	void save(Department department);

	void update(Department department);

	Department findById(Integer did);

	void delete(Department department);

	List<Department> findAll();
	
}
