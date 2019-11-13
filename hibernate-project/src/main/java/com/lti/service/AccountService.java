package com.lti.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.lti.dao.AccountDao;
import com.lti.dao.GenericDao;
import com.lti.model.Account;
import com.lti.model.Transaction;

public class AccountService {

	public void openAccount(Account acc) {
		 GenericDao dao=new GenericDao();
		 dao.save(acc);
		
	}
	public void withdraw(int acno,double amount) {

	 GenericDao dao=new GenericDao();
		Account acc=(Account)dao.fetchById(Account.class,acno);			
		acc.setBalance(acc.getBalance()-amount);
		
		Transaction tr = new Transaction();
		tr.setType("withdraw");
		tr.setDateAndTime(LocalDateTime.now());
		tr.setAmount(amount);
		tr.setAccount(acc);	 
		
		dao.save(acc);
       dao.save(tr);		 
		
	}
	public void deposit(int acno,double amount) {
		

		 GenericDao dao=new GenericDao();
			Account acc=(Account)dao.fetchById(Account.class,acno);			
			acc.setBalance(acc.getBalance()+amount);
			
			Transaction tr = new Transaction();
			tr.setType("deposit");
			tr.setDateAndTime(LocalDateTime.now());
			tr.setAmount(amount);
			tr.setAccount(acc);	 
			
			dao.save(acc);
	       dao.save(tr);	
		
	}
	
	public void transfer(int fromAcno,int toAcno,double amount) {
		
		 GenericDao dao=new GenericDao();
			Account acc=(Account)dao.fetchById(Account.class,fromAcno);	
			acc.setBalance(acc.getBalance()-amount);
			
		Transaction tr = new Transaction();
		tr.setType("transfer");
		tr.setDateAndTime(LocalDateTime.now());
		tr.setAmount(amount);
		tr.setAccount(acc);	 
		
		dao.save(acc);
       dao.save(tr);
       

		Account acc1=(Account)dao.fetchById(Account.class,toAcno);	
		acc1.setBalance(acc1.getBalance()+amount);
		
	Transaction tr1 = new Transaction();
	tr1.setType("transfer");
	tr1.setDateAndTime(LocalDateTime.now());
	tr1.setAmount(amount);
	tr1.setAccount(acc);	 
	
	dao.save(acc1);
  dao.save(tr1);
	
	}
	
	public void checkBalance(int acno) {
		 GenericDao dao=new GenericDao();
		 Account acc=(Account)dao.fetchById(Account.class,acno);
		
	
			System.out.println("The balance in "+acc.getName() +" is "+ acc.getBalance());
		
	}
	public List<Account>getAccountByType(String type){
		
		AccountDao dao1 =new AccountDao();
		
		// Account acc=(Account)dao1.fetchById(Account.class,type);
		// System.out.println("The account type is "+acc.getType() );
  return dao1.fetchByType(type);
		}
	
	
	public List<Transaction> fetchMiniStatement(int acno){
		
		AccountDao dao2 =new AccountDao();
		
		return dao2.fetchMiniStatement(acno);
		
	}
	
	public List<Transaction> fetchTransactionDate(int acno, LocalDate date){
		
		AccountDao dao3 =new AccountDao();
		
		return dao3.fetchTransactions(acno,date);
	}
	
public List<Account> fetchIncomeTax(double amount){
		
		AccountDao dao4 =new AccountDao();
		
		return dao4.fetchDeposit(amount);
	}
}
