package ficherosPractica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import utilidades.Entrada;

public class Completo2 {

	public static void main(String[] args) throws IOException {
		/*
		 * Ejercicio: Crear archivo con líneas introducidas por el usuario Usa
		 * JFileChooser para que el usuario elija dónde guardar un nuevo archivo.
		 * 
		 * Pide al usuario por consola que escriba líneas de texto (usa Scanner).
		 * 
		 * Cuando escriba la palabra "FIN", deja de pedir líneas.
		 * 
		 * Guarda todas las líneas en el archivo elegido, usando PrintWriter.
		 * 
		 * Después, abre ese mismo archivo con BufferedReader y muestra su contenido en
		 * consola.
		 */

		// 1 dodne guardar
		JFileChooser jfc = new JFileChooser(".");
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setDialogTitle("donde deseas guardar el archivo");
		int opcion1 = jfc.showSaveDialog(null);
		File rutaCarpeta = jfc.getSelectedFile();
		if (opcion1 == JFileChooser.APPROVE_OPTION) {
			if (!rutaCarpeta.exists()) {
				System.out.println("la ruta carpeta no existe saliendo...");
				return;
			} else if (!rutaCarpeta.isDirectory()) {
				System.out.println("la ruta existe pero no es un carpeta saliendo...");
				return;
			}
		}
		// 2. Pedir nombre del archivo por consola

		System.out.print("Introduce el nombre del archivo (sin espacios, ejemplo: notas.txt): ");
		String nombreArchivo = Entrada.cadena();
		// crear un File combinando carpeta + nombre (new File(carpeta, nombre)).
		//
		File rutaArchivo = new File(rutaCarpeta, nombreArchivo);

		// 3 pedir datos y escirbir en destino
		PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo, true));
		boolean auxSalida = false;
		while (!auxSalida) {
			System.out.println("Introduce las líneas que deseas guardar / FIN para terminar:");
			String lineas = Entrada.cadena();
			if (lineas.equalsIgnoreCase("fin")) {
				System.out.println("Has terminado de escribir. Guardando...");
				auxSalida = true;
			} else {
				pw.println(lineas);
			}
		}

		pw.close();


        // 4. Leer el archivo creado
        System.out.println("\nContenido del archivo :"+"\n" + nombreArchivo);
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String lineaLeida;
        while ((lineaLeida = br.readLine()) != null) {
            System.out.println(lineaLeida);
        }
        br.close();

	}// fin main

}// fin clase
