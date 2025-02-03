package parkingmanagement.service;

import java.util.HashMap;

import parkingmanagement.driverclasses.Spotstatus;
import parkingmanagement.driverclasses.Spottype;
import parkingmanagement.driverclasses.Vehicletype;
import parkingmanagement.models.Parkingfloor;
import parkingmanagement.models.Parkingspot;
import parkingmanagement.models.Vehicle;

public class parkingservice
{
	private HashMap<String ,Parkingfloor> floorsmap;
	
	public parkingservice()
	{
		this.floorsmap=new HashMap<>();
	}
	
	//adding floor to the map
	public void addfloor(String floorid)
	{
		Parkingfloor floor=new Parkingfloor(floorid);
		floorsmap.put(floorid,floor);
		System.out.println("Parking floor " + floorid + " added.");
	}
	
	//add a spot to floor
	public void addParkingSpot(String floorId, String spotId, Spottype type)
	{
	     Parkingfloor floor = floorsmap.get(floorId);
         if (floor == null)
         {
          System.out.println("Floor " + floorId + " does not exist.");
           return;
         }
         floor.addspot(new Parkingspot(spotId,type));
         System.out.println("Spot " + spotId + " added to floor " + floorId + ".");
         
	}
	
	
	//parking vehicle and marking variables
	public void parkvehicle(String floorId,Vehicle vehicle)
	{		
		Parkingfloor floor = floorsmap.get(floorId);
        if (floor == null)
        {
            System.out.println("Floor " + floorId + " does not exist.");
            return;
        }
        
        Spottype requiredtype=getspottypeforvehicle(vehicle.getType());
        Parkingspot spot=floor.findavailablespot(requiredtype);
        
        if (spot != null)
        {
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle " + vehicle.getLicensePlate() + " parked in spot " + spot.getSpotId() + " on floor " + floorId + ".");
        } 
        else
        {
            System.out.println("No available spots for " + vehicle.getType() + " on floor " + floorId + ".");
        }
	}
	
	
	//retreiving vehicles from parking spot (emptying)
    public void retrievevehicle(String floorId,String spotId)
    {
    	 Parkingfloor floor = floorsmap.get(floorId);
         if (floor == null)
         {
             System.out.println("Floor " + floorId + " does not exist.");
             return;
         }
         
         Parkingspot spot = floor.getSpots().get(spotId);
         
         if(spot!=null && spot.getStatus()==Spotstatus.OCCUPIED)
         {
        	 Vehicle vehicle=spot.getParkedVehicle();
        	 spot.removeVehicle();  //emptying the spot
        	 System.out.println("Vehicle " + vehicle.getLicensePlate() + " retrieved from spot " + spotId + " on floor " + floorId + ".");
         }
         else
         {
        	 System.out.println("Spot " + spotId + " is not occupied.");
         }
    }
	
	
	private Spottype getspottypeforvehicle(Vehicletype type)
	{
		switch(type)
		{
		case CAR:
			return Spottype.REGULAR;
		case BIKE:
			return Spottype.COMPACT;
		case VAN:
			return Spottype.HEAVYVEHICLES;
			
		default:
			throw new IllegalArgumentException("Invalid vehicle type");
		}
	}

	
	//view all spots
	public void viewstatus()
	{
		for(Parkingfloor floor :floorsmap.values())
		{
			 System.out.println("Floor " + floor.getFloorId() + ":");
			 for(Parkingspot spot   :floor.getSpots().values())
			 {
				 System.out.println("Spot " + spot.getSpotId() + ": " + spot.getStatus());
			 }
		}
		
	}
	

}
