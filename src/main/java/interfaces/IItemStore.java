package interfaces;

public interface IItemStore {
	
	// Agrega un item nuevo
	boolean addItem(IItem i);

	// Busca un item
	IItem searchItem(String name);

	// Actualiza los datos de un item
	boolean updateProduct(String name, String description, float price);

	// Elimina un item
	boolean removeProduct(IItem i);

	// Muestra los datos de los items existentes
	String toString();

	// Almacena los datos de los items existentes en un archivo XML
	void saveItems(String url);

	// Carga los items desde un archivo XML
	void loadItems(String url);
}
