package model;

import java.io.File;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Reservation Store")
@XmlAccessorType(XmlAccessType.FIELD)
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
	
	/**
	 * Busca en el Set una reservada dada por el usuario.
	 * 
	 * @param id Código de la reserva a buscar.
	 * @return Devuelve la reserva si la ha encontrado o null si no.
	 */
	public Reservation searchReservation(String id) {
		Reservation r= null;
		if(!reservs.isEmpty() && id!=null) {
			Iterator<Reservation> it = reservs.iterator();
			while(it.hasNext()) {
				 r = it.next();
				if(!r.getId().equals(id)) {
					r=null;
				}
			}
		}
		return r;
	}
	
	/**
	 * Actualiza el estado y la fecha de finalización de una reserva que se encuentre en el Set
	 * 
	 * @param id Código de reserva a actualizar.
	 * @param dateFinished Fecha en la que finaliza una reserva.
	 * @return True o false si se realizó o no.
	 */
	public boolean updateReservation(String id, LocalDateTime dateFinished) {
		boolean result = false;
		if(!reservs.isEmpty() && id!=null && dateFinished!=null) {
			Reservation r = searchReservation(id);
			if(r!=null) {
				r.setDateFinished(dateFinished);
				r.setStatus(Status.INLOWRESERVE);
				result=true;
			}
		}
		return result;
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
	
	/**
	 * Almacena todas las reservas existentes en un archivo XML.
	 * 
	 * @param url Nombre del archivo XML.
	 */
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
	
	/**
	 * Carga de un archivo XML las reservas existentes.
	 * 
	 * @param url Nombre del archivo XML.
	 */
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
