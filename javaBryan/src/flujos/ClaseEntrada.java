package flujos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClaseEntrada {

	public static void main(String[] args) throws IOException {

		/* entrada */
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		/* salida */

		/*
		 * /
		 */
		String linea;
		while ((linea = bfr.readLine()) != null) {

			System.err.println(linea);
			System.err.println("[" + linea + "]");

		}
		bfr.close();

		System.out.println("sigo vivo");

	}

}
