package Flightbooking.models;
import java.util.*;

import Flightbooking.driverclass.Flightstatus;
import Flightbooking.driverclass.Seatstatus;

public class flight
{
  private String flightId;
  private String airline;
  private String source;
  private String destination;
  private Date departuretime;
  private Flightstatus status;
  private HashMap<Seatstatus, Integer> availableSeats;
  
  public flight(String airline, String source, String destination,Date departuretime)
  {
	  this.flightId = UUID.randomUUID().toString();
	  this.flightId = UUID.randomUUID().toString();
      this.airline = airline;
      this.source = source;
      this.destination = destination;
      this.departuretime = departuretime;
      this.status = Flightstatus.SCHEDULED;
      this.availableSeats=new HashMap<>();
      availableSeats.put(Seatstatus.ECONOMY, 50);
      availableSeats.put(Seatstatus.FIRST_CLASS, 20);
      availableSeats.put(Seatstatus.BUSINESS, 10);
  }
  public String getFlightId() { return flightId; }
  public String getAirline() { return airline; }
  public String getSource() { return source; }
  public String getDestination() { return destination; }
  public Date getDepartureTime() { return departuretime; }
  public Flightstatus getStatus() { return status; }
  
  // bookseat
  public boolean bookseat(Seatstatus sclass)
  {	  
	  if(availableSeats.get(sclass)>0)
	  {
		  availableSeats.put(sclass, availableSeats.get(sclass)-1);  
		  return true;
	  }	 
	return false;
  }
  
  public void cancelseat(Seatstatus sclass) {
	  availableSeats.put(sclass, availableSeats.get(sclass)+1);
  }
  
  
}
