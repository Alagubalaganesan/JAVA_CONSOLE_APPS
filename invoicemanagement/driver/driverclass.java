package invoicemanagement.driver;

import invoicemanagement.models.Customer;
import invoicemanagement.models.Item;
import invoicemanagement.service.invoiceservice;

public class driverclass
{
   public static void main(String[] args)
   {
	   invoiceservice is=new invoiceservice();
	   
	   //create customer and invoice
	   
	   Customer customer=new Customer("C1","john","john.doe@gmail.com");	   
	   is.createinvoice("inv1", customer);
	   
	   //add items
	   Item item1=new Item("I1", "Laptop", 60000.0, 1, Itemtype.PRODUCT);
	   Item item2=new Item("I2", "Headphones", 800.0, 2, Itemtype.PRODUCT);
	   
	   System.out.println();
	   
	   is.additemtoinvoice("inv1", item1);
	   is.additemtoinvoice("inv1", item2);
	   
	   System.out.println();
	   

       // View invoice
       is.viewinvoicedetails("inv1");
       
       System.out.println();
       
       //upate payment status
       is.updateinvoicestatus("inv1");
       
       System.out.println();
	   
       
       //view all invoice
       is.viewallinvoice();  
	   
   }
}
