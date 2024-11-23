package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio30_Contiene {

	public static void main(String[] args) {
		//Escribe un programa que verifique si una cadena 
		//contiene la subcadena "programación".
		
		System.out.println("introduce un texto");
		String texto=Entrada.cadena();
		System.out.println("que palabra buscas");
		String palabra=Entrada.cadena();
		
		
		
		System.out.println(FuncionesConceptos.EncuentraFrase(texto, palabra));
		
		
	}

}
