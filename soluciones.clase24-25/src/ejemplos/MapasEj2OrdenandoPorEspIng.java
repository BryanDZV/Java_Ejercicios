
package ejemplos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utilidades.Entrada;

import java.util.HashMap;

public class MapasEj2OrdenandoPorEspIng {
	public static void main(String[] args) {

		Map<String, String> diccEspIng = new TreeMap<String,String>();

		diccEspIng.put("ordenador", "computer");
		diccEspIng.put("gato", "cat");
		diccEspIng.put("rojo", "red");
		diccEspIng.put("árbol", "tree");
		diccEspIng.put("pingüino", "penguin");
		diccEspIng.put("sol", "sun");
		diccEspIng.put("agua", "water");
		diccEspIng.put("viento", "wind");
		diccEspIng.put("siesta", "nap");
		diccEspIng.put("arriba", "up");
		diccEspIng.put("ratón", "mouse");
		diccEspIng.put("estadio", "arena");
		diccEspIng.put("calumnia", "calumny");
		diccEspIng.put("aguacate", "avocado");
		diccEspIng.put("cuerpo", "body");
		diccEspIng.put("concurso", "contest");
		diccEspIng.put("cena", "dinner");
		diccEspIng.put("salida", "exit");
		diccEspIng.put("lenteja", "lentil");
		diccEspIng.put("cacerola", "pan");
		diccEspIng.put("pastel", "pie");
		diccEspIng.put("membrillo", "quince");
		
		System.out.println("Listado ordenado por clave (TreeMap)");
		for (String esp : diccEspIng.keySet()) {
			System.out.println(esp+" "+diccEspIng.get(esp));
			
		}
		
		System.out.println("Listado ordenado por valor (nos apoyamos en una lista)");
		List<Pareja> l=new ArrayList<Pareja>();
		for (String esp : diccEspIng.keySet()) {
			l.add(new Pareja(esp, diccEspIng.get(esp)));
		}
		l.sort(null);
		for (Pareja pareja : l) {
			System.out.println(pareja.getEsp()+" "+pareja.getIng());
		}

		System.out.print("Introduzca una palabra en español: ");
		String palabraIntro = Entrada.cadena();

		if (diccEspIng.containsKey(palabraIntro)) {
			System.out.println(palabraIntro + " en inglés es " + diccEspIng.get(palabraIntro));
		} else {
			System.out.print("La palabra no se encuentra en el diccionario.");
		}
	}
}
