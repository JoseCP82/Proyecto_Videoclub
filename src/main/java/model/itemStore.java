package model;

import java.io.File;
import java.util.HashSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import interfaces.IItem;
import interfaces.IItemStore;

public class ItemStore implements IItemStore {
private HashSet<Item> items;
	
	
	
	

	public ItemStore() {
		 items = new HashSet<Item>();
	}

	
/**
 * Este metodo añade un item a la coleccion
 * @param i el item el que vamos a añadir
 * @return Devuelve true si se a añadido con facilidad o false si no se a añadido
 */
	public boolean addItem(IItem i) {
		// TODO Auto-generated method stub
		boolean valid = items.add((Item) i);
		return valid;
	}

	/**
	 * Sirve para buscar un Item por su clave que en este caso seria la key
	 * @param key La clave del Item por el cual vas a buscar
	 * @return Devuelve el Item buscado o null si no se encuentra
	 */
	public Item searchItem(String name) {
		Item e = null;
		
		for(Item o:items) {
			if(o.getName()==name) {
				e=o;
			}
		}
		return e;
	}
/**
 *  Cambia los parametros de un item
 * @param name El nombre por el que lo quieres cambiar
 * @param description La descripcion que has cambiado
 * @param price El precio que le cambias
 * @return Devuelve true si se a cambiado correctamente
 */
	public boolean updateProduct(String name, String description, float price) {
		// TODO Auto-generated method stub
		boolean valid = false;
		Item search = searchItem(name);
		
		if(search !=null) {
			search.setDescription(description);
			search.setPrice(price);
			valid=true;
		}
		return valid;
		
	}
	/**
	 * Elimina un producto  de la colección
	 * 
	 * @param p El Item que le pasas. 
	 * @return True si a sido eliminado o false si no a sido encontrado y por lo tanto no lo a eliminado.
	 */
	public boolean removeProduct(IItem i) {
		// TODO Auto-generated method stub
		boolean valid = items.remove(i);
		return valid;
	}
/**
 * Guarda los Item en un xml
 * @param url
 */
	
		public void saveItems(String url) {
			// TODO Auto-generated method stub
			JAXBContext contexto;
			try {
				contexto=JAXBContext.newInstance(ItemStore.class);
				Marshaller m = contexto.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
				m.marshal(this, new File(url));
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		
	
/**
 * Carga los Item guardados en el xml
 * @param url
 */
	public void loadItems(String url) {
		// TODO Auto-generated method stub
		JAXBContext contexto;
		try {
			contexto=JAXBContext.newInstance(ItemStore.class);
			Unmarshaller um = contexto.createUnmarshaller();
			ItemStore 	newitem = (ItemStore)um.unmarshal(new File(url));
			items = newitem.items;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	/**
	 * 
	 * @return  Este metodo devuelve si la lista tiene algun producto o no
	 */
	public boolean isEmpty() {
		
		return items.isEmpty();
		
	}


	

	

	


	


	


	
}



