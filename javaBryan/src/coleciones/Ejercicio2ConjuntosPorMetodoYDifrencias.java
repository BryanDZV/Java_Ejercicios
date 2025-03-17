package coleciones;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import utilidades.Entrada;

public class Ejercicio2ConjuntosPorMetodoYDifrencias {

	public static void main(String[] args) {
		/*
		 * 
		 * pedir numeros en forma de cadena en bucle hasta que cadena vacia fin crear
		 * una validacion que capture la exepcion crear un metodo y pasarle los datos de
		 * entrada en el metodo crear un conjunto de enteros pasar a int la cadena
		 * numero añadir al conjunto si ya existe lanzar ya existe
		 * 
		 */

		Set<Integer> set = new HashSet<Integer>();
		set = crearConjuntoNumeros("Conjunto 1");
		Set<Integer> set2 = new HashSet<Integer>();
		set2 = crearConjuntoNumeros("Conjunto 2");

		System.out.println("conjunto1" + set);
		System.out.println("conjunto2" + set2);

		/*
		 * Mostrar los números del conjunto 1 que no están en el conjunto 2. Mostrar los
		 * números del conjunto 2 que no están en el conjunto 1.
		 */
		/*
		 * recorro el c1 y recorro el conjunto2 con for each comparo si c1 tiene los
		 * elementos de c2 con contains implementar equasl y hascode CREAR UN LITA
		 * AUXILIAR guardar todo los numeros del c1 q no estan en el c2 y MOSTARLO HACER
		 * LO MISMO PARAEL C2
		 */
		System.out.println("******DIFERENCIA CON FOR EACH******");
		Set<Integer> set3 = new HashSet<Integer>();

		for (Integer elementoC1 : set) {

			if (!set2.contains(elementoC1)) {
				set3.add(elementoC1);
			}
			

		} // for ex
		System.out.println("****numeros del set que no estan en el set2:***\n" + set3);


		System.out.println("******DIFERENCIA CON REMOVEALL******");

		// Mostrar los números del conjunto 1 que no están en el conjunto 2
		/*
		 * diferencia1.removeAll(set2): elimina todos los elementos de set2 en
		 * diferencia1, dejando solo los que no están en set.
		 */
		Set<Integer> diferencia1 = new HashSet<>(set);//pasando el set como argumento estamos iniciado el conjunto difrencia1 con una copia de set pasdo como parametro
		diferencia1.removeAll(set2);//en diferencia1 quita todo lo que sea igual a set2 dejando en difrencia1 solo solo que no sea igual en set2
		System.out.println("Números en set que no están en set2 : \n" + diferencia1);

	}// main

	private static Set<Integer> crearConjuntoNumeros(String string) {
		System.out.println("introdusca numero enter (enter para salir)");

		Set<Integer> set = new HashSet<Integer>();

		String cadena;

		do {
			cadena = Entrada.cadena();
			if (!cadena.equals("")) {
				try {
					int numero = Integer.valueOf(cadena);
					if (!set.add(numero)) {// falso sino añade porque ya exite
						System.out.println("el numero ya existe");
					} else {
						System.out.println("introduciendo en el" + string);
					}
				} catch (NumberFormatException e) {
					System.out.println("solo SE PERMITEN NUMEROS");
				}

			} else {
				System.out.println("has introducido enter: saliendo....");
			}

		} while (!cadena.equals(""));

		return set;
	}

}
