/*
 *******************************************************************************
 * @FileName	DepartmentServiceImpl.java
 * @package		com.jy.service.impl
 * @author		jiangyao
 * @Date		2018年1月29日 上午2:13:57
 * @description 
 *******************************************************************************
 */
package com.jy.service.impl;

import java.util.List;

import com.jy.dao.DepartmentDao;
import com.jy.domain.Department;
import com.jy.domain.PageBean;
import com.jy.service.DepartmentService;

/**
 ******************************************
 * @author jiangyao  [2018年1月29日 上午2:13:57]
 ******************************************
 */
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentDao departmentDao;

	/* 
	 * 分页查询部门
	 * @see com.jy.service.DepartmentService#findByPage(java.lang.Integer)
	 */
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装数据库总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setToatlPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage-1)*pageSize;
		List<Department> list = this.departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

}
