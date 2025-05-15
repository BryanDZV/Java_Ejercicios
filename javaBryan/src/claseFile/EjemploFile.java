package claseFile;

import java.io.File;

import utilidades.Entrada;

public class EjemploFile {
	public static void main(String[] args) {
		/*
		 * System.out.print("Introduzca una ruta: "); String ruta = Entrada.cadena();
		 * File f = new File(ruta); if (!f.exists()) { // se comprueba si la ruta existe
		 * o no System.out.println("No existe la ruta: " + f.getAbsolutePath()); } else
		 * { System.out.println("La ruta: " + f.getAbsolutePath()); if (f.isDirectory())
		 * { System.out.println("Es un directorio."); } if (f.isFile()) {
		 * System.out.println("Es un fichero."); System.out.println("Su tamaño es: " +
		 * f.length() + " bytes"); } }
		 */
		// LISTAR
		System.out.println("introduzca una ruta de dictorio");
		// ruta prueba C:\Users\bryan\Desktop
		//C:\Users\bryan\Desktop\labsuser.pem
		String ruta1;

		File[] contenido;
		boolean salidaExitosa = false;
		do {
			ruta1 = Entrada.cadena();
			File f1 = new File(ruta1);
			if (f1.exists() && f1.isDirectory()) {
				contenido = f1.listFiles();
				for (File file : contenido) {
					if (file.isDirectory()) {
						System.out.println("LAS RUTAS:" + file + " es una carpeta");
					} else if (file.isFile()) {
						System.out.println("LAS RUTAS:" + file + " es un ARCHIVO");

					}

				}
				salidaExitosa = true;
			}else {
				if (f1.exists() && !f1.isDirectory()) {
					System.out.println("la ruta existe pero no es un directorio");
				}else {System.out.println(" NO existe la ruta");}
				
				
			}
			
		} while (!salidaExitosa);

		System.out.println("FIN");

	}// main
}// clase