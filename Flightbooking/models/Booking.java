package Flightbooking.models;

import Flightbooking.driverclass.Bookingstatus;
import Flightbooking.driverclass.Seatstatus;
import java.util.*;

public class Booking
{
   private String bookingId;
   private User user;
   private flight flight;
   private Seatstatus seatclass;
   private Bookingstatus bookingstatus;
   private double price;
   
   public Booking(User user ,flight vimanam,Seatstatus seatclass,double price) {
          this.bookingId=UUID.randomUUID().toString();
          this.bookingId = UUID.randomUUID().toString();
          this.user = user;
          this.flight = vimanam;
          this.seatclass = seatclass;
          this.bookingstatus = Bookingstatus.PENDING;
          this.price = price;  
          
   }
   public String getBookingId() { return bookingId; }
   public User getUser() { return user; }
   public flight getFlight() { return flight; }
   public Seatstatus getSeatClass() { return seatclass; }
   public Bookingstatus getStatus() { return bookingstatus; }
   public double getPrice() { return price; }
   
   public void confirmBooking() { this.bookingstatus = Bookingstatus.CONFIRMED; }
   public void cancelBooking() {this.bookingstatus=Bookingstatus.CANCELLED;}
   
}
