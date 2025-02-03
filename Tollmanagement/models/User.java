package Tollmanagement.models;

public class User
{
  private String userid;
  private String name;
  private double balance;
  
  public User(String id,String name,double balance)
  {
	  this.userid=id;
	  this.name=name;
	  this.balance=balance;
  }
public String getUserid() {
	return userid;
}
public String getName() {
	return name;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
  public boolean deductbalance(double amount)
  {
	  if(balance>=amount)
	  {
		  balance-=amount;
		  return true; 
	  }
		  
	  return false;
  }
  
}
