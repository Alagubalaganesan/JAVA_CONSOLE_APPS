package invoicemanagement.service;

import java.util.HashMap;

import invoicemanagement.driver.invoicestatus;
import invoicemanagement.models.*;
import invoicemanagement.models.Invoice;

public class invoiceservice
{
   private HashMap<String ,Invoice> invoicelist;
   public invoiceservice()
   {
	   this.invoicelist=new HashMap<>();
   }
   
   //create new invoice
   public void createinvoice(String invoiceid,Customer customer)
   {
	   Invoice invoice=new Invoice(invoiceid,customer);
	   invoicelist.put(invoiceid,invoice);
	   System.out.println("Invoice " + invoiceid + " created for customer " + customer.getName());
   }
   
   public void additemtoinvoice(String invoiceid,Item item)
   {
	   Invoice invoice=invoicelist.get(invoiceid);
	   if(invoice==null)
	   {
		   System.out.println("Invoice " + invoiceid + " does not exist.");
           return;
	   }
	   invoice.addItem(item);
	  
	   System.out.println("Item " + item.getName() + " added to invoice " + invoiceid);
   }
   
   
   //view invoice details
   public void viewinvoicedetails(String invoiceid) {
	   Invoice invoice = invoicelist.get(invoiceid);
       if (invoice == null) {
           System.out.println("Invoice " + invoiceid + " does not exist.");
           return;
       } 

       System.out.println("Invoice ID: " + invoice.getInvoiceId());
       System.out.println("Customer: " + invoice.getCustomer().getName() + " (" + invoice.getCustomer().getEmail() + ")");
       System.out.println("Items:");
       for (Item item : invoice.getItems()) {
           System.out.println(" - " + item.getName() + " (x" + item.getQuantity() + "): $" + item.gettotalprice());
       }
       System.out.println("Subtotal: $" + invoice.calculateSubtotal());
       System.out.println("Tax: $" + invoice.calculateTax());
       System.out.println("Discount: $" + invoice.discount);
       System.out.println("Total: $" + invoice.calculateTotal());
       System.out.println("Status: " + invoice.getStatus());
   }
   
   //Update invoice status
   public void updateinvoicestatus(String invoiceid)
   {
	   Invoice invoice = invoicelist.get(invoiceid);
       if (invoice == null) {
           System.out.println("Invoice " + invoiceid + " does not exist.");
           return;
       }
       invoice.setStatus(invoicestatus.PAID);
       System.out.println("Invoice " + invoiceid + " status updated to " + invoicestatus.PAID);
       
   }
   
   public void viewallinvoice()
   {
	   for(Invoice invoice :invoicelist.values())
	   {
		   System.out.println("Invoice ID: " + invoice.getInvoiceId() + ", Customer: " + invoice.getCustomer().getName() + ", Total: $" + invoice.calculateTotal() + ", Status: " + invoice.getStatus());
	   }
   }
   
}
