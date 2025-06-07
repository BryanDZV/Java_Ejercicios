package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio2_suma {

	public static void main(String[] args) {
		// 2. Escriba un programa Java para imprimir la suma de dos números.
		
		System.out.println("Da dos números y te los sumo");
		System.out.println("numero a");
		int a=Entrada.entero();
		System.out.println("numero b");
		int b=Entrada.entero();
		
		System.out.println("la suma es:"+(a+b));

	}

}
