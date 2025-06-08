
package ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import utilidades.Entrada;

public class NumeroMayorMenorV2 {
	public static void main(String[] args) {
		// Obtiene el número mayor y menor entre una serie de némero introducidos por
		// teclado. SIN UTILIZAR LISTAS, NI MANEJO DE EXCEPCION para números incorrectos
		int menor = 0, mayor = 0, cnt = 0, n = 0;
		boolean salir;
		do {
			System.out.print("Número (ENTER para salir) ? ");
			String t = Entrada.cadena();
			salir = t.equals(""); // Se podría hacer también: salir=t.length()==0;
			if (!salir) {
				if (t.matches("[-]?[0-9]+")) {
					n = Integer.valueOf(t);
					cnt++;
					if (cnt == 1) { // primer número
						mayor = n;
						menor = n;
					} else {// segundo número y sucesivos
						if (n > mayor)
							mayor = n;
						if (n < menor)
							menor = n;
					}
				}
				else
					System.out.println("Sólo se admiten números enteros!!");
			}
		} while (!salir);
		if (cnt > 0) {
			System.out.println("Menor: " + mayor);
			System.out.println("Mayor: " + menor);
		} else {
			System.out.println("No ha introducido números.");
		}
	}

}
