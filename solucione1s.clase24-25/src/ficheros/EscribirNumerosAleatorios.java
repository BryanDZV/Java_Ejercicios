package ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Random;

import utilidades.Entrada;

public class EscribirNumerosAleatorios {

	public static void main(String[] args) throws IOException {
		System.out.print("Cuántos números quieres generar? ");
		int cuantos=Entrada.entero();
		
		Random r=new Random();
		
		File f=new File("numeros");
		PrintWriter pw=new PrintWriter(new FileWriter(f));
		
		for (int i = 1; i <= cuantos; i++) {
			pw.println(r.nextInt(10000)); //0..9999
		}
		pw.close();
	}

}
