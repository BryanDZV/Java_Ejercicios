package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utilidades.Entrada;

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {
		System.out.println("ponga ruta");
		String ruta = "C:\\Users\\bryan\\git\\Java_Ejercicios\\BryanZavala\\src\\ficheros\\texto2.txt";
		File f = new File(ruta);
		if (!f.exists()) {
			System.out.println("no existe ruta");
		} else if (!f.isFile()) {
			System.out.println("existe pero no es un fichero");
		}

		Map<String, Integer> m = new TreeMap<String, Integer>();
		m = estadisticaPalabras(f);
		System.out.println("***PALABRA ALFABETO***");
		for (String elemento : m.keySet()) {
			System.out.println(elemento + "\t" + m.get(elemento));

		}
		List<Persona> l = new ArrayList<Persona>();
		l = estadisticaPalabrasAparicion(m);
		System.out.println("***PALABRAS POR APARICION***");
		l.sort(new porOrdenAparicion());
		for (Persona elemento : l) {
			System.out.println(elemento);
		}
		
		System.out.println("***LETRAS POR ALFABETO***");
		m=estadiscaLetras(m);
		//calculo total de letras
		int totalLetras=0;
		for (String elemento : m.keySet()) {
			totalLetras+=m.get(elemento);
		}
		System.out.println("total Letras"+totalLetras);
		
		for (String elemento : m.keySet()) {
			double aparicionPorcentaje=((double)m.get(elemento)*100)/totalLetras;
			
			System.out.printf("%s\t%.3f%%\n", elemento, aparicionPorcentaje);
		}
		
		System.out.println("***LETRAS POR APARICION***");
		
		l=letrasPorcentaja(m);
		l.sort(new ordenarPorAparicion());
		for (Persona elemento : l) {
			System.out.printf("%s\t%.2f%%\n", elemento.getPalabra(), elemento.getAparicionLetra());
		}
		
	}// main

	private static List<Persona> letrasPorcentaja(Map<String, Integer> m) {
		
		List<Persona>l=new ArrayList<Persona>();
		int total=0;
		for (String elemento : m.keySet()) {
			for (int i = 0; i < elemento.length(); i++) {
				total+=m.get(elemento);
			}
		}
		//System.out.println("total LETRATRAS"+total);
		for (String elemento : m.keySet()) {
			int cntPrevio=m.get(elemento);
			if (!l.contains(elemento)) {
				double porcentaje=(cntPrevio*100.0)/total;
				l.add(new Persona(elemento, porcentaje));
			}
		}
		return l;
	}

	private static Map<String, Integer> estadiscaLetras(Map<String, Integer> m) {
		Map<String, Integer> mLetras=new TreeMap<String, Integer>();
		

		for (String elemento : m.keySet()) {
			int aprcPrev=m.get(elemento);
			for (int i = 0; i < elemento.length(); i++) {
				String c=""+elemento.charAt(i);
				//System.out.println(c);
				
				if (!mLetras.containsKey(c)) {
					mLetras.put(c, aprcPrev);
				}else {
					mLetras.put(c,mLetras.get(c)+aprcPrev);
				}
			}
			
		}
		
		
		return mLetras;
	}

	private static List<Persona> estadisticaPalabrasAparicion(Map<String, Integer> m) {
		List<Persona> l = new ArrayList<Persona>();
		for (String elemento : m.keySet()) {
			if (!l.contains(elemento)) {
				l.add(new Persona(elemento, m.get(elemento)));
			}
		}

		return l;
	}

	private static Map<String, Integer> estadisticaPalabras(File f) throws IOException {
		Map<String, Integer> m = new TreeMap<String, Integer>();
		BufferedReader bfr = new BufferedReader(new FileReader(f));
		String linea = bfr.readLine();
		String[] array = new String[linea.length()];
		while (linea != null) {
			// System.out.println(linea);
			array = linea.toUpperCase().replaceAll("[^a-zA-z0-9 ]", "").split(" ");
			linea = bfr.readLine();
			for (String elemento : array) {
				if (!m.containsKey(elemento)) {
					m.put(elemento, 1);
				} else {
					m.put(elemento, m.get(elemento) + 1);
				}

			}

		}
		bfr.close();

		return m;
	}

}// clase
