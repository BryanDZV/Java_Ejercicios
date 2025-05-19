package validaciones;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class ValidarRango {

	public static void main(String[] args) {
		// Pide un número del 1 al 10 (inclusive).

		List<Integer> l = new ArrayList<Integer>();
		boolean salir = false;

		while (!salir) {
			System.out.println("numeros del 1 al 10 inclusives/fin para salir");
			String dato = Entrada.cadena();

			if (!dato.matches("[0-9]+") && dato.equalsIgnoreCase("fin")) {
				salir = true;
			} else {

				try {
					int num = Integer.parseInt(dato);
					if (num < 1 || num > 10) {
						System.out.println("solo del 1 al 10");
					} else {
						l.add(num);
					}
				} catch (Exception e) {
					System.out.println("solo numeros");
				}

			}
		}
		for (Integer integer : l) {
			System.out.println(integer);
		}

	}

}
