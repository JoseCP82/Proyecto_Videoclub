package interfaces;

public interface IItem {
	// Obtiene el nombre del item
	String getName();

	// Setea el nombre del item
	void setName(String name);

	// Obtiene la descripción del item
	String getDescription();

	// Setea la descripción del item
	void setDescription(String description);

	// Obtiene el precio del item
	float getPrice();

	// Setea el precio del item
	void setPrice(float prize);
	
	// Compara la existencia de un item por el atributo name
	boolean equals(Object o);

	// Obtiene los datos de un item
	String toString();
}
