package listas;

import java.util.ArrayList;

import utilidades.Entrada;

public class Ejercicio3SortInteger {

	public static void main(String[] args) {
		/**
		 * Ejercicio 3 Escribe un programa que ordene 5 números enteros introducidos por
		 * teclado y almacenados en un objeto de la clase ArrayList.
		 */
		
		/**
		 * crear una lista para almacenar los numero
		 * pedir 5 nmero por teclado
		 * ordenar con sort por null*/
		
		ArrayList<Integer> lista=new ArrayList<Integer>();
		while (lista.size()!=5) {
			System.out.println("introduce 5 numero y los ordenamos");
			int num=Entrada.entero();
			lista.add(num);
		}
		System.out.println(lista);
		/*ordenar*/
		/**
		 * sort con null aqui no necesito comprable porque la lista es Integer y ya tiene por defecto el comprable*/
		lista.sort(null);
		System.out.println(lista);
		

	}

}
