package com.masai.utilty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {

	static final String url;
	static final String username;
	static final String password;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ResourceBundle rb=ResourceBundle.getBundle("dbDetails");
		url=rb.getString("url");
		username=rb.getString("username");
		password=rb.getString("password");
	}
	
	static Connection createConnection() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}
	
	static void closeConnection(Connection con) throws SQLException {
		if(con!=null) {
			con.close();			
		}
	}
}
