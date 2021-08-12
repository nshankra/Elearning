package com.elearning.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elearning.daos.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean admin;
		try {
			admin = request.getParameterValues("admin")[0].equalsIgnoreCase("on");
		}catch (NullPointerException e) {
			admin = false;
		}
		
		String role = admin ? "admin" : "user";
		LoginDAO loginDao = new LoginDAO();
		boolean success = loginDao.login(username, password, role);
		HttpSession session=request.getSession();
		if(success) {
			System.out.println(role + " aa gya");
			
			session.setAttribute("loggedIn", "true");
			session.setAttribute("role", role);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		    rd.forward(request, response);
		}
		else {
			session.setAttribute("loggedIn", "false");
			session.setAttribute("role", "");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		    rd.forward(request, response);
		}
		
	}

}
