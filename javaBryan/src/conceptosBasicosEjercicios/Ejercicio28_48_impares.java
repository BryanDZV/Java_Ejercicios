package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio28_48_impares {

	public static void main(String[] args) {
		// Escriba un programa Java para imprimir números
		// impares del 1 al 99. Imprime un número por línea.
		
		System.out.println("introduce dos numeros para sacar los pares que hay entre ellos");
		int num1=Entrada.entero();
		int num2=Entrada.entero();
		
		System.out.println(FuncionesConceptos.imparesRango(num1, num2));
		

	}

}
