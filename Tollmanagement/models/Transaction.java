package Tollmanagement.models;

import Tollmanagement.driver.Paymentstatus;

public class Transaction
{
	private String transactionid;
	private Vehicle vehicle;
	private Tollboth tolldetails;
	private double amount;
	private Paymentstatus status;
	
	public Transaction(String transactionid,Vehicle vehicle,Tollboth details,double amount)
	{
		this.transactionid=transactionid;
		this.vehicle=vehicle;
		this.tolldetails=details;
		this.amount=amount;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public Tollboth getTolldetails() {
		return tolldetails;
	}
	public double getAmount() {
		return amount;
	}
	public Paymentstatus getStatus() {
		return status;
	}
	public void setstatus(Paymentstatus status)
	{
		this.status=status;
	}
	
}
