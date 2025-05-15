package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class CombinarEjercicio58_73 {

	public static void main(String[] args) {
		/**
		 * pasar dos cadenas extraer caracter del string con charARt para la 2 frase
		 * coger el ultimo serai lenght-1 tambien con subtring usar concat pra unir o
		 * concatenando
		 * 
		 */

		System.out.println("frase1");
		String frase1 = Entrada.cadena();
		System.out.println("frase2");
		String frase2 = Entrada.cadena();

		System.out.println(combinar(frase1, frase2));

	}

	private static String combinar(String frase1, String frase2) {

		String frCombinadas = "";
		if (frase1.length() == 0) {
			frase1 = "#";

		} else if (frase2.length() == 0) {
			frase2 = "#";

		}

	
		char frase1Ch = frase1.charAt(0);
		char frase2Ch = frase2.charAt(frase2.length() - 1);
		frCombinadas =""+frase1Ch + frase2Ch;
		return frCombinadas;
	}

}
