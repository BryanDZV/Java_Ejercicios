package ordenamientos;

public class mergeSort {

	public static void main(String[] args) {
		/** DIVIDE Y VENCERAS */
		/**
		 * Dividir la lista en dos mitades. Ordenar cada mitad recursivamente. Combinar
		 * las mitades ordenadas.
		 */

		int[] array = { 1, 4, 5, 75, 67 };

		System.out.println("array ordenado");
		mergeSort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + ", ");
		}
	}

	private static void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;// Calculamos el punto medio
			// Dividimos en dos mitades
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);

			// Combinamos las dos mitades ordenadas
			merge(array, left, mid, right);
		}

	}

	private static void merge(int[] array, int left, int mid, int right) {
		// Método para fusionar dos subarrays ordenados

		int n1 = mid - left + 1; // Tamaño de la primera mitad
		int n2 = right - mid; // Tamaño de la segunda mitad
		// Creamos arrays temporales
		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];
		// Copiamos los datos a los subarrays
		for (int i = 0; i < n1; i++)
			leftArray[i] = array[left + i];

		for (int j = 0; j < n2; j++)
			rightArray[j] = array[mid + 1 + j];
		// Fusionamos los arrays ordenados
		int i = 0, j = 0;
		int k = left;

		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		// Copiamos los elementos restantes de leftArray (si hay)
		while (i < n1) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		// Copiamos los elementos restantes de rightArray (si hay)
		while (j < n2) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}
}
