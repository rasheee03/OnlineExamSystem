package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.dao.UserAddressDao;
import com.lti.model.Address;
import com.lti.model.Passport;
import com.lti.model.Person;
import com.lti.model.User;

public class PersonPassportTest {

	@Test
	public void addPerson() {
		Person person=new Person();
		//person.setId(123);
		person.setName("mayank");
		person.setAge(21);
		
		 GenericDao dao=new GenericDao();
		 dao.save(person);	
	}

	@Test
	public void assignPassportToAPerson() {
		 GenericDao dao=new GenericDao();
		 Person person=(Person) dao.fetchById(Person.class,181);
		 
		 Passport passport=new Passport();
		 passport.setPassportNo("m12111");
		 passport.setCountry("India");
		 passport.setIssueDate(LocalDate.of(2010, 10, 10));
		 passport.setExpiryDate(LocalDate.of(2010, 10, 10));
		 passport.setPerson(person);
		 dao.save(passport);
		 
		 
		
	}
	@Test
	public void addPersonAlongWithPassport() {
		GenericDao dao=new GenericDao ();
			Person person=new Person();
			person.setName("ABC");
			person.setAge(25);
			
			
			
			
		Passport passport = new Passport();
			passport.setPassportNo("H5141");
			passport.setCountry("USA");
			passport.setIssueDate(LocalDate.of(2013,12,11));
			passport.setExpiryDate(LocalDate.of(2023,11,11));
			
			
			person.setPassport(passport);
			passport.setPerson(person);
			//dao.save(passport);
			dao.save(person);
	}
	
	
	@Test
	public void UpdatePerson() {
		GenericDao dao=new GenericDao();
 Person person=(Person) dao.fetchById(Person.class,208);
		 
 
		
		 person.setAge(100);
		 dao.save(person);

		 
		
	}
	
	
}
