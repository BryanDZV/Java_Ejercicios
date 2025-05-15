package examen1;

import aleatorios.ExtraccionCaracter;
import utilidades.Entrada;

public class Ejercicio1 {

	public static void main(String[] args) {
		System.out.println("introduce un Numero Amstrong");
		int numeroAmstrong = Entrada.entero();

		System.out.println("el numero "+numeroAmstrong+ " es "+ esAmstrong(numeroAmstrong));

	}

	public static boolean esAmstrong(int parametro) {

		String resultado = "";
		String parametroString = "" + parametro;
		int longitud = parametroString.length();
		double contador = 0;
		
		if (parametro>0) {
			for (int i = 0; i < parametroString.length(); i++) {
			char extracionCaracter = parametroString.charAt(i);
			int valorNumerico = Character.getNumericValue(extracionCaracter);
			// verificacion amstrong
			double valorExponente = Math.pow(valorNumerico, longitud);
			contador = contador + valorExponente;
			// double valorExponente=Math.pow(valorCaracter, parametroString.length());

		}
		}
		
		return contador == parametro;
	}

}
