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

import model.Product;

@XmlRootElement(name = "Productos")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductStore implements Serializable{

	private static final long serialVersionUID = 1L;
	private HashSet<Product> products;
	
	public ProductStore() {
		products = new HashSet<Product>();
	}
	
	/**
	 * Guarda los Productos en un xml
	 * 
	 * @param url Nombre del archivo xml donde se almacenan los datos
	 */
	public void saveFile(String url, HashSet<Product> products) {
		this.products=products;
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(ProductStore.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.marshal(this, new File(url));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Carga los Productos guardados en el xml
	 * 
	 * @param url Nombre del archivo xml
	 */
	public HashSet<Product> loadFile(String url) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(ProductStore.class);
			Unmarshaller um = context.createUnmarshaller();
			ProductStore newClient = (ProductStore) um.unmarshal(new File(url));
			products = newClient.products;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return products;
	}
}
