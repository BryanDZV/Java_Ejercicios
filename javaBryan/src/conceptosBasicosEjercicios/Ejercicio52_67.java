package conceptosBasicosEjercicios;

public class Ejercicio52_67 {

	public static void main(String[] args) {
		// void no devuelve nada

		System.out.println("inserta una frase");
		// String frase = Entrada.cadena();
		String frase = "Python 3.0";

		System.out.println("inserta una palabra para colocarla en medio de la frase");
		// String palabra = Entrada.cadena();
		String palabra = "Tutorial";

		System.out.println("resultado :::" + palabraEnMedio(frase, palabra));

	}

	private static String palabraEnMedio(String frase, String palabra) {
		// TODO Auto-generated method stub

		// variables

		String resultado = "";

		// pasar a array

		String[] arrayFrase = frase.split(" ");

		// mita de la cadena

		int sizeMedio = (arrayFrase.length) / 2;
		System.out.println("mitad de array " + sizeMedio);

		// insertar la palabra en medio en un array
		for (int i = 0; i < arrayFrase.length; i++) {
			resultado += arrayFrase[i];
			// System.out.println("palabra ::" + arrayFrase[i] + " su posicion::: " + i);
			// Insertar la palabra en el índice medio
			if (i == sizeMedio - 1) {
				// System.out.println(arrayFrase[sizeMedio]);
				resultado += " " + palabra;

			}
			// Añadir un espacio después de cada palabra excepto la última
			if (i < arrayFrase.length - 1) {
				resultado += " ";
			}
		}

		return resultado;
	}

}
