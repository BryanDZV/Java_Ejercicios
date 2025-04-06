package ficheros;

import java.io.File;

import utilidades.Entrada;

public class ListarContenidoDeCarpeta {
	public static void main(String[] args) {
		System.out.print("Introduzca una ruta: ");
		String ruta = Entrada.cadena();
		
		File f = new File(ruta);
		System.out.println(f.getAbsolutePath());
		if (!f.exists()) { // se comprueba si la ruta existe o no
			System.out.println("No existe la ruta.");
		} else {
			if (!f.isDirectory()) {
				System.out.println("La ruta existe pero no es una carpeta");
			}
			else {
				File [] contenido=f.listFiles();
				for (int i = 0; i < contenido.length; i++) {
					File elem=contenido[i];
					System.out.println(elem.getName()+" "+(elem.isFile()?"fichero "+f.length()+" bytes":"carpeta"));
				}
			}
		}
	}
}
