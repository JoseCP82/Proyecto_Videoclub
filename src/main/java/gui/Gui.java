package gui;

import interfaces.IGUI;
import utils.IOUtils;

public class Gui implements IGUI {
	
	/**
	 * Muestra por consola un mensaje o texto
	 * @param texto Mensaje o texto a mostrar
	 */
	private void printLine(String texto) {
		System.out.println(texto);
	}

	/**
	 * muestra por consola el Menu principal.
	 */
	public void showMainMenu() {
		this.printLine("\\\\====Bienvenido a BLOCKBUSTER====//");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("|   1. Gestión de clientes.        |");
		this.printLine("|   2. Gestión de productos.       |");
		this.printLine("|   3. Gestión de copias.          |");
		this.printLine("|   4. Gestión de reservas.        |");
		this.printLine("|   0. Salir.                      |");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("//====Bienvenido a BLOCKBUSTER====\\\\");
	}

	/**
	 * muestra por consola el menu de Clientes.
	 */
	public void showClientMenu() {
		this.printLine("\\\\============Clientes============//");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("|   1. Introducir cliente.         |");
		this.printLine("|   2. Buscar clientes.            |");
		this.printLine("|   3. Eliminar cliente.           |");
		this.printLine("|   4. Actualizar cliente.         |");
		this.printLine("|   5. Mostrar clientes.           |");
		this.printLine("|   0. Volver atras.               |");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("//============Clientes============\\\\");
	}

	/**
	 * muestra por consola el menu de Articulos.
	 */
	public void showProductMenu() {
		this.printLine("\\\\============Productos===========//");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("|   1. Insertar producto.          |");
		this.printLine("|   2. Buscar producto.            |");
		this.printLine("|   3. Eliminar producto.          |");
		this.printLine("|   4. Actualizar producto.        |");
		this.printLine("|   5. Mostrar productos.          |");
		this.printLine("|   0. Volver atras.               |");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("//============Productos===========\\\\");
	}

	/**
	 * muestra por consola el menu de Reservas.
	 */
	public void showReservationMenu() {
		this.printLine("\\\\===========Reservas=============//");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("|   1. Introducir reserva.         |");
		this.printLine("|   2. Buscar reserva.             |");
		this.printLine("|   3. Eliminar reserva.           |");
		this.printLine("|   4. Actualizar reserva.         |");
		this.printLine("|   5. Mostrar reservas.           |");
		this.printLine("|   0. Volver atras.               |");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("//============Reservas============\\\\");

	}

	/**
	 * muestra por pantalla el menu de Copias.
	 */
	public void showItemMenu() {
		this.printLine("\\\\============Copias==============//");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("|   1. Introducir copia.           |");
		this.printLine("|   2. Buscar copia.               |");
		this.printLine("|   3. Eliminar copia.             |");
		this.printLine("|   4. Actualizar copia.           |");
		this.printLine("|   5. Mostrar copias.             |");
		this.printLine("|   0. Volver atras.               |");
		this.printLine("@~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~@");
		this.printLine("//==============Copias============\\\\");
	}

	/**
	 * muestra por pantalla el mensaje.
	 */
	public void showMessage(String message) {
		System.out.println(message);
	}

	/**
	 * muestra un mensaje que valida que sea decimal.
	 */
	public float validateFloat(String message) {
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
	 * @param message valida que se introduzca un nÃºmero de telÃ©fono.
	 * @return devuelve el conjunto introducido y sea correcto.
	 */
	public String validatePhone(String message) {
		return IOUtils.validatePhone(message);
	}
	
	/**
	 * Metodo que pide un numero por tecado y valida que sea entero y se encuemtre
	 * entre dos rangos.
	 * 
	 * @param Hace  referencia a la frase que mostrarï¿½ para pedir el valor.
	 * @param Rango minimo en el que puede estar el numero.
	 * @param Rango maximo en el que puede estar el numero.
	 * @return devuelve un numero entero positivo vï¿½lido.
	 */
	public int validateRangeInt(String message, int min, int max) {
		return IOUtils.validateRangeInt(message, min, max);
	}
	
	/**
	 * Lee un string del teclado
	 * 
	 * @return el string introducido
	 */
	public String readString(String texto) {
		return IOUtils.readString(texto);
	}
}

