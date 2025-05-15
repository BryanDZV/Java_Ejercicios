package ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Numeros1a100CSV {

	public static void main(String[] args) throws IOException {
		File f=new File("Numeros1-1000.csv");
		PrintWriter pw=new PrintWriter(new FileWriter(f));
		for (int i = 1; i <=1000; i++) {
			pw.print(i);
			if (i%10==0)
				pw.println();
			else
				pw.print(";");
		}
		pw.close();
	}

}
