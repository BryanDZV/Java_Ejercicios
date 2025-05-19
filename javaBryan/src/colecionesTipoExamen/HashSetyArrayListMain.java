package colecionesTipoExamen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashSetyArrayListMain {

	public static void main(String[] args) {
		/*
		 * Enunciado Tienes una clase Articulo(String codigo, String nombre, int stock)
		 * implements Comparable<Articulo> (orden natural por codigo). Lee de un array
		 * de datos duplicados y:
		 * 
		 * Añade todos los artículos a un HashSet para eliminar duplicados (dos
		 * artículos son iguales si tienen mismo codigo).
		 * 
		 * Pasa el contenido del HashSet a un ArrayList.
		 * 
		 * Ordena el ArrayList según el orden natural (Comparable).
		 * 
		 * Imprime la lista ordenada.
		 * 
		 * Puntos clave
		 * 
		 * HashSet para unicidad.
		 * 
		 * Comparable<Articulo> para orden natural.
		 * 
		 * Ordenación por selección sobre la lista.
		 */

		Articulo[] producto = { new Articulo("B001", "Don Quijote de la Mancha", 5),
				new Articulo("B002", "Cien Años de Soledad", 3), new Articulo("B003", "La Sombra del Viento", 4),
				// duplicados intencionados
				new Articulo("B002", "Cien Años de Soledad", 3), new Articulo("B001", "Don Quijote de la Mancha", 5),
				// otro producto distinto
				new Articulo("B004", "El Nombre del Viento", 2) };

		Map<String, Articulo> m = new HashMap<String, Articulo>();
//dentor de un hasmap
		for (Articulo elemento : producto) {
			String codigo = elemento.getCodigo();
			m.put(codigo, elemento);
		}

//		for (String elemento : m.keySet()) {
//			System.out.println(elemento + m.get(elemento));
//		}
		
		//a un List
		
		List<Articulo>l=new ArrayList<Articulo>();
		for (Articulo elemento : m.values()) {
			l.add(elemento);
		}
		
		System.out.println("lista");
		
		for (Articulo articulo : l) {
			System.out.println(articulo);
		}
		
		System.out.println("ordenada por stock");
		l.sort(null);
		for (Articulo articulo : l) {
			System.out.println(articulo);
		}
		
		

	}// main

}
