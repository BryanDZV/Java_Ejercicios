package matrices;

import conceptosBasicosEjercicios.FuncionesConceptos;
import utilidades.Entrada;

public class EjerciciosMatrices {

	public static void main(String[] args) {
		boolean correcto;
		int filasCols;
		do {
			System.out.print("Filas/columnas de la matriz: ");
			filasCols = Entrada.entero();
			correcto = filasCols > 0;
			if (!correcto) {
				System.out.println("Introduzaca un número mayor que 0");
			}
		} while (!correcto);
		
		//Creamos matriz cuadrada
		int [][] m=new int[filasCols][filasCols];
		
		//Ponemos unos en la diagonal
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (j==i)
					m[i][j]=1;
				else
					m[i][j]=0;
			}
		}
		FuncionesConceptos.mostrarMatriz(m);
		System.out.println();
		
		//Ponemos unos en parte superior y diagonal
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (j>=i)
					m[i][j]=1;
				else
					m[i][j]=0;
			}
		}
		FuncionesConceptos.mostrarMatriz(m);
		System.out.println();
		//Ponemos unos en parte inferior
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (j<i)
					m[i][j]=1;
				else
					m[i][j]=0;
			}
		}
		FuncionesConceptos.mostrarMatriz(m);
		

	}


}
