package dao;

import java.util.HashSet;
import interfaces.IItemDAO;
import model.Item;
import storage.ItemStore;

public class ItemDAO implements IItemDAO {

	private final String URL="items.xml";
	private HashSet<Item> items;

	/**
	 * Constructor por defecto 
	 */
	public ItemDAO() {
		try {
			items = new ItemStore().loadFile(URL);
		}catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Este metodo añade un item a la colección
	 * 
	 * @param i el item el que vamos a añadir
	 * @return Devuelve true si se a añadido con facilidad o false si no se a
	 *         añadido
	 */
	public boolean addItem(Item i) {
		boolean valid = items.add(i);
		new ItemStore().saveFile(URL, items);
		return valid;
	}

	/**
	 * Sirve para buscar un Item por su clave que en este caso seria la key
	 * 
	 * @param key La clave del Item por el cual vas a buscar
	 * @return Devuelve el Item buscado o null si no se encuentra
	 */
	public Item searchItem(String name) {
		Item e = null;
		for (Item o : items) {
			if (o.getName().equals(name)) {
				e = o;
			}
		}
		return e;
	}

	/**
	 * Cambia los parametros de un item
	 * 
	 * @param name El nombre por el que lo quieres cambiar
	 * @param description La descripcion que has cambiado
	 * @param price El precio que le cambias
	 * @return Devuelve true si se a cambiado correctamente
	 */
	public boolean updateItem(String name, String description, float price) {
		boolean valid = false;
		Item search = searchItem(name);
		if (search != null) {
			search.setDescription(description);
			search.setPrice(price);
			valid = true;
			new ItemStore().saveFile(URL, items);
		}
		return valid;
	}

	/**
	 * Elimina un producto de la colección
	 * 
	 * @param p El Item que le pasas.
	 * @return True si ha sido eliminado o false si no ha sido encontrado y por lo tanto no lo a eliminado.
	 */
	public boolean removeItem(Item i) {
		boolean valid = items.remove(i);
		new ItemStore().saveFile(URL, items);
		return valid;
	}

	/**
	 * 
	 * @return Este metodo devuelve si la lista tiene algun producto o no
	 */
	public boolean isEmpty() {
		return items.isEmpty();
	}

	/**
	 * Método que obtiene todos los datos de un item y los almacena en un 
	 * string para mostrarlos por pantalla.
	 * 
	 * @return Cadena con los datos almacenados
	 */
	public String toString() {
		String cadena = "";
		for (Item o : items) {
			cadena += o.toString()+"\n";
		}
		return cadena;
	}
}
