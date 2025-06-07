package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class EliminarPrimerCaracterYConcatenar56_71 {

	public static void main(String[] args) {
		/**
		 * pedir frase y pasarla ala funcion
		 * 
		 * elimanar 1 caracter de la frase (usar subtring)
		 * 
		 * concatenar las frase en un string
		 * 
		 * longitud de 1
		 * 
		 * 
		 */
		
		
		try {
			System.out.println("vamos a introducir 2 frase para unirlas sin su 1 letra");
			System.out.println("introducir una frase");
			String frase = Entrada.cadena();
			System.out.println("introduce 2 frase");
			String frase2 = Entrada.cadena();
			
			
			
			System.out.println(eliminarPrimerCaracter(frase, frase2));
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("la longitud minima es 1::::"+e.getMessage());
		}

	

	}

	private static String eliminarPrimerCaracter(String frase, String frase2) {
		String f1 = frase.substring(1);
		String f2 = frase2.substring(1);

		String resultado = f1.concat(f2);
		//System.out.println("soy la union:::" + resultado);
		
		return resultado;

	}

	/**
	 * concat uno strings y me devuelve un string subtring me da un string con el
	 * iinico y final especificado
	 * 
	 * 
	 * 
	 * 
	 */

}
