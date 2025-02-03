package parkingmanagement.driverclasses;

import parkingmanagement.models.Vehicle;
import parkingmanagement.service.parkingservice;

public class driverclass
{
	public static void main(String[] args)
	{
	     //add parking floor
		parkingservice ps=new parkingservice();
		
		ps.addfloor("F1");
		ps.addfloor("F2");
		
		//add parking spot
		ps.addParkingSpot("F1","S1", Spottype.REGULAR);
		ps.addParkingSpot("F1", "S2", Spottype.COMPACT);
		ps.addParkingSpot("F1", "S3", Spottype.HEAVYVEHICLES);
		ps.addParkingSpot("F2", "S1", Spottype.REGULAR);
		
		
		//park vehicles
		ps.parkvehicle("F1", new Vehicle("car123",Vehicletype.CAR));
		ps.parkvehicle("F1", new Vehicle("bike456",Vehicletype.BIKE));
		ps.parkvehicle("F1",new Vehicle("van789",Vehicletype.VAN));
		ps.parkvehicle("F2", new Vehicle("car345",Vehicletype.CAR));
		
		
		//retreive vehicle
		ps.retrievevehicle("F1", "S1");
		
		//view status on parked vehicles and empty spots
	    ps.viewstatus();
		
		

	}
}
