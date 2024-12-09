package conceptosBasicosEjercicios;

public class Ejercicio43_58 {

	public static void main(String[] args) {
		/*
		 * Escriba cada palabra con mayúscula Escriba un programa en Java para poner en
		 * mayúscula la primera letra de cada palabra de una oración. Ejemplo de salida:
		 */

		System.out.println("introduzca un texto");
		String texto = "simplemente el texto asdsa asdsa fdf d dsfds e relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como";

		// METODO 1 ARRAY STRING
		String[] textoFormateado = FuncionesConceptos.primeraLetraMayuscula(texto);
		for (String string : textoFormateado) {
			System.out.println(string);
		}
		// METODO 2 STRING
		/*
		 * String textoFormateado = FuncionesConceptos.primeraLetraMayuscula(texto);
		 * System.out.println(textoFormateado);
		 * 
		 */
	}
}
