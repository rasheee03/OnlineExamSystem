package com.lti.app;

import org.junit.Test;

import com.lti.dao.UserAddressDao;
import com.lti.model.User;

public class App1 {

	public static void main(String[] args) {

		
			User u=new User();
			u.setName("John");
			u.setEmail("john@gmail.com");
			u.setPassword("john123");
			
			 UserAddressDao dao=new UserAddressDao();
			dao.insert(u);	


	}

}
