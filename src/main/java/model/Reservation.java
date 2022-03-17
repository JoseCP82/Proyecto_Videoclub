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

	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name="Código reserva")
	private String id;
	private LocalDateTime dateIni;
	private LocalDateTime dateEnd;
	private LocalDateTime dateFinished;
	private boolean status;
	private IClient client; 
	private IItem item;
	
	public Reservation() {
		this("",null,null,null,false,null,null);
	}

	public Reservation(String id, LocalDateTime dateIni, LocalDateTime dateEnd, LocalDateTime dateFinished, boolean status, IClient client, IItem item) {
		this.id = id;
		this.dateIni = dateIni;
		this.dateEnd = dateEnd;
		this.dateFinished = dateFinished;
		this.status = status;
		this.client = client;
		this.item = item;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDateIni() {
		return dateIni;
	}

	public void setDateIni(LocalDateTime dateIni) {
		this.dateIni = dateIni;
	}

	public LocalDateTime getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDateTime dateEnd) {
		this.dateEnd = dateEnd;
	}

	public LocalDateTime getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(LocalDateTime dateFinished) {
		this.dateFinished = dateFinished;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public IClient getClient() {
		return client;
	}

	public void setClient(IClient client) {
		this.client = client;
	}

	public IItem getItem() {
		return item;
	}

	public void setItem(IItem item) {
		this.item = item;
	}

	@Override
	public String toString() {
		String isReturn="Articulo no devuelto. Alquiler en alta.";
		if(this.status) {
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
