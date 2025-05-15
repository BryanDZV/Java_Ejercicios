package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

		File f = new File("C:\\Users\\bryan\\Desktop\\javaBryan\\javaBryan\\src\\ficheros\\pinocho");
		// C:\\Users\\bryan\\git\\Java_Ejercicios\\javaBryan\\src\\ficheros\\pinocho
		if (!f.exists()) {
			System.out.println("no existe el fichero");
		} else {
			if (!f.isFile()) {
				System.out.println("ruta existe pero no es un fichero");
			}
		}
		/****** ORDENADO RPO ORDEN ALFABETICO **********/
		System.out.println("*******ORDENADO RPO ORDEN ALFABETICO**********");
		Map<String, Integer> m = new TreeMap<String, Integer>(new porOrdenAlfabetico());
		m = extracionPalabra(f);
		for (String elemento : m.keySet()) {
			System.out.println(elemento+"\t"+m.get(elemento));
		}

		// System.out.println(m);
		/****** ORDENADO POR APARICIONES **********/
		System.out.println("******ORDENADO POR APARICIONES**********");
		List<Palabras> l = new ArrayList<Palabras>();
		for (String elemento : m.keySet()) {
			l.add(new Palabras(elemento, m.get(elemento)));
		}
		l.sort(new porAparicion());

		// System.out.println(l);
		for (Palabras elemento : l) {
			 System.out.println(elemento+"\n");
		}
		
		/****** ORDENADO POR ORDEN ALFABETICO -LETRA **********/
		System.out.println("****** ORDENADO POR ORDEN ALFABETICO -LETRA **********");
		m = extracionLetra(m);
		//System.out.println(m);
		for (String elemento : m.keySet()) {
			System.out.println(elemento+"\t"+m.get(elemento));
		}
		/****** ORDENADO POR APARICIONES-LETRAS **********/
		
		List<Letras> p=new ArrayList<Letras>();
		for (String elemento : m.keySet()) {
			p.add(new Letras(elemento,m.get(elemento)));
		}
		//
		for (Letras elemento : p) {
			System.out.println(elemento+"\n");
		}
		
		p.sort(null);
		
		
		

	}// main

	private static Map<String, Integer> extracionLetra(Map<String, Integer> m) {
	    Map<String, Integer> m1 = new TreeMap<>();

	    for (String elemento : m.keySet()) { 
	    	//System.out.println(m.get(elemento));
	        for (int i = 0; i < elemento.length(); i++) { 
	        	int cnt=m.get(elemento);
	            String c = "" + elemento.charAt(i); 
	           // System.out.println(c);

	         
	            if (!m1.containsKey(c)) {
	                m1.put(c, cnt);
	            } else {
	                m1.put(c, m1.get(c)+cnt);//mirar porque cnt
	            }
	        }
	    }

	    //System.out.println(m1);
	    return m1;
	}


	private static Map<String, Integer> extracionPalabra(File f) throws IOException {
		Map<String, Integer> m = new TreeMap<String, Integer>();

		BufferedReader bfr = new BufferedReader(new FileReader(f));
		String linea;
		int cnt = 0;
		String[] aLinea = new String[20];

		do {
			linea = bfr.readLine();
			// System.out.println(linea);

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



/*package ficheros.ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import 
java.util.Map
;
import java.util.Set;
import java.util.TreeMap;

import utilidades.Entrada;

public class EstadisticaPalabrasLetras {

	public static void main(String[] args) throws IOException {
		System.out.print("Ruta del fichero: ");
		String ruta = Entrada.cadena();
		File f = new File(ruta);
		if (!f.exists())
			System.out.println("No existe la ruta: " + f.getAbsolutePath());
		else {
			if (!f.isFile())
				System.out.println("La ruta " + f.getAbsolutePath() + " existe pero no es un fichero.");
			else {
					Map<String, Integer> palabras = extraerPalabras(f);
					Set<String> claves=palabras.keySet();
					System.out.println("=== Palabras por orden alfabético ===");
					for (String cl : claves) {
						System.out.printf("%-12s %d\n", cl,palabras.get(cl));
					}
			}
		}
	}

	private static Map<String, Integer> extraerPalabras(File f) throws IOException {
		// El mapa almacena el número de apariciones de cada palabra en el texto
		Map<String, Integer> m = new TreeMap<String, Integer>();

		BufferedReader bfr = new BufferedReader(new FileReader(f));
		String linea;
		// Leemos el contenido del fichero línea a línea
		while ((linea = bfr.readLine()) != null) {
			String lineaMay = linea.toUpperCase();
			// Extrae palabras dividiendo por epacios o signos de puntuación
			String[] palabrasLinea = lineaMay.split("[\\(\\) ,.;:-]+"); //Delimitadores de palabra: ()<espacio>,.;:-
			// Inserta las palabras en el mapa
			for (String pal : palabrasLinea) {
				if (pal.length()>0) { //split puede crear un cadena vacía sy hay delimitadores al comienzo de la línea
					if (m.containsKey(pal)) {
						int veces = m.get(pal);
						veces++;
						m.put(pal, veces);
					} else
						m.put(pal, 1);
				}
			}
		}
		// Cierre del fichero
		bfr.close();

		return m;
	}

} 
11:14


avatar
rpozori
rpozori dice:public class PalabraVeces implements Comparable<PalabraVeces>{
	String pal;
	int veces;
	
	public PalabraVeces(String pal, int veces) {
		super();
		this.pal = pal;
		this.veces = veces;
	}

	public String getPal() {
		return pal;
	}

	public int getVeces() {
		return veces;
	}

	@Override
	public int compareTo(PalabraVeces o) {
		return -(veces-o.veces);
	}

	@Override
	public String toString() {
		return "PalabraVeces [pal=" + pal + ", veces=" + veces + "]";
	}
} 
12:02
rpozori dice:package ficheros.ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import 
java.util.Map
;
import java.util.Set;
import java.util.TreeMap;

import utilidades.Entrada;

public class EstadisticaPalabrasLetras {

	public static void main(String[] args) throws IOException {
		System.out.print("Ruta del fichero: ");
		String ruta = Entrada.cadena();
		File f = new File(ruta);
		if (!f.exists())
			System.out.println("No existe la ruta: " + f.getAbsolutePath());
		else {
			if (!f.isFile())
				System.out.println("La ruta " + f.getAbsolutePath() + " existe pero no es un fichero.");
			else {
					Map<String, Integer> mapaPalabras = extraerPalabras(f);
					Set<String> claves=mapaPalabras.keySet();
					System.out.println("=== Palabras por orden alfabético ===");
					for (String cl : claves) {
						System.out.printf("%-12s %d\n", cl,mapaPalabras.get(cl));
					}
					
					List<PalabraVeces> l=new ArrayList<PalabraVeces>();
					for (String pal : claves) {
						l.add(new PalabraVeces(pal, mapaPalabras.get(pal)));
					}
					l.sort(null);
					System.out.println("=== Palabras por número de apariciones ===");
					for (PalabraVeces pv : l) {
						System.out.printf("%-12s %d\n", pv.getPal(),pv.getVeces());
					}
					
					Map<Character,Integer> mapaLetras=new TreeMap<Character, Integer>();
					int totalLetras=0;
					for (String pal : claves) {
						String sinTildes=quitarTildes(pal);
						int vecesPal=mapaPalabras.get(pal);
						
						for(int i=0;i<sinTildes.length();i++) {
							char letra=sinTildes.charAt(i);
							if (mapaLetras.containsKey(letra)) 
								mapaLetras.put(letra, mapaLetras.get(letra)+vecesPal);
							else 
								mapaLetras.put(letra, vecesPal);
						}
					}
					//calcula total de letras
					for (Character let: mapaLetras.keySet()) 
						totalLetras+=mapaLetras.get(let);
					System.out.println(mapaLetras);
					System.out.println(totalLetras);
					
			}
		}
	}

	private static Map<String, Integer> extraerPalabras(File f) throws IOException {
		// El mapa almacena el número de apariciones de cada palabra en el texto
		Map<String, Integer> m = new TreeMap<String, Integer>();

		BufferedReader bfr = new BufferedReader(new FileReader(f));
		String linea;
		// Leemos el contenido del fichero línea a línea
		while ((linea = bfr.readLine()) != null) {
			String lineaMay = linea.toUpperCase();
			// Extrae palabras dividiendo por epacios o signos de puntuación
			String[] palabrasLinea = lineaMay.split("[\\(\\) ,.;:-]+"); //Delimitadores de palabra: ()<espacio>,.;:-
			// Inserta las palabras en el mapa
			for (String pal : palabrasLinea) {
				if (pal.length()>0) { //split puede crear un cadena vacía sy hay delimitadores al comienzo de la línea
					if (m.containsKey(pal)) {
						int veces = m.get(pal);
						veces++;
						m.put(pal, veces);
					} else
						m.put(pal, 1);
				}
			}
		}
		// Cierre del fichero
		bfr.close();

		return m;
	}

	public static String quitarTildes(String t) {
		String sinTildes = "";
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			switch (c) {
			case 'Á':
				c = 'A';
				break;
			case 'á':
				c = 'a';
				break;
			case 'É':
				c = 'E';
				break;
			case 'é':
				c = 'e';
				break;
			case 'Í':
				c = 'I';
				break;
			case 'í':
				c = 'i';
				break;
			case 'Ó':
				c = 'O';
				break;
			case 'ó':
				c = 'o';
				break;
			case 'Ú':
			case 'Ü':
				c = 'U';
				break;
			case 'ú':
			case 'ü':
				c = 'u';
				break;
			}
			sinTildes = sinTildes + c;
		}
		return sinTildes;
	}

} 
12:51
rpozori dice:package ficheros.ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import 
java.util.Map
;
import java.util.Set;
import java.util.TreeMap;

import utilidades.Entrada;

public class EstadisticaPalabrasLetras {

	public static void main(String[] args) throws IOException {
		System.out.print("Ruta del fichero: ");
		String ruta = Entrada.cadena();
		File f = new File(ruta);
		if (!f.exists())
			System.out.println("No existe la ruta: " + f.getAbsolutePath());
		else {
			if (!f.isFile())
				System.out.println("La ruta " + f.getAbsolutePath() + " existe pero no es un fichero.");
			else {
					Map<String, Integer> mapaPalabras = extraerPalabras(f);
					Set<String> claves=mapaPalabras.keySet();
					System.out.println("=== Palabras por orden alfabético ===");
					for (String cl : claves) {
						System.out.printf("%-12s %d\n", cl,mapaPalabras.get(cl));
					}
					
					List<PalabraVeces> l=new ArrayList<PalabraVeces>();
					for (String pal : claves) {
						l.add(new PalabraVeces(pal, mapaPalabras.get(pal)));
					}
					l.sort(null);
					System.out.println("=== Palabras por número de apariciones ===");
					for (PalabraVeces pv : l) {
						System.out.printf("%-12s %d\n", pv.getPal(),pv.getVeces());
					}
					
					Map<Character,Integer> mapaLetras=new TreeMap<Character, Integer>();
					int totalLetras=0;
					for (String pal : claves) {
						String sinTildes=quitarTildes(pal);
						int vecesPal=mapaPalabras.get(pal);
						
						for(int i=0;i<sinTildes.length();i++) {
							char letra=sinTildes.charAt(i);
							if (mapaLetras.containsKey(letra)) 
								mapaLetras.put(letra, mapaLetras.get(letra)+vecesPal);
							else 
								mapaLetras.put(letra, vecesPal);
						}
					}
					//calcula total de letras
					for (Character let: mapaLetras.keySet()) 
						totalLetras+=mapaLetras.get(let);
					System.out.println(mapaLetras);
					System.out.println(totalLetras);
					
					System.out.println("=== Letras por orden alfabético ===");
					for (Character let: mapaLetras.keySet()) {
						double porcentaje=mapaLetras.get(let)*100.0/totalLetras;
						System.out.printf("%c %.2f%%\n", let,porcentaje);
					}
						
					List<LetraVeces> l2=new ArrayList<LetraVeces>();
					for (Character let : mapaLetras.keySet()) {
						l2.add(new LetraVeces(let, mapaLetras.get(let)));
					}
					l2.sort(null);
					System.out.println("=== Letras por número de apariciones ===");
					for (LetraVeces lv : l2) {
						double porcentaje=lv.getVeces()*100.0/totalLetras;
						System.out.printf("%c %.2f%%\n", lv.getLetra(),porcentaje);
					}
					
					
			}
		}
	}

	private static Map<String, Integer> extraerPalabras(File f) throws IOException {
		// El mapa almacena el número de apariciones de cada palabra en el texto
		Map<String, Integer> m = new TreeMap<String, Integer>();

		BufferedReader bfr = new BufferedReader(new FileReader(f));
		String linea;
		// Leemos el contenido del fichero línea a línea
		while ((linea = bfr.readLine()) != null) {
			String lineaMay = linea.toUpperCase();
			// Extrae palabras dividiendo por epacios o signos de puntuación
			String[] palabrasLinea = lineaMay.split("[\\(\\) ,.;:-]+"); //Delimitadores de palabra: ()<espacio>,.;:-
			// Inserta las palabras en el mapa
			for (String pal : palabrasLinea) {
				if (pal.length()>0) { //split puede crear un cadena vacía sy hay delimitadores al comienzo de la línea
					if (m.containsKey(pal)) {
						int veces = m.get(pal);
						veces++;
						m.put(pal, veces);
					} else
						m.put(pal, 1);
				}
			}
		}
		// Cierre del fichero
		bfr.close();

		return m;
	}

	public static String quitarTildes(String t) {
		String sinTildes = "";
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			switch (c) {
			case 'Á':
				c = 'A';
				break;
			case 'á':
				c = 'a';
				break;
			case 'É':
				c = 'E';
				break;
			case 'é':
				c = 'e';
				break;
			case 'Í':
				c = 'I';
				break;
			case 'í':
				c = 'i';
				break;
			case 'Ó':
				c = 'O';
				break;
			case 'ó':
				c = 'o';
				break;
			case 'Ú':
			case 'Ü':
				c = 'U';
				break;
			case 'ú':
			case 'ü':
				c = 'u';
				break;
			}
			sinTildes = sinTildes + c;
		}
		return sinTildes;
	}

} */
