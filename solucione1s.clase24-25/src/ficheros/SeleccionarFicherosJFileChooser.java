package ficheros;

import java.io.File;

import javax.swing.JFileChooser;

public class SeleccionarFicherosJFileChooser {

	public static void main(String[] args) {
		JFileChooser fc=new JFileChooser(".");
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setDialogTitle("Seleccione fichero origen");
		int opcion=fc.showOpenDialog(null);
		if (opcion==JFileChooser.APPROVE_OPTION){
			File ruta=fc.getSelectedFile();
			System.out.println(ruta.getAbsolutePath());
		}
		else
			System.out.println("No se ha seleccionado ningún fichero.");
	}

}
