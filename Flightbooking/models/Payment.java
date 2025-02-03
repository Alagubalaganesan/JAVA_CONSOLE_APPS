package Flightbooking.models;

import java.util.UUID;

import Flightbooking.driverclass.Paymentstatus;

public class Payment
{
	private String paymentId;
	private Booking booking;
	private Paymentstatus status;
	
	 public String getPaymentId() { return paymentId; }
	    public Booking getBooking() { return booking; }
	    public Paymentstatus getStatus() { return status; }
	
	public Payment(Booking booking)
	{
		this.paymentId=UUID.randomUUID().toString();
		this.booking=booking;
		this.status=Paymentstatus.PENDING;	
		
	}
	public void completepayment()
	{
		this.status=Paymentstatus.SUCCESS;
	}
	public void failedpayment() {
		this.status=Paymentstatus.FAILED;
	}	

}
