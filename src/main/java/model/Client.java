package model;

import interfaces.IClient;

public class Client implements IClient {
	private String id;
	private String name;
	private String phone;
	private String time;
	
	public Client() {
		this("0","default","000","1/1/2000");
	}
	
	public Client(String id, String name, String phone, String time) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.time = time;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time=time;
	}

	@Override
	public String toString() {
		return "\nCliente=" + "\n\tId=" + id + "\n\tNombre=" + name + "\n\tTelefono=" + phone + "\n\tFecha de Alta=" + time;
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
