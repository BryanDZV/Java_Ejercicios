package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio48_63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Valor más grande o más pequeño
		 * 
		 * Escriba un programa Java que acepte dos valores enteros del usuario y
		 * devuelva el valor más grande. Sin embargo, si los dos valores son iguales,
		 * devuelva 0 y encuentre el valor más pequeño si los dos valores tienen el
		 * mismo resto al dividirlos por 6. Ejemplo de salida:
		 * 
		 * Ingrese el primer número: 12 Ingrese el segundo número: 13 Resultado: 13
		 */
		/*
		 * 0 cual es mas grande 1 compara los dos valores{iguales numeros digo 0} 2
		 * hacer el modulo con 6 con mismo resto decir cual es el mas pequeño
		 */
		System.out.println("introduzca 2 numeros");
		int numA = Entrada.entero();
		int numB = Entrada.entero();

		System.out.println(valorMasGrandeOMasPeque(numA, numB));

	}

	public static int valorMasGrandeOMasPeque(int numA, int numB) {
		// TODO Auto-generated method stub
		int resultado = 0;
		int resto1 = numA % 6;
		int resto2 = numB % 6;
		/*
		 * // mas grande
		 * 
		 * if (numA > numB) { resultado = numA; } else { resultado = numB; } // fin 1
		 * 
		 * // comprobar si son iguales if (numA == numB) { resultado = 0;
		 * 
		 * } // fin 2 // comprobar resto else if (resto1 == resto2 && numA > numB) {
		 * resultado = numB;
		 * 
		 * } else { resultado = numA; } // fin else if
		 * 
		 * //return resultado;
		 */

		// metodo dos

		// Si los dos números son iguales, devolver 0
		if (numA == numB) {
			resultado = 0;
		}

		// Si los dos números tienen el mismo resto al dividirse por 6
		if (resto1 == resto2) {
			resultado = Math.min(numA, numB); // Devolver el valor más pequeño
		} else {
			// Devolver el valor más grande en cualquier otro caso
			resultado = Math.max(numA, numB);
		}

		return resultado;
	}// fin valorGRandePequeño

}
