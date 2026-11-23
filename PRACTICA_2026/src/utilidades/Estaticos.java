package utilidades;

public class Estaticos {
	// 1. Realizar una función, a la que se le pase como parámetro un número N, y
	// muestre por
	// pantalla N veces, el mensaje: “Módulo ejecutándose”
	public static String intro(int num, String texto) {
		String mensaje = "";
		while (num > 0) {
			mensaje += texto + "\n";
			num--;
		}
		return mensaje;

	}

	/*
	 * . Diseñar una función que tenga como parámetros dos números, y que calcule el
	 * máximo.
	 */
	public static int maximo(int num1, int num2) {
		return (num1 > num2) ? num1 : num2;

	}
	
	/*3.  una versión que calcule el máximo de 3 números.*/
	//SOBRECARGAMOS
	
	public static int maximo(int num1, int num2,int num3) {
		return maximo(maximo(num1,num2),num3);
		

	}
	/*versión que calcule el máximo de una tabla de n elementos.*/
	
	public static int maximo(int[] numeros) {
		int max=numeros[0];
		for(int i=1;i<numeros.length;i++) {
			max=maximo(max,numeros[i]);
		}
		return max;

	}
	
	

}
