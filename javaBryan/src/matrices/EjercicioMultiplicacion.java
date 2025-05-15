package matrices;

import conceptosBasicosEjercicios.FuncionesConceptos;

public class EjercicioMultiplicacion {

	public static void main(String[] args) {
		/*
		 * SUMA DE MATRICES REQUISITO IGUAL ANCHO Y COLUMNAS
		 * 
		 * 
		 * 
		 */

		/*
		 * PLAN DE ATAQUE
		 * 
		 * COMPROBAR FILA Y COLUMNAS CREAR MATRIZ RESULTADO CON EL MISMO F Y C RECORRER
		 * LOS MATRICES RETURN
		 * 
		 */
		
		
		double [][] a= {{2,4,6},{1,2,3}};
		double [][] b= {{5,5,5},{6,6,6}};
		
		double[][] suma=FuncionesConceptos.sumarMatrices(a, b);
		FuncionesConceptos.mostrarMatriz(suma);

		
		
		
	}

}
