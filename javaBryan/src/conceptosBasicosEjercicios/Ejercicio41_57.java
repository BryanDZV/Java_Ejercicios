package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio41_57 {

	public static void main(String[] args) {
		// Contar factores de números enteros

//Escriba un programa Java que acepte un número entero y cuente los factores del número.
//Ejemplo de salida:

		System.out.println("introduzca un numero enetero");
		int numeroA = Entrada.entero();
		System.out.println("numero de facotres del numero " + numeroA + " es "
				+ FuncionesConceptos.factoresNumeroCantidad(numeroA));

	}

}
