package controller;

import utils.IOUtils;

public class ReservationController {
	
	public void run() {
		/*
		int option = -1;
		do {
			// gui.showReservationMenu();
			option = utils.IOUtils.validaEntero("Elija una opción: ", 0, 5); //Modificar y usar el metodo de la clase Gui
			switchOption(option);
		} while (option != 0);
		*/
		
		System.out.println("En construcción");
		IOUtils.pulsaIntro();
		
		new AppController().appInit();
	}
	
	public void switchOption(int option) {
		
	}
}
