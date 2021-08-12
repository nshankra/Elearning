package com.elearning.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elearning.dbutils.DBUtils;
import com.elearning.entitites.Course;
import com.elearning.entitites.Feedback;

public class FeedbackDAO implements FeedbackDAOI {

	@Override
	public boolean saveFeedback(Feedback feedback) {
		try {
			Connection connection = DBUtils.getConnection();
			String query = "insert into feedback (user_id,name,email,feedback) values (?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, feedback.getUserId());
			pst.setString(2, feedback.getName());
			pst .setString(3,feedback.getEmail());
			pst.setString(4, feedback.getFeedback());
			int result = pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Feedback> getAllFeedback() {
		ArrayList<Feedback> dataList = new ArrayList<Feedback>(); 
		try {
			Connection connection = DBUtils.getConnection();
			String query = "select * from feedback";
			Statement s = connection.createStatement();
			s.executeQuery(query);
			ResultSet rs = s.getResultSet();
			
			while (rs.next ()){				  
				Feedback c = new Feedback(rs.getInt("user_id"), rs.getString("name"), rs.getString("email"), rs.getInt("f_id"), rs.getString("feedback"));
				dataList.add(c);
			}
			return dataList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
