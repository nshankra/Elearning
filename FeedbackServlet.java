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

import com.elearning.daos.FeedbackDAO;
import com.elearning.entitites.Contact;
import com.elearning.entitites.Feedback;

/**
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FeedbackDAO feedbackDao = new FeedbackDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List feeds = feedbackDao.getAllFeedback();
		request.setAttribute("feeds", feeds);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/feeds.jsp");
		dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("uid");
	    String name = request.getParameter("uname");
	    String email = request.getParameter("email");
	    String feedbackS = request.getParameter("feedback");
	    Feedback feedback = new Feedback(Integer.parseInt(userId), name, email, 0, feedbackS);
	    boolean saved = feedbackDao.saveFeedback(feedback);
	    HttpSession session=request.getSession();
	    session.setAttribute("userid", userId);
	    session.setAttribute("uname", name);
	    session.setAttribute("email", email);
	    session.setAttribute("feedback", feedbackS);
	    RequestDispatcher rd = request.getRequestDispatcher("/feedback_result.jsp");	    
	    rd.forward(request, response);		
	}

}
