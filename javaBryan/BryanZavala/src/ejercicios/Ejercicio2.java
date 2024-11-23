package ejercicios;

import utilidades.Entrada;

public class Ejercicio2 {

	public static void main(String[] args) {

		System.out.println("introduce una frase");
		String texto = Entrada.cadena();

		System.out.print(eliminarImpares(texto));

	}

	public static String eliminarImpares(String parametro) {
		String resultado = "";
		String resultadoM = "";
		String fin = "fin";
		if (parametro.toString() == fin) {
			return fin;

		}else {
			for (int i = 0; i < parametro.length(); i++) {
				char caracter = parametro.charAt(i);

				if (parametro.toLowerCase() == fin) {
					System.out.println("finfff");
					;
				} else {
					if (i % 2 != 0) {
						resultado = resultado + caracter;

					}
					if (i % 2 == 0) {
						resultadoM = resultadoM + parametro.toUpperCase().charAt(i);
					} else {
						resultadoM = resultadoM + parametro.charAt(i);
					}
				}

			}
			
		}

		return resultado + "\n" + resultadoM;
	}

}
