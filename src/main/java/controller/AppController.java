package controller;

import gui.Gui;
import interfaces.IAppController;

public class AppController implements IAppController{
	
	Gui gui = new Gui();
	
	/**
	 * Método inicial del controlador.
	 * Muestra el menú principal y obtiene opción elegida.
	 */
	public void appInit() {
		int option=-1;
		do {
			gui.showMainMenu();
			option=utils.IOUtils.validateRangeInt("Elija una opción: ",0,4);
			switchOption(option);
			
		}while(option!=0);
	}

	/**
	 * Metodo que implementa un switch en el cual se llaman a otros controladores de la aplicación.
	 * 
	 * @param Opción elegida por el usuario.
	 */
	public void switchOption(int option) {
		gui.showMessage("");
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
				gui.showMessage("Aplicación finalizada.\nHasta pronto.");
				break;
			default:
				gui.showMessage("Opción incorrecta.");
		}
	}
}
