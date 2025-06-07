package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio47_62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Comprueba la diferencia de la resta
		 * 
		 * Escriba un programa Java que acepte tres valores enteros y devuelva verdadero
		 * si uno es 20 o más menor que las restas de los otros
		 */

		System.out.println("introduzca 3 valores");
		int numA = Entrada.entero();
		int numB = Entrada.entero();
		int numC = Entrada.entero();

		System.out.println(FuncionesConceptos.compruebaDiferencia(numA, numB, numC));
	}

}
