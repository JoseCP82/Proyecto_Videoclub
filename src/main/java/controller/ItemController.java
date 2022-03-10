package controller;

import gui.Gui;

public class ItemController {
	
	Gui gui = new Gui();
	// ItemStore its = new ItemStore();

	/**
	 * Método que inicia el uso de la clase. Muestra el menú referente a las
	 * opciones de Items. Obtiene la opción elegida.
	 */
	public void run() {
		int option = -1;
		do {
			// gui.showItemMenu();
			option = utils.IOUtils.validaEntero("Elija una opción: ", 0, 5); //Modificar y usar el metodo de la clase Gui
			switchOption(option);
		} while (option != 0);
		new AppController().appInit();
	}

	/**
	 * Metodo que implementa un switch en el cual se llaman a otros metodos para la
	 * gestión de items.
	 * 
	 * @param Opción elegida por el usuario.
	 */
	private void switchOption(int option) {
		switch (option) {
			case 1:
				insertItem();
				break;
			case 2:
				/*
				if(!its.isEmpty()) {
					searchItem();
				}
				else {
					gui.showMessage("No existen copias aún.");
				}
				*/
				break;
			case 3:
				/*
				if(!its.isEmpty()) {
					updateItem();
				}
				else {
					gui.showMessage("No existen copias aún.");
				}
				*/
				break;
			case 4:
				/*
				if(!its.isEmpty()) {
					removeItem();
				}
				else {
					gui.showMessage("No existen copias aún.");
				}
				*/
				break;
			case 5:
				/*
				if(!its.isEmpty()) {
					gui.showMessage(its.toString());
				}
				else {
					gui.showMessage("No existen copias aún.");
				}
				*/
				break;
			case 0:
				break;
			default:
				// gui.showMessage("Opción incorrecta.");
		}
	}
	
	/**
	 * Crea una copia nueva y la inserta en la base de datos.
	 * Indica si la acción se realizó o no con éxito.
	 */
	private void insertItem() {
		/*
		String name = gui.leeCadenaVacia("Inserte el nombre de la copia: ");
		String description = gui.leeCadena("Inserte la descripción de la copia: ");
		float price = gui.validateFloat("Inserte el precio de la copia: ");:
		if(its.addItem(new Item(name,description,price))) {
			gui.showMessage("Copia almacenada correctamente.");
		}
		else {
			gui.showMessage("No se pudo almacenar la copia.");
		}
		*/
	}

	/**
	 * Busca una copia y muestra sus datos en caso de que exista.
	 * 
	 * @return Devuelve la copia encontrada o null si no existe.
	 */
	
	/*
	public Item searchItem() {
		Item i=null;
		String name = gui.leeCadenaVacia("Inserte el nombre de la copia a buscar: ");
		if(i=its.searchItem(name)!=null) {
			gui.showMessage(i);
		}
		else {
			gui.showMessage("Copia no encontrada.");
		}
		return i;
	}
	*/
	
	/*
	 * Actualiza la descripción y/o el precio de una copia existente.
	 */
	
	/*
	public void updateItem() {
		Item i = null;
		boolean result = false;
		if(i=searchItem()!=null) {
			String description = gui.validateString("Inserte la nueva descripción de la copia: ");
			float price = gui.validateFloat("Inserte el nuevo precio de la copia: ");
			result = its.updateItem(name, description, price);
		}
		if(result) {
			gui.showMessage("Datos de la copia actualizados con éxito.);
		}
		else {
			gui.showMessage("No se pudieron actualizar los datos de la copia.");
		}
	}
	*/
	
	/*
	 * Da de baja una copia existente.
	 */
	/*
	public void removeItem() {
		Item i = its.removeItem(searchItem());
		if(i!=null) {
			gui.showMessage("Copia eliminada con éxito.");
		}
		else {
			gui.showMessage("No se pudo eliminar la copia.");
		}
	}
	*/
}
