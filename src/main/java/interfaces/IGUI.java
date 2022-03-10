package interfaces;

public interface IGUI {
	// Muestra el menú principal de la aplicación
	void showMainMenu();

	// Muestra el menu para la gestión de clientes
	void showClientMenu();

	// Muestra el menu para la gestión de productos
	void showProductMenu();

	// Muestra el menu para la gestión de reservas
	void showReservationMenu();

	// Muestra un mensaje dado por el usuario
	String showMessage(String message);

	// Pide con un mensaje que se introduzca un número enero positivo pudiendo
	// contener decimales
	float validateFloat(String message);

	// Pide con un mensaje que se introduzca una cadena de caracteres
	String validateString(String message);
	
}
