package validaciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utilidades.Entrada;

public class ValidarCreciente {

	public static void main(String[] args) {
		/*
		 * Enunciado: Pide números al usuario hasta que escriba fin. Solo los guarda si
		 * son positivos y van en orden creciente.
		 */

		boolean salir = false;
		int v = 0;
		List<Integer> l = new ArrayList<Integer>();
		while (!salir) {
			System.out.println("introduce numeros/fin para terminar");
			String dato = Entrada.cadena();

			if (dato.equals("fin")) {
				System.out.println("saliendo");
				salir = true;
			} else {
				// sólo entra aquí si NO es "fin"
				if (!dato.matches("[0-9]+")) {
					System.out.println("solo numeros");
				} else {

					int numero = Integer.parseInt(dato);

					if (v >= numero) {
						System.out.println("solo numeros en orden creciente");

					} else {
						l.add(numero);
						v = numero;
					}
				}

			}

			System.out.println("tu lista");
			for (Integer elemento : l) {
				System.out.println(elemento);
			}

		}
	}

}
