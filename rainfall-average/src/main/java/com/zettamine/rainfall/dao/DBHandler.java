package com.zettamine.rainfall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBHandler {
	private static Connection con = null;
	public static Connection establishConnection() throws SQLException, ClassNotFoundException {
		if(con==null) {
			ResourceBundle bundle = ResourceBundle.getBundle("dbconfig");
			String dc = bundle.getString("jdbc.driverclass");
			String url = bundle.getString("jdbc.url");
			String user = bundle.getString("jdbc.username");
			String pass = bundle.getString("jdbc.password");
			
			Class.forName(dc);
			con = DriverManager.getConnection(url,user,pass);
			return con;
		}
		return con;
	}
}
