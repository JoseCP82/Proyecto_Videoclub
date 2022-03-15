package model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import interfaces.IClient;
import interfaces.IItem;

@XmlRootElement(name="Reserva")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation implements Serializable{

	/**
	 * Atributos de clase
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name="Código reserva")
	private String id;
	private LocalDateTime dateIni;
	private LocalDateTime dateEnd;
	private LocalDateTime dateFinished;
	private Status status;
	private IClient client; 
	private IItem item;
	
	/**
	 * Constructor por defecto
	 */
	public Reservation() {
		this("Default",null,null,null,null);
		this.status=Status.HIGHRESERVE;
	}

	/**
	 * Constructor con parametros
	 * 
	 * @param id Código identificativo 
	 * @param dateIni Fecha de inicio
	 * @param dateEnd Fecha estimada de finalización
	 * @param dateFinished Fecha de finalización
	 * @param client Cliente que realiza la reserva
	 * @param item Articulo que se desea alquilar
	 */
	public Reservation(String id, LocalDateTime dateIni, LocalDateTime dateEnd, IClient client, IItem item) {
		this.id = id;
		this.dateIni = dateIni;
		this.dateEnd = dateEnd;
		this.dateFinished = null;
		this.client = client;
		this.item = item;
		this.status=Status.HIGHRESERVE;
	}

	/**
	 * Obtiene el id de la reserva
	 * 
	 * @return Id de la reserva
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setea el id de la reserva
	 * 
	 * @param id Dato con el id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene la fecha de inicio de la reserva
	 * 
	 * @return Fecha de inicio de la reserva
	 */
	public LocalDateTime getDateIni() {
		return dateIni;
	}

	/**
	 * Setea la fecha de inicio de la reserva
	 * 
	 * @param dateIni Dato con la fecha de inicio
	 */
	public void setDateIni(LocalDateTime dateIni) {
		this.dateIni = dateIni;
	}

	/**
	 * Obtiene la fecha estimada de la reserva
	 * 
	 * @return Fecha estimada de la reserva
	 */
	public LocalDateTime getDateEnd() {
		return dateEnd;
	}

	/**
	 * Setea la fecha de finalización estimada de la reserva
	 * 
	 * @param dateEnd Dato con la fecha de finalización estimada
	 */
	public void setDateEnd(LocalDateTime dateEnd) {
		this.dateEnd = dateEnd;
	}

	/**
	 * Obtiene la fecha de finalización de la reserva
	 * 
	 * @return Fecha de finalización
	 */
	public LocalDateTime getDateFinished() {
		return dateFinished;
	}

	/**
	 * Setea la fecha de finalización de la reserva
	 * 
	 * @param dateFinished Dato con la fecha de finalización
	 */
	public void setDateFinished(LocalDateTime dateFinished) {
		this.dateFinished = dateFinished;
	}

	/**
	 * Obtiene el estado de la reserva
	 * 
	 * @return Estado de la reseva (True en alta, false en baja)
	 */
	public Status isStatus() {
		return status;
	}

	/**
	 * Setea el estado de la reserva
	 * 
	 * @param status Dato con el estado
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Obtiene el cliente que realiza la reserva
	 * 
	 * @return Cliente que realiza la reserva
	 */
	public IClient getClient() {
		return client;
	}

	/**
	 * Setea un cliente
	 * 
	 * @param client Cliente a setear
	 */
	public void setClient(IClient client) {
		this.client = client;
	}

	/**
	 * Obtiene el item reservado
	 * 
	 * @return Item reservado
	 */
	public IItem getItem() {
		return item;
	}

	/**
	 * Setea un item
	 * 
	 * @param item Item a setear
	 */
	public void setItem(IItem item) {
		this.item = item;
	}

	/**
	 * Muestra por consola todos los datos de la reserva
	 */
	@Override
	public String toString() {
		String isReturn="Articulo no devuelto. Alquiler en alta.";
		if(status==Status.INLOWRESERVE) {
			isReturn="Articulo devuelto. Alquiler finalizado.";
		}
		return "Código de reserva: " + id + "\nFecha de reserva: " + dateIni + "\nFecha entrega estimada: " + dateEnd + "\nFecha entrega final: "
				+ dateFinished + "\nEstado: " + isReturn + "\nCliente: " + client + "\nProducto: " + item;
	}

	/**
	 * Compara una reserva con otro por su atributo ID.
	 * Devuelve true o false en case de que sean iguales o no.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean result=false;
		if (obj != null) {
			if (this == obj) {
				result = true;
			} else {
				if(obj instanceof Reservation){
					if (this.id!=null && this.id.equals(((Reservation)obj).id)) {
						result = true;
					}
				}
			}
		}
		return result;
	}	
}
