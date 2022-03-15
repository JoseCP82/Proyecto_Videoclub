package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import gui.Gui;
import model.Client;
import model.ClientStore;

public class ClientController {

	Gui gui = new Gui();
	ClientStore cs = new ClientStore();

	/**
	 * Método que inicia el uso de la clase. Muestra el menú referente a las
	 * opciones de clientes. Obtiene la opción elegida.
	 */
	public void run() {
		int option = -1;
		do {
			gui.showClientMenu();
			option = utils.IOUtils.validaEntero("Elija una opción: ", 0, 5); //Modificar y usar el metodo de la clase Gui
			switchOption(option);
		} while (option != 0);
	}

	/**
	 * Metodo que implementa un switch en el cual se llaman a otros metodos para la
	 * gestión de clientes.
	 * 
	 * @param Opción elegida por el usuario.
	 */
	private void switchOption(int option) {
		switch (option) {
			case 1:
				insertClient();
				break;
			case 2:
				if(!cs.isEmpty()) {
					searchClient();
				}
				else {
					gui.showMessage("No existen clientes aún.");
				}
				break;
			case 3:
				if(!cs.isEmpty()) {
					updateClient();
				}
				else {
					gui.showMessage("No existen clientes aún.");
				}
				break;
			case 4:
				if(!cs.isEmpty()) {
					removeClient();
				}
				else {
					gui.showMessage("No existen clientes aún.");
				}
				break;
			case 5:
				if(!cs.isEmpty()) {
					gui.showMessage(cs.toString());
				}
				else {
					gui.showMessage("No existen clientes aún.");
				}
				break;
			case 0:
				break;
			default:
				gui.showMessage("Opción incorrecta.");
		}
	}
	
	/**
	 * Da de alta a un cliente y lo inserta en la base de datos.
	 * Indica si la acción se realizó o no con éxito.
	 */
	private void insertClient() {
		String id = gui.validatedni("Inserte el Dni del cliente: ");
		String name = gui.validateString("Inserte el nombre del cliente: ");
		String phone = gui.validatePhone("Inserte el teléfono del cliente: ");
		String date = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss").format(Calendar.getInstance().getTime());
		if(cs.addClient(new Client(id,name,phone,date))) {
			gui.showMessage("Alta realizada correctamente.");
		}
		else {
			gui.showMessage("No se pudo dar de alta al cliente.");
		}
	}

	/**
	 * Busca un cliente y muestra sus datos en caso de encontrarse en alta.
	 * 
	 * @return Devuelve el cliente encontrado o null si no existe.
	 */
	
	public Client searchClient() {
		String id = gui.validatedni("Inserte el DNI del cliente a buscar: ");
		Client c=cs.searchClient(id);
		if(c!=null) {
			gui.showMessage(c.toString());
		}
		else {
			gui.showMessage("Cliente no encontrado.");
		}
		return c;
	}
	
	/*
	 * Actualiza el nombre y/o teléfono de un cliente existente.
	 */
	public void updateClient() {
		Client c = searchClient();
		boolean result = false;
		if(c!=null) {
			String name = gui.validateString("Inserte el nuevo  nombre del cliente: ");
			String phone = gui.validatePhone("Inserte el nuevo teléfono del cliente: ");
			result = cs.updateClient(c.getId(), name, phone);
		}
		if(result) {
			gui.showMessage("Datos del cliente actualizados con éxito.");
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
			result=cs.removeClient(c);
		}
		if(result) {
			gui.showMessage("Cliente dado de baja con éxito.");
		}
		else {
			gui.showMessage("No se pudo dar de baja al cliente.");
		}
	}
}
