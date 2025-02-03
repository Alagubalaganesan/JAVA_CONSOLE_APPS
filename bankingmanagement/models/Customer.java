package bankingmanagement.models;

import java.util.ArrayList;
import java.util.List;


public class Customer
{
   private String name;
   private String cusid;
   private List<Account> accounts;
   public Customer(String id,String nam)
   {
	  this.cusid=id;
	  this.name=nam;
	  this.accounts=new ArrayList<>();
   }
   
   public String getCustomerId() {
       return cusid;
   }

   public String getName() {
       return name;
   }
   
   public List<Account> getaccount() 
   {
	   return accounts;
   }
   
   public void addaccount(Account account)
   {
	   accounts.add(account);
   }
   


}
