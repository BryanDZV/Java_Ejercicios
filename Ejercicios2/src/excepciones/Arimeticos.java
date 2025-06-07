package excepciones;

import utilidades.Entrada;

public class Arimeticos {
	public static void main(String[] args) {

		System.out.println("introduzca un numero para dividir");
		int operacion = 0;
		boolean correcto;
		do {
			try {
				int num1 = Entrada.entero();
				operacion += 100 / num1;
				correcto = false;
			} catch (ArithmeticException e) {
				correcto = true;
				System.out.println("el numero no puede ser 0");
				System.out.println("intentalo denuevo");
			}
		} while (correcto);

		System.out.println(operacion);

	}

}
