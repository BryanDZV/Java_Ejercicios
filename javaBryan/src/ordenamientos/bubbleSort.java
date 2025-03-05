package ordenamientos;

public class bubbleSort {
	public static void main(String[] args) {
		/**
		 * ordena una lista recorriendola y comparando los elementos adyacentes
		 */
		int[] arrayNum = { 54, 87, 5, 4, 7, 8, 53, 2, 5 };

		bubbleSort(arrayNum);
		System.out.println("array ordenado");
		
		for (int i : arrayNum) {
			System.out.print(+i+", ");
			
		}
	}

	private static void bubbleSort(int[] arrayNum) {

		for (int i = 0; i < arrayNum.length; i++) {
			boolean swap = false;
			for (int j = 0; j < arrayNum.length-1; j++) {
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
