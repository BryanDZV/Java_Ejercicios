package ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Escribir {

	public static void main(String[] args) throws IOException {
		File f=new File("datos");
		PrintWriter pw=new PrintWriter(new FileWriter(f,true));
		
		pw.println("Pirraca");
		
		
		pw.close();
	}

}
