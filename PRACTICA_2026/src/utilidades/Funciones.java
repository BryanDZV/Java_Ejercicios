package utilidades;

import java.nio.charset.IllegalCharsetNameException;

public class Funciones {

	public static int calculoFactorial(int numero) {
		int factorial = 0;
		if (numero < 0) {
			throw new IllegalArgumentException();
		} else if (numero == 0) {
			factorial = 1;

		} else {
			int flag = numero;
			while (flag > 0) {
				flag--;
				factorial += numero * (flag);

			}
		}

		return factorial;
	}

}
