package mapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import utilidades.Entrada;

public class Ejercicio2 {

	public static void main(String[] args) {

		Map<String, String> diccEspIng = new HashMap<String, String>();

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

		System.out.print("Introduzca una palabra en español: ");
		String palabraIntro = Entrada.cadena();

		if (diccEspIng.containsKey(palabraIntro)) {
			System.out.println(palabraIntro + " en inglés es " + diccEspIng.get(palabraIntro));
		} else {
			System.out.print("La palabra no se encuentra en el diccionario.");
		}
		System.out.println("\n");
		System.out.println("********LISTA CON FOR EACH********");
		for (String elemento : diccEspIng.keySet()) {
			System.out.println(elemento+" "+diccEspIng.get(elemento));
			
		}
		System.out.println("\n");
		System.out.println("********LISTA PERSONALIZADA********");
		
		List<Pareja> l=new ArrayList<Pareja>();
		
		for (String clave : diccEspIng.keySet()) {
		    String valor = diccEspIng.get(clave);
		    Pareja nuevaPareja = new Pareja(clave, valor);
		    if (!l.contains(nuevaPareja)) {
		        l.add(nuevaPareja);
		    }
		}
		
		System.out.println(l);
		
		
	}//main
	

}//clase
