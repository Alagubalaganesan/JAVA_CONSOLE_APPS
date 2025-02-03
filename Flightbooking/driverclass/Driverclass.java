package Flightbooking.driverclass;
import java.util.*;
import Flightbooking.models.*;

import Flightbooking.services.Flightservice;

public class Driverclass
{
  public static void main(String args[])
  {
	  User u1=new User("Arun","aruncool@gmail.com",2000.0);
	  User u2=new User("Praveen","praveen02@gmail.com",3000.0);
	  User u3=new User("Bharath","bharathkohli@gmail.com",2500);
	  
	  Flightservice fs=new Flightservice();
	  fs.addFlights("AirIndia", "Chennai", "Delhi", new Date());
	  fs.addFlights("Indigo", "Chennai", "Mumbai", new Date());
	  fs.addFlights("visathara", "Bangalore", "Kolkata", new Date());
	  
	  flight vimanam=fs.searchflights("Chennai", "Mumbai");
	  
	  if(vimanam!=null)
	  {
		  Booking booking=fs.bookflight(u3, Seatstatus.ECONOMY, vimanam, 1);
		  if(booking!=null)
		  {
			  System.out.println("Booking successful! Booking ID: " + booking.getBookingId() +"\n"+"Name of the passenger:"+booking.getUser().getName());
			  Payment payment=fs.processpayment(booking);
			  System.out.println("Payment Status:"+payment.getStatus());
			  
		  }
		  else
		  {
			  System.out.println("Booking failed insuffiecient funds");
		  }
	  }
	  else
	  {
		  System.out.println("No flights found");
	  }
  }
}
