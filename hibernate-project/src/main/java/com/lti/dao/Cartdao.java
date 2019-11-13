package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.model.Address;
import com.lti.model.Item;
import com.lti.model.User;
import com.lti.model.customer;


public class Cartdao {
	public void save(Item item)
	{

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
	
		EntityManager em=emf.createEntityManager();


		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		em.persist(item);
		tx.commit();
		em.close();
		emf.close();
		
	}}