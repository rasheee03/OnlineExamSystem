package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.model.customer;

public class CustomerTest {

	@Test
	public void saveCustomer() {
		
		customer ob=new customer();
		ob.setName("Jyoti");
		ob.setCity("raebareli");
		CustomerDao dao=new CustomerDao();
		dao.insert(ob);	
		
	}
@Test

public void fetchById() {
	CustomerDao dao=new CustomerDao();
	customer c=dao.fetch(61);  //checking in db
	assertNotNull(c);
	System.out.println(c.getName());
	System.out.println(c.getCity());
	
	
	
}
	
	
	
}
