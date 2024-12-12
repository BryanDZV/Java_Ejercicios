package ejerciciosObjetos;

import utilidades.Entrada;

public class DniRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("introduzca un dni");
		String dni = Entrada.cadena();

		dniValido(dni);

	}

	public static void dniValido(String dni) {
		// TODO Auto-generated method stub
		// DEUELVE NORMALIZADO UN sTRING LA FUNCION
		// NULL SI ES IVALIDO

		// expresion regex
		String t = "[1-9]{8}[A-Z]";

		if (t == dni) {
			System.out.println("formato valido");
		} else {
			System.out.println("formato no valido");
		}

		// array letra
		char[] arrayLetra = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E' };

		// letra requsito
		String numero = "[0-9]{8}";
		int numeroD = Integer.valueOf(numero);
		int resultado = numeroD % 23;
		System.out.println(resultado);

		// COICIDIR LETRA CON REQUISITO

		for (int i = 0; i < arrayLetra.length; i++) {

			if (resultado == i) {
				System.out.println(arrayLetra[i]);

			} else {
				System.out.println("no lelga");

			}

		}

		dni.matches(t);

	}

}
