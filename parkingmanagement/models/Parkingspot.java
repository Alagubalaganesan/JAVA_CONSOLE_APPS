package parkingmanagement.models;

import parkingmanagement.driverclasses.Spotstatus;
import parkingmanagement.driverclasses.Spottype;

public class Parkingspot
{
	 private String spotId;
	 private Spottype type;
	 private Spotstatus status;
	 private Vehicle parkedVehicle;
	 
	 
	 public Parkingspot(String spotId,Spottype type)
	 {
		 this.spotId=spotId;
		 this.type=type;
		 this.status=Spotstatus.AVAILABLE;		 
	 }
	 
	 public void parkVehicle(Vehicle vehicle)
	 {
	        this.parkedVehicle=vehicle;
	        this.status=Spotstatus.OCCUPIED;
	 }	 

	  public void removeVehicle()
      {
	     this.parkedVehicle=null;
	     this.status=Spotstatus.AVAILABLE;
	  }    
	    
	    public String getSpotId()
		{
			return spotId;
		}

		public Spottype getType() {
			return type;
		}

		public Spotstatus getStatus() {
			return status;
		}

		public Vehicle getParkedVehicle() {
			return parkedVehicle;
		}	
		
}
