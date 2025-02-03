package liftsystem.driverclass;

import liftsystem.services.liftservice;

public class driverclass {

	public static void main(String[] args)
	{
		
		//create obj for service class
		liftservice ls=new liftservice();
		
		//add lift
		ls.addlift("L1",8);
		ls.addlift("L2",6);
		
		//requestinglift
		ls.requestlift(0,3);
		ls.requestlift(3,5);
		
		
		//view liftstatus
		ls.viewstatus();

	}

}
