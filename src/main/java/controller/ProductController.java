package controller;

import dao.ProductDAO;
import gui.Gui;
import model.Product;

public class ProductController {
	
	Gui gui = new Gui();
	ProductDAO pd = new ProductDAO();

	/**
	 * M?todo que inicia el uso de la clase. Muestra el men? referente a las
	 * opciones de productos. Obtiene la opci?n elegida.
	 */
	public void run() {
		int option = -1;
		do {
			gui.showProductMenu();
			option = gui.validateRangeInt("Elija una opci?n: ", 0, 5);
			switchOption(option);
			gui.showMessage("");
		} while (option != 0);
	}

	/**
	 * Metodo que implementa un switch en el cual se llaman a otros metodos para la
	 * gesti?n de productos.
	 * 
	 * @param Opci?n elegida por el usuario.
	 */
	private void switchOption(int option) {
		gui.showMessage("");
		switch (option) {
			case 1:
				insertProduct();
				break;
			case 2:
				if(!pd.isEmpty()) {
					searchProduct();
				}
				else {
					gui.showMessage("No existen productos a?n.");
				}
				break;
			case 3:
				if(!pd.isEmpty()) {
					removeProduct();
				}
				else {
					gui.showMessage("No existen productos a?n.");
				}
				break;
			case 4:
				if(!pd.isEmpty()) {
					updateProduct();
				}
				else {
					gui.showMessage("No existen productos a?n.");
				}
				break;
			case 5:
				if(!pd.isEmpty()) {
					gui.showMessage(pd.toString());
				}
				else {
					gui.showMessage("No existen productos a?n.");
				}
				break;
			case 0:
				break;
			default:
				gui.showMessage("Opci?n incorrecta.");
		}
	}
	
	/**
	 * Crea un producto y lo inserta en la base de datos.
	 * Indica si la acci?n se realiz? o no con ?xito.
	 */
	private void insertProduct() {
		String key = gui.validateName("Inserte el c?digo del producto: ");
		if(pd.searchProduct(key)==null) {
			String name = gui.readString("Inserte el nombre del producto: ");
			if(pd.addProduct(new Product(key,name))) {
				gui.showMessage("Producto almacenado correctamente.");
			}
			else {
				gui.showMessage("No se pudo almacenar el producto.");
			}
		}
		else {
			gui.showMessage("El producto ya existe.");
		}
	}

	/**
	 * Busca un producto y muestra sus datos en caso de encontrarse almacenado.
	 * 
	 * @return Devuelve el producto encontrado o null si no existe.
	 */
	public Product searchProduct() {
		String key = gui.validateName("Inserte la clave del producto a buscar: ");
		Product p=pd.searchProduct(key);
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
			String name = gui.readString("Inserte el nuevo nombre del producto: ");
			if(name=="") {
				name=p.getName();
			}
			result = pd.updateProduct(p.getKey(),name);
		}
		if(result) {
			gui.showMessage("Datos del producto actualizados con ?xito.");
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
			result=pd.removeProduct(p);
		}
		if(result) {
			gui.showMessage("Producto eliminado con ?xito.");
		}
		else {
			gui.showMessage("No se pudo eliminar el producto.");
		}
	}
}
