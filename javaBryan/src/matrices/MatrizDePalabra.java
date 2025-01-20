package matrices;

import conceptosBasicosEjercicios.FuncionesConceptos;

public class MatrizDePalabra {

	public static void main(String[] args) {
		//matrices
		
		String [][] pal= {{"casa","lobo","alumno"},{"pepe","jardin","chiton"}};
		
		
		FuncionesConceptos.mostrarMatriz(pal);
		
		int [][] numeros= {{3,5},{6,7},{30,111},{8,0}};
		FuncionesConceptos.mostrarMatriz(numeros);

	}



}
