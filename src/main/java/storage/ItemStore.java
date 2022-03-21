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

import model.Item;

@XmlRootElement(name="Copias")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemStore implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private HashSet<Item> items;
	
	/**
	 * Constructor por defecto
	 */
	public ItemStore() {
		items = new HashSet<Item>();
	}
	
	/**
	 * Guarda los Item en un xml
	 * 
	 * @param url Nombre del archivo xml donde se almacenan los datos
	 */
	public void saveFile(String url, HashSet<Item> items) {
		this.items= items;
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(ItemStore.class);
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
	 * 
	 * @param url Nombre del archivo xml
	 */
	public HashSet<Item> loadFile(String url) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(ItemStore.class);
			Unmarshaller um = contexto.createUnmarshaller();
			ItemStore newItem = (ItemStore) um.unmarshal(new File(url));
			items = newItem.items;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
}
