package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio38_53 {

	public static void main(String[] args) {
		/*Escriba un programa Java que acepte tres
		*números enteros del usuario. Devuelve verdadero
		*si el segundo número es mayor que el primero y el
		*tercer número es mayor que el segundo. Si "abc" es
		*verdadero, no es necesario que el segundo número 
		sea mayor que el primero.*/
		
		System.out.println("introduzca 3 numeros");
		
		System.out.println("introduzca primer numero");
		int numA=Entrada.entero();
		System.out.println("introduzca segundo numero");
		int numB=Entrada.entero();
		System.out.println("introduzca tercer numero");
		int numC=Entrada.entero();
		
		if (FuncionesConceptos.comparacionNumeros(numA,numB,numC)) {
			System.out.println("Verdadero");
			
		}else {
			System.out.println("no se cumple la condicion ");
		}

		 

	}

	

}
