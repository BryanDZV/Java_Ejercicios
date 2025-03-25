package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {
	/*
	 * En Windows, puedes usar \\ para las barras invertidas (\) o / para las barras
	 * diagonales (/).
	 * 
	 * En Unix/Linux, es común usar solo /.
	 */

	public static void main(String[] args) throws IOException {
		File f = new File(
				"I:\\Otros ordenadores\\Mi portátil hp\\ies grado superior\\programacion\\3EVAPROGRAMACION\\pruebasFicheros\\pruebaProg.csv");
		BufferedReader bfr = new BufferedReader(new FileReader(f));
		String linea = bfr.readLine();
		do {
			System.out.println(linea + " ");
			linea = bfr.readLine();
		} while (linea != null);
	}

}
