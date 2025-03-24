package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\bryan\\Desktop\\ies grado superior\\programacion\\3EVAPROGRAMACION\\pruebasFicheros");
		BufferedReader bfr=new BufferedReader(new FileReader(f));
		String linea=bfr.readLine();
		do {
			System.out.println(linea+" ");
			linea=bfr.readLine();
		} while (linea!=null);
	}

}
