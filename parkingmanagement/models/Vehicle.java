package parkingmanagement.models;

import parkingmanagement.driverclasses.Vehicletype;

public class Vehicle
{
	 private String licensePlate;
	 private Vehicletype type;
	 
	 public Vehicle(String licensePlate,Vehicletype type)
	 {
		 this.licensePlate=licensePlate;
		 this.type=type;		 
	 }
	 
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public Vehicletype getType() {
		return type;
	}
	public void setType(Vehicletype type) {
		this.type = type;
	}
   
}
