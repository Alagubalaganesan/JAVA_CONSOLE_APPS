package liftsystem.models;

import liftsystem.driverclass.Direction;
import liftsystem.driverclass.Liftstatus;

public class lift
{
  private String liftid;
  public int currentfloor;
  private Direction direction;
  private Liftstatus status;
  private final int capacity;
  
  public lift(String liftid,int capacity)
  {
	  this.liftid=liftid;
	  this.capacity = capacity;
	  this.currentfloor=0;
	  this.direction = Direction.IDLE;
      this.status = Liftstatus.IDLE;  
  }

public int getCurrentfloor() {
	return currentfloor;
}

public void setCurrentfloor(int currentfloor) {
	this.currentfloor = currentfloor;
}

public String getLiftid() {
	return liftid;
}

public void setLiftid(String liftid) {
	this.liftid = liftid;
}

public Liftstatus getStatus() {
	return status;
}

public void setStatus(Liftstatus status) {
	this.status = status;
}

public int getCapacity() {
	return capacity;
}

public Direction getDirection() {
	return direction;
}

public void setDirection(Direction direction) {
	this.direction = direction;
}
  
}
