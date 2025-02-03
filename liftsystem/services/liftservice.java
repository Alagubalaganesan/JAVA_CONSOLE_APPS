package liftsystem.services;

import java.util.ArrayList;
import java.util.List;
import liftsystem.driverclass.Direction;
import liftsystem.driverclass.Liftstatus;
import liftsystem.models.lift;

public class liftservice
{
  private List<lift> liftlist;
  
  public liftservice()
  {
	  this.liftlist=new ArrayList<>();	  
  }
  
  //add lift
  public void addlift(String liftid,int capacity)
  {
	  liftlist.add(new lift(liftid,capacity));
	  System.out.println("Lift " + liftid + " added successfully.");
  }
  
  //request a lift
  public void requestlift(int currentfloor,int requestedfloor)
  {
	  lift selectedlift=null;
	  int mindistance=Integer.MAX_VALUE;
	  int distance=0;
	  
	  for(lift lift: liftlist)
	  {
		  if((lift.getStatus()==Liftstatus.IDLE || lift.getStatus()==Liftstatus.STOPPED)&& lift.getDirection()==Direction.IDLE)
		  {
			  distance=Math.abs(lift.getCurrentfloor()-currentfloor);
			  
			  if(mindistance > distance)  //if distance less than mindistance
			  {
				  mindistance=distance;
				  selectedlift=lift;
			  }
		  }
	  }
	  System.out.println("lift is in :"+selectedlift.currentfloor);
	  System.out.println(selectedlift.getLiftid()+"lift is locked");
	  
	  
	  if(selectedlift!=null)
	  {
		  System.out.println("Lift " + selectedlift.getLiftid() + " arrived to your current floor:" + currentfloor);
		  
		  System.out.println("Lift " + selectedlift.getLiftid() + " is moving to floor to requested floor:" + requestedfloor);
          movelift(selectedlift,requestedfloor);
	  }
	  else
	  {
		 System.out.println("No available lifts for the request.");
	  }
  }

  //movelift helper function
  private void movelift(lift lift, int requestedfloor)
  {
	if(lift.getCurrentfloor()<requestedfloor)
	{
		lift.setDirection(Direction.UP);
	}
	else if(lift.getCurrentfloor()>requestedfloor)
	{
		lift.setDirection(Direction.DOWN);
	}
	else
	{
		lift.setDirection(Direction.IDLE);
		lift.setStatus(Liftstatus.STOPPED);
		System.out.println("Lift " + lift.getLiftid() + " is already on the requested floor.");
		System.out.println();
		 return;
	}
	
	lift.setStatus(Liftstatus.MOVING);     //moving towards requestedfloor
	lift.setCurrentfloor(requestedfloor); //reached the requestedfloor
	
	lift.setStatus(Liftstatus.STOPPED);  //changing status and direction
	lift.setStatus(Liftstatus.IDLE);
	lift.setDirection(Direction.IDLE);  
	
	
	
    System.out.println("Lift " + lift.getLiftid() + " has reached floor " + requestedfloor);	
    System.out.println();
	
}

  //viewing status of the lift
  public void viewstatus()
  {
	for(lift lift:liftlist)
	{
		 System.out.println("Lift ID: " + lift.getLiftid() +
                 ", Current Floor: " + lift.getCurrentfloor() +
                 ", Direction: " + lift.getDirection() +
                 ", Status: " + lift.getStatus());
	}
  }
}
