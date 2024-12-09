package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio42_57 {

	public static void main(String[] args) {
		// FACTOR DE UN NUMERO A, SON OTROS QUE MILTIPLICADOS ENTRE ELLOS DAN A
		// DISIVBLE UN NUMERO ES DIVISIBLE ENTRE OTRO CUANDO SU MODULO DA 0 ES DECIR
		// AL HACER LA SIVION DA DE RESTO 0
		// todos los factores de un número lo dividen sin dejar residuo
		// los factores de un número son los números que lo dividen exactamente (sin
		// residuo)

		System.out.println("INTRODUZCA UN NUMERO");
		int numero = Entrada.entero();

		// int numero = 45;
		int[] factores = FuncionesConceptos.factoresNumero(numero);
		System.out.println(factores);
		for (int i = 0; i < factores.length; i++) {
			switch (i) {

			case 0:

				break;
			default:
				System.out.println(factores[i]);
				break;
			}

		} // fin for

	}
}
