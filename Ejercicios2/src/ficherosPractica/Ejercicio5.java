package ficherosPractica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {

	public static void main(String[] args) throws IOException {
		String ruta = ".\\src\\ficherosPractica\\autos";
		File f = new File(ruta);

		if (!f.exists()) {
			System.out.println("la ruta no existe");
			return;
		} else {
			if (!f.isFile()) {
				System.out.println("la ruta existe pero NO es un FICHERO");
				return;
			}
		}
		System.out.println("*****************ORDEN POR MARCA,PRECIO Y MATRICULA****************");
		List<Autos> l = new ArrayList<Autos>();
		l = listarAutos(f);
		l.sort(null);
		for (Autos elemento : l) {
			System.out.println(elemento);
		}
		
		

	}// main

	private static List<Autos> listarAutos(File f) throws IOException {
		List<Autos> l = new ArrayList<Autos>();
		BufferedReader bfr = new BufferedReader(new FileReader(f));
		String linea = bfr.readLine();
		linea = bfr.readLine();// vuelvo a leer para saltarme el encabezado la añado cuadno escirba al principio
		String arrayTemp[] = new String[linea.length()];
		while (linea != null) {
			// System.out.println(linea);
			arrayTemp = linea.split(";");
			Integer precio=Integer.parseInt(arrayTemp[1]);
			l.add(new Autos(arrayTemp[0],precio , arrayTemp[2]));

			linea = bfr.readLine();

		}
		bfr.close();

		return l;
	}

}// clase
