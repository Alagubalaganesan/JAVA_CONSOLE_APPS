package bankingmanagement.service;

import java.util.HashMap;
import java.util.Map;

import bankingmanagement.driverclasses.Accounttype;
import bankingmanagement.driverclasses.Transactiontype;
import bankingmanagement.models.*;

import java.util.UUID;
public class Bankingservice
{
   private Map<String,Customer> customerlist;
   private Map<String,String> cusid_and_accid_mapping;
   public Bankingservice() 
   {
	   this.customerlist=new HashMap<>();
	   this.cusid_and_accid_mapping=new HashMap<>();
	   
   }
   
   
   //add customer
   public void addcustomer(String customerid,String name)
   {
	   if(customerlist.containsKey(customerid))
	   {
		   System.out.print("customer id already exists");
		   return ;
	   }
	  
	   customerlist.put(customerid, new Customer(customerid, name));
	   System.out.println("customer added successfully");
   }



   
   //create account
    public void createaccount(String customerid,Accounttype at,double initialdeposit)
    {
    	//getting value from customerlist map
    	Customer customer =customerlist.get(customerid);  
    	
    	if(customer==null)
    	{
    		 System.out.println("Customer with ID " + customerid + " not found.");
             return;
    	}
    	String accid=UUID.randomUUID().toString();
    	Account account=new Account(accid, at ,initialdeposit);
    	
    	cusid_and_accid_mapping.put(customerid, accid);
    	customer.addaccount(account);
    	
    	
        System.out.println("Account created successfully for " + customer.getName() + " with Account ID: " + accid);
    	System.out.println("Your accid is:"+accid);
    }
	
	
   
   
   //withdrawmoney
    
    public void withdraw(String customerid, double amount)
    {
    	String accountid=cusid_and_accid_mapping.get(customerid);
    	Account account=findaccount(customerid,accountid);
    	
    	if(account==null)
    	{
    		 System.out.println("Account not found.");
             return;
    	}
    	 if (account.getbalance() < amount) {
             System.out.println("Insufficient balance.");
             return;
         }
    	account.setbalance(account.getbalance() - amount);
		
    	account.addtransaction(new Transaction(UUID.randomUUID().toString(),Transactiontype.WITHDRAW,amount));
        System.out.println("Withdrew " + amount + " from Account ID: " + accountid);

    }
    
   
   //depositmoney
    public void deposit(String customerid, double amount)
    {
    	String accountid=cusid_and_accid_mapping.get(customerid);
    	Account account=findaccount(customerid,accountid);
    	
    	if(account==null)
    	{
    		 System.out.println("Account not found.");
             return;
    	}
    	 
    	account.setbalance(account.getbalance() + amount);
		
    	account.addtransaction(new Transaction(UUID.randomUUID().toString(),Transactiontype.DEPOSIT,amount));
        System.out.println("DEPOSIT " + amount + " from Account ID: " + accountid);

    }
    
   
   //view balance
    public void viewbalance(String customerid )
    {
    	String accountid=cusid_and_accid_mapping.get(customerid);

    	Account account=findaccount(customerid,accountid);
    	if(account==null)
    	{
    		System.out.print("No accounts found");
    		return;
    	}
    	
    	 System.out.println("Balance for Account ID " + accountid + ": " + account.getbalance());
		 	
    	
    }
    
    //findaccount helper function
    public Account findaccount(String customerid,String accountid)
    {
    	Customer customer=customerlist.get(customerid);
    	if(customer==null)
    	{
    		System.out.println("no customers found");
    		return null;
    	}
    	return customer.getaccount()
    			.stream()
    			.filter(account->account.getaccountid().equals(accountid))
    			.findFirst()
    			.orElse(null);
    }
}
