package ficherosPractica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ejercicios2 {
	/*
	 * NOTAS [^\\p{L}\\p{N}] significa:
	 * "Buscar cualquier carácter que NO sea una letra (\p{L}) o un número (\p{N})".
	 * Es decir, coincide con espacios, signos de puntuación, caracteres
	 * especiales,etc. EQUIVALE ("[^a-zA-Z0-9]", "")
	 */

	public static void main(String[] args) throws IOException {
		File f = new File("src\\ficherosPractica\\prueba");
		/* comprobacion */
		if (!f.exists()) {
			System.out.println("la ruta no existe");
		} else {
			if (f.isDirectory()) {
				System.out.println("la ruta existe pero no es un archivo");
			}
		}

		Map<String, Integer> m = new TreeMap<String, Integer>();
		m = estadisticaPalabras(f);
		System.out.println("********por orden alfabetico Palabras****");
		for (String elemento : m.keySet()) {
			System.out.println(elemento + "\t" + m.get(elemento));
		}
		System.out.println("********por orden aparicion Palabras****");
		List<Pareja> l = new ArrayList<Pareja>();
		l = listaPalabras(m);
		l.sort(new ordenamientoAparicion());
		for (Pareja elemento : l) {
			System.out.println(elemento);
		}
		System.out.println("=== Letras por orden alfabético ===");
		/* letras */
		m = estadisticaLetras(m);
		// calcula total de letras
		int totalLetras = 0;
		for (String elemento : m.keySet()) {
			for (int i = 0; i < elemento.length(); i++) {
				totalLetras += m.get(elemento);// por cada letra sumo el valor previo que tenia
			}
		}
		// System.out.println(m);
		// System.out.println(totalLetras);
		for (String elemento : m.keySet()) {
			// System.out.println(elemento + "\t" + m.get(elemento));
			double porcentaje = (double) m.get(elemento) * 100 / totalLetras;
			System.out.printf("%s\t%.2f%%\n", elemento, porcentaje);
			/*
			 * Parte | Significado
			 *  %s | Imprime una cadena (String) — en este caso, elemento
			 * \t | Tabulador — espacio horizontal grande, como en una tabla 
			 * %.2f | Número decimal con 2 decimales — en este caso, 
			 * porcentaje %% | Imprime el símbolo % tienes que duplicarlo porque % solo ya se usa como marcador 
			 * \n | Salto de línea (como Enter)
			 */
		}

		System.out.println("=== Letras por orden de Aparicion ===");
		l = listaLetras(m);
		l.sort(new letrasAparicion());
		for (Pareja elemento : l) {
			System.out.printf("%s\t%.2f%%\n", elemento.getClave(), elemento.getAparicionLetra());

		}

	}// main

	private static List<Pareja> listaLetras(Map<String, Integer> mapa) {
		List<Pareja> l = new ArrayList<Pareja>();
		int totalLetras = 0;
		for (String elemento : mapa.keySet()) {
			for (int i = 0; i < elemento.length(); i++) {
				totalLetras += mapa.get(elemento);
				System.out.println("***************"+totalLetras);
			}
		}

		for (String elemento : mapa.keySet()) {
			// System.out.println(elemento+"\t"+mapa.get(elemento));
			int cntPrevio = mapa.get(elemento);
			double porcentaje = (cntPrevio * 100.0) / totalLetras;
			// System.out.println(porcentaje);
			l.add(new Pareja(elemento, porcentaje));
		}

		return l;
	}

	private static Map<String, Integer> estadisticaLetras(Map<String, Integer> mapa) {
		Map<String, Integer> m = new TreeMap<String, Integer>();

		for (String elemento : mapa.keySet()) {
			int cntPrevio = mapa.get(elemento);
			for (int i = 0; i < elemento.length(); i++) {
				String c = "" + elemento.charAt(i);
				if (!m.containsKey(c)) {
					m.put(c, cntPrevio);
				} else {
					m.put(c, (m.get(c) + cntPrevio));
				}
			}
		}

		return m;
	}// metodoLetras

	private static List<Pareja> listaPalabras(Map<String, Integer> m) {
		List<Pareja> l = new ArrayList<Pareja>();
		for (String elemento : m.keySet()) {
			l.add(new Pareja(elemento, m.get(elemento)));
		}

		return l;
	}

	private static Map<String, Integer> estadisticaPalabras(File f) throws IOException {

		Map<String, Integer> m = new TreeMap<String, Integer>();
		/* lectura */
		BufferedReader bfr = new BufferedReader(new FileReader(f));
		String linea = bfr.readLine();
		String[] palabra = new String[linea.length()];
		do {
			// System.out.println(linea);

			palabra = linea.replaceAll("[^a-zA-Z0-9 ]", "").toUpperCase().split(" ");
			for (String elemento : palabra) {
				// System.out.println(elemento);
				if (!m.containsKey(elemento)) {
					m.put(elemento, 1);
				} else {
					m.put(elemento, m.get(elemento) + 1);
				}
			}
			linea = bfr.readLine();

		} while (linea != null);
		bfr.close();

		return m;
	}// metodo

}// clase
