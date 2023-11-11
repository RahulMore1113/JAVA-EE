package com.rahul.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil 
{

	private JDBCUtil()
	{
		
	}
	
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
	
	public static Connection getJDBCConnection() throws SQLException, IOException
	{
		FileInputStream fis = new FileInputStream("P:\\Project\\JAVA EE\\JDBCCRUDAPP2\\src\\main\\java\\com\\rahul\\properties\\applicaton.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		System.out.println("Connection Object Created...");
		return connection;
	}
	
	public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) throws SQLException
	{
		if(connection!=null)
			connection.close();
		
		if(statement!=null)
			statement.close();
		
		if(resultSet!=null)
			resultSet.close();
	}

}
