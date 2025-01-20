package matrices;

import utilidades.Func;

public class MatrizDePalabras {

	public static void main(String[] args) {
		String [][] pal= {{"casa","lobo","alumno"},
				          {"pepe","jardín","chitón"}};
		Func.mostrarMatriz(pal);
		
		int [][] numeros= {{3,5},{6,7},{30,111},{8,0}};
		Func.mostrarMatriz(numeros);
		
	}

}
