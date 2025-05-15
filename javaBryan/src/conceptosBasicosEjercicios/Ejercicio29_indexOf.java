package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio29_indexOf {

	public static void main(String[] args) {
		//Escribe un programa que encuentre el índice de la primera
		//aparición de la subcadena "Java" en una cadena dada.
		
		System.out.println("introduce un texto");
		String texto=Entrada.cadena();
		System.out.println("dime una palabra y te digo la posicion de la primera letra donde empieza");
		String palabra=Entrada.cadena();
		System.out.println(FuncionesConceptos.SubcadenaEncontrda(palabra, texto));

	}

}
