package controller;

import gui.Gui;
import model.Product;
import model.ProductStore;

public class ProductController {
	
	Gui gui = new Gui();
	ProductStore ps = new ProductStore();

	/**
	 * Método que inicia el uso de la clase. Muestra el menú referente a las
	 * opciones de productos. Obtiene la opción elegida.
	 */
	public void run() {
		int option = -1;
		do {
			gui.showProductMenu();
			option = utils.IOUtils.validaEntero("Elija una opción: ", 0, 5); //Modificar y usar el metodo de la clase Gui
			switchOption(option);
		} while (option != 0);
	}

	/**
	 * Metodo que implementa un switch en el cual se llaman a otros metodos para la
	 * gestión de productos.
	 * 
	 * @param Opción elegida por el usuario.
	 */
	private void switchOption(int option) {
		switch (option) {
			case 1:
				insertProduct();
				break;
			case 2:
				if(!ps.isEmpty()) {
					searchProduct();
				}
				else {
					gui.showMessage("No existen productos aún.");
				}
				break;
			case 3:
				if(!ps.isEmpty()) {
					updateProduct();
				}
				else {
					gui.showMessage("No existen productos aún.");
				}
				break;
			case 4:
				if(!ps.isEmpty()) {
					removeProduct();
				}
				else {
					gui.showMessage("No existen productos aún.");
				}
				break;
			case 5:
				if(!ps.isEmpty()) {
					gui.showMessage(ps.toString());
				}
				else {
					gui.showMessage("No existen productos aún.");
				}
				break;
			case 0:
				break;
			default:
				gui.showMessage("Opción incorrecta.");
		}
	}
	
	/**
	 * Crea un producto y lo inserta en la base de datos.
	 * Indica si la acción se realizó o no con éxito.
	 */
	private void insertProduct() {
		String key = gui.validateKey("Inserte la clave del producto: ");
		String name = gui.validateString("Inserte el nombre del producto: ");
		if(ps.addClient(new Product(key, name))) {
			gui.showMessage("Producto almacenado correctamente.");
		}
		else {
			gui.showMessage("No se pudo almacenar el producto.");
		}
	}

	/**
	 * Busca un producto y muestra sus datos en caso de encontrarse almacenado.
	 * 
	 * @return Devuelve el producto encontrado o null si no existe.
	 */
	public Product searchProduct() {
		String key = gui.validateKey("Inserte la clave del producto a buscar: ");
		Product p=ps.searchProduct(key);
		if(p!=null) {
			gui.showMessage(p.toString());
		}
		else {
			gui.showMessage("Producto no encontrado.");
		}
		return p;
	}
	
	/*
	 * Actualiza el nombre de un producto existente.
	 */
	public void updateProduct() {
		Product p = searchProduct();
		boolean result = false;
		if(p!=null) {
			String name = gui.validateString("Inserte el nuevo nombre del producto: ");
			result = ps.updateProduct(p.getKey(),name);
		}
		if(result) {
			gui.showMessage("Datos del producto actualizados con éxito.");
		}
		else {
			gui.showMessage("No se pudieron actualizar los datos del producto.");
		}
	}
	
	/*
	 * Elimina un producto existente.
	 */
	public void removeProduct() {
		Product p = searchProduct();
		boolean result=false;
		if(p!=null) {
			result=ps.removeProduct(p);
		}
		if(result) {
			gui.showMessage("Producto eliminado con éxito.");
		}
		else {
			gui.showMessage("No se pudo eliminar el producto.");
		}
	}
}
