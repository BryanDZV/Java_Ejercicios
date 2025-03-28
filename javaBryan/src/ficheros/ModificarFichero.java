package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import algoritmos.Array;

public class ModificarFichero {

	public static void main(String[] args) throws IOException {
		/*
		 * ACCEDER A LA RUTA FICHER TERMINAR SINO EXISTE COMROBAR SIE S UN FICHERO
		 * TERMINAR SINO ES FICHERO SI EXISTE Y ES FICHERO LEER
		 * 
		 * 
		 * ESTADISTICAS PALABRAS DIFRENTES Y ORDENAR 1--ALFAVBETICO Y 2--NUMERO DE
		 * APARICIONES/ LETRAS QUE HAY Y ORDENAR 1--ALFABETICO Y 2-- NUMERO DE
		 * APARICIONES /LAS PARICIONES EN PORCENTAJE RESPECTO A TOTAL NO CUENTA MAYUS Y
		 * MINUS NISGINOS
		 * 
		 * que necsito metodo para devolverme un mapa con las palabras logica pra las
		 * palabras extraer spli por espacio en un array primero por palabra y depues
		 * por letra necesito leerlas bfr do while
		 *
		 * alguna tipo de lista set map para guardar las palabras ---->metodo que me
		 * devuelva un map sort para ordenarlas equals o comparable o comparator crear
		 * clases ?¿
		 */

		File f = new File("C:\\Users\\bryan\\git\\Java_Ejercicios\\javaBryan\\src\\ficheros\\pinocho");
		if (!f.exists()) {
			System.out.println("no existe el fichero");
		} else {
			if (!f.isFile()) {
				System.out.println("ruta existe pero no es un fichero");
			}
		}
		/******ORDENADO RPO ORDEN ALFABETICO**********/
		System.out.println("*******ORDENADO RPO ORDEN ALFABETICO**********");
		Map<String, Integer> m = new TreeMap<String, Integer>(new porOrdenAlfabetico());
		m = extracionPalabra(f);
		for (String elemento : m.keySet()) {
			System.out.println(elemento+"\t"+m.get(elemento));
		}
	
		//System.out.println(m);
		/******ORDENADO POR APARICIONES**********/
		System.out.println("******ORDENADO POR APARICIONES**********");
		List<Palabras> l=new ArrayList<Palabras>();
		for (String elemento : m.keySet()) {
			l.add(new Palabras(elemento,m.get(elemento)));
		}
		l.sort(new porAparicion());
		
		//System.out.println(l);
		for (Palabras elemento : l) {
			System.out.println(elemento+"\n");
		}
		
		l = extracionLetra(l);
		
	}// main

	private static List<Palabras> extracionLetra(List<Palabras> l2) {
		List<Palabras> l=new ArrayList<Palabras>();
		l=l2;
	
		
		
		return l;
	}

	private static Map<String, Integer> extracionPalabra(File f) throws IOException {
		Map<String, Integer> m = new TreeMap<String, Integer>();
		
		
		BufferedReader bfr = new BufferedReader(new FileReader(f));
		String linea;
		int cnt = 0;
		String[] aLinea = new String[20];

		do {
			linea = bfr.readLine();
			 //System.out.println(linea);

			if (linea != null) {
				aLinea = linea.toUpperCase().replaceAll("[.Ñ,]", "").split(" ");
				for (String elemento : aLinea) {
					if (!m.containsKey(elemento)) {
						m.put(elemento, 1);
					} else {
						m.put(elemento, m.get(elemento) + 1);
					}

				}

			}

		} while (linea != null);

//		for (String elemento : m.keySet()) {
//			System.out.println(elemento);
//		}

		return m;
	}
}// clase
