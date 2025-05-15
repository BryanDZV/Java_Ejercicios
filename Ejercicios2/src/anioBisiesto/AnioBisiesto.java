package anioBisiesto;

import utilidades.Entrada;

public class AnioBisiesto {

	public static void main(String[] args) {

		/* validacion aqui */
		/*
		 * Crea un algoritmo que nos diga si un año es bisiesto. El usuario introducirá
		 * un año por teclado y se le mostrará por pantalla si lo es o no.
		 */

		/*
		 * si es divible por 4 es bisiesto factores y divisores de un nuemro son igual
		 * factores:a*c=b a y b son facores;divisores=b/a=0 bes divisor maximos factores
		 * o divisores de un numero = numero max divisores de 12 no puede tener mas de
		 * 12 para arriba es decir 1,2,3,4,6,12
		 * 
		 * PRIMOS TIENENN SOLO 2 DIVISORES
		 * 
		 */
		System.out.println("introduce un año para saber si es bisiesto");
		double anio = Entrada.entero();

		/* validacion */

		while (anio < 0) {
			System.out.println("solo años depues del año 0");
			System.out.println("introduce un año para saber si es bisiesto");
			anio = Entrada.entero();
		}

		if (anioBisiesto(anio)) {
			System.out.println("el año " + anio + " es bisiesto");

		} else {
			System.out.println("el año " + anio + " no es bisiesto");

		}

		System.out.println(anioBisiesto(anio));

	}

	private static boolean anioBisiesto(double anio) {

		/*
		 * divisibles entre 4, y lo que son divisibles entre 100 no son bisiestos, a
		 * menos que también sean divisibles entre 400
		 */
		 // Los años bisiestos son divisibles por 4, pero no por 100, a menos que también sean divisibles por 400
	    
		return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
	}}

