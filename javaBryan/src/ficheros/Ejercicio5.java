package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;

public class Ejercicio5 {

	public static void main(String[] args) {
		String ruta="\\src\\ficheros\\coche.cvs";
		File f=new File(ruta);
		BufferedReader bfr=new BufferedReader(new FileWriter(f));


	}

}
