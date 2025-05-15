package ficheros;

import java.io.File;

import javax.swing.JFileChooser;

import utilidades.Entrada;

public class EjemploFileConJFileChooser {
	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser(".");
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int salidaDeVentana = fc.showOpenDialog(null);
		if (salidaDeVentana == JFileChooser.APPROVE_OPTION) { // El usuario ha seleccionado un elemento
			File f=fc.getSelectedFile();
			if (!f.exists()) { // se comprueba si la ruta existe o no
				System.out.println("No existe la ruta: " + f.getAbsolutePath());
			} else {
				System.out.println("La ruta: " + f.getAbsolutePath());
				if (f.isDirectory()) {
					System.out.println("Es un directorio.");
				}
				if (f.isFile()) {
					System.out.println("Es un fichero.");
					System.out.println("Su tamaño es: " + f.length() + " bytes");
				}
			}
		}
		else {
			System.out.println("El usuario no ha seleccionado nada.");
		}
	}
}
