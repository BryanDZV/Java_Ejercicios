package matrices;

import java.util.Random;

public class Restar {

	public static void main(String[] args) {

		int[][] matriz1 = new int[6][6];
		int[][] matriz2 = new int[6][6];

		Random random = new Random();

		int[][] matrizResta = new int[3][3];

		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1[i].length; j++) {

				matriz1[i][j] = random.nextInt(10) + 1;

			}
		} // fin for 1

		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2[i].length; j++) {

				matriz2[i][j] = random.nextInt(10) + 1;

			}
		} // fin for 2

		for (int i = 0; i < matrizResta.length; i++) {
			for (int j = 0; j < matrizResta[i].length; j++) {
				matrizResta[i][j] = matriz1[i][j] - matriz2[i][j];

			}
		} // fin for 1

		// Mostrar matrices
		System.out.println("Matriz 1: ");
		imprimirMatriz(matriz1);
		System.out.println("Matriz 2:");
		imprimirMatriz(matriz2);
		System.out.println("Matriz Resta:");
		imprimirMatriz(matrizResta);

	}// main

	private static void imprimirMatriz(int[][] matrizResta) {
		for (int[] fila : matrizResta) {
			for (int valor : fila) {
				System.out.print(valor + "\t");

			} // cada vlaor
			System.out.println();
		} // cada fila

	}

}// clas
