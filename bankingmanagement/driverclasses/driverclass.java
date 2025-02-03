package bankingmanagement.driverclasses;

import bankingmanagement.models.Customer;
import bankingmanagement.service.Bankingservice;


public class driverclass {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Bankingservice bs=new Bankingservice();
		
		//Add customers
		
		bs.addcustomer("b1","John");
		
		//create Accounts
		bs.createaccount("b1",Accounttype.SAVINGS  ,2000.0);
		
		
		//withdraw money
		bs.withdraw("b1",1000.0);
		
		//deposit money
		bs.deposit("b1",1000.0);
		
		
		//view balance
		bs.viewbalance("b1");

	}

}
