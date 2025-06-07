package colecionesTipoExamenOrdinaria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class HashMapListMain {

	public static void main(String[] args) {

		String[][] datos = { { "Ana", "7" }, { "Luis", "9" }, { "Ana", "8" }, { "María", "6" } };

		Map<String, List<Integer>> m = new HashMap<String, List<Integer>>();

		for (String[] elemento : datos) {
			String nombre = elemento[0];
			if (!m.containsKey(nombre)) {
				m.put(nombre, new ArrayList<Integer>());
			}

			for (int i = 1; i < elemento.length; i++) {
				int nota = Integer.parseInt(elemento[i]);
				m.get(nombre).add(nota);
			}
		}

		System.out.println("lista sin ordenar");
		for (String clave : m.keySet()) {
			System.out.println(clave + " su lista" + m.get(clave));
		}

		System.out.println("lista ordenada por NOTA DESC");
		List<Escuela> lescuela = new ArrayList<Escuela>();
		for (String elemento : m.keySet()) {
			lescuela.add(new Escuela(elemento, m.get(elemento)));
		}
		lescuela.sort(null);
		for (Escuela elemento : lescuela) {
			System.out.println(elemento.getNombre()+"\t"+elemento.getNotas());
		}

	}// main

}// class
