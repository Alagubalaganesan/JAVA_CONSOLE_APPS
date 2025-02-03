package Tollmanagement.service;

import java.util.HashMap;

import Tollmanagement.driver.*;

import Tollmanagement.models.*;


public class Tollservices
{
 private HashMap<String,Tollboth> tollbooths;
 private HashMap<Vehicletype,Tollrate> tollrates;
 
 
 public Tollservices()
 {
	 
	 this.tollbooths=new HashMap<>();
	 this.tollrates=new HashMap<>();
	 
	 //adding tollrates
	 tollrates.put(Vehicletype.CAR,new Tollrate(Vehicletype.CAR,50.0)); 
	 tollrates.put(Vehicletype.TRUCK,new Tollrate(Vehicletype.TRUCK,100.0));
	 tollrates.put(Vehicletype.MOTORBIKE,new Tollrate(Vehicletype.MOTORBIKE,30.0));
	 tollrates.put(Vehicletype.BUS,new Tollrate(Vehicletype.BUS,80.0));
	 
	 
 }
 
 //adding tollboths
 public void addTollBooth(String tollBoothId, String location)
 {
     Tollboth tollBooth = new Tollboth(tollBoothId, location);
     tollbooths.put(tollBoothId, tollBooth);
 }
 
 public void processtollpayment(String tollboothid,Vehicle vehicle) 
 {
	 Tollboth tollbooth=tollbooths.get(tollboothid);
	 if(tollbooth==null || tollbooth.getStatus() != Tollboothstatus.ACTIVE)
	 {
		 System.out.println("Invalid or inactive toll booth");
		 return; 
	 }
	 Tollrate tollrate=tollrates.get(vehicle.getType());
	 if(tollrate==null)
	 {
		 System.out.println("No toll rate found for vehicle type " + vehicle.getType());
         return;
	 }	 
	 double amount=tollrate.getRate();
	 
	 User owner=vehicle.getOwner();
	 
	 if(owner.deductbalance(amount))
	 {
		 // System.currentTimeMillis() returns time in milliseconds
		 Transaction transaction=new Transaction("TXN"+ System.currentTimeMillis(),vehicle,tollbooth,amount);
		 transaction.setstatus(Paymentstatus.SUCCESS);
		 System.out.println("Toll processed successfully. Transaction ID:"+transaction.getTransactionid());
		 System.out.println("Paid amount is:"+transaction.getAmount());
	 } 
	 else
	 {
		 System.out.println("Insufficient Balance for Vehicle"+vehicle.getVehicleid());
	 }
		 
		 
 }
 
 
 
 //view Tolldetails
 public void viewtollboothdetails(String tollboothid)
 {
	 Tollboth tollbooth=tollbooths.get(tollboothid);
	 if(tollbooth==null)
	 {
         System.out.println("Toll booth " + tollboothid + " not found.");
         return;
	 }
		 
	 for(Tollboth booth:tollbooths.values())
	 {
		 System.out.println(booth.getId());
		 System.out.println(booth.getLocation());
		 System.out.println(booth.getStatus());		 
	 }
 }
 
  
 

 
 
}
