package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Product;
import com.resource.Resource;

public class ProductDao {
	
	public int storeProduct(Product p) {
		try {
		Connection con = Resource.getDBconnection();
		PreparedStatement pstst= con.prepareStatement("insert into product values (?,?,?)");
		pstst.setInt(1, p.getPid());
		pstst.setString(2,p.getPname());
		pstst.setFloat(3, p.getPrice());
		int res = pstst.executeUpdate();
		return res;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
		
		
		
	}
	
	public List<Product> getAllDetails(){
		
		List<Product> listofall = new ArrayList<Product>();
		
		try {
			
			Connection con = Resource.getDBconnection();
			PreparedStatement pstst = con.prepareStatement("Select * from product");
			ResultSet rs = pstst.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getFloat(3));
				listofall.add(p);
				
				
			}
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
		return listofall;
		
		
	}

}
