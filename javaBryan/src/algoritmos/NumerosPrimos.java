package algoritmos;

import utilidades.Entrada;

public class NumerosPrimos {

	public static void main(String[] args) {

		/*
		 * Algoritmo NumeroPrimo Definir n, divisor, cnt Como Entero Escribir "Número?"
		 * Leer n Si n>=1 Entonces //Algoritmo primo divisor=2 cnt=0; //Número de
		 * divisiones que producen resto 0 Mientras divisor<=n-1 Hacer Si n%divisor==0
		 * Entonces cnt=cnt+1 Fin Si divisor=divisor+1 Fin Mientras //Decimos si el
		 * número es primo o no según el valor de cnt Si cnt>0 | n==1 Entonces Escribir
		 * "NO ES PRIMO" SiNo Escribir "ES PRIMO" Fin Si SiNo Escribir
		 * "El número debe ser mayor que 0" Fin Si
		 * 
		 * FinAlgoritmo
		 */

		int n, divisor, cnt;// entero

		// LEER
		System.out.println("Numero?");
		n = Entrada.entero();
		// algoritmo primo

		if (n >= 1) {
			divisor = 2;
			cnt = 0;
			while (divisor <= n - 1 && cnt == 0) {
				if (n % divisor == 0) {
					System.out.println(n + " es divisible entre " + divisor);
					cnt++;

				} // end if dentro de while
				divisor++;

			} // end while
				// según valor de cnt primo o no
			if (cnt > 0 || n == 1) {
				System.out.println("No es primo");

			} else {
				System.out.println("es primo");

			}
		} // end if
		else {
			System.out.println("El número debe ser mayor que 0");

		} // end else
	}// end main

}// end class
