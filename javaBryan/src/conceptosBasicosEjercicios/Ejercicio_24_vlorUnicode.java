package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio_24_vlorUnicode {

	public static void main(String[] args) {
		// VALOR UNICODE
		
		System.out.println("introduce una letra para saber su valor unicode");
		char letra=Entrada.caracter();
		int valorUnicode=(int)letra;
		
		System.out.println("valor unicode de la"+" "+letra+"es"+" :"+valorUnicode);

	}

}
