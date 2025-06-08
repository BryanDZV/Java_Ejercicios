package soluciones2425;

import java.util.Set;
import java.util.TreeSet;

public class splitTexto {

	public static void main(String[] args) {
		String texto = "En resumen, substring() es una herramienta útil para extraer partes específicas de una cadena de texto en Java. ";

		String[] tmp = texto.split(" ");

		Set<String> set = new TreeSet<String>();

		for (String p : tmp) {
			set.add(p);
		}
		
		for (String s : set) {
			System.out.println(s);
		}

	}

}
