package interfaces;

public interface IAppController {
	//Metodo que inicia la aplicación, se llama al menú principal
	void appInit();
	
	//Metodo que implementa un switch en el cual se llaman a otros controladores
	void switchOption(int option);
}
