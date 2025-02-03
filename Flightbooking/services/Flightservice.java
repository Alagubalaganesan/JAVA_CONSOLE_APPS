package Flightbooking.services;
import java.util.*;

import Flightbooking.driverclass.Seatstatus;
import Flightbooking.models.Booking;
import Flightbooking.models.Payment;
import Flightbooking.models.User;
import Flightbooking.models.flight;
public class Flightservice
{
	private List<flight> flights;
	
	public Flightservice()
	{
		this.flights=new ArrayList<>();
	}
	public void addFlights(String airline, String source, String destination, Date departureTime)
	{
	    flights.add(new flight(airline, source, destination, departureTime));
	}
	public flight searchflights(String source ,String destination)
	{
		for (flight flight : flights) {
            if (flight.getSource().equals(source) && flight.getDestination().equals(destination)) {
                return flight;
            }
		}
		return null;
	}
		
	public Booking bookflight(User user,Seatstatus seatclass,flight flight, double price)
	{
		
		if(seatclass==Seatstatus.ECONOMY)
			price=800;
		else if(seatclass==Seatstatus.BUSINESS)
			price=1200;
		else
			price=1500;
		
		if(flight.bookseat(seatclass) && user.deductBalance(price))
		{
			
			Booking booking=new Booking(user,flight,seatclass,price);
			booking.confirmBooking();
			return booking;
		}
		
		return null;		
	}
	public void cancelflight(Booking booking)
	{
		booking.cancelBooking();
		booking.getFlight().cancelseat(booking.getSeatClass());
	}
	
	public Payment processpayment(Booking booking)
	{
		Payment payment=new Payment(booking);
		if(booking.getUser().deductBalance(booking.getPrice()))
		{
			payment.completepayment();
		}
		else
		{
			payment.failedpayment();
		}
		return payment;		
		
	}
	
			
}

  

