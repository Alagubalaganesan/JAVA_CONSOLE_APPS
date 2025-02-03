package Flightbooking.models;
import java.util.UUID;

public class User
{
	private String userId;
	private String name;
	private String email;
	private double balance;
	
	public User(String naam,String email,double paisa)
	{
		this.userId= UUID.randomUUID().toString();
		this.name=naam;
		this.email=email;
		this.balance=paisa;
	}
	public String getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
    public boolean deductBalance(double amount) {
    	
        if (balance >= amount) {
        	
            balance -= amount;
            return true;
        }
        return false;
    }
	

}
