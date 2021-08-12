package com.elearning.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.elearning.daos.UserDAO;
import com.elearning.entitites.User1;



/**
 * Servlet implementation class UserServlet
 */
@MultipartConfig
@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List users = userDao.getAllUsers();
		System.out.println("Helo");
		System.out.println(users);
		request.setAttribute("users", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/users.jsp");
		dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> multipartRequestParams = request.getParameterMap();
		String name = request.getParameter("uname");
	    String phoneNo = request.getParameter("phone");
	    String email = request.getParameter("email");
	    String address = request.getParameter("address");
	    String regDate = "";
	    String password = request.getParameter("pwd");
	    
	    
	    
	    Part filePart = request.getPart("uploadPhoto");
	    String exts[] = Paths.get(filePart.getSubmittedFileName()).getFileName().toString().split("\\."); // MSIE fix.
	    String ext = exts[exts.length - 1];
	    String fileName = email.split("@")[0] + "." + ext;
	    InputStream fileContent = filePart.getInputStream();
	    
	    OutputStream outStream = new FileOutputStream("C:/Users/nshan/OneDrive/Desktop" + fileName);
	    
	    
	    byte[] buf = new byte[8192];
	    int length;
	    while ((length = fileContent.read(buf)) > 0) {
	        outStream.write(buf, 0, length);
	    }
	    
	    fileContent.close();
	    outStream.close();
	    
	    User1 user = new User1(0, name, phoneNo, email, address, regDate, password, fileName);
	    int id = userDao.register(user);
	    HttpSession session=request.getSession();
	    session.setAttribute("userid", id);
	    RequestDispatcher rd = request.getRequestDispatcher("/registration_result.jsp");
	    
	    rd.forward(request, response);
		
	}

}
