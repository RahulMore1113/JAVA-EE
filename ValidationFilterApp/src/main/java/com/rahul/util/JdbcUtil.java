package com.rahul.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil 
{
	private JdbcUtil() 
	{
		
	}
	
	static
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException, IOException
	{
		FileInputStream fis = new FileInputStream("P:\\Project\\JAVA EE\\ValidationFilterApp\\src\\main\\java\\properties\\mysqljdbc.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		Connection con = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		
		return con;
	}
}
