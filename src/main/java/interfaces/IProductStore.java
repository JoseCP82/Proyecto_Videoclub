package interfaces;

public interface IProductStore {

	// Agrega un producto nuevo
	boolean addProduct(IProduct p);

	// Busca un producto
	IProduct searchProduct(String key);

	// Actualiza los datos de un producto
	boolean updateProduct(String name);

	// Elimina un producto
	boolean removeProduct(IProduct p);

	// Muestra los datos de los productos existentes
	String toString();

	// Almacena los datos de los productos existentes en un archivo XML
	void saveProducts(String url);

	// Carga los productos desde un archivo XML
	void loadProducts(String url);
}
