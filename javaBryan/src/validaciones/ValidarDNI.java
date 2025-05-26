package validaciones;

import utilidades.Entrada;

public class ValidarDNI {
	/* El usuario introduce un DNI. Debe tener 8 dígitos y 1 letra al final. */
	public static void main(String[] args) {
		boolean salir = false;

		while (!salir) {
			System.out.println("intrduzca un dni valido");
			String dato = Entrada.cadena();
			boolean dni = dato.matches("[0-9]+[A-Z]{1}");
			boolean longitud = dato.length() == 9;
			if (dni && longitud) {
				System.out.println("dni valido");

			} else {
				System.out.println("no valido");
			}

		}
		
		
		System.out.println("Introduce DNI (formato 12345678A):");
		String dni = Entrada.cadena().toUpperCase();

		if (dni.length() == 9) {
		    String numeros = dni.substring(0, 8);
		    char letra = dni.charAt(8);
		    if (numeros.matches("[0-9]+{8}") && Character.isLetter(letra)) {
		        System.out.println("DNI válido");
		    } else {
		        System.out.println("Formato incorrecto");
		    }
		} else {
		    System.out.println("Longitud incorrecta");
		}


	}

}
