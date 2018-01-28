/*
 *******************************************************************************
 * @FileName	DepartmentDao.java
 * @package		com.jy.dao
 * @author		jiangyao
 * @Date		2018年1月29日 上午2:12:46
 * @description 
 *******************************************************************************
 */
package com.jy.dao;

import java.util.List;

import com.jy.domain.Department;

/**
 ******************************************
 * @author jiangyao  [2018年1月29日 上午2:12:46]
 ******************************************
 */
public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

}
