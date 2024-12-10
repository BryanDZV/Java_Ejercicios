package conceptosBasicosEjercicios;

public class Ejercicio44_59 {

	public static void main(String[] args) {
		/*
		 * Convertir a minúsculas
		 * 
		 * Escriba un programa Java para convertir una cadena a minúsculas.
		 */

		System.out.println("itroduzca un texto");
		String texto = "EL ZORRO MARRÓN RÁPIDO SALTA SOBRE EL PERRO PEREZOSO.";

		// pimera letra mayuscula
		String[] textoFormateadoMayusculas = FuncionesConceptos.primeraLetraMayuscula(texto);
		for (int i = 0; i < textoFormateadoMayusculas.length; i++) {
			System.out.print(" ");
			System.out.print(textoFormateadoMayusculas[i]);
		} // fin for

		// cadena en minusculas
		String textoFormateado = FuncionesConceptos.cadenaMinusculas(texto);

		System.out.println("\n" + "-------------------------");
		System.out.println(textoFormateado);

	}

}
