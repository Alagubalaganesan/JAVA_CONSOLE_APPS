package invoicemanagement.models;

import java.util.ArrayList;
import java.util.List;

import invoicemanagement.driver.invoicestatus;

public class Invoice
{
	 private String invoiceId;
	    private Customer customer;
	    private List<Item> items;
	    private double taxRate;
	    public double discount;
	    private invoicestatus status;
	    
	   
	    	 public Invoice(String invoiceId, Customer customer)
	    	 {
	    	        this.invoiceId = invoiceId;
	    	        this.customer = customer;
	    	        this.items = new ArrayList<>();
	    	        this.taxRate = 0.1; // Default tax rate (10%)
	    	        this.discount = 0.0;
	    	        this.status = invoicestatus.PENDING;
	    	 }
			


			public String getInvoiceId() {
				return invoiceId;
			}
			
			 public Customer getCustomer() {
			        return customer;
			    }
			 
			 public List<Item> getItems() {
			        return items;
			    }
			 
			 public void addItem(Item item) {
			        items.add(item);
			    }

			    public double calculateSubtotal() {
			        return items.stream().mapToDouble(Item::gettotalprice).sum();
			    }

			    public double calculateTax() {
			        return calculateSubtotal() * taxRate;
			    }

			    public double calculateTotal() {
			        return calculateSubtotal() + calculateTax() - discount;
			    }

			    public void applyDiscount(double discount) {
			        this.discount = discount;
			    }

			    public void setStatus(invoicestatus status) {
			        this.status = status;
			    }

			    public invoicestatus getStatus() {
			        return status;
			    }	

}
