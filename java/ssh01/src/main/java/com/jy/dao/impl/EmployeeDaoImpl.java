package com.jy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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
	
	
}
