/*
 *******************************************************************************
 * @FileName	UserDaoImpl.java
 * @package		com.jy.dao.impl
 * @author		jy·DT
 * @Date		2018年1月30日 上午2:10:47
 * @description 
 *******************************************************************************
 */
package com.jy.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.jy.dao.UserDao;
import com.jy.domain.User;
import com.jy.utils.JDBCUtils;

/**
 ******************************************
 * @author jy·DT  [2018年1月30日 上午2:10:47]
 ******************************************
 */
public class UserDaoImpl implements UserDao{

	@Override
	public void save(User user) throws Exception {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into usermail values(?,?,?,?,?,?,?)";
		Object[] params = {user.getUid(),user.getUsername(),user.getPassword(),user.getNickname(),user.getEmail(),user.getStatus(),user.getCode()};
		queryRunner.update(sql, params);
	}

	@Override
	public User findByCode(String code) throws Exception {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from usermail where code=?";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class), code);
		return user;
	}

	@Override
	public void update(User user) throws Exception {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update usermail set status=?,code=? where uid=?";
		Object[] params = {user.getStatus(),user.getCode(),user.getUid()};
		queryRunner.update(sql, params);
	}

}
