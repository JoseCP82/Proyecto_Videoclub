package controller;

import java.sql.Date;
import java.time.LocalDate;

import utils.IOUtils;

public class ReservationController {
	
	/**
	 * M�todo que inicia el uso de la clase. Muestra el men� referente a las
	 * opciones de Reservas. Obtiene la opci�n elegida.
	 */
	public void run() {
		int option = -1;
		do {
			// gui.showReservationMenu();
			option = utils.IOUtils.validaEntero("Elija una opci�n: ", 0, 5); //Modificar y usar el metodo de la clase Gui
			switchOption(option);
		} while (option != 0);
		
		IOUtils.pulsaIntro();
		
	}
	
	/**
	 * M�todo que implementa un switch en el cual se llaman a otros m�todos para la
	 * gesti�n de reservas.
	 * 
	 * @param Opci�n elegida por el usuario.
	 */
	public void switchOption(int option) {
		
	}
}
