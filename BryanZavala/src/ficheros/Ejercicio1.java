package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {
		System.out.println("una ruta");
		// C:\Users\bryan\git\Java_Ejercicios\BryanZavala\src\ficheros\texto1.txt
		// String ruta = Entrada.cadena();
		String ruta = "src/ficheros/texto1.txt";
		File f = new File(ruta);
		if (!f.exists()) {
			System.out.println("la ruta no existe");
			return;

		} else if (!f.isFile()) {
			System.out.println("la ruta existe pero no es un archivo");
			return;
		}
		System.out.println("ruta encontrada");
		while (true) {
			System.out.println("cadena a buscar/ENTER PAR SALIR");
			String cadena = Entrada.cadena();
			if (cadena.isEmpty()) {
				System.out.println("has pulsado enter.saliendo...");
				return;
			} else {

				List<String> l = new ArrayList<String>();
				l = buscarCadena(f, cadena);
				if (l.isEmpty()) {
					System.out.println("no se encontro coincidencias");

				} else {
					for (String elemento : l) {
						System.out.println("encontrada coincidencias------" + elemento);

					}
				}
			}

		}
	}// main

	private static List<String> buscarCadena(File f, String cadena) throws IOException {
		List<String> l = new ArrayList<String>();
		BufferedReader bfr = new BufferedReader(new FileReader(f));
		String linea = bfr.readLine();
		do {

			// System.out.println(linea);
			if (linea.toLowerCase().contains(cadena.toLowerCase())) {
				String lineaR = linea.replaceAll(cadena, cadena.toUpperCase());
				l.add(lineaR);
			}
			linea = bfr.readLine();
		} while (linea != null);

		bfr.close();
		return l;
	}

}// clase
