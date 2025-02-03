package Tollmanagement.driver;

import Tollmanagement.models.User;
import Tollmanagement.models.Vehicle;
import Tollmanagement.service.Tollservices;

public class driverclass {

	public static void main(String[] args)
	{
		
		Tollservices ts=new Tollservices();
		//Add user
		User user1=new User("U1","shiva",200.0);
		User user2=new User("U1","vinayak",150.0);
		
		Vehicle v1=new Vehicle("KA1",Vehicletype.MOTORBIKE,user1);
		Vehicle v2=new Vehicle("KA2",Vehicletype.CAR,user2);
		
		ts.addTollBooth("TB1", "Bangalore highway");;
		ts.addTollBooth("TB2", "Mysore highway");
		
		ts.processtollpayment("TB1", v1);
		ts.processtollpayment("TB2", v2); 
		
		 // View toll booth details
        ts.viewtollboothdetails("TB1");
		

	}

}
