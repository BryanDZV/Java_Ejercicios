package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Leer {

	public static void main(String[] args) throws IOException {
		File f=new File("persona1.txt");
		BufferedReader bfr=new BufferedReader(new FileReader(f));
		String linea;
		
		while ((linea=bfr.readLine()) != null){
			System.out.println("longitud "+linea.length()+": "+linea);
		}
		
		bfr.close();
	}

}
