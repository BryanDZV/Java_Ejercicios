package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio49_64 {

	public static void main(String[] args) {
		/*
		 * Dígito común en números
		 * 
		 * Escriba un programa Java que acepte dos valores enteros entre 25 y 75 y
		 * devuelva verdadero si hay un dígito común en ambos números.
		 */

		System.out.println("introduzca 2 numeros");
		int numA = Entrada.entero();
		int numB = Entrada.entero();

		if (digitoComun(numA, numB)) {
			System.out.println("verdadero");
		} else {
			System.out.println("falso");
		}

	}

	private static boolean digitoComun(int numA, int numB) {
		/*
		 * 1-extraer cada digito 2-compara digitos de los numeros?¿?¿ for, if?¿
		 * 
		 * 3-verdadero si alguno es igual
		 * 
		 * NOTA EQUAL COMPARA EL VALOR
		 * ==COMPARA REFERENCIAS
		 * PARA RECORRER UN STRING DEBES SACAR LOS CARACTERES PRIMERO
		 * 
		 */

		String numAstrin = "" + numA;
		String numBstrin = "" + numB;
		boolean resultado = false;

		// System.out.println(numAstrin + numBstrin);

		for (int i = 0; i <= numAstrin.length()-1; i++) {
			for (int j = 0; j <= numBstrin.length()-1; j++) {
				char  valori = numAstrin.charAt(i);
				String valoriStrin=Character.toString(valori);
				char valorj =numBstrin.charAt(j);
				String valorjStrin=Character.toString(valorj);


				if (valoriStrin.equals(valorjStrin)) {
					resultado = true;

				}

			}

		}

		return resultado;
	}

}
