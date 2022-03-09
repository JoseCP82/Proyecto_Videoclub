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
		this.printLine("\\\\============Productos============//");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("|   1. Insertar producto.           |");
		this.printLine("|   2. Buscar.                      |");
		this.printLine("|   3. Eliminar.                    |");
		this.printLine("|   3. Actualizar.                  |");
		this.printLine("|   0. Volver atras.                |");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("//============Productos============\\\\");
	}

	/**
	 * muestra por consola el menu de reservas.
	 */
	public void showReservationMenu() {
		this.printLine("\\\\==========Reservas==============//");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("|   1. Introducir reserva.         |");
		this.printLine("|   2. Buscar reserva.             |");
		this.printLine("|   3. Eliminar reserva.           |");
		this.printLine("|   4  Actualizar reserva.         |");
		this.printLine("|   0. Volver atras.               |");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("//============Reservas============\\\\");

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
		IOUtils.validateString(message);
		return null;
	}

	public String validatedni(String message) {
		return IOUtils.validateDni(message);
	}
	
	public String validateName(String message) {
		IOUtils.validateName(message);
		return null;
	}
	
	public String validateKey(String message) {
		IOUtils.validateKey(message);
		return null;
	}
	
	public String validatePhone(String message) {
		IOUtils.validatePhone(message);
		return null;
	}
	
}
