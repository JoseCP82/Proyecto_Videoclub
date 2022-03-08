package gui;

import interfaces.IGUI;
import utils.IOUtils;

public class Gui implements IGUI {
	private void printLine(String texto) {
		System.out.println(texto);
	}

	/**
	 * muestra por consola el Menu principal.
	 */
	public void showMainMenu() {
		// TODO Auto-generated method stub
		this.printLine("\\\\====Bienvenido a BLOCKBUSTER====//");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("|   1. Gestión de clientes.        |");
		this.printLine("|   2. Gestión de articulos.       |");
		this.printLine("|   3. Gestión de reservas.        |");
		this.printLine("|   0. Salir.                      |");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("//====Bienvenido a BLOCKBUSTER====\\\\");

	}

	/**
	 * muestra por consola el menu de Clientes.
	 */
	public void showClientMenu() {
		// TODO Auto-generated method stub
		this.printLine("\\\\============Clientes============//");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("|   1. Introducir cliente.        |");
		this.printLine("|   2. Buscar clientes.           |");
		this.printLine("|   3. Eliminar cliente.          |");
		this.printLine("|   4. Actualizar cliente.        |");
		this.printLine("|   0. Volver atras.              |");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("//============Clientes============\\\\");
	}

	/**
	 * muestra por consola el menu de Articulos.
	 */
	public void showProductMenu() {
		// TODO Auto-generated method stub

	}

	/**
	 * muestra por consola el menu de reservas.
	 */
	public void showReservationMenu() {
		// TODO Auto-generated method stub

	}

	
	public String showMessage(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	public float validateFloat(String message) {
		// TODO Auto-generated method stub
		IOUtils.validaFloatPositivo(message);
		return 0;
	}

	public int validateInt(String message) {
		return 0;
	}

	public String validateString(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	public String validatedni(String message) {
		return IOUtils.validateDni(message);
	}
}
