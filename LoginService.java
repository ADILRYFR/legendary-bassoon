package com.Service;

import com.bean.Login;
import com.dao.LongDao;

public class LoginService {
	
	LongDao ld = new LongDao();
	public String checkUser(Login ll) {
		
		if(ll.getTypeOfUser().equals("Admin")) {
			if(ll.getEmail().equals("idk@gmail.com")&&ll.getPassword().equals("idkagain")) {
				return "Admin Success";
			}else {
				return "Admin Failure";
			}
		}else {
			
			StringBuffer sb = new StringBuffer(ll.getPassword());
			String newpassword = sb.reverse().toString();
			ll.setPassword(newpassword);
			
			if(ld.checkLoginDetails(ll)) {
				return "success";
			}else {
				return "failure";
			}
			
			
		}
		
		
		
		
	}
	
	public String createUser(Login ll) {
		StringBuffer sb = new StringBuffer(ll.getPassword());
		String newpassword = sb.reverse().toString();
		ll.setPassword(newpassword);
		
		if(ld.createLoginDetails(ll)>0) {
			return "Account created";
		}else {
			return"Account was not created";
		}
		
		
	}
	
	

}
