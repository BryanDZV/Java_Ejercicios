package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicios22_39 {

	public static void main(String[] args) {

		System.out.println("introduce 4 numeros y te doy las opciones posibles de 3 cifras con los 4 numeros");
		
		int numA=Entrada.entero();
		int numB=Entrada.entero();
		int numC=Entrada.entero();
		int numD=Entrada.entero();
		
		
		String resultado=FuncionesConceptos.numerosPosibles(numA, numB, numC, numD);
		System.out.println(resultado);
		
		
		
		
		
		
	}

}
