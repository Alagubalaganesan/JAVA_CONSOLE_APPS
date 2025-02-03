package Tollmanagement.models;

import Tollmanagement.driver.Vehicletype;

public class Tollrate
{
  private Vehicletype type;
  private double rate;
  
  public Tollrate(Vehicletype type,double rate)
  {
	  this.type=type;
	  this.rate=rate;
  }

public Vehicletype getType() {
	return type;
}

public double getRate() {
	return rate;
}
  
}
