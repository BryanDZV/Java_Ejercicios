package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio3_division {

	public static void main(String[] args) {
		// Escriba un programa en Java para dividir
		//dos números e imprimirlos en la pantalla.
		
		System.out.println("division de dos numero");
		
		int a=Entrada.entero();
		int b=Entrada.entero();
		
		int resultado=a/b;
		
		System.out.println("resultado:"+(resultado));

	}

}
