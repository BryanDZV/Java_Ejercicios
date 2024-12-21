package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio50_65 {

	public static void main(String[] args) {
		/*
		 * Módulo personalizado
		 * 
		 * Escriba un programa Java para calcular los módulos de dos números sin
		 * utilizar ningún operador de módulo incorporado.
		 */

		System.out.println("introduce 2 numeros");
		int numA = Entrada.entero();
		int numB = Entrada.entero();

		System.out.println(moduloPersonalizado(numA, numB));

	}

	private static int moduloPersonalizado(int numA, int numB) {
		// TODO Auto-generated method stub
		/*
		 * 1- divir los numeros de 1 a n {for¿?
		 * 
		 * 2-resto=dividendo-(divisor*cociente) 3. RESULTADO DE LA DIVISION TRUNCADO
		 * USAR. NO IGUAL Q UNA CALCULADORA NORMAL
		 */

		int cociente = numA / numB;
		int resultado = numA - (numB * cociente);

		return resultado;

	}

}
