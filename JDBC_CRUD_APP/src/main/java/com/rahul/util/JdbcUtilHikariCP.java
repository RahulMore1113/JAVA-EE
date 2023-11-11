package com.rahul.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtilHikariCP {

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static Connection getJdbcConnection() throws SQLException {

		HikariConfig config = new HikariConfig(
				"R:\\Study\\Projects\\JAVA EE\\JDBC_CRUD_APP\\src\\main\\java\\com\\rahul\\properties\\JDBCHikariCP.properties");
		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource.getConnection();

	}

}
