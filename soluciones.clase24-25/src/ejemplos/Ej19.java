package ejemplos;

import utilidades.Entrada;

public class Ej19 {

	public static void main(String args[]) {
		int negativos;
		int num;
		int positivos;
		String t;
		boolean terminar;
		negativos = 0;
		positivos = 0;
		do {
			System.out.println("Número (Introduzca SALIR para terminar)?");
			t = Entrada.cadena();
			t=t.toUpperCase();
			terminar = t.equals("SALIR");
			if (!terminar) {
				num = Integer.valueOf(t);
				// Convertimos texto a número
				if (num < 0) {
					negativos++;
				} else {
					positivos++;
				}
			}
		} while (!terminar);
		System.out.println("Negativos: " + negativos);
		System.out.println("Positivos: " + positivos);
	}

	
	
	
	
	
	
	
	
}