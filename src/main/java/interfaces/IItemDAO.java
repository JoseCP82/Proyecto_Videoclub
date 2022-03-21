package interfaces;

import model.Item;

public interface IItemDAO {
	
	// Agrega un item nuevo
	boolean addItem(Item i);

	// Busca un item
	Item searchItem(String name);

	// Actualiza los datos de un item
	boolean updateItem(String name, String description, float price);

	// Elimina un item
	boolean removeItem(Item i);

	// Muestra los datos de los items existentes
	String toString();
}
