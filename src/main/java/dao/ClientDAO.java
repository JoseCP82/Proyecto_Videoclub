package dao;

import java.util.HashSet;

import interfaces.IClientDAO;
import model.Client;
import storage.ClientStore;

public class ClientDAO implements IClientDAO{

	private final String URL="clients.xml"; 
	private HashSet<Client> clientes;

	/**
	 * Constructor por defecto
	 */
	public ClientDAO() {
		clientes = new HashSet<Client>();
		try {
			clientes = new ClientStore().loadFile(URL);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	/**
	 * Obtiene un set con clientes
	 * 
	 * @return Set con clientes o nul si no hay ninguno
	 */
	public HashSet<Client> getClientes() {
		return clientes;
	}

	/**
	 * Especifica si el Set de clientes está vacío o no. 
	 * 
	 * @return True o false si está vacío o no.
	 */
	public boolean isEmpty() {
		return clientes.isEmpty();
	}
	
	/**
	 * inserta un cliente en en el hashset
	 * 
	 * @param e cliente a insertar
	 * @return true si se ha introducido correctamente y false si no lo ha introducido
	 */
	public boolean addClient(Client c) {
		boolean valid = clientes.add(c);
		new ClientStore().saveFile(URL,clientes);
		return valid;
	}

	/**
	 * busca un cliente por su id
	 * 
	 * @param Id el id del cliente a buscar
	 * @return el cliente correspondiente o null si no lo encuentra
	 */
	public Client searchClient(String id) {
		Client e = null;
		for (Client o : clientes) {
			if (o.getId().equals(id)) {
				e = o;
			}
		}
		return e;
	}

	/**
	 * actualiza los el nombre y el telefono de uno de los clientes
	 * 
	 * @param id es la id del cliente que quieres actualizar los datos
	 * @param name es el nuevo nombre del cliente
	 * @param phone es el nuevo telefono del cliente
	 * @return true si se actualizado los datos correctamente y false si no se ha podido
	 */
	public boolean updateClient(String id, String name, String phone) {
		boolean valid = false;
		Client search = searchClient(id);
		if (search != null) {
			search.setName(name);
			search.setPhone(phone);
			valid = true;
			new ClientStore().saveFile(URL,clientes);
		}
		return valid;
	}

	/**
	 * elimina un cliente
	 * 
	 * @param c es el cliente que se quiere eliminar
	 * @return true si se a eliminado un cliente y false si no lo ha borrado
	 */
	public boolean removeClient(Client c) {
		boolean valid = clientes.remove(c);
		new ClientStore().saveFile(URL,clientes);
		return valid;
	}

	/**
	 * Método que obtiene todos los datos de un cliente y los almacena en un 
	 * string para mostrarlos por pantalla.
	 * 
	 * @return Cadena con los datos almacenados
	 */
	public String toString() {
		String cadena = "";
		for (Client o : clientes) {
			cadena += o.toString()+"\n";
		}
		return cadena;
	}
}
