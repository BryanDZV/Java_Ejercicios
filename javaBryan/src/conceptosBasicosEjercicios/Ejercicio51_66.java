package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio51_66 {

	public static void main(String[] args) {
		/*
		 * . Suma de 100 números primos
		 * 
		 * Escriba un programa Java para calcular la suma de los primeros 100 números
		 * primos.
		 * 
		 */

		System.out.println("indtroduce un numero desde donde empezar a sumar los 100 primeros numeros primos");

		int numA = Entrada.entero();

		System.out.println("la suma de los divisibles es :" + sumar100Primos(numA));

	}

	private static int sumar100Primos(int numA) {
		// TODO Auto-generated method stub

		/*
		 * Conceptos :: FACTORES DE UN NUMERO= NUMERO QUE SEPARAN AL NUMERO EN OTROS
		 * NUMEROS QUE al multiplicarse entre sí, producen el número original.,
		 * 
		 * DIVISBLES DE UN NUMERO= CUANDO SU RESTO ES 0 SIEMPRE COINCIDE DIVISBLES Y
		 * FACTORES DE UN NUMEROS
		 * 
		 * PRIMOS DE UN NUMERO= Tienen exactamente dos divisores con resto 0 No primos:
		 * Tienen más de dos divisores con resto 0 NUMERO PAR= AQUELLOS QUE SON
		 * DIVISBLES POR 2 NUMERO IMPAR =AQUELLOS QUE NO SON DIVISBLES POR 2
		 *
		 *
		 * 1- rango desde numA +100 numeros primeros{variable auxiliar, for} 2- contar
		 * los divisibles cada numero 3-si es rsto=0 aumentar en 1 el conteto divisbles
		 * 4- filtrar solo a 2 divisbles cuando conteo==2 4-si conteo ==2 es primo 5-si
		 * es primo sumar 3- ir sumando solo los primos
		 * 
		 */
		int sumaPrimos = 0; // Suma de los números primos
		int contadorPrimos = 0; // Contar los primos encontrados
		int i = numA; // Comenzar desde el número inicial

		while (contadorPrimos < 100) { // Continuar hasta encontrar 100 números primos
			int conteoDivisibles = 0;

			// Revisar divisores del número actual 'i'
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					conteoDivisibles++;
				}

				// Usar switch para salir si no es primo
				switch (conteoDivisibles) {
				case 3: // Más de 2 divisores, no es primo
					j = i; // Forzar salida del bucle
					break;
				}
			}

			// Si el número tiene exactamente 2 divisores, es primo
			if (conteoDivisibles == 2) {
				sumaPrimos += i; // Sumar el número primo
				contadorPrimos++; // Incrementar el conteo de primos encontrados
			}

			i++; // Pasar al siguiente número
		}

		return sumaPrimos;
	}

}
