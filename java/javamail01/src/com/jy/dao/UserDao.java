/*
 *******************************************************************************
 * @FileName	UserDao.java
 * @package		com.jy.dao
 * @author		jy·DT
 * @Date		2018年1月30日 上午2:10:23
 * @description 
 *******************************************************************************
 */
package com.jy.dao;

import com.jy.domain.User;

/**
 ******************************************
 * @author jy·DT  [2018年1月30日 上午2:10:23]
 ******************************************
 */
public interface UserDao {

	void save(User user) throws Exception;

	User findByCode(String code) throws Exception;

	void update(User user) throws Exception;

}
