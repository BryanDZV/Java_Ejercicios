package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio35_51 {

	public static void main(String[] args) {
		//  Escriba un programa Java para
		//convertir una cadena en un entero.
		
		
		
		System.out.println("introduce un (numero) para convertir a entero");
		String cadenaNum=Entrada.cadena();
		
		while (!cadenaNum.matches("[0-9]+")) {
			System.out.println("No es un numero");
			 cadenaNum=Entrada.cadena();			
		}
		
		System.out.println("Cadena(String) ="+cadenaNum+"  convertida a numero entero(int)="+FuncionesConceptos.cadenaToNumero(cadenaNum));
		

	}

	

}