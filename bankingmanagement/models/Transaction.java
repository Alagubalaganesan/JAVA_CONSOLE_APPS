package bankingmanagement.models;

import bankingmanagement.driverclasses.Transactiontype;

public class Transaction
{
	private String transactionid;
	private Transactiontype ttype;
	private double amount;
	
	public Transaction(String id,Transactiontype type,double amount)
	{
		this.transactionid=id;
		this.ttype=type;
		this.amount=amount;
	}
	// TODO Auto-generated constructor stub
	
	public String gettransactionid()
	{
		return transactionid;
	}
	public double getamount()
	{
		return amount;
	}
}
