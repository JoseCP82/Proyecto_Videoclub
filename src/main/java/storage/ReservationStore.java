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

import model.Reservation;

@XmlRootElement(name = "Reservas")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReservationStore implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private HashSet<Reservation> reservs;
	
	/**
	 * Constructor por defecto
	 */
	public ReservationStore() {
		reservs = new HashSet<Reservation>();
	}
	
	/**
	 * Almacena todas las reservas existentes en un archivo XML.
	 * 
	 * @param url Nombre del archivo XML.
	 */
	public void saveFile(String url, HashSet<Reservation> reservs) {
		this.reservs=reservs;
		JAXBContext contexto;
		try {
			contexto=JAXBContext.newInstance(ReservationStore.class);
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
	 * Carga de un archivo XML las reservas existentes.
	 * 
	 * @param url Nombre del archivo XML.
	 */
	public HashSet<Reservation> loadFile(String url) {
		JAXBContext contexto;
		try {
			contexto=JAXBContext.newInstance(ReservationStore.class);
			Unmarshaller um = contexto.createUnmarshaller();
			ReservationStore newReserv = (ReservationStore)um.unmarshal(new File(url));
			reservs = newReserv.reservs;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservs;
	}
}
