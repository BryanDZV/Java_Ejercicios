package conceptosBasicosEjercicios;

public class PosicionesArrayEjercicio59_74 {

	public static void main(String[] args) {

		/**
		 * estraer elementos 1 y ultimo comparar
		 */
		int[] numeArr = { 1, 2, 34, 1 };

		int size = numeArr.length;
		int primerEleme = numeArr[0];
		int ultimoEleme = numeArr[size - 1];
		boolean resultado = false;
		if (primerEleme == ultimoEleme) {
			resultado = true;
			System.out.println(resultado);
		}else {
			System.out.println(resultado);
		}
		
	}

}
