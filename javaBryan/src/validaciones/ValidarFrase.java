package validaciones;

import utilidades.Entrada;

public class ValidarFrase {

	public static void main(String[] args) {
		System.out.println("Introduce una frase:");
		String frase = Entrada.cadena();
		
		if (!frase.isEmpty() && Character.isUpperCase(frase.charAt(0)) && frase.endsWith(".")) {
			System.out.println("Frase válida");
		} else {
			System.out.println("Debe empezar con mayúscula y acabar en punto.");
		}
		
	}

}
