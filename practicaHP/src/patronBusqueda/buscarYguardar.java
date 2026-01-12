package patronBusqueda;

public class buscarYguardar {

	public static void main(String[] args) {
		/*
		 * Leer los datos correspondiente a dos tablas de 12 elementos numéricos, y
		 * mezclarlos en una tercera de la forma: 3 de la tabla A, 3 de la B, otros 3 de
		 * A, otros 3 de la B, etc
		 */

		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int[] array2 = { 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };
		int[] array3 = new int[18];
		int contador=0;
		for (int i = 0; i < array1.length; i++) {
			array3[contador]=array1[i];
			if(i%2==0) {
				for (int j = 0; j < array2.length; j++) {
					array3[contador]=array1[j];
					if(j%2==0) {
						
					}
				}
			}
		}

	}

}
