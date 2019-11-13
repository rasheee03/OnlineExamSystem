package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.model.Address;
import com.lti.model.User;
import com.lti.model.customer;


public class UserAddressDao {
	public void insert(User user)
	{

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
	
		EntityManager em=emf.createEntityManager();


		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		em.persist(user);
		tx.commit();
		em.close();
		emf.close();
		
	}
  //fetching data
	public void save(Address addr)
	{
	//STEP-1
		//load/create entitymanagerfactory object
		//during this step, META-INF/persistence.xml file is read automatically
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		//STEP-2
		//Load/create entitymanagerfactory object
		EntityManager em=emf.createEntityManager();
		
		//STEP-3
			//participate or start a transaction

		EntityTransaction tx=em.getTransaction();
		tx.begin();
		//Now we can insert/update/delete
		//persist method generates insert query for us
		em.persist(addr);
		tx.commit();
		em.close();
		emf.close();
	}
	public User Userfetch(int i) {
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
			EntityManager em=emf.createEntityManager();
			User c=em.find(User.class, i); //generates select query 
			//customer.class gives table name 
			//find: use for primary key
			em.close();
			emf.close();
			return c;
		}
	
	}
	}


