package controller;

import gui.Gui;
import interfaces.IAppController;

public class AppController implements IAppController{
	
	Gui gui = new Gui();
	
	/**
	 * M�todo inicial del controlador.
	 * Muestra el men� principal y obtiene opci�n elegida.
	 */
	public void appInit() {
		int option=-1;
		do {
			//gui.showMainMenu();
			option=utils.IOUtils.validaEntero("Elija una opci�n: ",0,4); //Modificar y usar el metodo de la clase Gui
			switchOption(option);
		}while(option!=0);
	}

	/**
	 * Metodo que implementa un switch en el cual se llaman a otros controladores de la aplicaci�n.
	 * 
	 * @param Opci�n elegida por el usuario.
	 */
	public void switchOption(int option) {
		switch(option) {
			case 1:
				new ClientController().run();
				break;
			case 2:
				new ProductController().run();
				break;
			case 3:
				new ItemController().run();
				break;
			case 4:
				new ReservationController().run();
				break;
			case 0:
				//gui.showMessage("Aplicaci�n finalizada.\nHasta pronto.");
				break;
			default:
				//gui.showMessage("Opci�n incorrecta.");
		}
	}
}
