package model;

import interfaces.IItem;

public class Item extends Product implements IItem {
	private String Name;
	private String Description;
	private float price;
	
	
	
	public Item() {
		super();
		Name = "";
		Description = "";
		price = -1;
	}
	public Item(String name, String description, float price) {
		super();
		Name = name;
		Description = description;
		this.price = price;
	}
	/**
	 * Obtine el nombre del Item
	 * 
	 * @return Name del item
	 */
	public String getName() {
		return Name;
	}
	/**
	 * Setea el Name Del item
	 * 
	 * @param name dato con el name
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * Obtiene la descripcion de item
	 * 
	 * @return descripcion de item
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * Setea La descripcion Del item
	 * 
	 * @param description dato con la description
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * Obtiene el precio del item
	 * 
	 * @return precio del item
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * Setea elPrice Del item
	 * 
	 * @param price con el dato price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * Muestra por consola todos los datos del Item
	 */
	@Override
	public String toString() {
		return "Item [Name=" + Name + ", Description=" + Description + ", price=" + price + "]";
	}
	
	
	
	
	
	

}
