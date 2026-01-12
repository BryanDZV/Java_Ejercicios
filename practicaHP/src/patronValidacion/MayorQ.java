package patronValidacion;

import utilidades.Entrada;

public class MayorQ {

	public static void main(String[] args) {

		/*
		 * ParImpar Crea un algoritmo que solicite un número positivo (>0) al usuario, y
		 * nos muestre si el valor introducido es par o impar. Avisar al usuario con un
		 * mensaje en caso de introducir un número negativo.
		 */
		
		
		System.out.println("numtero");
		int numero=Entrada.entero();
		while (numero<0) {
			System.out.println("numtero");
		 numero=Entrada.entero();
		}
		
		if(numero%2==0) {
			System.out.println("es par");
		}else {
			System.out.println("es impar");
		}
	}

}
