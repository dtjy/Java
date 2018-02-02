/*
 *******************************************************************************
 * @FileName	UserDao.java
 * @package		com.dtjt.dao
 * @author		jy·DT
 * @Date		2018年2月1日 下午8:47:17
 * @description 
 *******************************************************************************
 */
package com.dtjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dtjt.entity.User;
import com.dtjt.utils.dbUtil;

/**
 * dao
 ******************************************
 * @author jy·DT  [2018年2月1日 下午8:47:17]
 ******************************************
 */
public class UserDao {

	/**
	 * 查询全部
	 * [2018年2月1日 下午9:11:03]
	 * @return 结果集合
	 * @throws SQLException
	 */
	public List<User> findAll() throws SQLException {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user";
		Connection connection = dbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet result =  ps.executeQuery();
		while(result.next()){
			list.add(create(result));
		}
		dbUtil.close(connection);
		return list;
	}
	
	/**
	 * 构造User对象
	 * [2018年2月1日 下午9:10:48]
	 * @param rs
	 * @return 新建user对象
	 * @throws SQLException
	 */
	public User create(ResultSet rs) throws SQLException{
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setComp(rs.getString("comp"));
		user.setAccount(rs.getString("account"));
		user.setPassword(rs.getString("password"));
		return user;
	}

	/**
	 * 条件模糊查找
	 * [2018年2月2日 上午11:24:33]
	 * @param parameter
	 * @return 结果集合
	 * @throws SQLException
	 */
	public List<User> findBy(String parameter) throws SQLException {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user where comp like ?";
		Connection connection = dbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, "%"+parameter+"%");
		ResultSet result =  ps.executeQuery();
		while(result.next()){
			list.add(create(result));
		}
		dbUtil.close(connection);
		return list;
	}

	/**
	 * 新增
	 * [2018年2月2日 上午11:24:48]
	 * @param user
	 * @return 影响行数
	 * @throws SQLException
	 */
	public int add(User user) throws SQLException {
		String sql = "insert into user (comp,account,password) values(?,?,?)";
		Connection connection = dbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, user.getComp());
		ps.setString(2, user.getAccount());
		ps.setString(3, user.getPassword());
		int resultRow = ps.executeUpdate();
		dbUtil.close(connection);
		return resultRow;
	}

	/**
	 * 修改数据
	 * [2018年2月2日 下午2:27:50]
	 * @param user
	 * @return 修改结果，影响行数
	 * @throws SQLException
	 */
	public int update(User user) throws SQLException {
		String sql = "update user set comp=?,account=?,password=? where id=?";
		Connection connection = dbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, user.getComp());
		ps.setString(2, user.getAccount());
		ps.setString(3, user.getPassword());
		ps.setInt(4, user.getId());
		int resultRow = ps.executeUpdate();
		dbUtil.close(connection);
		return resultRow;
	}

	public int delete(List<Integer> list) throws SQLException {
		String sql = "delete from user where id=?";
		Connection connection = dbUtil.getConnection();
		PreparedStatement ps = null;
		int count = 0;
		for(Integer i:list){
			ps = connection.prepareStatement(sql);
			ps.setInt(1, i);
			int resultRow =  ps.executeUpdate();
			count += resultRow;
		}
		dbUtil.close(connection);
		return count;
	}
	
}
