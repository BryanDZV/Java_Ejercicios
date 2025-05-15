package parImpar;

import utilidades.Entrada;

public class ParImpar {

	public static void main(String[] args) {
		/*
		 * ParImpar Crea un algoritmo que solicite un número positivo (>0) al usuario, y
		 * nos muestre si el valor introducido es par o impar. Avisar al usuario con un
		 * mensaje en caso de introducir un número negativo.
		 */

		System.out.println("introducir un numero para saber si es impar o par");
		int numero = Entrada.entero();
		System.out.println(ParImpar(numero));
		/* VALIDACION */

		while (!(numero > 0)) {
			System.out.println("solo numero positivos");
			System.out.println("introduce un numero POSITIVO");
			numero = Entrada.entero();

		}
		
		/*control de resultado*/

		if (ParImpar(numero)) {
			System.out.println("el numero es par");
		} else {
			System.out.println("el numero es impar");
		}

	}

	private static boolean ParImpar(int numero) {
		String resultado = "";
		boolean validar = true;

		/* par o impar */

		if (numero % 2 == 0) {
			validar = true;

		} else {
			validar = false;
		}

		return validar;
	}

}
