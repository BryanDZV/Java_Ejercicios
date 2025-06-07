package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio6_tablaMultiplicar {

	public static void main(String[] args) {
		/*7. Escriba un programa Java que tome un número como
		 *  entrada e imprima su tabla de multiplicación hasta 10.*/

		System.out.println("Dame un numero y te digo la su tabla hasta el numero 10.");
		
		int a=Entrada.entero();
		
		int r=0;
		
		for (int i = 0; i <=10; i++) {
			
			r=(a*i);
			
			System.out.println(r);
			
		}
		
	}

}
