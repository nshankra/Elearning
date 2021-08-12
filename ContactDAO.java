package com.elearning.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.elearning.dbutils.DBUtils;
import com.elearning.entitites.Contact;

public class ContactDAO implements ContactDAOI {

	@Override
	public boolean saveContact(Contact contact) {
		try {
			Connection connection = DBUtils.getConnection();
			String query = "insert into contact (user_id,name,email,phone_no,messege) values (?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, contact.getUserId());
			pst.setString(2, contact.getName());
			pst .setString(3,contact.getEmail());
			pst.setString(4, contact.getPhoneNo());
			pst.setString(5, contact.getMessage());
			int result = pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
