package ficherosPractica;

import java.io.File;

import javax.swing.JFileChooser;

public class GaurdarArchivoYMostrarRuta {

	 public static void main(String[] args) {
	        JFileChooser fileChooser = new JFileChooser();
	        int seleccion = fileChooser.showSaveDialog(null);

	        if (seleccion == JFileChooser.APPROVE_OPTION) {
	            File fichero = fileChooser.getSelectedFile();
	            System.out.println("Guardar en: " + fichero.getAbsolutePath());
	        } else {
	            System.out.println("Guardado cancelado");
	        }
	    }
}
