package claseFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import utilidades.Entrada;

public class Escritura {

	public static void main(String[] args) throws IOException {
		/**
		 * crear un fichero de numero pedir al usuaario la cantidad guardar
		 * aleatoriamente esa cantidad de numeros ( 9999) y sumar el total de esos
		 * numeros
		 */
		// seleccionar Ruta de destino
		File ruta = new File("./src/claseFile/datos");// si existe al sobreescrib sino la crea
		// apertura de Ruta àra escribir
		PrintWriter pw = new PrintWriter(new FileWriter(ruta, true));// con true añado mas lineas al final sin borrar el
																		// contenido
		// escritura

		pw.println("nñoki");
		// cierre
		pw.close();

		// seleccionar Ruta de destino
		File rutita = new File("./src/claseFile/numeritos");
		// apertura de Ruta àra escribir
		PrintWriter er = new PrintWriter(new FileWriter(rutita));
		// escritura
		Random rand=new Random();
		boolean salida=false;
		System.out.println("cantidad de numeros");
		int datos=Entrada.entero();
		while (salida) {
			int aleatorios=rand.nextInt(10000);
			er.println(aleatorios);
		
			
		}
		pw.println("nñoki");
		// cierre
		pw.close();

	}

}
