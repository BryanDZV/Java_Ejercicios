package conceptosBasicosEjercicios;

public class Posiciones_arryaEjercicio60_75 {

	public static void main(String[] args) {
		/**
		 * verificar si el primer o ultimo elementos es 10
		 * 
		 * coger el 1 y ultimo elemento y comprar que sean iguales
		 * 
		 * debes ser 10 los dos es true
		 */

		int[] arrNumeros = { 10, 5, 3, 2, 12, 10 };
		int size = arrNumeros.length;
		boolean resultado = false;

		if (arrNumeros[0] == 10 && arrNumeros[0] == arrNumeros[size - 1]) {
			resultado = true;
			System.out.println(resultado);
		} else {
			System.out.println(false);
		}

	}

}
