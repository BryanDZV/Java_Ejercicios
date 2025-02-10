package excepciones;

import java.io.IOException;

public class ComprobadaNoComprobada {

	public static void main(String[] args) throws Exception {
		System.out.println("Hola");
		funcion(3);
		System.out.println("Adiós");
	}

	private static void funcion(int a) throws Exception {
		if (a <= 5) {
				throw new Exception("Error bla bla bla");
		} else if (a <= 10) {
			try {
				throw new RuntimeException("Error2 bla bla bla");
			} catch (RuntimeException e) {
				System.out.println("ERROR222222222222222222222");
			}
		}
	}

}
