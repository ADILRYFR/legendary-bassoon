package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Service.LoginService;
import com.bean.Login;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw = response.getWriter();
		HttpSession hs = request.getSession();
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String typeOfUser= request.getParameter("typeOfUser");
		
		Login ll = new Login();
		ll.setEmail(email);
		ll.setPassword(password);
		ll.setTypeOfUser(typeOfUser);
		
		LoginService ls = new LoginService();
		String result = ls.checkUser(ll);
		
		RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
		RequestDispatcher rd1= request.getRequestDispatcher("adminHome.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("userHome.jsp");
		
		if(result.equals("Admin Success")) {
			hs.setAttribute("admin",ll.getEmail());
			rd1.forward(request, response);
		}else if(result.equals("success")) {
			hs.setAttribute("user",ll.getEmail());
			rd2.forward(request, response);
		}else {
			pw.println("Invalid credentials");
			rd.include(request, response);
		
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession hs = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String typeOfUser = request.getParameter("typeOfUser");
		
		Login ll = new Login();
		ll.setEmail(email);
		ll.setPassword(password);
		ll.setTypeOfUser(typeOfUser);
		
		LoginService ls = new LoginService();
		String result = ls.checkUser(ll);
		pw.println(result);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	
		
		
				
		
	}

}
