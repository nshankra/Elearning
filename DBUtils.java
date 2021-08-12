package com.elearning.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {

	private static String URL ="jdbc:mysql://localhost:3306/elearning?allowPublicKeyRetrieval=true&useSSL=false";
	private static String user = "root";
	private static String password ="root";
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(URL, user, password);
			return c;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
