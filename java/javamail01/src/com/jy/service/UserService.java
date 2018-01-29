/*
 *******************************************************************************
 * @FileName	UserService.java
 * @package		com.jy.service
 * @author		jy·DT
 * @Date		2018年1月30日 上午2:08:02
 * @description 
 *******************************************************************************
 */
package com.jy.service;

import com.jy.domain.User;

/**
 ******************************************
 * @author jy·DT  [2018年1月30日 上午2:08:02]
 ******************************************
 */
public interface UserService {
	//保存注册数据
	void save(User user) throws Exception;
	//邮箱激活

	User findByCode(String code) throws Exception;

	void update(User user) throws Exception;
	
}
