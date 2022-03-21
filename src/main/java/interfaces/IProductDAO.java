package interfaces;

import model.Product;

public interface IProductDAO {

	// Agrega un producto nuevo
	boolean addProduct(Product p);

	// Busca un producto
	Product searchProduct(String key);

	// Actualiza los datos de un producto
	boolean updateProduct(String key, String name);

	// Elimina un producto
	boolean removeProduct(Product p);

	// Muestra los datos de los productos existentes
	String toString();
}
