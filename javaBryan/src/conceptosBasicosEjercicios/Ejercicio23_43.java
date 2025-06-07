package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio23_43 {

	public static void main(String[] args) {
		// Llamada al método que gestiona todo el proceso y devuelve el texto formateado 
		
		System.out.println("introduce un texto");
		String texto=Entrada.cadena();
		
		String textoFormateado =FuncionesConceptos.generarTextoFormateado(texto); // Imprimir el texto formateado desde el main 
		System.out.println(textoFormateado);
	}

}
