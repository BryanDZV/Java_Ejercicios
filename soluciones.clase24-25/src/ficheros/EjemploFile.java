package ficheros;

import java.io.File;

import utilidades.Entrada;

public class EjemploFile {
	public static void main(String[] args) {
		System.out.print("Introduzca una ruta: ");
		String ruta = Entrada.cadena();
		File f = new File(ruta);
		if (!f.exists()) { // se comprueba si la ruta existe o no
			System.out.println("No existe la ruta: " + f.getAbsolutePath());
		} else {
			System.out.println("La ruta: " + f.getAbsolutePath());
			if (f.isDirectory()) {
				System.out.println("Es un directorio.");
			}
			if (f.isFile()) {
				System.out.println("Es un fichero.");
				System.out.println("Su tamaño es: "+f.length()+" bytes");
			}
		}
	}
}
