package controller;

import dao.ItemDAO;
import gui.Gui;
import model.Item;

public class ItemController {
	
	Gui gui = new Gui();
	ItemDAO itd = new ItemDAO();

	/**
	 * Método que inicia el uso de la clase. Muestra el menú referente a las
	 * opciones de Items. Obtiene la opción elegida.
	 */
	public void run() {
		int option = -1;
		do {
			gui.showItemMenu();
			option = gui.validateRangeInt("Elija una opción: ", 0, 5);
			switchOption(option);
			gui.showMessage("");
		} while (option != 0);
	}

	/**
	 * Metodo que implementa un switch en el cual se llaman a otros metodos para la
	 * gestión de items.
	 * 
	 * @param Opción elegida por el usuario.
	 */
	private void switchOption(int option) {
		gui.showMessage("");
		switch (option) {
			case 1:
				insertItem();
				break;
			case 2:
				if(!itd.isEmpty()) {
					searchItem();
				}
				else {
					gui.showMessage("No existen copias aún.");
				}
				break;
			case 3:
				if(!itd.isEmpty()) {
					removeItem();
				}
				else {
					gui.showMessage("No existen copias aún.");
				}
				break;
			case 4:
				if(!itd.isEmpty()) {
					updateItem();
				}
				else {
					gui.showMessage("No existen copias aún.");
				}
				break;
			case 5:
				if(!itd.isEmpty()) {
					gui.showMessage(itd.toString());
				}
				else {
					gui.showMessage("No existen copias aún.");
				}
				break;
			case 0:
				break;
			default:
				 gui.showMessage("Opción incorrecta.");
		}
	}
	
	/**
	 * Crea una copia nueva y la inserta en la base de datos.
	 * Indica si la acción se realizó o no con éxito.
	 */
	private void insertItem() {
		String name = gui.readString("Inserte el nombre de la copia: ");
		if(itd.searchItem(name)==null) {
			String description = gui.readString("Inserte la descripción de la copia: ");
			float price = gui.validateFloat("Inserte el precio de la copia: ");
			if(itd.addItem(new Item(name,description,price))) {
				gui.showMessage("Copia almacenada correctamente.");
			}
			else {
				gui.showMessage("No se pudo almacenar la copia.");
			}
		}
		else {
			gui.showMessage("El item ya existe en la base de datos.");
		}
	}

	/**
	 * Busca un item por su nombre.
	 * 
	 * @param id Identificador del item
	 * @return Devuelve el item encontrado o null si no existe.
	 */
	public Item searchClient(String name) {
		return itd.searchItem(name);
	}
	
	/**
	 * Busca una copia y muestra sus datos en caso de que exista.
	 * 
	 * @return Devuelve la copia encontrada o null si no existe.
	 */
	public Item searchItem() {
		String name = gui.readString("Inserte el nombre de la copia a buscar: ");
		Item i=itd.searchItem(name);
		if(i!=null) {
			gui.showMessage(i.toString());
		}
		else {
			gui.showMessage("Copia no encontrada.");
		}
		return i;
	}
	
	/*
	 * Actualiza la descripción y/o el precio de una copia existente.
	 */
	public void updateItem() {
		boolean result = false;
		Item i = searchItem();
		if(i!=null) {
			String description = gui.readString("Inserte la nueva descripción de la copia: ");
			float price = gui.validateFloat("Inserte el nuevo precio de la copia: ");
			if(description=="") {
				description=i.getDescription();
			}
			if(price==0) {
				price=i.getPrice();
			}
			result = itd.updateItem(i.getName(), description, price);
		}
		if(result) {
			gui.showMessage("Datos de la copia actualizados con éxito.");
		}
		else {
			gui.showMessage("No se pudieron actualizar los datos de la copia.");
		}
	}
	
	/*
	 * Da de baja una copia existente.
	 */
	public void removeItem() {
		Item i = searchItem();
		if(itd.removeItem(i)) {
			gui.showMessage("Copia eliminada con éxito.");
		}
		else {
			gui.showMessage("No se pudo eliminar la copia.");
		}
	}
}
