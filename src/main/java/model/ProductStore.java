package model;

import java.util.HashSet;
import java.util.Set;
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

public class ProductStore implements Serializable  {
	
		private static final long serialVersionUID = 1L;
	private HashSet<Product> productos;
	
	
	
	

	public ProductStore() {
		 productos = new HashSet<Product>();
	}

	public Set<Product> getProducto() {
		return productos;
	}

	public void setProducto(Set<Product> producto) {
		this.productos = productos;
	}

	public ProductStore(Set<Product> producto) {
		super();
		this.productos = productos;
	}
	
	
	

	
	/**
	 * Añade un producto al arraylist
	 * @param p El producto que le pasas
	 * @return True si a sido añadido o false si no a sido  añadido.
	 */
	public boolean addProduct(Product p) {
		boolean valid=productos.add(p);
	
		return valid;
	}
	/**
	 * Elimina un producto  del arraylist
	 * 
	 * @param p El producto que le pasas. 
	 * @return True si a sido eliminado o false si no a sido encontrado y por lo tanto no lo a eliminado.
	 */
	public boolean removeProduct(Product p) {
		boolean valid=productos.remove(p);
		
		
		return valid;
	}
		
	public boolean updateProduct(String key, String name) {
		boolean valid =false;
		Product search = searchProduct(key);
		
		if(search !=null) {
			
			search.setName(name);
			valid=true;
		}
			
		
		
		return valid;
	}
	/**
	 * Sirve para buscar un producto por su clave que en este caso seria la key
	 * @param key La clave del producto por el cual vas a buscar
	 * @return Devuelve el Producto buscado o null si no se encuentra
	 */
	public Product searchProduct(String key) {
		
	Product	e = null;
		
		for (Product o:productos) {
			if(o.getKey()==key) {
				e=o;
			}
		}
		
		return e;
	}
	
	public String toString() {
		String cadena="";
		for(Product o : productos) {
			cadena += o.toString();
		}
		return cadena;
	}


	public void saveProducts(String url) {
		JAXBContext contexto;
		try {
			contexto=JAXBContext.newInstance(ProductStore.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.marshal(this, new File(url));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

	public void loadProducts(String url) {
		JAXBContext contexto;
		try {
			contexto=JAXBContext.newInstance(ProductStore.class);
			Unmarshaller um = contexto.createUnmarshaller();
			ProductStore 	newProduct = (ProductStore)um.unmarshal(new File(url));
			productos = newProduct.productos;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
