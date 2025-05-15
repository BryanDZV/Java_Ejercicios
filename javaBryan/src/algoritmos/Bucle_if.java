package algoritmos;

import utilidades.Entrada;

public class Bucle_if {
	public static void main(String[] args) {
		int n;

		System.out.print("Introduzca un numero:");
		n = Entrada.entero();
		if (n > 10) {
			System.out.println("grande");
			System.out.println("grande");
			System.out.println("grande");
			System.out.println("grande");

		} // end if
		else {
			System.out.println("pequeño1");
			System.out.println("pequeño2");

		} // end else si no hay parentesis solo se lee pequeño 2 al estar fuera de los bucles
	}//end main
}//end class
