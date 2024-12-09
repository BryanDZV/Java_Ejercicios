package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicios40_56 {

	public static void main(String[] args) {
		// Contar divisibles en el rango

//Escriba un programa Java para encontrar la cantidad de valores en un rango dado 
//que son divisibles por un valor dado.

		System.out.println("introduzca un rango y valor por el cual quieres divisibles");
		System.out.println("intruduzca rango x");
		int rangoX = Entrada.entero();
		System.out.println("introduzca rango y");
		int rangoY = Entrada.entero();
		System.out.println("introduzca el factor divisible");
		int divisible = Entrada.entero();

		System.out.println("cantidad de divisibles, por " + divisible + " es "
				+ FuncionesConceptos.divisibleRango(rangoX, rangoY, divisible));

	}

}
