package invoicemanagement.models;

import invoicemanagement.driver.Itemtype;

public class Item
{
	 private String itemId;
	    private String name;
	    private double price;
	    private int quantity;
	    private Itemtype type;

	    public Item(String itemId, String name, double price, int quantity, Itemtype type) {
	        this.itemId = itemId;
	        this.name = name;
	        this.price = price;
	        this.quantity = quantity;
	        this.type = type;
	    }

		public String getItemId() {
			return itemId;
		}

		public String getName() {
			return name;
		}

		public double getPrice() {
			return price;
		}

		public int getQuantity() {
			return quantity;
		}

		public Itemtype getType() {
			return type;
		}
		public double gettotalprice()
		{
			return price*quantity;
		}
}
