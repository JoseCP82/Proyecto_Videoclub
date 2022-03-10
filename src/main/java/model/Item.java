package model;

import interfaces.IItem;

public class Item extends Product implements IItem {
	private String Name;
	private String Description;
	private float price;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Item [Name=" + Name + ", Description=" + Description + ", price=" + price + "]";
	}
	
	
	
	
	
	

}
