package ejemplos;

import java.util.ArrayList;
import java.util.List;

import utilidades.Func;

public class MatrizOrden {

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
		
		
		List<SumaFila> l=new ArrayList<SumaFila>();
		
		for (int i = 0; i < m.length; i++) {
			int suma=0;
			for (int j = 0; j < m[i].length; j++) {
				suma += m[i][j];
			}
			l.add(new SumaFila(i, suma));
		}
		//Ordeno lista conforme a suma (ver compareTo en SumaLista)
		l.sort(null);
		//Creamos matris resultado de la ordenación
		int [][] res=new int[m.length][m[0].length];
		
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				res[i][j] = m[l.get(i).getIndiceFila()][j];
			}
		}
		
		return res;
	}

}
