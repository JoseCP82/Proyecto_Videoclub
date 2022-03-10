package model;

import java.util.HashSet;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="identificador")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientStore implements Serializable  {

	private static final long serialVersionUID = 1L;
	private HashSet<Client> clientes;
	
	public ClientStore() {
		clientes = new HashSet<Client>();
	}
	
	/**
	 *  inserta un cliente en en el hashset
	 * @param e  cliente a insertar
	 * @return true si se ha introducido correctamente y
	 *  fale si no lo ha introducido
	 */
	public boolean addClient (Client e) {
		boolean valid=clientes.add(e);
		return valid;
	}
	
	/**
	 * busca un cliente por su id
	 * @param Id el id del cliente a buscar
	 * @return el cliente correspondiente o null si no lo encuentra
	 */
	public Client searchClient(String Id) {
		Client e =null;
		for(Client o: clientes) {
			if(o.getId()==Id) {
				e=o;
			}
		}
		return e;
	}
	
	/**
	 * actualiza los el nombre y el telefono de uno de los clientes
	 * @param id es la id del cliente que quieres actualizar los datos
	 * @param name es el nuevo nombre del cliente
	 * @param phone es el nuevo telefono del cliente
	 * @return true si se actualizado los datos correctamente y false si no se ha podido
	 */
	public boolean updateClient (String id, String name, String phone) {
		boolean valid=false; 
		Client search=searchClient(id);
		if(search != null) {
			search.setName(name);
			search.setPhone(phone);
			valid=true;
		}
		return valid;
	}
	
	/**
	 * elimina un cliente 
	 * @param c es el cliente que se quiere eliminar 
	 * @return true si se a eliminado un cliente y false si no lo ha borrado
	 */
	public boolean removeClient (Client c) {
		boolean valid=clientes.remove(c);
		return valid;
	}
	
	public String toString() {
		String cadena="";
		for(Client o: clientes) {
			cadena += o.toString();
		}
		return cadena;
	}
	
	public void saveFile(String url) {
		JAXBContext contexto;
		try {
			contexto=JAXBContext.newInstance(ClientStore.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.marshal(this, new File(url));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFile(String url) {
		JAXBContext contexto;
		try {
			contexto=JAXBContext.newInstance(ClientStore.class);
			Unmarshaller um = contexto.createUnmarshaller();
			ClientStore newClient = (ClientStore)um.unmarshal(new File(url));
			clientes = newClient.clientes;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
