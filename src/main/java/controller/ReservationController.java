package controller;

import java.sql.Date;
import java.time.LocalDate;

import utils.IOUtils;

public class ReservationController {
	
	/**
	 * Método que inicia el uso de la clase. Muestra el menú referente a las
	 * opciones de Reservas. Obtiene la opción elegida.
	 */
	public void run() {
		int option = -1;
		do {
			// gui.showReservationMenu();
			option = utils.IOUtils.validaEntero("Elija una opción: ", 0, 5); //Modificar y usar el metodo de la clase Gui
			switchOption(option);
		} while (option != 0);
		
		IOUtils.pulsaIntro();
		
	}
	
	/**
	 * Método que implementa un switch en el cual se llaman a otros métodos para la
	 * gestión de reservas.
	 * 
	 * @param Opción elegida por el usuario.
	 */
	public void switchOption(int option) {
		
	}
}
