package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Login;
import com.resource.Resource;

public class LongDao {
	
	public int createLoginDetails(Login ll) {
		try {
			
//			Class.forName("com.mysql.cj.jdbc.Driver"); 
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_batch", "root", "Simplilearn");
			Connection con = Resource.getDBconnection();
			PreparedStatement pstmt = con.prepareStatement("insert into login values(?,?)");
			pstmt.setString(1,ll.getEmail());
			pstmt.setString(2,ll.getPassword());
			int res = pstmt.executeUpdate();
			return res;
			
			
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public boolean checkLoginDetails(Login ll) {
		try {
//		Class.forName("com.mysql.cj.jdbc.Driver"); 
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_batch", "root", "Simplilearn");
			
	    Connection con = Resource.getDBconnection();
		PreparedStatement pstmt = con.prepareStatement("select * from login where email = ? and password = ?");
		pstmt.setString(1, ll.getEmail());
		pstmt.setString(2, ll.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return true;
			
		}
		
		}catch(Exception e) {
			return false;
		}
		return false;
		
	}

}
