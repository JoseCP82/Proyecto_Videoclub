package model;

public class Product {
	private String key;
	private String name;
	
	
	/**
	 * Contrustor por defecto
	 */
	public Product() {
		super();
		this.key = "";
		this.name = "Desconocido";	
	}
	/**
	 * Contructor con Full equip
	 * @param key
	 * @param name
	 */
	public Product(String key, String name) {
		super();
		this.key = key;
		this.name = name;
	}
	/**
	 *  Metodo sirve para coger el valor key
	 * @return Devuelve Key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * Setea el key Del Producto
	 * 
	 * @param key dato con la key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 *  Metodo sirve para coger el valor name
	 * @return Devuelve name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Metodo nos sirve para setear el nombre
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Muestra por consola todos los datos del producto
	 */
	@Override
	public String toString() {
		return "Product [key=" + key + ", name=" + name + "]";
	}

	@Override
	/**
	 * Compara un producto con otro por su atributo KEY.
	 * Devuelve true o false en case de que sean iguales o no.
	 */
	public boolean equals(Object obj) {
		boolean result=false;
		if (obj != null) {
			if (this == obj) {
				result = true;
			} else {
				if(obj instanceof Product){
					if (this.key!=null && this.key.equals(((Product)obj).key)) {
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	

}
