package com.lti.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.lti.model.Account;
import com.lti.model.Transaction;
import com.lti.model.customer;

public class AccountDao extends GenericDao{
 
	public List<Account> fetchByType(String type){
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select a from Account as a where a.type=:ty");
	    
	    q.setParameter("ty",type);
	    
	    List<Account> account=q.getResultList();
	    
		em.close();
		emf.close();
		return account;
		
	}
	
	//select *from(select * from TBL_Transaction  order by  DATEANDTIME desc) where rownum<6 ;
	public List<Transaction> fetchMiniStatement(int acno){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select t from Transaction t " + " where t.account.acno =:ac " + "  order by t.dateAndTime desc");
	    
	    q.setParameter("ac",acno);
	    q.setMaxResults(5);
	    
	    List<Transaction> transaction  =q.getResultList();
	    
		em.close();
		emf.close();
		
		return transaction;
	}
	public List<Transaction> fetchTransactions(int acno,LocalDate date)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select t from Transaction t " + " where t.account.acno =:ac " + " and t.dateAndTime between :dt1 and :dt2");
	    
	    q.setParameter("ac",acno);
	    q.setParameter("dt1", LocalDateTime.of(date,LocalTime.of( 0,0,0 )));
	    q.setParameter("dt2", LocalDateTime.of(date,LocalTime.of( 23,59,59 )));

	    
	    List<Transaction> transaction  =q.getResultList();
	    
		em.close();
		emf.close();
		
		return transaction;
	
	}
	
	public List<Account> fetchDeposit(double amount)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select distinct a from Account a inner join fetch a.transactions t where t.amount >= :amt");
	    
	
q.setParameter("amt",amount);
			
			
		    List<Account> account  =q.getResultList();
		    
			em.close();
			emf.close();
			
			return account;
			
			
		}
		
	
	}


	   
	    


