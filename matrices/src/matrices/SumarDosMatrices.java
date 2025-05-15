package matrices;

import java.util.Iterator;

import utilidades.Func;

public class SumarDosMatrices {

	public static void main(String[] args) {
		int [][] m= {{1,2},{4,4},{6,7},{9,2}};
		Func.mostrarMatriz(m);
		int [][] ord=ordenarPorSumaFilas(m);

	}

	/*validacion */
	private static int[][] ordenarPorSumaFilas(int[][] m) {
		
		if(m==null)
			throw new RuntimeException("no existe matriz");
		
		/*nueva matriz resultado*/
		
		int [][] res=new int[m.length][m[0].length];
		
		
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				
				
			}
			
		}
	
		
		
		
		
		
		
		return null;
	}

} 
