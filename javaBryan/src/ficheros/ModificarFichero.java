package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ModificarFichero {

	public static void main(String[] args) throws IOException {
		//ruta
		File ruta=new File("numeros1-1000.csv");
		//apertura con ruta
		BufferedReader bfr=new BufferedReader(new FileReader(ruta));
		//lectura y acumular en array su suma
		String [] arrayAcumulador=new String[10];
		String linea=bfr.readLine();
		while (linea!=null) {
			linea=bfr.readLine();
			arrayAcumulador=linea.split(";");
			System.out.println(linea);
		}
		
	
for (String string : arrayAcumulador) {
	System.out.println("******************************");
	System.out.println(string);
}
	}

}
