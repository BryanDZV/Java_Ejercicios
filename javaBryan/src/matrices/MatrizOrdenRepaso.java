package matrices;


import java.util.ArrayList;
import java.util.List;

import utilidades.Func;

public class MatrizOrdenRepaso {

	public static void main(String[] args) {
		int [][] m= {{1,2},{4,4},{6,7},{9,2}};
		Func.mostrarMatriz(m);
		int [][] ord=ordenarPorSumaFilas(m);
		System.out.println();
		Func.mostrarMatriz(ord);

	}

	private static int[][] ordenarPorSumaFilas(int[][] m) {
		if (m==null)
			throw new RuntimeException("No existe matriz para ordenar");
		
		int [][] res=new int[m.length][m[0].length];
		List<SumaFila> l=new ArrayList<SumaFila>();
		
		for (int i = 0; i < m.length; i++) {
			int suma=0;
			for (int j = 0; j < m[i].length; j++) {
				suma += m[i][j];
			}
			System.out.println(i+" "+suma);
			l.add(new SumaFila(i, suma));
		}
		System.out.println(l);
		//Ordeno lista conforme a suma
		l.sort(null);
		System.out.println(l);
		
		return res;
	}

} 
