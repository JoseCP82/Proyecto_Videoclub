package interfaces;

public interface IGUI {
	// Muestra el men� principal de la aplicaci�n
	void showMainMenu();

	// Muestra el menu para la gesti�n de clientes
	void showClientMenu();

	// Muestra el menu para la gesti�n de productos
	void showProductMenu();

	// Muestra el menu para la gesti�n de reservas
	void showReservationMenu();
	
	// Muestras el menu para la gestión de copias
	void showItemMenu();

	// Muestra un mensaje dado por el usuario
	void showMessage(String message);

	// Pide con un mensaje que se introduzca un n�mero enero positivo pudiendo
	// contener decimales
	float validateFloat(String message);

	// Pide con un mensaje que se introduzca una cadena de caracteres
	String validateString(String message);

}
