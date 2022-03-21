package dao;

import java.util.HashSet;

import interfaces.IProductDAO;
import model.Product;
import storage.ProductStore;

public class ProductDAO implements IProductDAO {

	private final String URL="products.xml";
	private HashSet<Product> productos;

	/**
	 * Constructor por defecto
	 */
	public ProductDAO() {
		productos = new HashSet<Product>();
		try {
			productos = new ProductStore().loadFile(URL);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	/**
	 * Añade un producto a la coleccion
	 * 
	 * @param p El producto que le pasas
	 * @return True si a sido añadido o false si no a sido añadido.
	 */
	public boolean addProduct(Product p) {
		boolean valid = productos.add(p);
		new ProductStore().saveFile(URL, productos);
		return valid;
	}

	/**
	 * Elimina un producto de la coleccion
	 * 
	 * @param p El producto que le pasas.
	 * @return True si a sido eliminado o false si no a sido encontrado y por lo
	 *         tanto no lo a eliminado.
	 */
	public boolean removeProduct(Product p) {
		boolean valid = productos.remove(p);
		new ProductStore().saveFile(URL, productos);
		return valid;
	}

	/**
	 * Cambia los parametros a un Producto
	 * 
	 * @param key  La key por el cual buscas el producto
	 * @param name El nombre que le vas a cambiar
	 * @return Devuelve True si lo a cambiado correctamente
	 */
	public boolean updateProduct(String key, String name) {
		boolean valid = false;
		Product search = searchProduct(key);
		if (search != null) {
			search.setName(name);
			valid = true;
			new ProductStore().saveFile(URL, productos);
		}
		return valid;
	}

	/**
	 * Sirve para buscar un producto por su clave que en este caso seria la key
	 * 
	 * @param key La clave del producto por el cual vas a buscar
	 * @return Devuelve el Producto buscado o null si no se encuentra
	 */
	public Product searchProduct(String key) {
		Product e = null;
		for (Product o : productos) {
			if (o.getKey().equals(key)) {
				e = o;
			}
		}
		return e;
	}

	/**
	 * Metodo que sirve para mostrar la coleccion por pantalla
	 */
	public String toString() {
		String cadena = "";
		for (Product o : productos) {
			cadena += o.toString()+"\n";
		}
		return cadena;
	}

	/**
	 * 
	 * @return Este metodo devuelve si la lista tiene algun producto o no
	 */
	public boolean isEmpty() {
		return productos.isEmpty();
	}

}
