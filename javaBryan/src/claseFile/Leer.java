package claseFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Leer {
	public static void main(String[] args) throws IOException {
		// Seleccionar ruta
		File f = new File("./src/claseFile/persona1.txt");
		// Apertura del archivo
		BufferedReader bfr = new BufferedReader(new FileReader(f));
		// Primera lectura
		String linea = bfr.readLine();

		// Bucle do-while corregido
		do {
			System.out.println(linea + " " + linea.length());

			linea = bfr.readLine(); // Leer siguiente línea
		} while (linea != null);

		// Cierre del archivo
		bfr.close();
	}

}
