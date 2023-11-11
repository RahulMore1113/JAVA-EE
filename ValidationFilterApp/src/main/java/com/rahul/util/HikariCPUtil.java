package com.rahul.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPUtil 
{
	private HikariCPUtil() 
	{
		
	}
	
	static
	{
		
	}
	
	public static Connection getJdbcConnection() throws SQLException
	{
		HikariConfig config = new HikariConfig("P:\\Project\\JAVA EE\\ValidationFilterApp\\src\\main\\java\\properties\\HikariCP.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		
		return dataSource.getConnection();
	}
}
