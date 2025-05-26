package validaciones;

import utilidades.Entrada;

public class ValidarPalabra {

	public static void main(String[] args) {
		// Ejercicio 9: Validar si una palabra contiene solo
		// letras y al menos una vocal

		System.out.println("introduce una palabra");
		
		boolean salir = false;
		while (!salir) {
			String dato = Entrada.cadena();
			if (!dato.matches("[A-Za-z]+") && !dato.matches("[áéíóúÁÉÍÓÚ]")) {
				System.out.println("solo letras");
				salir=false;
			} else {
				System.out.println("palabra valida ");
				salir=true;
			}
		}

	}

}
