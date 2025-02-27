package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio57_72 {

	public static void main(String[] args) {
		/**
		 * pasar una frase como pramatro
		 * 
		 * coger los 3 primero caracteres (substring)
		 * 
		 * camibar por # si la longitud es menor a 3
		 * 
		 */

		System.out.println("frase :::");
		String frase = Entrada.cadena();

		tresCaracteres(frase);

	}

	private static void tresCaracteres(String frase) {
		
		/**
		 * recorro con for para cada i voy rellenando por #
		 * 
		 * 
		 * ir rellenando asta que sea longitud 3
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		int len=frase.length();
		
		if (len>=3) {
			frase.substring(0, 4);
		}else if (len<3) {
			for (int i = 0; i < frase.length(); i++) {
				//String frellenado=
				
				
			}
		}
		
		

		
	}

}
