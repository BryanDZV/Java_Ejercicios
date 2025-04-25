package ejemplos;

import java.util.ArrayList;
import java.util.List;

import utilidades.Func;

public class MatrizOrden {

	public static void main(String[] args) {
		int [][] m= {{1,2,75},{4,4,22},{6,7,1},{9,2,5}};
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
		System.out.println(l);
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
