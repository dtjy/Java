package com.jy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jy.dao.EmployeeDao;
import com.jy.domain.Employee;

/**
 * 使用Spring对ORM的模板支持类
 ******************************************
 * @author jiangyao  [2018年1月29日 上午12:28:02]
 ******************************************
 */
public class EmployeeDaoImpl implements EmployeeDao{
	
	private SessionFactory sessionFactory;
	
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username=? and password=?";
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString(0, employee.getUsername());
		query.setString(1, employee.getPassword());
		Employee existEmployee = (Employee) query.uniqueResult();
//		List<Employee> list =  this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
//		session.close();
		tx.commit();
		session.close();
		if(existEmployee!=null){
			return existEmployee;
		}
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int findCount() {
		String hql = "select count(*) from Employee";
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		Long count = (Long) query.uniqueResult();
		tx.commit();
		session.close();
		return count.intValue();
	}


	public List<Employee> findByPage(int begin, int pageSize) {
		String hql = "from Employee";
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setMaxResults(pageSize);
		query.setFirstResult(begin);
		@SuppressWarnings("unchecked")
		List<Employee> list = query.list();
		tx.commit();
		session.close();
		return list;
	}

	public void saveEmployee(Employee employee) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
	}

	public Employee findById(Integer eid) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, eid);
		tx.commit();
		session.close();
		return employee;
	}

	public void update(Employee employee) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(employee);
		tx.commit();
		session.close();
	}

	public void delete(Employee employee) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(employee);
		tx.commit();
		session.close();
	}
	
	
}
