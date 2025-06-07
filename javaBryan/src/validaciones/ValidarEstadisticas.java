package validaciones;

import utilidades.Entrada;

public class ValidarEstadisticas {

	public static void main(String[] args) {
		/*
		 * Enunciado: Pide números hasta que se escriba “fin”. Solo se aceptan
		 * positivos. Al final, muestra:
		 * 
		 * Total de números válidos
		 * 
		 * Media
		 * 
		 * Mayor y menor
		 */
		boolean salir = false;
		boolean bandera = true;
		int mayor = 0;
		int menor = 0;
		int suma = 0;
		int cnt = 0;
		while (!salir) {
			System.out.println("numeros/fin para terminar");
			String dato = Entrada.cadena();
			if (dato.equals("fin")) {
				System.out.println("saliendo");
				salir = true;
			} else {
				if (!dato.matches("[-]?[0-9]+")) {
					System.out.println("solo numeros");
				} else {
					int numero = Integer.parseInt(dato);
					if (numero > 0) {
						if (bandera) {
							mayor = numero;
							menor = numero;
							bandera = false;
						}

						if (numero > mayor) {
							mayor = numero;
						}

						if (numero < menor) {
							menor = numero;
						}
						suma += numero;
						cnt++;

					} else {
						System.out.println("solo positivos");
					}

				}

			}
		}

		if (cnt == 0) {
			System.out.println("No se han introducido números válidos.");
		} else {
			// Aseguramos división en double
			double media = (double) suma / cnt;
			System.out.println("Total de números válidos: " + cnt);
			System.out.println("Media: " + media);
			System.out.println("Mayor: " + mayor);
			System.out.println("Menor: " + menor);
		}

	}// main

}
