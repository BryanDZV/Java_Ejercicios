package ejercicios;

import utilidades.Entrada;

public class Ejercicio2 {
	public static void main(String[] args) {
		String frase;

		do {
			System.out.print("Introduzca frase: ");
			frase = Entrada.cadena();

			if (!frase.equals("fin")) {
				System.out.println(eliminarImpares(frase));
				System.out.println(alternarMayMin(frase));
			}
		} while (!frase.equals("fin"));

	}

	public static String eliminarImpares(String t) {
		String resultado = "";

		for (int i = 1; i < t.length(); i = i + 2) { // Comienza desde el índice 1 (pares)
			resultado = resultado + t.substring(i, i + 1); // Agrega el carácter en la posición par
		}

		return resultado;
	}

	public static String alternarMayMin(String t) {
		String resultado = "";
		int contadorLetras = 0; // Contador para alternar mayúsculas y minúsculas

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);

			if (Character.isLetter(c)) {
				if (contadorLetras % 2 == 0) {
					c = Character.toUpperCase(c);
				} else {
					c = Character.toLowerCase(c);
				}
				contadorLetras++; // Incrementa el contador solo si es una letra
			}

			resultado += c; // Agrega el carácter resultante
		}

		return resultado;
	}

}