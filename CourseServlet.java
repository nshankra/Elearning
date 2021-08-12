package com.elearning.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elearning.daos.CourseDAO;
import com.elearning.entitites.Course;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CourseDAO courseDao = new CourseDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List courses = courseDao.getAllCourses();
		request.setAttribute("courses", courses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/courses.jsp");
		dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String cname = request.getParameter("cname");
	    String cdesp = request.getParameter("cdesp");
	    String cfees = request.getParameter("cfees");
	    String cres = request.getParameter("cres");
	    Course course = new Course(0, cname, cdesp, cfees, cres);
	    boolean added = courseDao.addCourse(course);
	    HttpSession session=request.getSession();
	    
	    session.setAttribute("cname", cname);
	    session.setAttribute("cdesp", cdesp);
	    session.setAttribute("cfees", cfees);
	    session.setAttribute("cres", cres);
	    RequestDispatcher rd = request.getRequestDispatcher("/course_result.jsp");	    
	    rd.forward(request, response);		
	}

}
