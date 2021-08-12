package com.elearning.entitites;

import java.util.Objects;

public class Course {

	
	private int courseId;
	private String cName;
	private String cDesp;
	private String cFees;
	private String cResource;
	
	

	public Course() {
		
	}
	
	

	public Course(int courseId, String cName, String cDesp, String cFees, String cResource) {
		
		this.courseId = courseId;
		this.cName = cName;
		this.cDesp = cDesp;
		this.cFees = cFees;
		this.cResource = cResource;
	}

	

	public String getcDesp() {
		return cDesp;
	}



	public void setcDesp(String cDesp) {
		this.cDesp = cDesp;
	}

	

	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}



	public String getcName() {
		return cName;
	}



	public void setcName(String cName) {
		this.cName = cName;
	}



	public String getcFees() {
		return cFees;
	}



	public void setcFees(String cFees) {
		this.cFees = cFees;
	}



	public String getcResource() {
		return cResource;
	}



	public void setcResource(String cResource) {
		this.cResource = cResource;
	}



	@Override
	public int hashCode() {
		return Objects.hash(cDesp, cFees, cName, cResource, courseId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(cDesp, other.cDesp) && Objects.equals(cFees, other.cFees)
				&& Objects.equals(cName, other.cName) && Objects.equals(cResource, other.cResource)
				&& courseId == other.courseId;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + courseId + ", c_name=" + cName + ", c_desp=" + cDesp + ", c_fees=" + cFees
				+ ", c_resource=" + cResource + "]";
	}
	
	
	
	
}
