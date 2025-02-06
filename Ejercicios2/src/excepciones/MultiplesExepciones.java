package excepciones;

import utilidades.Entrada;

public class MultiplesExepciones {

	public static void main(String[] args) {
		System.out.println("introduce un numero");
		boolean correcto;
		int num1 = 0;
		int operacion=0;

		do {
			try {

				num1 = Entrada.entero();
				 operacion = 100 / num1;
				correcto = true;
			} catch (NumberFormatException e) {
				System.out.println("solo puedes poner numero");
				System.out.println("intentalo de nuevo");
				correcto = false;
			} catch (ArithmeticException e) {
				System.out.println("no se puede dividir entre numero 0");
				System.out.println("intentalo de nuevo");
				correcto = false;

			}

		} while (!correcto);
		System.out.println(
				"tu numero es: " + num1 + "y el resultado de la division de 100 entre tu numero es: " + operacion);

	}

}
