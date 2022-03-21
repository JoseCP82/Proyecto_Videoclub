package model;

import interfaces.IClient;

public class Client implements IClient {
	private String id;
	private String name;
	private String phone;
	private String time;
	
	/**
	 * Constructor por defecto
	 */
	public Client() {
		this("0","default","000","1/1/2000");
	}
	
	/**
	 * Constructor con parametros
	 * @param id Identificación del cliente
	 * @param name Nombre del cliente
	 * @param phone Teléfono del cliente
	 * @param time Fecha de alta del cliente
	 */
	public Client(String id, String name, String phone, String time) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.time = time;
	}

	/**
	 * Obtiene la identificación del cliente
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Setea la identificación del cliente
	 */
	public void setId(String id) {
		this.id=id;
	}
	
	/**
	 * Obtien el nombre del cliente
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setea el nombre del cliente
	 */
	public void setName(String name) {
		this.name=name;
	}
	
	/**
	 * Obtiene el número de teléfono del cliente
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Setea el número de teléfono del cliente
	 */
	public void setPhone(String phone) {
		this.phone=phone;
	}
	
	/**
	 * Obtiene la fecha de alta de un cliente
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * Setea la fecha de alta de un cliente
	 */
	public void setTime(String time) {
		this.time=time;
	}

	/**
	 * Obtiene todos los datos de un cliene
	 */
	@Override
	public String toString() {
		return "Cliente=" + "\n\tId=" + id + "\n\tNombre=" + name + "\n\tTelefono=" + phone + "\n\tFecha de Alta=" + time;
	}
	
	/**
	 * Compara si dos clientes son iguales
	 * se pasa un objeto y si este es el mismo Cliete o si es un Cliente y tiene 
	 * el mismo id deveuelve true y si no devuelve false;
	 */
	public boolean equals(Object obj) {
		boolean result=false;
		if (obj != null) {
			if (this == obj) {
				result = true;
			} else {
				if(obj instanceof Client){
					if (this.id!=null && this.id.equals(((Client)obj).id)) {
						result = true;
					}
				}
			}
		}
		return result;
	}
	
}
