package com.elevateLabs.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DButils {
	private static final String URL = "jdbc:mysql://localhost:3306/elevateLabs_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public static Connection connection() throws SQLException{
		return DriverManager.getConnection(URL ,USERNAME ,PASSWORD);
	}
}
