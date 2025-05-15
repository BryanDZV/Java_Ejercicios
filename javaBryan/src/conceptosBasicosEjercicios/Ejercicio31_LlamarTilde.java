package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio31_LlamarTilde {

	public static void main(String[] args) {
		// llamar tilde
		System.out.println("introduce un texto");
		String texto=Entrada.cadena();
		
		System.out.println(Func.quitarTildes(texto));
		
	
		
	}
	

}
