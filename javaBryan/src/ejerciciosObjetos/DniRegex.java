package ejerciciosObjetos;

import utilidades.Entrada;

public class DniRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TRIM SOLO QUITA ESPACIOS A LOS LADOS

		System.out.println("introduzca un dni");
		String dni = Entrada.cadena();

		String resultado = dniValido(dni);

		if (resultado == null) {
			System.out.println("DNI INCORRECTO :" + resultado);

		} else {
			System.out.println("DNI CORRECTO :" + resultado);
		}

	}

	public static String dniValido(String dni) {
		// TODO Auto-generated method stub
		// DEUELVE NORMALIZADO UN sTRING LA FUNCION
		// NULL SI ES IVALIDO

		// expresion regex
		String t = "([0-9]{1,7})?[0-9][a-zA-Z]";

		// 1 VALIDACION REGEX
		if (!dni.matches(t)) {
			System.out.println("Formato no válido");
			return null;
		}

		// 2 NORMALIZAR mayusculas dni
		String normalizado = dni.trim().toUpperCase();
		char[] normalizadoDos = new char[9];
		int indice = normalizado.length() - 1;

		// 3 RELLENADO DE CEROS
		for (int i = normalizadoDos.length - 1; i >= 0; i--) {
			if (indice >= 0) {
				// Accedemos a los caracteres del String con charAt
				normalizadoDos[i] = normalizado.charAt(indice);
				indice--;
			} else {
				// Rellenar con ceros si no hay más dígitos
				normalizadoDos[i] = '0';
			}
		}

		// 5CREO UN OBJETO STRING CON el array de char
		String dniNormalizado = new String(normalizadoDos);

		// array letra para control
		String[] arrayLetra = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q",
				"V", "H", "L", "C", "K", "E" };

		// 6 letra requsito
		String soloNumero = dni.substring(0, dni.length() - 1);
		int valorNumerico = Integer.parseInt(soloNumero);// Devuelve un valor primitivo int
		int resultado = valorNumerico % 23;
		// System.out.println("soy el resto"+resultado);

		// COICIDIR LETRA CON REQUISITO
		/*
		 * cada letra tiene un indice asignado en el array cada dni tiene una letra
		 * calculada y debe coincidir con la letra de idice asignado en el arrayLetra
		 * 
		 */

		// caracter en indice resultado en el arrayLetra
		String caracterArray = arrayLetra[resultado];

		// caracter de mi dni normalizado
		String letraDni = dniNormalizado.substring(dniNormalizado.length() - 1);

		/*
		 * NOTA cuando uso == para comparar objetos como String, estás verificando si
		 * ambas referencias apuntan al mismo objeto en memoria, no si los valores de
		 * las cadenas son iguales. Usa == para comparar referencias (¿es el mismo
		 * objeto?).
		 * 
		 * Usa equals() para comparar valores (¿tienen el mismo contenido?).
		 */

		// COMPARACION VALORES
		// ???0
		// String devolucion="";
		String devolucion = new String();

		if (letraDni.equals(caracterArray)) {

			// System.out.println("dni valido");
			devolucion = dniNormalizado;
		} else {
			// System.out.println("dni no valido");
			devolucion = null;
		}

		return devolucion;
	}

}
