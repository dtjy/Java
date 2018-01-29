/*
 *******************************************************************************
 * @FileName	UUIDUtil.java
 * @package		com.jy.utils
 * @author		jy·DT
 * @Date		2018年1月30日 上午2:03:35
 * @description 
 *******************************************************************************
 */
package com.jy.utils;

import java.util.UUID;

/**
 * code生成工具
 ******************************************
 * @author jy·DT  [2018年1月30日 上午2:03:35]
 ******************************************
 */
public class UUIDUtil {
	
	public static String code(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
