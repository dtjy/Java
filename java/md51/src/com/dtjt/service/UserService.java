/*
 *******************************************************************************
 * @FileName	UserService.java
 * @package		com.dtjt.service
 * @author		jy·DT
 * @Date		2018年2月1日 下午8:47:02
 * @description 
 *******************************************************************************
 */
package com.dtjt.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dtjt.dao.UserDao;
import com.dtjt.entity.User;

/**
 * service
 ******************************************
 * @author jy·DT  [2018年2月1日 下午8:47:02]
 ******************************************
 */
public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public List<User> findAll() throws SQLException {
		return this.userDao.findAll();
	}

	public List<User> findBy(String parameter) throws SQLException {
		return this.userDao.findBy(parameter);
	}

	public String add(User user) throws SQLException {
//		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		int result = this.userDao.add(user);
		if(result==1){
			return "添加成功";
		}else {
			return "添加失败";
		}
	}

	public String update(User user) throws SQLException {
//		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		int resultRow = this.userDao.update(user);
		if(resultRow==1){
			return "更新成功";
		}else{
			return "更新失败";
		}
	}

	public String delete(String ids) throws SQLException {
		int resultRow = 0;
		List<Integer> list = new ArrayList<Integer>();
		if(ids.contains(",")){
			String[] arrStr = ids.split(",");
			for(int i=0; i<arrStr.length; i++){
				list.add(Integer.parseInt(arrStr[i]));
			}
			resultRow = this.userDao.delete(list);
		}else{
			list.add(Integer.parseInt(ids));
			resultRow = this.userDao.delete(list);
		}
		if(resultRow>0){
			return "删除成功";
		}else {
			return "删除失败";
		}
	}
	
}
