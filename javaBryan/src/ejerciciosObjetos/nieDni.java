package ejerciciosObjetos;

import utilidades.Entrada;

public class nieDni {

	public static void main(String[] args) {
		System.out.println("introduzaca nie");
		String dniNie = Entrada.cadena();

		System.out.println(validarDniNie(dniNie));

	}
	// TODO Auto-generated method stub

	public static String validarDniNie(String dniNie) {
		// Devuelve el dni con 0's a la izquierda(hasta 8) y letra mayúscula si el dni
		// es válido.
		// null si el dni no es válido

		char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };

		dniNie = dniNie.trim().toUpperCase(); // quitamos espacios y pasamos a mayúsculas

		// Distinguimos entre NIE o DNI
		if (dniNie.matches("[XYZ][0-9]{7}[A-Z]")) {
			// NIE

			// Letra inicial
			char letraInicial = dniNie.charAt(0);
			// Letra final
			char letraFinal = dniNie.charAt(dniNie.length() - 1);
			// Números
			String digitos = dniNie.substring(1, dniNie.length() - 1);

			int numero = 0; // Aquí almacenaré el número que voy a dividir por 23
			switch (letraInicial) {
			case 'X':
				numero = Integer.valueOf(digitos);
				break;
			case 'Y':
				numero = 10000000 + Integer.valueOf(digitos);
				break;
			case 'Z':
				numero = 20000000 + Integer.valueOf(digitos);
				break;
			}
			// Obtenemos la letra del array que corresponde a los dígitos
			char letraCalculada = letras[numero % 23];
			// Comparamos letras
			if (letraFinal != letraCalculada) {
				dniNie = null;
			}
			return dniNie;

		} else { // DNI
			if (!dniNie.matches("[0-9]{1,8}[A-Z]")) {
				return null;
			}

			// Letra
			char letra = dniNie.charAt(dniNie.length() - 1);
			// Números
			String digitos = dniNie.substring(0, dniNie.length() - 1);
			// Obtenemos la letra del array que corresponde a los dígitos
			char letraCalculada = letras[Integer.valueOf(digitos) % 23];
			// Comparamos letras
			if (letra == letraCalculada) {
				while (dniNie.length() < 9) { // 8digitos+letra
					dniNie = "0" + dniNie;
				}

			} else {

				// dni incorrecto
				dniNie = null;
			}

			return dniNie;
		}
	}
}
