package Tollmanagement.models;

import Tollmanagement.driver.Tollboothstatus;

public class Tollboth
{
   private String id;
   private String location;
   private Tollboothstatus status;
   
   
   public Tollboth(String id,String loc)
   {
	   this.id=id;
	   this.location=loc;
	   this.status=Tollboothstatus.ACTIVE;	 
   }
public String getId() {
	return id;
}
public String getLocation() {
	return location;
}
public Tollboothstatus getStatus() {
	return status;
}

public Tollboothstatus setStatus() {
	return status;
}
   
   
}
