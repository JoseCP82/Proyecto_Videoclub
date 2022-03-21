package model;

public class Reservation {
	
	/**
	 * Atributos de clase
	 */
	private static int NUM_RES=1;
	private String id;
	private String dateIni;
	private String dateEnd;
	private String dateFinished;
	private Status status;
	private String idClient; 
	private String nameItem;
	
	/**
	 * Constructor por defecto
	 */
	public Reservation() {
		this(null,null,null,null);
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
	public Reservation(String dateIni, String dateEnd, String idClient, String nameItem) {
		this.id = "Reserv"+NUM_RES++;
		this.dateIni = dateIni;
		this.dateEnd = dateEnd;
		this.dateFinished = null;
		this.idClient = idClient;
		this.nameItem = nameItem;
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
	public String getDateIni() {
		return dateIni;
	}

	/**
	 * Setea la fecha de inicio de la reserva
	 * 
	 * @param dateIni Dato con la fecha de inicio
	 */
	public void setDateIni(String dateIni) {
		this.dateIni = dateIni;
	}

	/**
	 * Obtiene la fecha estimada de la reserva
	 * 
	 * @return Fecha estimada de la reserva
	 */
	public String getDateEnd() {
		return dateEnd;
	}

	/**
	 * Setea la fecha de finalización estimada de la reserva
	 * 
	 * @param dateEnd Dato con la fecha de finalización estimada
	 */
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	/**
	 * Obtiene la fecha de finalización de la reserva
	 * 
	 * @return Fecha de finalización
	 */
	public String getDateFinished() {
		return dateFinished;
	}

	/**
	 * Setea la fecha de finalización de la reserva
	 * 
	 * @param dateFinished Dato con la fecha de finalización
	 */
	public void setDateFinished(String dateFinished) {
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
	public String getIdClient() {
		return idClient;
	}

	/**
	 * Setea un cliente
	 * 
	 * @param client Cliente a setear
	 */
	public void setClient(String idClient) {
		this.idClient = idClient;
	}

	/**
	 * Obtiene el item reservado
	 * 
	 * @return Item reservado
	 */
	public String getNameItem() {
		return nameItem;
	}

	/**
	 * Setea un item
	 * 
	 * @param item Item a setear
	 */
	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
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
		return "Reserva\n\tCódigo de reserva: " + id + "\n\tFecha de reserva: " + dateIni + "\n\tFecha entrega estimada: " + dateEnd + "\n\tFecha entrega final: "
				+ dateFinished + "\n\tEstado: " + isReturn + "\n\tCliente: " + idClient + "\n\tProducto: " + nameItem;
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
