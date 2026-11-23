package pruebas;

public class Pruebas {

	public static void main(String[] args) {
		int[][] matriz = new int[4][4];
		int[][] matrizX = new int[4][4];
		int[][] matrizR = new int[4][4];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				int aleatorio = (int) (Math.random() * 5) + 1;
				matriz[i][j] = aleatorio;

				if (i == j) {
					matriz[i][j] = 7;
				} else if (i + j == 3) {
					matriz[i][j] = 7;
				} else {
					matriz[i][j] = aleatorio;
				}
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println(" ");
		}

		System.out.println("*********");
		for (int i = 0; i < matrizX.length; i++) {
			for (int j = 0; j < matrizX[i].length; j++) {
				int aleatorio = (int) (Math.random() * 3) + 0;
				matrizX[i][j] = aleatorio;

				if (i == j) {
					matrizX[i][j] = 9;
				} else if (i + j == 3) {
					matrizX[i][j] = 9;
				} else {
					matrizX[i][j] = aleatorio;
				}
				System.out.print(matrizX[i][j] + " ");
			}
			System.out.println(" ");
		}
		System.out.println("*********");
		for (int i = 0; i < matrizX.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matrizR[i][j] = matrizX[i][j] + matriz[i][j];
				System.out.print(matrizR[i][j] + " ");
			}
			System.out.println(" ");
		}
		System.out.println("*********");
		System.out.println("*********");
		double decimal=8.987;
		int parteEntera=(int)decimal;
		double parteDecimal1=decimal-parteEntera;
		double parteDecimal=Math.round(parteDecimal1 * 1000) / 1000.0;

		System.out.println("numero::."+decimal);
		System.out.println("parte Entera::"+parteEntera);
		System.out.println("parte Decimal1::"+parteDecimal1);
		System.out.println("parte Decimal::"+parteDecimal);
	
	}

}
