package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bean.Product;
import com.Service.ProductService;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    ProductService ps = new ProductService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		List<Product> listofallproducts = ps.getallProductdetails();
		hs.setAttribute("listofproducts",listofallproducts);
		//response.sendRedirect("displayproduct.jsp");
		RequestDispatcher rd1 = request.getRequestDispatcher("displayproduct.jsp");
		rd1.include(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		Float price = Float.parseFloat(request.getParameter("price"));
		response.setContentType("text/html");
		
		Product p = new Product();
		p.setPid(pid);
		p.setPname(pname);
		p.setPrice(price);
		
		String result = ps.addProduct(p);
		pw.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("storeproduct.jsp");
		rd.include(request, response);
		//doGet(request, response);
		
		
		
	}

}
