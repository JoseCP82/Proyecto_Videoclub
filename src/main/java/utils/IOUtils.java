package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IOUtils {

	/**
	 * Metodo que pide un numero por tecado y valida que sea decimal y positivo.
	 * 
	 * @param hace referencia a la frase que mostrará para pedir el valor.
	 * @return devuelve un numero decimal positivo válido.
	 */
	public static float validatePositiveFloat(String frase) {
		Scanner sc = new Scanner(System.in);
		float numero = 0;
		boolean valido = false;
		do {
			try {
				System.out.print(frase);
				numero = sc.nextFloat();
				valido = true;
				if (numero < 0) {
					System.out.println("El número no puede ser negativo.");
				}
			} catch (InputMismatchException ex) {
				System.out.println("Dato incorrecto.");
				sc.next();
			}
		} while (!valido || numero < 0);

		// sc.close();
		return numero;
	}

	/**
	 * Metodo que pide un numero por tecado y valida que sea entero.
	 * 
	 * @param hace referencia a la frase que mostrará para pedir el valor
	 * @return devuelve un numero entero válido
	 */
	public static int validateInt(String frase) {
		Scanner sc = new Scanner(System.in);
		int numero = 0;
		boolean valido = false;

		do {
			try {
				System.out.print(frase);
				numero = sc.nextInt();
				valido = true;
			} catch (InputMismatchException ex) {
				System.out.println("Dato incorrecto.");
				sc.next();
			}
		} while (!valido);

		// sc.close();
		return numero;
	}

	/**
	 * Metodo que pide un numero por tecado y valida que sea entero y positivo.
	 * 
	 * @param hace referencia a la frase que mostrará para pedir el valor.
	 * @return devuelve un numero entero positivo válido.
	 */
	public static int validatePositiveInt(String frase) {
		Scanner sc = new Scanner(System.in);
		int numero = 0;
		boolean valido = false;

		do {
			try {
				System.out.print(frase);
				numero = sc.nextInt();
				valido = true;
				if (numero < 0) {
					System.out.println("El número no puede ser negativo.");
				}
			} catch (InputMismatchException ex) {
				System.out.println("Dato incorrecto.");
				sc.next();
			}
		} while (!valido || numero < 0);

		// sc.close();
		return numero;
	}

	/**
	 * Metodo que pide un numero por tecado y valida que sea entero y se encuemtre
	 * entre dos rangos.
	 * 
	 * @param Hace  referencia a la frase que mostrará para pedir el valor.
	 * @param Rango minimo en el que puede estar el numero.
	 * @param Rango maximo en el que puede estar el numero.
	 * @return devuelve un numero entero positivo válido.
	 */
	public static int validateRangeInt(String frase, int minimo, int maximo) {
		Scanner sc = new Scanner(System.in);
		int numero = 0, aux = 0;
		boolean valido = false;

		if (minimo > maximo) { // Validamos que el número mínimo y máximo corespondan con sus valores.
			aux = minimo;
			minimo = maximo;
			maximo = aux;
		}

		do {
			try {
				System.out.print(frase);
				numero = sc.nextInt();
				valido = true;
				if (numero < minimo || numero > maximo) {
					System.out.println("El número debe estar comprendido entre " + minimo + " y " + maximo + ".");
				}
			} catch (InputMismatchException ex) {
				System.out.println("Dato incorrecto.");
				sc.next();
			}
		} while (!valido || numero < minimo || numero > maximo);

		// sc.close();
		return numero;
	}

	/**
	 * Muestra por consola "Pulsa intro" y solo acepta presionar dicha tecla para
	 * continuar
	 */
	public static void pressIntro() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Pulsa intro para continuar...");
		sc.nextLine();
		System.out.println();
	}

	/**
	 * Lee un string del teclado
	 * 
	 * @return el string introducido
	 */
	public static String readString(String texto) {
		Scanner sc = new Scanner(System.in);
		System.out.print(texto);
		return sc.next();
	}

	/**
	 * Lee un string del teclado y valida que no está vacío
	 * 
	 * @return el string introducido
	 */
	public static String readEmptyString(String texto) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		do {
			System.out.print(texto);
			result = sc.nextLine();
			if (result.isEmpty()) {
				System.out.println("El campo no puede estar vacío.");
			}
		} while (result.isEmpty());
		return result;
	}

	/**
	 * Muestra por una frase y valida si el caracter introducido es 'S' o 's' o 'N'
	 * o 'n'
	 * 
	 * @param frase Frase a mostrar
	 * @return Caracter válido seleccionado
	 */
	public static char validateExit(String frase) {
		Scanner sc = new Scanner(System.in);
		char salida = ' ';
		do {
			System.out.print(frase);
			salida = sc.next().charAt(0);
			if (salida != 'S' && salida != 's' && salida != 'N' && salida != 'n') {
				System.out.println("Opcionn incorrecta.\nIntroduzca (S/N).");
			}
		} while (salida != 'S' && salida != 's' && salida != 'N' && salida != 'n');
		return salida;
	}

	/**
	 * Comprueba que el DNI introducido sea correcto
	 * 
	 * @param frase que se introducirá¡
	 * @return devuelve que el dni este escrito de forma correcta.
	 */
	public static String validateDni(String frase) {
		Scanner sc = new Scanner(System.in);
		String dni = "";
		boolean invalido = false;
		do {
			System.out.print(frase);
			dni = sc.next();
			//readEmptyString(dni);
			if (dni.matches("^[0-9]{8}[\\w]{1}$")) {
				invalido = true;
			} else {
				System.out.println("el DNI " + dni + " no es válido");
			}
		} while (!invalido);

		return dni;

	}

	/**
	 * valida que la frase introducida solo sean numeros
	 * 
	 * @param frase numero a introducir
	 * @return devuelve la cadena que solo admite numeros
	 */
	public static String validatePhone(String frase) {
		Scanner sc = new Scanner(System.in);
		boolean invalido = false;
		String number = "";

		do {
			System.out.print(frase);
			number = sc.next();
			/*
			if (number.matches("^[0-9][^\\Sa-zA-Z]$")) {
				invalido = true;
			} else {
				System.out.println("no se permiten letras");
			}
			*/
			invalido=true;
		} while (!invalido);

		return number;
	}

	/**
	 * comprueba que se introduzcan solo texto con espacios
	 * 
	 * @param frase texto que se introducirá
	 * @return devuelve el texto
	 */
	public static String validateString(String frase) {
		Scanner sc = new Scanner(System.in);
		boolean invalido = false;
		String txt = "";
		do {
			System.out.print(frase);
			txt = sc.next();
			if (txt.matches("^[a-zA-Z\\s]\\D$")) {
				invalido = true;
			} else {
				System.out.println("No se permiten números");
			}
		} while (!invalido);

		return txt;
	}

	/**
	 * comprueba que la clave tenga tres letras en mayuscula un guion y 4 digitos
	 * @param frase que se introducira
	 * @return devuelve la clave
	 */
	public static String validateKey(String frase) {
	
		Scanner sc = new Scanner(System.in);
		boolean invalido = false;
		String key= "";
		do {
			System.out.print(frase);
			key = sc.next();
			if (key.matches("^[A-Z]{3,3}[-]{1,1}[0-9]{4,4}$")) {
				invalido = true;
			} else {
				System.out.print("la clave tiene que estar en este formato (AAA-9999) ");
			}
		} while (!invalido);
		
		return key;
	}

	/**
	 * comprueba que el nombre introducido empiece por mayuscula y tenga 2 digitos
	 * 
	 * @param frase nombre que se introducirá
	 * @return devuelve el nombre
	 */
	public static String validateName(String frase) {
		Scanner sc = new Scanner(System.in);
		boolean invalido = false;
		String name = "";
		do {
			System.out.print(frase);
			name = sc.next();
			if (name.matches("^[A-Z][a-z][0-9]{2,2}$")) {
				invalido = true;
			} else {
				System.out.println("Tiene que empezar en Mayuscula y como maximo puede tener 2 digitos");
			}
		} while (!invalido);

		return name;
	}

}
