/*
 *******************************************************************************
 * @FileName	UserServiceImpl.java
 * @package		com.jy.service.impl
 * @author		jy·DT
 * @Date		2018年1月30日 上午2:08:31
 * @description 
 *******************************************************************************
 */
package com.jy.service.impl;

import com.jy.dao.UserDao;
import com.jy.dao.impl.UserDaoImpl;
import com.jy.domain.User;
import com.jy.service.UserService;
import com.jy.utils.MailUtil;

/**
 ******************************************
 * @author jy·DT  [2018年1月30日 上午2:08:31]
 ******************************************
 */
public class UserServiceImpl implements UserService{

	@Override
	public void save(User user) throws Exception {
		//用户注册保存
		UserDao userDao = new UserDaoImpl();
		userDao.save(user);
		//邮箱激活
		MailUtil.sendMail(user.getEmail(), user.getCode());
	}

	@Override
	public User findByCode(String code) throws Exception {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findByCode(code);
		return user;
	}

	@Override
	public void update(User user) throws Exception {
		UserDao userDao = new UserDaoImpl();
		userDao.update(user);
		
	}
	
	

}
