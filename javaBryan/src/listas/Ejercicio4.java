package listas;

import java.util.ArrayList;
import java.util.Iterator;

import utilidades.Entrada;

public class Ejercicio4 {

	public static void main(String[] args) {
		/**
		 * Ejercicio 4 Realiza un programa equivalente al anterior, pero en esta ocasión
		 * el programa debe ordenar palabras en lugar de números. Se mostrará la lista
		 * de palabras ordenada. Se borrarán las palabras de la lista que contengan la
		 * letra M (mayúscula o minúscula). Volver a mostrar la lista tras el borrado.
		 */

		ArrayList<String> lista = new ArrayList<String>();
		while (lista.size() != 5) {
			System.out.println("introduce 5 palabras y los ordenamos");
			String palabra = Entrada.cadena();
			lista.add(palabra);
		}
		/* sin ordenar */
		System.out.println("sin ordenar" + "\n" + lista);

		/* ordenar y sin las palabras que tengan la letra M o m */
		/**
		 * sort con null aqui no necesito comprable porque la lista es Integer y ya
		 * tiene por defecto el comprable
		 */
		/*
		 * recorrer el array y sacar la palabra recorrecor la palabra y mirar si tiene
		 * la la m pasar a minusculas devolver el array si la palabra con m recorrer al
		 * reves para evitar el problema del indice de desplazamiento al ir borrando
		 */
		for (int i = lista.size() - 1; i >= 0; i--) {
			String palabra = lista.get(i);
			if (palabra.contains("m")) {
				lista.remove(i);
			}

		}

		lista.sort(null);
		System.out.println("ordenada y eliminando" + "\n" + lista);

	}

}
