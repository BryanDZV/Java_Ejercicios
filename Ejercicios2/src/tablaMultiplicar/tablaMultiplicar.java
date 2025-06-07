package tablaMultiplicar;

import utilidades.Entrada;

public class tablaMultiplicar {

	public static void main(String[] args) {
/*1. TablaMultiplicarSinBucle
Crea un algoritmo que nos muestre la tabla de multiplicar
 de un número que introducirá el usuario por teclado.*/

		System.out.println("introduzca un numero para mostrar su tabla de multiplicar");
		int numero=Entrada.entero();
		
		System.out.println(tablaMultiplicar(numero));
		
	}

	private static String tablaMultiplicar(int numero) {
		String resultado = "";
		int contador=1;
		while (contador!=11) {
			
			  resultado+=numero*contador+" ";
			 contador++;
			// System.out.println(resultado);
			
		}
		
		
		
		
		
		return resultado;
	}

}
