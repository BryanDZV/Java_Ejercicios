package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio42_57 {

	public static void main(String[] args) {
		// FACTOR DE UN NUMERO A, SON OTROS QUE MILTIPLICADOS ENTRE ELLOS DAN A
		// DISIVBLE UN NUMERO ES DIVISIBLE ENTRE OTRO CUANDO SU MODULO DA 0 ES DECIR
		// AL HACER LA SIVION DA DE RESTO 0
		// Es correcto:
		// - Todos los factores de un número lo dividen sin dejar residuo.
		// - Los divisores de un número son los números que lo dividen exactamente (sin
		// residuo).
		// - Los factores son los números que, multiplicados entre sí en distintas
		// combinaciones, dan el número.
		;
		System.out.println("INTRODUZCA UN NÚMERO:");
		int numero = Entrada.entero();

		// Llamamos al método para calcular los factores
		int[] factores = FuncionesConceptos.factoresLosNumeros(numero);
		int contadorFactores = 0;
		// Imprimimos los factores
		System.out.println("Factores del número " + numero + " veo dentro del array son:");

		for (int factor : factores) {
			System.out.println(factor);
			contadorFactores = factores.length;

		}

		System.out.println("total factores: " + contadorFactores);
	}
}
