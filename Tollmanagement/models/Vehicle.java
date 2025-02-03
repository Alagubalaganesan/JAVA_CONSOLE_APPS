package Tollmanagement.models;

import Tollmanagement.driver.Vehicletype;

public class Vehicle
{
   private String vehicleid;
   private Vehicletype type;
   private User owner;
   
   public Vehicle(String id,Vehicletype type,User owner)
   {
	   this.vehicleid=id;
	   this.type=type;
	   this.owner=owner;
   }
public String getVehicleid() {
	return vehicleid;
}
public Vehicletype getType() {
	return type;
}
public User getOwner() {
	return owner;
}
   
   

}
