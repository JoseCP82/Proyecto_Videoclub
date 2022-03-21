package storage;

import java.io.File;
import java.io.Serializable;
import java.util.HashSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import model.Client;

@XmlRootElement(name = "Clientes")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientStore implements Serializable {
			
	private static final long serialVersionUID = 1L;
	private HashSet<Client> clients;
	
	/**
	 * Constructor por defecto
	 */
	public ClientStore() {
		clients = new HashSet<Client>();
	}
	
	/**
	 * Guarda los Clientes en un xml
	 * 
	 * @param url Nombre del archivo xml donde se almacenan los datos
	 */
	public void saveFile(String url, HashSet<Client> clientes) {
		this.clients=clientes;
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(ClientStore.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.marshal(this, new File(url));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Carga los Clientes guardados en el xml
	 * 
	 * @param url Nombre del archivo xml
	 */
	public HashSet<Client> loadFile(String url) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(ClientStore.class);
			Unmarshaller um = context.createUnmarshaller();
			ClientStore newClient = (ClientStore) um.unmarshal(new File(url));
			clients = newClient.clients;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return clients;
	}
}
