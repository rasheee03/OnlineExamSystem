package com.lti.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.model.customer;
//data access object-> design pattern 
//connecting database
public class CustomerDao
{
public void insert(customer customer)
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
	em.persist(customer);
	tx.commit();
	em.close();
	emf.close();
	
}


public customer fetch(int fid)   //fetching data
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
	EntityManager em=emf.createEntityManager();
	customer c=em.find(customer.class, fid); //generates select query 
	//customer.class gives table name 
	//find: use for primary key
	em.close();
	emf.close();
	return c;
}



public List<customer> fetchByCity(String city) //fetching data
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
	EntityManager em=emf.createEntityManager();
	
	Query q=em.createQuery("select c from customer as c where c.city=:ct");
    
    q.setParameter("ct",city);
    
    List<customer> customers=q.getResultList();
    
	em.close();
	emf.close();
	return customers;
	//return c;
}
}

