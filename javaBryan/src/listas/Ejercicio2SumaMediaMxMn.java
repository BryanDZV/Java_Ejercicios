package listas;

import java.util.ArrayList;
import java.util.Random;

import utilidades.Entrada;

public class Ejercicio2SumaMediaMxMn {

	public static void main(String[] args) {
		/**
		 * Ejercicio 2 Realiza un programa que introduzca valores aleatorios (entre 0 y
		 * 100) en un ArrayList y que luego calcule la suma, la media, el máximo y el
		 * mínimo de esos números. El número de elementos de la lista también será
		 * aleatorio y podrá oscilar entre 10 y 20 elementos ambos inclusive.
		 */

		/**
		 * crear un arrayList rellenear con valor entre 0 y 100 aleatorios el tamaño del
		 * array sera de entre 10 y 20 elementos primero elegio el tamaño del array
		 * luego releno de numer seugn el tamaño calcular
		 */

		ArrayList<Integer> lista = new ArrayList<Integer>();
		Random rad = new Random();

		int nelementos = rad.nextInt(11) + 10;

		for (int i = 0; i < nelementos; i++) {
			lista.add(rad.nextInt(101));

		}

		/* suma */
		int suma = 0;
		for (Integer elemento : lista) {
			suma += elemento;
		}
		/* media */
		int media = suma / nelementos;
		/* maximo y minimo */
		int max = lista.get(0);
		int min = lista.get(0);
		for (Integer elemento : lista) {
			if (elemento > max) {
				max = elemento;
			}
			if (elemento < min) {
				min = elemento;

			}
		}
		
		System.out.println("la suma es: "+suma+"\n"+ "la media es: "+ media+ "\n"+ "el max es :"+max+"\n"+ "el min es:"+min);

	}
}
