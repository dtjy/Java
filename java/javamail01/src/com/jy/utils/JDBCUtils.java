package com.jy.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private static String url = "jdbc:mysql://localhost:3306/bamboo";
    private static String user = "root";
    private static String passwd = "mysql";
    private static String driver = "com.mysql.jdbc.Driver";
   
	public static ComboPooledDataSource getDataSource() throws Exception{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( driver);
        cpds.setJdbcUrl( url );
        cpds.setUser(user);                                  
        cpds.setPassword(passwd);  
        cpds.setMinPoolSize(5);                                     
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(30);
        cpds.setMaxIdleTime(60);
		return cpds;
	}
}
