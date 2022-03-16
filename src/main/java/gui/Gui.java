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
	 * muestra por consola el menu de Reservas.
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

	/**
	 * muestra por pantalla el menu de Copias.
	 */
	public void showItemMenu() {
		this.printLine("\\\\==========COPIAS==============//");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("|   1. Introducir copia.           |");
		this.printLine("|   2. Buscar copia.               |");
		this.printLine("|   3. Eliminar reserva.           |");
		this.printLine("|   4  Actualizar reserva.         |");
		this.printLine("|   0. Volver atras.               |");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("//============COPIAS============\\\\");
	}

	/**
	 * muestra por pantalla el mensaje.
	 */
	public void showMessage(String message) {
		// TODO Auto-generated method stub
	}

	/**
	 * muestra un mensaje que valida que sea decimal.
	 */
	public float validateFloat(String message) {
		// TODO Auto-generated method stub

		return IOUtils.validatePositiveFloat(message);
	}

	/**
	 * muestra un mensaje que valida que sea entero.
	 */
	public int validateInt(String message) {
		return IOUtils.validateInt(message);
	}

	/**
	 * muestra un mensaje que valida que sea una cadena.
	 */
	public String validateString(String message) {

		return IOUtils.validateString(message);
	}

	/**
	 * muestra un mensaje que valida que comprueba que se introduzca un dni valido.
	 */
	public String validateDni(String message) {
		return IOUtils.validateDni(message);
	}

	/**
	 * 
	 * @param message valida un nombre introducido.
	 * @return devuelve un nombre que sea correcto.
	 */
	public String validateName(String message) {
		return IOUtils.validateName(message);
	}

	/**
	 * 
	 * @param message valida una key que permite identificar un objeto.
	 * @return devuelve la key introducida y que sea corecta.
	 */
	public String validateKey(String message) {

		return IOUtils.validateKey(message);
	}

	/**
	 * 
	 * @param message valida que se introduzca un número de teléfono.
	 * @return devuelve el conjunto introducido y sea correcto.
	 */
	public String validatePhone(String message) {

		return IOUtils.validatePhone(message);
	}
}
