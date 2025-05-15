package ordenamientos;

public class bubbleSort {
	public static void main(String[] args) {
		/**
		 * que ordena una lista iterando repetidamente a través de ella, comparando
		 * elementos adyacentes y cambiándolos de posición si están en el orden
		 * incorrecto.
		 * 
		 * Comenzar desde el primer elemento. Comparar el elemento actual con el
		 * siguiente. Si el elemento actual es mayor que el siguiente, intercambiarlos.
		 * Continuar comparando y cambiando de posición hasta el final de la lista.
		 * Repetir el proceso para todos los elementos, hasta que no se necesiten más
		 * intercambios.
		 * 
		 */
		int[] arrayNum = { 54, 87, 5, 4, 7, 8, 53, 2, 5 };

		bubbleSort(arrayNum);
		System.out.println("array ordenado");

		for (int i : arrayNum) {
			System.out.print(+i + ", ");

		}
	}

	private static void bubbleSort(int[] arrayNum) {

		for (int i = 0; i < arrayNum.length; i++) {
			boolean swap = false;
			for (int j = 0; j < arrayNum.length - 1; j++) {
				if (arrayNum[j] > arrayNum[j + 1]) {
					int temp = arrayNum[j];
					arrayNum[j] = arrayNum[j + 1];
					arrayNum[j + 1] = temp;
					swap = true;
				} else {
					swap = false;
				}
			}

		}

	}

}
