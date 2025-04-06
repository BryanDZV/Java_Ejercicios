package ejemplos;

public class sumarNumeros {

	public static void main(String[] args) {

		sumar(7, 12);
		sumar(7, 12, 3);

		System.out.println("2 argumetnos:  " + sumar(7, 12));
		System.out.println("3 argumetnos:  " + sumar(7, 12, 3));

	}

	private static int sumar(int a, int b, int c) {
		int r = a + b + c;
		return r;
	}

	private static int sumar(int a, int b) {
		int r = a + b;
		return r;

	}

}
