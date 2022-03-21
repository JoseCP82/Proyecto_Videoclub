package dao;

import java.util.HashSet;
import java.util.Iterator;
import model.Reservation;
import model.Status;
import storage.ReservationStore;

public class ReservationDAO {
	
	private final String URL="reservs.xml";
	
	/**
	 * Set donde se almacenan las reservas
	 */
	private HashSet<Reservation> reservs;
	
	/**
	 * Constructor de clase
	 */
	public ReservationDAO() {
		reservs = new HashSet<Reservation>();
		try {
			reservs = new ReservationStore().loadFile(URL);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Obtiene si el Set contiene elementos o está vacío
	 * 
	 * @return True o false si está vacío o no.
	 */
	public boolean isEmpty() {
		return reservs.isEmpty();
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
			new ReservationStore().saveFile(URL, reservs);
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
	public boolean updateReservation(String id, String dateFinished, Status status) {
		boolean result = false;
		if(!reservs.isEmpty() && id!=null && dateFinished!=null) {
			Reservation r = searchReservation(id);
			if(r!=null) {
				r.setDateFinished(dateFinished);
				r.setStatus(status);
				new ReservationStore().saveFile(URL, reservs);
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
			new ReservationStore().saveFile(URL, reservs);
		}
		return result;
	}
	
	/**
	 * Método que obtiene todos los datos de un cliente y los almacena en un 
	 * string para mostrarlos por pantalla.
	 * 
	 * @return Cadena con los datos almacenados
	 */
	public String toString() {
		String result = "";
		for (Reservation o : reservs) {
			result += o.toString()+"\n";
		}
		return result;
	}
}
