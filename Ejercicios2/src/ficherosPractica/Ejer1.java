package ficherosPractica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class Ejer1 {

	public static void main(String[] args) throws IOException {
		System.out.println("ruta a buscar");
		String ruta = "C:\\Users\\bryan\\git\\Java_Ejercicios\\Ejercicios2\\src\\ficherosPractica\\quijote";
		File f = new File(ruta);
		if (!f.exists()) {
			System.out.println("la ruta no existe");
			return;
		} else {
			if (!f.isFile()) {
				System.out.println("la ruta existe pero no es un FICHERO");
				return;
			}
		}

		List<String> l = new ArrayList<String>();

		while (true) {
			System.out.println("cadena a buscar/ENTER PARA SALIR");
			String cadena = Entrada.cadena();
			if (cadena.isEmpty()) {
				System.out.println("fin");
				return;
			}
			l = buscarCadena(f, cadena);
			for (String string : l) {
				System.out.println(string);
			}
		}

	}// main

	private static List<String> buscarCadena(File f, String cadena) throws IOException {
		List<String> l = new ArrayList<String>();
		BufferedReader bfr = new BufferedReader(new FileReader(f));
		String linea = bfr.readLine();
		while (linea != null) {
			// System.out.println(linea);
			if (linea.toLowerCase().contains(cadena.toLowerCase())) {
				l.add(linea);
			}
			linea = bfr.readLine();
		}
		bfr.close();
		return l;

	}

}// clase
