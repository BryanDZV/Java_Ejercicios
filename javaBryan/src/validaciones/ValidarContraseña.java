package validaciones;

import utilidades.Entrada;

public class ValidarContraseña {
	/*
	 * Una contraseña válida debe tener:
	 * 
	 * Al menos 8 caracteres
	 * 
	 * Una mayúscula
	 * 
	 * Un número
	 */

	public static void main(String[] args) {

		while (true) {
			System.out.println("itrudce una contraseña valida");
			String dato = Entrada.cadena();
			boolean mayuscula = dato.matches(".*[A-Z].*");
			boolean numero = dato.matches(".*[0-9].*");
			boolean longitud = dato.length() == 8;
			if (mayuscula && numero && longitud) {
				System.out.println(" contraeña valida");

			} else {
				System.out.println("contraseña no valida");
			}
		}

	}

}
