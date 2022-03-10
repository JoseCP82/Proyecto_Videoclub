package model;

public class Product {
	private String key;
	private String name;
	
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
