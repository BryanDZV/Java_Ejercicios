package execpciones;

import utilidades.Entrada;
import java.io.IOException;

public class tryCatch {
	public static void main(String[] args) throws Exception {

//		int num2 = 0;
//		int num = 3;
//		int resu = 0;
//
//		try {
//			resu += num / num2;
//		} catch (ArithmeticException e) {
//			System.out.println("no se puede dividir entre 0");
//		}
//		System.out.println(resu);
//
//		try {
//			int numero = Entrada.entero();
//		} catch (NumberFormatException e) {
//			System.out.println("solo puedes meter numeros");
//
//		}

		try {
			System.out.println("introduzca un nombre");
			String nombre = Entrada.cadena();

		
			verficarCarateres(nombre);
		} catch (Exception e) {
			System.out.println("solo letras");
		}

	}

	private static void verficarCarateres(String nombre) throws Exception {

		for (int i = 0; i < nombre.length(); i++) {
			char extCarac = nombre.charAt(i);
			boolean esLetra = Character.isLetter(extCarac);
			if (!esLetra) {
				throw new Exception("solo letras");

			}

		}

	}

}
