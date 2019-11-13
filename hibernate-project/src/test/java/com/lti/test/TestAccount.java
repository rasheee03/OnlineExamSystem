package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.model.Account;
import com.lti.model.Album;
import com.lti.model.Transaction;
import com.lti.service.AccountService;


public class TestAccount {

	@Test
public void openAccount() {
		
		Account account =new Account();
		account.setAcno(111);
		account.setName("mayank");	
		account.setType("current");
		account.setBalance(12321);
				
		AccountService accServ=new AccountService();
			accServ.openAccount(account);	
			
			Account account1 =new Account();
			account1.setAcno(222);
			account1.setName("vishal");	
			account1.setType("savings");
			account1.setBalance(1232146577);
					
			AccountService accServ1=new AccountService();
				accServ1.openAccount(account1);	
				
				Account account2 =new Account();
				account2.setAcno(333);
				account2.setName("Shrutika");	
				account2.setType("savings");
				account2.setBalance(3);
						
				AccountService accServ2=new AccountService();
					accServ2.openAccount(account2);	
					
					Account account3 =new Account();
					account3.setAcno(444);
					account3.setName("cyril");	
					account3.setType("current");
					account3.setBalance(300000);
							
					AccountService accServ3=new AccountService();
						accServ1.openAccount(account3);	
				

	}
	@Test
	public void withdraw() {
		

		
		AccountService obj=new AccountService();
		
		obj.withdraw(111,1200);
		
AccountService obj1=new AccountService();
		
		obj1.withdraw(222,577);
		
AccountService obj2=new AccountService();
		
		obj.withdraw(444,1200);

	
		
	}

@Test
public void deposit() {
	
	AccountService a=new AccountService();
	
	a.deposit(111,12);
	
AccountService a1=new AccountService();
	
	a1.deposit(222,2);
	
AccountService a2=new AccountService();
	
	a2.deposit(444,20000);
	
	
AccountService a3=new AccountService();
	
	a2.deposit(333,20000);
	
	
}

@Test
	public void transfer() {
		
		AccountService t=new AccountService();
		
		t.transfer(444, 333, 1);
		
	}
	@Test
	 public  void checkBalance() {
		
		AccountService ck=new AccountService();
		ck.checkBalance(444);
	
		AccountService ck2=new AccountService();
		ck2.checkBalance(111);
		
		AccountService ck3=new AccountService();
		ck3.checkBalance(222);
		
		AccountService ck4=new AccountService();
		ck4.checkBalance(333);
	
		
	}
	
	@Test
	public void checkAccountType() {
		
		AccountService at=new AccountService();
 
		List<Account> as=at.getAccountByType("current");
		for(Account ab : as)
			
			System.out.println(ab);
	}
	
	@Test
	public void checkLastTransaction() {
		AccountService lt=new AccountService();
		
		List<Transaction> lm=lt.fetchMiniStatement(444);
		for (Transaction fc :lm)
			
			System.out.println(fc);
		
	}
	
	@Test
	public void checkTransactionDate() {
		AccountService td=new AccountService();
		
	
		LocalDate date = LocalDate.of(2019,11,9);
		List<Transaction> yc=td.fetchTransactionDate(444, date);
		for (Transaction rm :yc)
			
			System.out.println(rm);
	}
	
	
	@Test
	public void checkIncomeTax() {
		AccountService dd=new AccountService();
		List<Account> as = dd.fetchIncomeTax(12);	
		for(Account a : as) {
			System.out.println(a.getName());
			for(Transaction tx : a.getTransactions()) {
				
				System.out.println(tx.getDateAndTime());
				System.out.println(tx.getAmount());
				
			}
			
			
			
		}
	}
}

