package validaciones;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class ValidarPositivo {

	public static void main(String[] args) {
		// Enunciado: Pide un número entero.
		// Solo lo guardas si es mayor que 0.
		List<Integer> l = new ArrayList<Integer>();

		boolean salir = false;

		while (!salir) {
			System.out.println("solo positivos/fin para salir");
			String dato = Entrada.cadena();

			try {
				if (!dato.matches("[0-9]+") && dato.equalsIgnoreCase("fin")) {
					salir = true;
				} else {
					int num = Integer.parseInt(dato);
					
					
					if (num > 0) {
						l.add(num);
					}
				}

			} catch (NumberFormatException e) {
				System.out.println("solo numeros");
			}

		}
		
		for (Integer integer : l) {
			System.out.println(integer);
		}

	}// mian

}
