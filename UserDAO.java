package com.elearning.daos;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;

import com.elearning.dbutils.DBUtils;
import com.elearning.entitites.User1;

public class UserDAO implements UserDAOI{

	
	@Override
	public int register(User1 user) {
		
		try {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			String mysqlDateString = formatter.format(new Date());
			
			Connection connection = DBUtils.getConnection();
			String query = "insert into user1(name,phone_no,email,address,reg_date,password,upload_photo) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPhoneNo());
			pst .setString(3,user.getEmail());
			pst.setString(4,user.getAddress());
			pst.setString(5, mysqlDateString);
			pst.setString(6,user.getPassword());
			pst.setString(7, user.getUploadPhoto());
			int result = pst.executeUpdate();
			Statement stmt = connection.createStatement();  
	        ResultSet rs = stmt.executeQuery("select MAX(user_id) from user1");
	        rs.first();
			return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<User1> getAllUsers() {
		ArrayList<User1> dataList = new ArrayList<User1>(); 
		try {
			Connection connection = DBUtils.getConnection();
			String query = "select * from user1";
			Statement s = connection.createStatement();
			s.executeQuery(query);
			ResultSet rs = s.getResultSet();
			
			while (rs.next ()){				  
				User1 u = new User1(rs.getInt("user_id"), rs.getString("name"), rs.getString("phone_no"), rs.getString("email"), rs.getString("address"), rs.getString("reg_date"), rs.getString("password"), rs.getString("upload_photo"));
				  dataList.add(u);
			}
			return dataList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return dataList;
	}
	
}
