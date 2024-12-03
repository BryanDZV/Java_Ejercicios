package ejercicios;

import java.lang.reflect.UndeclaredThrowableException;

import utilidades.Entrada;

public class Ejercicio1_sol {

	public static void main(String[] args) {
		System.out.println("introduce un numero para saber si es Armstrong");
		int numero = Entrada.entero();

		System.out.println(esArmstriong(numero));

	}

	public static boolean esArmstriong(int parametro) {
		// String cifra=""+parametro;
		String cifra = String.valueOf(parametro);

		// String numAms="";
		int numAms = 0;
		if (parametro > 0) {
			for (int i = 0; i < cifra.length(); i++) {
				char extracionCar = cifra.charAt(i);
				int valorCaracter = Character.getNumericValue(extracionCar);
				System.out.println("soy caracter " + extracionCar + "posicion " + i);
				numAms += (int) Math.pow(valorCaracter, cifra.length());
				System.out.println("soy numAmsss " + numAms);

			}
		}

		return parametro == numAms;
	}

}
