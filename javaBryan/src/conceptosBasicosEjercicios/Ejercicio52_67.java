package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio52_67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("inserta una frase");
		//String frase = Entrada.cadena();
		String frase="pato lucas";

		System.out.println("inserta una palabra para colocarla en medio de la frase");
		//String palabra = Entrada.cadena();
		String palabra="jose";
		
		System.out.println("resultado :::"+palabraEnMedio(frase,palabra));

	}

	private static String palabraEnMedio(String frase, String palabra) {
		// TODO Auto-generated method stub
		
		//variables
		
		String resultado="";
		
		//pasar a array 
		
		String [] arrayFrase=frase.split(" ");
		
		//mita de la cadena
		
		int sizeMedio=(arrayFrase.length)/2;
		System.out.println(sizeMedio);
		
		//insertar la palabra en medio en un array :for
		
		for (String string : arrayFrase) {
			resultado+=string.substring(0);
		}
		
		
		
		
		
		return resultado;
	}

}
