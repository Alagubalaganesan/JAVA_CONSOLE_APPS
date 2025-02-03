package parkingmanagement.models;

import java.util.HashMap;
import java.util.Map;

import parkingmanagement.driverclasses.Spotstatus;
import parkingmanagement.driverclasses.Spottype;

public class Parkingfloor
{
	private String parkingfloorid;
	private HashMap<String,Parkingspot> spots;
	
	public Parkingfloor(String floorid)
	{
		this.parkingfloorid=floorid;
		this.spots=new HashMap<>();		
	}
	
	public void addspot(Parkingspot spot) //adding spot to spots map
	{
		spots.put(spot.getSpotId(), spot);
	}
	
	
	public Parkingspot findavailablespot(Spottype type)
	{
		for(Parkingspot spot: spots.values())
		{
			if(spot.getType()==type && spot.getStatus()==Spotstatus.AVAILABLE)
			return spot;	
		}	
		return null;		
	}
	
	 public String getFloorId()
	 {
	    return parkingfloorid;
	 }
	 
	 
	    public Map<String, Parkingspot> getSpots()
	    {
	        return spots;
	    }
	

}
