package examen1;

import utilidades.Entrada;

public class Ejercicio2Real {

	public static void main(String[] args) {
		System.out.println("introduce una frase y un numero");
		String texto = Entrada.cadena();
		int numero=Entrada.entero();

		//System.out.print("tu frase sin impares es"+textoImpar+"tu numero sin impar es"+numeroImpar);
		System.out.println("2"+eliminarImpares(texto, numero));
	}

	public static String eliminarImpares(String parA, int parB) {
		String resultado="";
		String parAnuevo="";
		for (int i = 0; i < parA.length(); i++) {
			int caracterPosicion=parA.indexOf(i);
			char caracterExtracion=parA.charAt(i);
			if (caracterPosicion%2!=0) {
				parAnuevo=parAnuevo+caracterExtracion;
				
			}
			
		}
		
		resultado="texto"+parA+"sin impares es\n"+parAnuevo;
		return resultado;
	}
}
