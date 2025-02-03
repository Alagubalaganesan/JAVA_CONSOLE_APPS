package taxibooking.models;

public class driver
{
   String name;
   String id;
   location loc;
   boolean available;
   
   public driver(String id,String nam,location l,boolean avail )
   {
	   this.name=nam;
	   this.id=id;
	   this.loc=l;
	   this.available=avail;
   }
}
