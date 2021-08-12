package com.elearning.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL ="jdbc:mysql://localhost:3306/elearning?allowPublicKeyRetrieval=true&useSSL=false";
		String username = "root";
		String password ="root";
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String mysqlDateString = formatter.format(new Date());

		Connection connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, username, password);
			String query = "insert into user1(name,phone_no,email,address,reg_date,password,upload_photo) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, "Aman");
			pst.setString(2, "7389445506");
			pst .setString(3,"amanktn");
			pst.setString(4,"Katni");
			pst.setString(5, mysqlDateString);
			pst.setString(6,"123456");
			pst.setString(7, "");
			int result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
