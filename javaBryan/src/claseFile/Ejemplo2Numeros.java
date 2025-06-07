package claseFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo2Numeros {

	public static void main(String[] args) throws IOException {
		// selecionar de ruta
		File f = new File("./src/claseFile/numeros");
		// apertura de ruta
		FileReader fr = new FileReader(f);
		// lectura de datos
		BufferedReader bfr = new BufferedReader(fr);
		// transiscion de datos
		String linea;// para guardar cada linea de dato
		int suma = 0;
		while ((linea = bfr.readLine()) != null) {
			suma = suma + Integer.valueOf(linea);
		}
		System.out.println(suma);
	}

}
