package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumarNumeros {

	public static void main(String[] args) throws IOException {
		File f=new File("numeros");
		BufferedReader bfr=new BufferedReader(new FileReader(f));
		String linea;
		int suma=0;
		
		while ((linea=bfr.readLine()) != null){
			suma=suma+Integer.valueOf(linea);
		}
		bfr.close();
		System.out.println("La suma de los números es: "+suma);
	}

}
