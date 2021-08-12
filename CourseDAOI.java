package com.elearning.daos;

import java.util.List;

import com.elearning.entitites.Course;

public interface CourseDAOI {
	public boolean addCourse(Course course);
	public List<Course> getAllCourses();
}
