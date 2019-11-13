package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.dao.UserAddressDao;
import com.lti.model.Address;
import com.lti.model.User;
import com.lti.model.customer;

public class UserTest {

	@Test
	public void test() {
		User u=new User();
		u.setName("cdvdjvbn");
		u.setEmail("b@yahoo.com");
		u.setPassword("dhcjh@3245");
		
		 UserAddressDao dao=new UserAddressDao();
		 dao.insert(u);	
	}
	
	@Test
	public void addAddressForAnExistingUser() {
		UserAddressDao dao = new UserAddressDao();
		User user = dao.Userfetch(129);
		Address addr = new Address();
		addr.setPincode(40001);
		addr.setCity("Mumbai");
		addr.setLandmark("Behind Tajmahal Hotel");
		addr.setUserObj(user);
		dao.save(addr);
	}
	
	@Test
	public void addUserAlongWithAddress() {

		 UserAddressDao dao=new UserAddressDao();
			User u=new User();
			u.setName("hahaha");
			u.setEmail("papa@yahoo.com");
			u.setPassword("dhcjh@3245");
			
			
			
			Address addr = new Address();
			addr.setPincode(40001);
			addr.setCity("Delhi");
			addr.setLandmark("Behind Hauz Khas");
			addr.setUserObj(u);
			dao.save(addr);
			
	}

}
