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
		session.close();
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
		session.close();
		return list;
	}
	
	public void save(Department department) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(department);
		tx.commit();
		session.close();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void update(Department department) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(department);
		tx.commit();
		session.close();
	}

	public Department findById(Integer did) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Department department =  (Department) session.get(Department.class, did);
		tx.commit();
		session.close();
		return department;
	}

	public void deleteDepartment(Department department) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(department);
		tx.commit();
		session.close();
	}

	public List<Department> findAll() {
		String hql = "from Department";
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Department> list =  query.list();
		tx.commit();
		session.close();
		return list;
	}	
}
