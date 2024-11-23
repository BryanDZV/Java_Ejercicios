package algoritmos;

import utilidades.Entrada;

public class Ejercicio_9 {

	public static void main(String[] args) {
		System.out.println("cuantos Numeros");
		int n = Entrada.entero();
		double[] b = new double[n]; // array con decimales
		double suma = 0; // variable

		for (int i = 0; i < b.length; i++) {
			System.out.println("numero" + i + "?");
			b[i] = Entrada.entero();
			suma = suma + b[i];

		}
		// Mostrar numeros y resultado
		System.out.print("la media de: ");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i] + " ");

		}
		System.out.println("es " + suma / b.length);// si quiero solo resultado

	}

}
