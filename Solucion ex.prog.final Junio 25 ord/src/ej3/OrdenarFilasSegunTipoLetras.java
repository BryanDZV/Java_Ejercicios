package ej3;

import java.util.ArrayList;

public class OrdenarFilasSegunTipoLetras {

	public static void main(String[] args) {
		String[][] m = {
			{"perro", "gato"},
			{"abeja", "elefante"},
			{"mono", "oso"},
			{"Tigre", "jirafa"},
			{"zorro", "aurón"}
		};
		probarMatriz(m);

		String[][] m2 = {
			{"uno", "dos"},
			{"tres", "cuatro"},
			{"aéreo", "índice"},
			{"móvil", "cielo"},
			{"zebra", "guión"}
		};
		probarMatriz(m2);
		
		String[][] m3 = {
				{"Árbol", "niÑo", "camión", "Ratón", "Útil"},
				{"mesa", "Silla", "puÉblo", "ventana", "LÁPIZ"},
				{"sol", "Luz", "Éxito", "día", "ruido"}
		};
		probarMatriz(m3);
	}

	private static void probarMatriz(String[][] m) {
		System.out.println("== Matriz original ==");
		mostrarMatriz(m);
		String[][] ordenada = ordenarSegunTipoLetras(m);
		System.out.println("== Matriz ordenada ==");
		mostrarMatriz(ordenada);
		System.out.println();
	}

	public static String[][] ordenarSegunTipoLetras(String[][] mat) {
		String[][] resultado = new String[mat.length][mat[0].length];
		ArrayList<FilaLetras> lista = new ArrayList<FilaLetras>();

		for (int i = 0; i < mat.length; i++) {
			int consonantes = contarConsonantes(mat[i]);
			int vocales = contarVocales(mat[i]);
			lista.add(new FilaLetras(i, consonantes, vocales));
		}

		lista.sort(null); // usa compareTo

		for (int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < mat[0].length; j++) {
				resultado[i][j] = mat[lista.get(i).fila][j];
			}
		}

		return resultado;
	}

	private static int contarVocales(String[] fila) {
		int cnt = 0;
		for (String palabra : fila) {
			String t = palabra.toUpperCase();
			for (int j = 0; j < t.length(); j++) {
				char c = t.charAt(j);
				if ("AEIOUÁÉÍÓÚÜ".indexOf(c) >= 0)
					cnt++;
			}
		}
		return cnt;
	}

	private static int contarConsonantes(String[] fila) {
		int cnt = 0;
		for (String palabra : fila) {
			String t = palabra.toUpperCase();
			for (int j = 0; j < t.length(); j++) {
				char c = t.charAt(j);
				if (Character.isLetter(c) && "AEIOUÁÉÍÓÚÜ".indexOf(c) == -1)
					cnt++;
			}
		}
		return cnt;
	}

	private static void mostrarMatriz(String[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
