package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class ExamenPrueba {

	public static void main(String[] args) {
/*	//index of 1 parametro

		System.out.println("Introduzca un texto");
		String t = Entrada.cadena();
		int contadorEspacios = 0;

		do {
			int pos = t.indexOf(" ");
			if (pos != -1) {
				contadorEspacios++;
				t = t.substring(pos + 1);// nuevo string desde la posicion anterior

			}
			System.out.println(pos);
		} while (contadorEspacios < 4);

		*/
		// INDEX 2 PARAMETROS

		System.out.println("2 PARAMETROS AHORA");

		String t2 = Entrada.cadena();
		int contador2 = 0;
		int pos = 0;
		int encontrado=0;

		do {
			pos = t2.indexOf("", pos);
			System.out.println(pos);//posiciones en las que encuentra espacios

			if (pos != -1) {
				contador2++;
				encontrado=pos;//asigo par evitar la pos de errror +1 en syso 
				pos=pos+1;
				

			}

		} while (contador2 != 2 && pos != -1);// regla CUANDO SEA FALSO SALGO SIE S TRUE SIGO

		if (contador2==2) {
			System.out.println("el segundo espacio esta en la posicion:"+pos);//aqui con encontrado evitamos el error
			
		} else {
			
			System.out.println("no hay segundo espacio");
			

		}
		
		
	}

}
