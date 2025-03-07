package conjuntos;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio1 {

	public static void main(String[] args) {
		/**
		 * Ejercicio 1 Desarrollar un método que recibe un array de palabras y devuelve
		 * un nuevo array donde se han eliminado las palabras duplicadas:
		 */

		String[] frase = { "hola", "pepe", "hola", "HOLA", "perro", "PERRO", "perro" };
		boolean ignorarMayMin = true;
		eliminarDuplicado(frase, ignorarMayMin);

	}

	private static void eliminarDuplicado(String[] frase, boolean ignorarMayMin) {
		Set<String> conjunto_sin_duplicados = new HashSet<String>();
		ignorarMayMin = true;
		if (ignorarMayMin) {
			for (int i = 0; i < frase.length; i++) {
				String nt = frase[i].toLowerCase();
				conjunto_sin_duplicados.add(nt);
			}
			System.out.println("ignorar maysuculas y minisculas" + conjunto_sin_duplicados);
		} else {
			for (String elemento : frase) {
				conjunto_sin_duplicados.add(elemento);
			}
			System.out.println("sin ignorar" + conjunto_sin_duplicados);
		}

	}
}
