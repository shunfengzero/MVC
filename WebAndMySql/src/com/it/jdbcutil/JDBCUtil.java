package com.it.jdbcutil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	private static String url;
	private static String user;
	private static String password;
	private static Connection conn;
	private static String driver;
	
	static {
		Properties props = new Properties();
		
		InputStream in = JDBCUtil.class.getResourceAsStream("/db.properties");
		
		try {
			props.load(in);
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("passwrod");
			driver = props.getProperty("driverClass");
			
			Class.forName(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public static Connection getConnection() {
		
		try {
			conn = DriverManager.getConnection(url,user,password);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
