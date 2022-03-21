package interfaces;

import model.Client;

public interface IClientDAO {
	
	// Agrega un cliente nuevo
	boolean addClient(Client c);

	// Busca un cliente
	Client searchClient(String id);

	// Actualiza los datos de un cliente
	boolean updateClient(String id, String name, String phone);

	// Elimina un cliente
	boolean removeClient(Client c);

	// Muestra los datos de los clientes existentes
	String toString();
}
