package validaciones;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class ValidarNoseRepitan {

	public static void main(String[] args) {

		List<String> l = new ArrayList<String>();
		boolean salir = false;
		while (!salir) {
			System.out.println("introduce palabras/fin para terminar");
			String dato = Entrada.cadena();
			if (dato.equalsIgnoreCase("fin")) {
				salir = true;
			} else {
				if (!l.contains(dato)) {
					l.add(dato);

				} else {
					System.out.println("no se permiten repetidos");
				}

			}

		}
		for (String string : l) {
			System.out.println(string);
		}
	}// main

}
