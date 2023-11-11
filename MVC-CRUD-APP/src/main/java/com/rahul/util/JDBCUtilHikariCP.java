package com.rahul.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JDBCUtilHikariCP 
{
	private JDBCUtilHikariCP() {}
	
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
	}
	
	public static Connection getJDBCConnection() throws SQLException
	{
		 HikariConfig config = new HikariConfig("P:\\Project\\JAVA EE\\JDBCCRUDAPP2\\src\\main\\java\\com\\rahul\\properties\\JDBCHikariCP.properties");
		 HikariDataSource dataSource = new HikariDataSource(config);
		 
		 return dataSource.getConnection();
	}
}
