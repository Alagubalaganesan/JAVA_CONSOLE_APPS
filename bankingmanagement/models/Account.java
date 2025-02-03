package bankingmanagement.models;

import java.util.ArrayList;
import java.util.List;

import bankingmanagement.driverclasses.Accounttype;

public class Account
{
   private String accid;
   private Accounttype acctype;
   private double balance;
   private List<Transaction> transactions;
   public Account(String accid, Accounttype acctype,double balance)
   {
	 this.accid=accid;
	 this.acctype=acctype;
	 this.balance=balance;
	 this.transactions=new ArrayList<>();
   }
   public String getaccountid()
   {
	   return accid;
   }
   public double getbalance()
   {
	   return balance;	   
   }
   public Accounttype getacctype()
   {
	   return acctype;
   }
   public void setbalance(double balance)
   {
	   this.balance=balance;
   }
   public List<Transaction> gettransactions()
   {
	   return transactions;
   }
   public void addtransaction(Transaction currtransaction)
   {
	   transactions.add(currtransaction);
   }
}
