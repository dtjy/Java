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
	public PageBean<Department> findByPage(int currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		System.out.println(currPage);
		pageBean.setCurrPage(currPage);
		//封装每页记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装数据库总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		int totalPage;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//封装每页显示的数据
		int begin = (currPage-1)*pageSize;
		List<Department> list = this.departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	public void save(Department department) {
		this.departmentDao.save(department);
	}
	
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public void update(Department department) {
		this.departmentDao.update(department);
	}

	public Department findById(Integer did) {
		
		return this.departmentDao.findById(did);
	}

	public void delete(Department department) {
		this.departmentDao.deleteDepartment(department);
		
	}

	public List<Department> findAll() {
		List<Department> list = this.departmentDao.findAll();
		return list;
	}


}
