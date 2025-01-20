package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio55_70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("escribe dos frase no pueden  tener la misma longitud");
		String fraseUno = Entrada.cadena();
		String fraseDos = Entrada.cadena();

		while (mixingCortaLargaCorta(fraseUno, fraseDos).contains("true")) {
			System.out.println("no pueden tener la misma longitud");
			fraseDos = Entrada.cadena();
			fraseUno = Entrada.cadena();
		}

		System.out.println(mixingCortaLargaCorta(fraseUno, fraseDos));

	}

	public static String mixingCortaLargaCorta(String fraseUno, String fraseDos) {
		// TODO Auto-generated method stub
		/*
		 * comprobar que no tegan la misma longitud saber cual tiene longitud corttaa y
		 * cual larga guardar en resultado la cadena corta + larga+corta
		 * 
		 */

		// variables

		String resultado = "";
		// longitud
		int longitudFraseUno = fraseUno.length();
		int longitudFraseDos = fraseDos.length();

		// comprobar que no sean igual logitud
		boolean iguales = false;
		if (longitudFraseUno == longitudFraseDos) {
			iguales = true;
			resultado = String.valueOf(iguales);
		} else if (longitudFraseUno > longitudFraseDos) {

			resultado = fraseUno + " " + fraseDos + " " + fraseUno;

		} else {
			resultado = fraseDos + " " + fraseUno + " " + fraseDos;
		}

		return resultado;
	}

}
