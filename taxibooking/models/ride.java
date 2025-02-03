package taxibooking.models;

import taxibooking.driver.Ridestatus;

public class ride
{
  int rideid;
  rider riderdetails;
  driver driverdetails;
  Ridestatus status;
  
  public ride(int id,rider rdetails,driver ddetails,Ridestatus status)
  {
	  this.rideid=id;
	  this.riderdetails=rdetails;
	  this.driverdetails=ddetails;
	  this.status=status;
  }
}
