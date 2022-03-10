package interfaces;

public interface IClientStore {
	// Obtiene una instancia de clientStore (Patrón Singleton)
	IClientStore getInstance();

	// Agrega un cliente nuevo
	boolean addClient(IClient c);

	// Busca un cliente
	IClient searchClient(String id);

	// Actualiza los datos de un cliente
	boolean updateClient(String id, String name, String phone);

	// Elimina un cliente
	boolean removeClient(IClient c);

	// Muestra los datos de los clientes existentes
	String toString();

	// Almacena los datos de los clientes existentes en un archivo XML
	void saveClients(String url);

	// Carga los clientes desde un archivo XML
	void loadClients(String url);
}
