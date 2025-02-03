 package taxibooking.driver;
import taxibooking.models.*;

import taxibooking.services.*;

public class driverclass
{
	/*public static void main(String[] args)
	{
		//initialize booking service
		
		//add drivers
		
		//add riders
		
		//book ride
		
		// completing the ride

	}*/
	public static void main(String[] args)
	{
	   Bookingservice bs=new Bookingservice();
	   
	   bs.adddriver(new driver("D1", "Alice", new location(10.0, 20.0), true));
	   bs.adddriver(new driver("D2", "Bob", new location(11.0, 21.0), true));
	   
	   rider rider = new rider("R1", "John", new location(10.5, 20.5));
	   
	}

}
