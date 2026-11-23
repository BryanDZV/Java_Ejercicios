package practica1;

import utilidades.Entrada;
import utilidades.Estaticos;
import utilidades.Funciones;

public class Main {

	public static void main(String[] args) {

		/*String resultado = Estaticos.intro(4, "Módulo ejecutándose");
		System.out.println(resultado);

		int maximo = Estaticos.maximo(1, 0);
		System.out.println(maximo);

		int maximo3 = Estaticos.maximo(1, 0, 5);
		System.out.println(maximo3);*/

		/*
		 * Crea un programa que calcule el factorial de un número entero positivo usando
		 * un método.
		 * 
		 * Condiciones
		 * 
		 * Si el número es negativo → error
		 * 
		 * Usa un método que devuelva el resultado
		 */

		System.out.println("factorial de :");
		int numero = Entrada.entero();

		try {
			int factorial = Funciones.calculoFactorial(numero);
			System.out.println("hola"+factorial);
		} catch (IllegalArgumentException e) {
			System.out.println("no puede haber negativos  ---"+e.getMessage()); 
		}

	}

}
