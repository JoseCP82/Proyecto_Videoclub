package utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOUtils {

	/**
	 * Metodo que pide un numero por tecado y valida que sea decimal y positivo.
	 * 
	 * @param hace referencia a la frase que mostrar� para pedir el valor.
	 * @return devuelve un numero decimal positivo v�lido.
	 */
	public static float validaFloatPositivo(String frase) {
		Scanner sc = new Scanner(System.in);
		float numero = 0;
		boolean valido = false;
		do {
			try {
				System.out.print(frase);
				numero = sc.nextFloat();
				valido = true;
				if (numero < 0) {
					System.out.println("El n�mero no puede ser negativo.");
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
	 * @param hace referencia a la frase que mostrar� para pedir el valor
	 * @return devuelve un numero entero v�lido
	 */
	public static int validaEntero(String frase) {
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
	 * @param hace referencia a la frase que mostrar� para pedir el valor.
	 * @return devuelve un numero entero positivo v�lido.
	 */
	public static int validaEnteroPositivo(String frase) {
		Scanner sc = new Scanner(System.in);
		int numero = 0;
		boolean valido = false;

		do {
			try {
				System.out.print(frase);
				numero = sc.nextInt();
				valido = true;
				if (numero < 0) {
					System.out.println("El n�mero no puede ser negativo.");
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
	 * @param Hace  referencia a la frase que mostrar� para pedir el valor.
	 * @param Rango minimo en el que puede estar el numero.
	 * @param Rango maximo en el que puede estar el numero.
	 * @return devuelve un numero entero positivo v�lido.
	 */
	public static int validaEntero(String frase, int minimo, int maximo) {
		Scanner sc = new Scanner(System.in);
		int numero = 0, aux = 0;
		boolean valido = false;

		if (minimo > maximo) { // Validamos que el n�mero m�nimo y m�ximo corespondan con sus valores.
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
					System.out.println("El n�mero debe estar comprendido entre " + minimo + " y " + maximo + ".");
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
	public static void pulsaIntro() {
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
	public static String leeString(String texto) {
		Scanner sc = new Scanner(System.in);
		System.out.print(texto);
		return sc.nextLine();
	}

	/**
	 * Lee un string del teclado y valida que no est� vacio
	 * 
	 * @return el string introducido
	 */
	public static String leeStringVacio(String texto) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		do {
			System.out.print(texto);
			result = sc.nextLine();
			if (result.isEmpty()) {
				System.out.println("El campo no puede estar vac�o.");
			}
		} while (result.isEmpty());
		return result;
	}

	/**
	 * Muestra por una frase y valida si el caracter introducido es 'S' o 's' o 'N'
	 * o 'n'
	 * 
	 * @param frase Frase a mostrar
	 * @return Caracter v�lido seleccionado
	 */
	public static char validateExit(String frase) {
		Scanner sc = new Scanner(System.in);
		char salida = ' ';
		do {
			System.out.print(frase);
			salida = sc.next().charAt(0);
			if (salida != 'S' && salida != 's' && salida != 'N' && salida != 'n') {
				System.out.println("Opci�n incorrecta.\nIntroduzca (S/N).");
			}
		} while (salida != 'S' && salida != 's' && salida != 'N' && salida != 'n');
		return salida;
	}

	/**
	 * Comprueba que el DNI introducido sea correcto
	 * 
	 * @param dni que se introducirá
	 * @return devuelve que el dni este escrito de forma correcta.
	 */
	public static String validateDni(String frase) {
		Scanner sc = new Scanner(System.in);
		String dni = "";
		boolean invalido = false;
		do {
			System.out.println(frase);
			dni = sc.next();
			leeStringVacio(dni);
			if (dni.matches("^[0-9]{8}[\\w]{1}$")) {
				invalido = true;
			} else {
				System.out.println("el DNI " + dni + " no es válido");
			}
		} while (!invalido);

		return dni;

	}

}
