package ej1;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class Ej1 {

	public static void main(String[] args) {
		System.out.println("introduce una frase");
		String frase = Entrada.cadena();
		int contador = 0;
		List<String> r = new ArrayList<String>();
		r = palabrasDistintas(frase);
		System.out.print("las palabras diferentes son: ");
		for (String item : r) {
			System.out.print("\t"+item+",");

		}
		
		for (int i = 0; i < r.size(); i++) {
			contador += 1;

		}

		System.out.println("\nnumero de palabras distintas es::" + contador);
	

		
		
		int a = estadisticasVocales(frase)[0];
		int e = estadisticasVocales(frase)[1];
		int i = estadisticasVocales(frase)[2];
		int o = estadisticasVocales(frase)[3];
		int u = estadisticasVocales(frase)[4];
		int totalVocales = a + e + i + o + u;
		System.out.println("\nel numero de vocales total es:: " + totalVocales);
		String resultado = "vocal a::" + a + "\tvocal e::" + e + "\tvocal i::" + i + "\tvocal o::" + o + "\tvocal u::"
				+ u;
		System.out.print(resultado);

	}

	private static int[] estadisticasVocales(String frase) {
		int contadorA = 0;
		int contadorE = 0;
		int contadorU = 0;
		int contadorI = 0;
		int contadorO = 0;

		int[] vocales = new int[5];

		for (int i = 0; i < frase.length(); i++) {
			char c = frase.toLowerCase().charAt(i);
			if (c == 'a') {
				contadorA++;
				vocales[0] = contadorA;
			} else if (c == 'e') {
				contadorE++;
				vocales[1] = contadorE;
			} else if (c == 'i') {
				contadorI++;
				vocales[2] = contadorI;

			} else if (c == 'o') {
				contadorO++;
				vocales[3] = contadorO;

			} else if (c == 'u') {
				contadorU++;
				vocales[4] = contadorU;

			}

		} // fin for

		return vocales;
	}

///
	public static List<String> palabrasDistintas(String frase) {

		List<String> l = new ArrayList<String>();
		String[] arrayLista = null;

		for (int i = 0; i < frase.length(); i++) {
			arrayLista = frase.toLowerCase().split("[^a-zA-Z0-9]+");//[^a-zA-ZáéíóúÁÉÍÓÚñÑ]+
			l.sort(null);

		} // fin for i

		// lista recorrere

		try {
			for (String item : arrayLista) {

				if (!l.contains(item)) {
					l.add(item);
				} else {
					l = l;
				} // fin if

			} // fin for
		} catch (NullPointerException e) {
			System.out.println("SIN PALABRAS::");
		}

		// System.out.println(l);

		return l;
	}
	////

}
