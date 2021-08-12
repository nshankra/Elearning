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
import com.elearning.entitites.User1;

public class CourseDAO implements CourseDAOI {

	@Override
	public boolean addCourse(Course course) {
		try {
			Connection connection = DBUtils.getConnection();
			String query = "insert into course (c_name,c_desp,c_fees,c_resource) values (?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, course.getcName());
			pst.setString(2, course.getcDesp());
			pst .setString(3,course.getcFees());
			pst.setString(4, course.getcResource());
			int result = pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Course> getAllCourses() {
		ArrayList<Course> dataList = new ArrayList<Course>(); 
		try {
			Connection connection = DBUtils.getConnection();
			String query = "select * from course";
			Statement s = connection.createStatement();
			s.executeQuery(query);
			ResultSet rs = s.getResultSet();
			
			while (rs.next ()){				  
				Course c = new Course(rs.getInt("course_id"), rs.getString("c_name"), rs.getString("c_desp"), rs.getString("c_fees"), rs.getString("c_resource"));
				dataList.add(c);
			}
			return dataList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
