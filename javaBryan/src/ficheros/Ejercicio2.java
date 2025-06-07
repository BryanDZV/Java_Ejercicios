package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {
		/*
		 * plan
		 * 
		 * ruta de fichero comprobaciones sino existe avisa y terminar si es un fcihero
		 * sino terminar
		 * 
		 * todo correcto leer
		 * 
		 * 
		 * contar las doferentes palabras y las letras y hacer un listado cada plabra su
		 * numero cada letra su porcetanje respecto total
		 * 
		 * may ymin no importa
		 * 
		 * 
		 */
		// ruta
		String linea;
		File f = new File("C:\\Users\\bryan\\Desktop\\javaBryan\\javaBryan\\src\\ficheros\\pinocho");
		if (!f.exists()) {
			System.out.println("no existe el ficher");
		} else if (f.isDirectory()) {
			System.out.println("existe pero NO ES UN FICHERO");
		} else {
			BufferedReader bfr = new BufferedReader(new FileReader(f));

			do {
				linea = bfr.readLine();
				// System.out.println(linea);
				Map<String, Integer> m = new TreeMap<String, Integer>();
				m = extracionPalabras(linea);

			} while (linea != null);

		}

	}// fin main

	private static Map<String, Integer> extracionPalabras(String linea) {
		Map<String, Integer> m = new TreeMap<String, Integer>();
		String[] a = linea.split(" ");

		for (int i = 0; i < a.length; i++) {
			int cnt = 0;
		

			
		}
		System.out.println(m.get("En"));
		
		
		return m;
		
		
		
	}//main

}//clase
