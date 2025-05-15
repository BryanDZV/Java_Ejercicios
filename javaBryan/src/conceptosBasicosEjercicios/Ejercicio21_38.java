package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio21_38 {

	public static void main(String[] args) {

		System.out.println("letras,espacios,numero y otros quieres saber cuantos hay en tu texto INTRODUCELO");
		
		String texto=Entrada.cadena();
	
		String conteo=FuncionesConceptos.contarLNEO(texto);
		
		System.out.println(conteo);
		

		
	}

}
