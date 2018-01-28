/*
 *******************************************************************************
 * @FileName	DepartmentDaoImpl.java
 * @package		com.jy.dao.impl
 * @author		jiangyao
 * @Date		2018年1月29日 上午2:13:08
 * @description 
 *******************************************************************************
 */
package com.jy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jy.dao.DepartmentDao;
import com.jy.domain.Department;

/**
 * 
 ******************************************
 * @author jiangyao  [2018年1月29日 上午2:13:08]
 ******************************************
 */
public class DepartmentDaoImpl implements DepartmentDao{
	
	private SessionFactory sessionFactory;
	
	public int findCount() {
		String hql = "select count(*) from Department";
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		Long a = (Long) query.uniqueResult();
		int totalCount = a.intValue();
		tx.commit();
		return totalCount;
	}
	
	public List<Department> findByPage(int begin, int pageSize) {
		String hql = "from Department";
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		@SuppressWarnings("unchecked")
		List<Department> list = query.list();
		tx.commit();
		return list;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
