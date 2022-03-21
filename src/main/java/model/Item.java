package model;

import interfaces.IItem;

public class Item extends Product implements IItem {
	
	private String name;
	private String description;
	private float price;
	
	/**
	 * Constructor por defecto
	 */
	public Item() {
		super();
		name = "";
		description = "";
		price = 0;
	}
	
	/**
	 * Constructor con parametros
	 * @param name Nombre del item
	 * @param description Descrpcion del item
	 * @param price Precio del item
	 */
	public Item(String name, String description, float price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	/**
	 * Obtiene el nombre del Item
	 * 
	 * @return Name del item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setea el Name Del item
	 * 
	 * @param name dato con el name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Obtiene la descripcion de item
	 * 
	 * @return descripcion de item
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Setea La descripcion Del item
	 * 
	 * @param description dato con la description
	 */
	public void setDescription(String description) {
		this.description = description;
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
		return "Item" + "\n\tTitulo= " + name + "\n\tDescripción= " + description + "\n\tPrecio= " + price;
	}

	/**
	 * Compara si dos clientes son iguales
	 * se pasa un objeto y si este es el mismo Cliente o si es un Cliente y tiene 
	 * el mismo id deveuelve true y si no devuelve false;
	 */
	public boolean equals(Object obj) {
		boolean result=false;
		if (obj != null) {
			if (this == obj) {
				result = true;
			} else {
				if(obj instanceof Item){
					if (this.name!=null && this.name.equals(((Item)obj).name)) {
						result = true;
					}
				}
			}
		}
		return result;
	}
}
