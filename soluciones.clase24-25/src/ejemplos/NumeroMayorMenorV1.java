
package ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import utilidades.Entrada;

public class NumeroMayorMenorV1 {
	public static void main(String[] args) {
		// Obtiene el número mayor y menor entre una serie de némero introducidos por
		// teclado
		ArrayList<Integer> al = new ArrayList<Integer>();

		boolean salir;
		do {
			System.out.print("Número (ENTER para salir) ? ");
			String t = Entrada.cadena();
			salir = t.equals(""); // Se podría hacer también: salir=t.length()==0;
			if (!salir) {
				try {
					al.add(Integer.valueOf(t));
				} catch (NumberFormatException e) {
					System.out.println("Sólo se admiten números enteros!!");
				}
			}
		} while (!salir);
		// Ordenamos lista denúmeros, el menor será el primero y el mayor el último
		al.sort(null);
		if (al.size() > 0) {
			System.out.println("Menor: "+al.get(0));
			System.out.println("Mayor: "+al.get(al.size()-1));
		}
		else{
			System.out.println("No ha introducido números.");
		}
	}

}
