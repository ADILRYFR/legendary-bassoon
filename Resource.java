package com.resource;

import java.sql.Connection;
import java.sql.DriverManager;


public class Resource {
	
	public static Connection getDBconnection()  {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_batch", "root", "Simplilearn");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
