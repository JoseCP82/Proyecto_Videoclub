package model;

import java.io.File;
import java.util.HashSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ReservationStore {
	/**
	 * Set donde se almacenan las reservas
	 */
	private HashSet<Reservation> reservs;
	
	/**
	 * Constructor de clase
	 */
	public ReservationStore() {
		this.reservs = new HashSet<Reservation>();
	}

	/**
	 * Añade al Set una nueva reserva.
	 * 
	 * @param r Objeto de clase reservation ha añadir.
	 * @return True o false si se agregó con éxito.
	 */
	public boolean addReservation(Reservation r) {
		boolean result = false;
		if(r!=null && r.getId()!=null) {
			result=reservs.add(r);
		}
		return result;
	}
	
	
	public Reservation searchReservation(String id) {
		Reservation r= null;
		if(!reservs.isEmpty() && id!=null) {
			
		}
		return r;
	}
	
	/**
	 * Elimina una reserva contenida en el Set.
	 * 
	 * @param r Objeto de clase reservation ha añadir.
	 * @return True o false si se agregó con éxito.
	 */
	public boolean removeReservation(Reservation r) {
		boolean result = false;
		if(r!=null && !reservs.isEmpty()) {
			result=reservs.remove(r);
		}
		return result;
	}
	
	public void saveFile(String url) {
		JAXBContext contexto;
		try {
			contexto=JAXBContext.newInstance(ReservationStore.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, true);
			m.marshal(this, new File(url));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFile(String url) {
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
	}
}
