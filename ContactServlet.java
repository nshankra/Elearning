package com.elearning.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elearning.daos.ContactDAO;
import com.elearning.entitites.Contact;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContactDAO contactDao = new ContactDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("uid");
	    String name = request.getParameter("uname");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String message = request.getParameter("message");
	    Contact contact = new Contact(Integer.parseInt(userId), name, email, phone, message, 0);
	    boolean saved = contactDao.saveContact(contact);
	    HttpSession session=request.getSession();
	    session.setAttribute("userid", userId);
	    session.setAttribute("uname", name);
	    session.setAttribute("email", email);
	    session.setAttribute("phone", phone);
	    session.setAttribute("message", message);
	    RequestDispatcher rd = request.getRequestDispatcher("/contactform_result.jsp");	    
	    rd.forward(request, response);		
	}

}
