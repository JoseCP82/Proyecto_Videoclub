package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import dao.ClientDAO;
import gui.Gui;
import model.Client;

public class ClientController {
	 
	Gui gui = new Gui();
	ClientDAO cd = new ClientDAO();

	/**
	 * M?todo que inicia el uso de la clase. Muestra el men? referente a las
	 * opciones de clientes. Obtiene la opci?n elegida.
	 */
	public void run() {
		int option = -1;
		do {
			gui.showClientMenu();
			option = gui.validateRangeInt("Elija una opci?n: ", 0, 5);
			switchOption(option);
			gui.showMessage("");
		} while (option != 0);
	}

	/**
	 * Metodo que implementa un switch en el cual se llaman a otros metodos para la
	 * gesti?n de clientes.
	 * 
	 * @param Opci?n elegida por el usuario.
	 */
	private void switchOption(int option) {
		gui.showMessage("");
		switch (option) {
			case 1:
				insertClient();
				break;
			case 2:
				if(!cd.isEmpty()) {
					searchClient();
				}
				else {
					gui.showMessage("No existen clientes a?n.");
				}
				break;
			case 3:
				if(!cd.isEmpty()) {
					removeClient();
				}
				else {
					gui.showMessage("No existen clientes a?n.");
				}
				break;
			case 4:
				if(!cd.isEmpty()) {
					updateClient();
				}
				else {
					gui.showMessage("No existen clientes a?n.");
				}
				break;
			case 5:
				if(!cd.isEmpty()) {
					gui.showMessage(cd.toString());
				}
				else {
					gui.showMessage("No existen clientes a?n.");
				}
				break;
			case 0:
				break;
			default:
				gui.showMessage("Opci?n incorrecta.");
		}
	}
	
	/**
	 * Da de alta a un cliente y lo inserta en la base de datos.
	 * Indica si la acci?n se realiz? o no con ?xito.
	 */
	private void insertClient() {
		String id = gui.validateDni("Inserte el Dni del cliente: ");
		if(cd.searchClient(id)==null) {
			String name = gui.readString("Inserte el nombre del cliente: ");
			String phone = gui.validatePhone("Inserte el tel?fono del cliente: ");
			String date = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss").format(Calendar.getInstance().getTime());
			if(cd.addClient(new Client(id,name,phone,date))) {
				gui.showMessage("Alta realizada correctamente.");
			}
			else {
				gui.showMessage("No se pudo dar de alta al cliente.");
			}
		}
		else {
			gui.showMessage("El cliente ya existe en la base de datos.");
		}
	}

	/**
	 * Busca un cliente por su identificacic?n.
	 * 
	 * @param id Identificador del cliente
	 * @return Devuelve el cliente encontrado o null si no existe.
	 */
	public Client searchClient(String id) {
		return cd.searchClient(id);
	}
	
	/**
	 * Busca un cliente y muestra sus datos en caso de encontrarse en alta.
	 * 
	 * @return Devuelve el cliente encontrado o null si no existe.
	 */
	
	public Client searchClient() {
		String id = gui.validateDni("Inserte el DNI del cliente a buscar: ");
		Client c=cd.searchClient(id);
		if(c!=null) {
			gui.showMessage(c.toString());
		}
		else {
			gui.showMessage("Cliente no encontrado.");
		}
		return c;
	}
	
	/*
	 * Actualiza el nombre y/o tel?fono de un cliente existente.
	 */
	public void updateClient() {
		Client c = searchClient();
		boolean result = false;
		if(c!=null) {
			String name = gui.readString("Inserte el nuevo nombre del cliente: ");
			String phone = gui.validatePhone("Inserte el nuevo tel?fono del cliente: ");
			if(name=="") {
				name=c.getName();
			}
			if(phone=="") {
				phone=c.getPhone();
			}
			result = cd.updateClient(c.getId(), name, phone);
		}
		if(result) {
			gui.showMessage("Datos del cliente actualizados con ?xito.");
		}
		else {
			gui.showMessage("No se pudieron actualizar los datos del cliente.");
		}
	}
	
	/*
	 * Da de baja a un cliente existente.
	 */
	public void removeClient() {
		Client c = searchClient();
		boolean result = false;
		if(c!=null){
			result=cd.removeClient(c);
		}
		if(result) {
			gui.showMessage("Cliente dado de baja con ?xito.");
		}
		else {
			gui.showMessage("No se pudo dar de baja al cliente.");
		}
	}
}
