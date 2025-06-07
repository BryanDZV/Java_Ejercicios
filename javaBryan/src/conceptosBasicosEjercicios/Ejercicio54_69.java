package conceptosBasicosEjercicios;

public class Ejercicio54_69 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("introduzca una frase y extraen la primera mita de ella");
		// String frase=Entrada.cadena();
		String frase = "Python loxo pep jaja";

		System.out.println(extraccionPrimeraMitad(frase));
	}

	public static String extraccionPrimeraMitad(String frase) {
		// TODO Auto-generated method stub

		/*
		 * es UN STRING pasarlo a array saber el indice medio de la array recorrer el
		 * array y sacar un substring hasta el indice medio guardar en String resultado
		 */

		// variables globales
		String resultado = "";
		// array
		String[] arrayFrase = frase.split(" ");
		// numero de elementos y punto medio
		int size = arrayFrase.length;
		int sizeMedio = size / 2;

		System.out.println("punto medio ;;.: " + sizeMedio);

		// comprobar longitud

		// Si hay solo una palabra, tomar la primera mitad de la palabra
		if (size == 1) {
			resultado = frase.substring(0, frase.length() / 2);
		} else {

			// Recorrer el array y extraer la primera mitad
			for (int i = 0; i < sizeMedio; i++) {
				// Aquí no usamos <=, solo hasta sizeMedio
				resultado += arrayFrase[i]; // Añadir palabra al resultado

				// Añadir espacio entre las palabras, excepto al final
				if (i < sizeMedio - 1) {
					resultado += " ";
				}
			}
		}

		return resultado;

	}

}
