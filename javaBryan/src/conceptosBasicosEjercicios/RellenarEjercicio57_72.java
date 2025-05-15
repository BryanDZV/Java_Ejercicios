package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class RellenarEjercicio57_72 {

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

		System.out.println(tresCaracteres(frase));

	}

	private static String tresCaracteres(String frase) {

		/**
		 * recorro con for para cada i voy rellenando por # (relleno con +=)
		 * 
		 * 
		 * ir rellenando asta que sea longitud 3
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		String fraseResultado = frase;
		int len = fraseResultado.length();

		int lenFaltante = Math.abs(len - 3);
		System.out.println("bucle while-----------");
		while (len < 3) {
			
			
			fraseResultado +="#";
			len=fraseResultado.length();

		}

		/***************************/

//		System.out.println("bucle for----------------------");
//		
//		if (len >= 3) {
//			fraseResultado = frase.substring(0, 3);
//
//		} else if (len < 3) {
//
//			for (int i = 0; i < lenFaltante; i++) {
//
//				fraseResultado += "#";
//
//			} // fin for
//
//		} // fin else

		return fraseResultado;
	}// fin metodo

}
