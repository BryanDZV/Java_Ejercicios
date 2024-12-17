package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio36_49 {

	public static void main(String[] args) {
		// Escriba un programa Java que acepte un 
		//número y verifique si es par o no. 
		//Imprime 1 si el número es par o 0 si es impar.

		System.out.println("introduzca un numero");
		int numero=Entrada.entero();
		
		while (numero<=0) {
			System.out.println("solo numeros positivos");
			System.out.println("vuelva a itroducir un numero");
			numero=Entrada.entero();
		}
		
		//System.out.println("el numero: "+FuncionesConceptos.verificarPar(numero)+"\n es par");
		if (FuncionesConceptos.verificarPar(numero)) {
			System.out.println("el numero es par");
		} else {
			System.out.println("no es Par");

		}
	}

	

}
