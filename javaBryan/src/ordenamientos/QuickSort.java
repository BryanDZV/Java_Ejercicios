package ordenamientos;

public class QuickSort {

	public static void main(String[] args) {

		int[] array = { 1, 5, 8, 98, 145, 5, 4, 56, 3 };

		quickSort(array, 0, array.length - 1);
		System.out.println("array ordenado");
		for (int i : array) {
			System.out.print(i + ", ");
		}

	}

	private static void quickSort(int[] array, int low, int high) {
		/** DIVIDE Y VENCERAS */
		/**
		 * Elegir un pivote.
		 *  Particionar la lista en dos sublistas: una con elementos
		 * menores que el pivote y otra con elementos mayores.
		 *  Aplicar recursivamente el ordenamiento a las sublistas.
		 *  Combinar las sublistas ordenadas con el pivote.
		 */
		/** HASTA CUADNO DIVIDO? */
		if (low < high) {
			int pi = partition(array, low, high);// retorna la posicon del pivote
			quickSort(array, low, pi - 1); // Ordena la parte izquierda
			quickSort(array, pi + 1, high);// Ordena la parte derecha
		}

	}

	private static int partition(int[] array, int low, int high) {
		/** ¿Cómo elegimos el pivote y reorganizamos los números? */
		int pivot = array[high];
		int i = low - 1;// i Marcará la frontera entre los números menores y mayores que el pivote.
		// Nos indica que aún no hemos encontrado números menores que el pivote .
		for (int j = low; j < high; j++) { // Recorremos desde low hasta high - 1
			if (array[j] < pivot) { // Si encontramos un número menor que el pivote
				i++; // Avanzamos la frontera de los números menores
				// el ulitmo menor tendra la posicion i para cuando j termine el bucle por esoi
				// es frontera

				// Intercambiamos array[i] con array[j]
				/**
				 * Cuando encontramos un número menor, lo intercambiamos con el primer número
				 * mayor que encontramos antes .
				 */
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;

			}
		}
		// Colocamos el pivote en su posición correcta
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;

		return i + 1; // Retornamos la posición del pivote
	}

}
